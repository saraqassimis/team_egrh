/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Diplome;
import bean.Employe;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sara
 */
@Stateless
@LocalBean
public class DiplomeFacade extends AbstractFacade<Diplome> implements DiplomeFacadeLocal {
    @PersistenceContext(unitName = "E-GRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiplomeFacade() {
        super(Diplome.class);
    }
     @Override
    public List<Diplome> loadDiplomes(Employe e){
        Query q=em.createQuery("SELECT  d FROM Diplome d WHERE d.employe.id="+e.getId());
        return q.getResultList();
        
    }
}
