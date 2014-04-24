/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Inscription;
import bean.Planformation;
import bean.Sessionf;
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
public class SessionfFacade extends AbstractFacade<Sessionf> implements SessionfFacadeLocal {
    @PersistenceContext(unitName = "E-GRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SessionfFacade() {
        super(Sessionf.class);
    }
    @Override
     public List<Inscription> loadInscription(Sessionf f)
    {Query q= em.createQuery("SELECT i FROM Inscription i WHERE i.session.id ="+ f.getId());
        System.out.println(q);
    return q.getResultList();
    }
     
    
    @Override
      public List<Sessionf> loadSessionf(Planformation p)
    {Query q= em.createQuery("SELECT s FROM Sessionf s WHERE s.planformation.id ="+ p.getId());
        System.out.println(q);
    return q.getResultList();
    }
      
   
    @Override
     public List<Sessionf> listSession()
    {Query q= em.createQuery("SELECT f FROM Sessionf f");
    return q.getResultList();}
        
}
