/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author soufiane
 */
public class UtilitaireSession {
    private static final UtilitaireSession instance = new UtilitaireSession();
    private UtilitaireSession() {
        super();
    }

    /**
     * Fonction permettant de recuperer l'instance de Session
     *
     * @return l'instance de Session
     */
    public static UtilitaireSession getInstance() {
        return instance;
    }

    /**
     * Fonction qui vérifie le contexte
     *
     * @return vrai si le contexte permet de recuperer une session
     */

    private boolean isContextOk(FacesContext fc) {
        boolean res = (fc != null
                && fc.getExternalContext() != null
                && fc.getExternalContext().getSession(false) != null);
        return res;
    }

    /**
     * Fonction qui recupere une session à partir du faces context
     */

    private HttpSession getSession(FacesContext fc) {
        return (HttpSession) fc.getExternalContext().getSession(false);
    }

    /**
     * Fonction qui permet de recuperer un objet dans la session
     *
     * @param cle La cle de l'objet a recuperer
     * @return l'objet correspondant
     */
    
    public Object get(String cle) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object res = null;
        if (isContextOk(fc)) {
            res = getSession(fc).getAttribute(cle);
        }
        return res;
    }

    /**
     * Procedure qui permet d'enregistrer une variable dans la session
     *
     * @param cle La cle qui permet d'identifier la varaible dans la session
     * @param valeur La valeur a enregistrer
     */
    public void set(String cle, Object valeur) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null && fc.getExternalContext() != null) {
            getSession(fc).setAttribute(cle, valeur);
        }
    }
}
