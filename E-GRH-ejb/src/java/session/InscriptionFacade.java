/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Employe;
import bean.Inscription;
import bean.Service;
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
public class InscriptionFacade extends AbstractFacade<Inscription> implements InscriptionFacadeLocal {
    @PersistenceContext(unitName = "E-GRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscriptionFacade() {
        super(Inscription.class);
    }
    @Override
     public List<Inscription> loadInscription(Sessionf f)
    {Query q= em.createQuery("SELECT i FROM Inscription i WHERE i.session.id ="+ f.getId());
    return q.getResultList();
    }
     
     
    @Override
     public List<Employe> findServiceOfEmploye(Service s){
        Query q=em.createQuery("SELECT e FROM Employe e WHERE e.service.id ="+s.getId());
         System.out.println(q);
          return  q.getResultList();
              
     } 
     
     
    @Override
     public List<Inscription> listInscrit(Sessionf f)
    {Query q= em.createQuery("SELECT i FROM Inscription i WHERE i.session.id ="+f.getId());
    return q.getResultList();
    }
}
