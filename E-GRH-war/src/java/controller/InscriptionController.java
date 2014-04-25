package controller;

import bean.Employe;
import bean.Inscription;
import bean.Sessionf;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import session.InscriptionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("inscriptionController")
@SessionScoped
public class InscriptionController implements Serializable {

    private Inscription current;
    private DataModel items = null;
    private int indice;
    @EJB
    private session.InscriptionFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Sessionf sessionf ;  
    public InscriptionController() {
    }

    
    public String ListSessionsFromInscri ( Sessionf s ){
   sessionf = s;
  return "/sessionf/ListSession";
    }
    
     public List<Inscription> getAllInscriptionOfSessionf ()
    {
        return getFacade().loadInscription(sessionf);
    }
     
     
      public List<Employe> getRmployeFromService()
    {
        return ejbFacade.findServiceOfEmploye(current.getService());
              
    }
    public Inscription getSelected() {
        if (current == null) {
            current = new Inscription();
            selectedItemIndex = -1;
        }
        return current;
    }

    private InscriptionFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Inscription) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String editView(Inscription i)
    {current = i;
    indice=current.getSession().getInscriptions().indexOf(i);
    return "Edit";
    }
    
     public String delete(Inscription i){
        
       System.out.println("a");
    getFacade().remove(i);
     System.out.println("b");
     recreatePagination();
        recreateModel();
     JsfUtil.addSuccessMessage("bien supprimeé");
    return "ListInscription";
}
     public String inscriptionListSession ( Sessionf s){
   sessionf = s;
  return "/inscription/ListInscription";
    
} 
    
    
    public String prepareCreate() {
        current = new Inscription();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.setSession(sessionf);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InscriptionCreated"));
            current = new Inscription();
           selectedItemIndex = -1;
           return "Create";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
     public String createSchedule() {
        try {
            
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InscriptionCreated"));
            current = new Inscription();
           selectedItemIndex = -1;
           return "Schedule";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Inscription) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InscriptionUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy(Sessionf f) {
        current = (Inscription) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        current.setSession(f);
        System.out.println("//////////////////////////////////////"+f.getInscriptions());
        f.setInscriptions(getFacade().listInscrit(f));
        System.out.println("+++++++lllllllllllllllllllllllllllllll"+f.getInscriptions());
        recreatePagination();
        recreateModel();
        return "ListInscription";
    }


    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InscriptionDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Inscription getInscription(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Inscription.class)
    public static class InscriptionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InscriptionController controller = (InscriptionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inscriptionController");
            return controller.getInscription(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Inscription) {
                Inscription o = (Inscription) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Inscription.class.getName());
            }
        }

    }

}
