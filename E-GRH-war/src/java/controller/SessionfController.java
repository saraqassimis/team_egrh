package controller;

import bean.Planformation;
import bean.Sessionf;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import session.SessionfFacade;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Iterator;
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

@Named("sessionfController")
@SessionScoped
public class SessionfController implements Serializable {

    private Sessionf current;
    private DataModel items = null;
    private int indice;
    @EJB
    private session.SessionfFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Planformation planformation;

    public SessionfController() {
    }
    
     public String listSessionFschedule() {
        String listEVT = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        boolean test = false;
        for (Iterator it = ejbFacade.findAll().iterator(); it.hasNext();) {
            test = true;
            Sessionf s = (Sessionf) it.next();
           
                String start = "new Date(" + (s.getDateDebut().getYear() + 1900)
                        + ", " + s.getDateDebut().getMonth()
                        + ", " + s.getDateDebut().getDate()
                        + ", " + s.getDateDebut().getHours()
                        + ", " + s.getDateDebut().getMinutes() + ")";
                String end = "new Date(" + (s.getDateFin().getYear() + 1900)
                        + ", " + s.getDateFin().getMonth()
                        + ", " + s.getDateFin().getDate()
                        + ", " + s.getDateFin().getHours()
                        + ", " + s.getDateFin().getMinutes() + ")";
                listEVT += "{";
                listEVT += "title: '" + s.getFormation().getLibelle() + "',";
                listEVT += "start: " + start + ",";
                listEVT += "end: " + end + ",";
                listEVT += "allDay: false,";
                listEVT += "url: 'javascript: showModal(" + s.getId() +");'";
                listEVT += "},";
            
        }
        if (test) {
            listEVT = listEVT.substring(0, listEVT.length() - 1);
        }
        test = false;
        return listEVT;
    }
 
    
 public List<Sessionf> getAllSessionOfPlanF ()
    {
        return getFacade().loadSessionf(planformation);
    }
 
  public int getNbrParticipants(Sessionf s)
{    
        return s.getInscriptions().size();
}
 
public double getPrixTotal(Sessionf s)
{
    return getNbrParticipants(s)* (s.getFormation().getPrixParPersonne());  
}

public String sessionListPlanFormation ( Planformation p){
   planformation = p;
  return "/sessionf/ListSession";
    
} 
public String sessionListPlanFormationS ( Planformation p){
   planformation = p;
  return "/sessionf/Schedule";
    
} 

 public List<Sessionf> getSessionfFromPlanF()
    {
        return ejbFacade.loadSessionf(current.getPlanformation());
              
    }
public String listSessions(){
    
     getFacade().loadSessionf(planformation);
    return"/sessionf/ListSession";
}


public String InscriptionOfSession (Sessionf f)
    {
    f.setInscriptions(ejbFacade.loadInscription(f));
    current =f;
    return"/inscription/ListInscription";
    }

 
    public Sessionf getSelected() {
        if (current == null) {
            current = new Sessionf();
            selectedItemIndex = -1;
        }
        return current;
    }

    private SessionfFacade getFacade() {
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
        current = (Sessionf) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

     public String editView(Sessionf f)
    {current = f;
    indice=current.getPlanformation().getSessionfList().indexOf(f);
    return "Edit";
    }
     
      public String delete(Sessionf f){
      
       System.out.println("a");
    getFacade().remove(f);
     System.out.println("b");
     recreatePagination();
        recreateModel();
      JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DiplomeDeleted"));
 
    return "ListSession";
}
    public String prepareCreate() {
        current = new Sessionf();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
             current.setPlanformation(planformation);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SessionfCreated"));
           current = new Sessionf();
             selectedItemIndex = -1;
             return "Create";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

     public String createS() {
        try {
             current.setPlanformation(planformation);
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SessionfCreated"));
           current = new Sessionf();
             selectedItemIndex = -1;
             return "Schedule";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Sessionf) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SessionfUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

   public String destroy(Planformation p) {
        current = (Sessionf) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
         current.setPlanformation(p);
         p.setSessionfList(getFacade().listSession());
        recreatePagination();
        recreateModel();
        return "ListSession";
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SessionfDeleted"));
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

    public Sessionf getSessionf(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Sessionf.class)
    public static class SessionfControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SessionfController controller = (SessionfController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sessionfController");
            return controller.getSessionf(getKey(value));
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
            if (object instanceof Sessionf) {
                Sessionf o = (Sessionf) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Sessionf.class.getName());
            }
        }

    }

}
