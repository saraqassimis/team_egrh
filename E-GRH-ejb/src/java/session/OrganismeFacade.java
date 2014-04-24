/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Organisme;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Acer
 */
@Stateless
@LocalBean
public class OrganismeFacade extends AbstractFacade<Organisme> implements OrganismeFacadeLocal {
    @PersistenceContext(unitName = "E-GRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganismeFacade() {
        super(Organisme.class);
    }
    
}
