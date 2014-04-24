package controller;

import bean.Emploiprecedent;
import bean.Employe;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import session.EmploiprecedentFacade;

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

@Named("emploiprecedentController")
@SessionScoped
public class EmploiprecedentController implements Serializable {

    private Emploiprecedent current;
    private DataModel items = null;
    @EJB
    private session.EmploiprecedentFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    int indice;

    public EmploiprecedentController() {
    }
      public List<Emploiprecedent> getAllEmploisPrecedentOfEmploye(Employe e){
     
     return getFacade().loadEmploiPrecedents(e); 
 }
 public String delete(Emploiprecedent ep){
      
       System.out.println("a");
    getFacade().remove(ep);
     System.out.println("b");
     JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmploiprecedentDeleted"));
 
    return "ListEmplois";
}
public String editeView(Emploiprecedent ep){
   current=ep;
   indice=current.getEmploye().getEmploiprecedentList().indexOf(ep);
  
    return "Edit";
}
    public Emploiprecedent getSelected() {
        if (current == null) {
            current = new Emploiprecedent();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EmploiprecedentFacade getFacade() {
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
        current = (Emploiprecedent) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Emploiprecedent();
        selectedItemIndex = -1;
        return "Create";
    }

     public String create(Employe employe) {
        try {
            /*current.setEmploye(ejbFacade.getEmployesById(current));
            System.out.println("======"+current.getEmploye());*/
            current.setEmploye(employe);
            System.out.println("++++++++"+employe);
           getFacade().create(current);
           System.out.println("***********"+current);
            recreateModel();
          JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmploiprecedentCreated"));
          current = new Emploiprecedent();
        selectedItemIndex = -1;
           return"/emploiprecedent/Create";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Emploiprecedent) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmploiprecedentUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Emploiprecedent) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmploiprecedentDeleted"));
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

    public Emploiprecedent getEmploiprecedent(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Emploiprecedent.class)
    public static class EmploiprecedentControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmploiprecedentController controller = (EmploiprecedentController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "emploiprecedentController");
            return controller.getEmploiprecedent(getKey(value));
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
            if (object instanceof Emploiprecedent) {
                Emploiprecedent o = (Emploiprecedent) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Emploiprecedent.class.getName());
            }
        }

    }

}
