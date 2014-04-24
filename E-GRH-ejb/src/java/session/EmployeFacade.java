/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Diplome;
import bean.Emploiprecedent;
import bean.Employe;
import bean.Evaluationemploye;
import bean.Image;
import bean.Poste;
import bean.Service;
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
public class EmployeFacade extends AbstractFacade<Employe> implements EmployeFacadeLocal {
    @PersistenceContext(unitName = "E-GRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
    }
    
     @Override
    public List<Poste> findPostOFservice (Service s){
        Query q= em.createQuery("SELECT p FROM Poste p WHERE p.service.id="+s.getId());
        return q.getResultList();
        
    }
    
     @Override
    public List<Emploiprecedent> loadEmploiPrecedents(Employe e){
        Query q=em.createQuery("SELECT  e FROM Emploiprecedent e WHERE e.employe.id="+e.getId());
        return q.getResultList();
        
    }
     @Override
    public List<Diplome> loadDiplomes(Employe e){
        Query q=em.createQuery("SELECT  d FROM Diplome d WHERE d.employe.id="+e.getId());
        return q.getResultList();
        
    }
    
    @Override
    public List<Image> loadImage(Employe e){
        Query q=em.createQuery("SELECT  i FROM Image i WHERE i.employe.id="+e.getId());
        return q.getResultList();
        
        
    }
    
       @Override
    public List<Evaluationemploye> loadEvaluations(Employe e){
        Query q=em.createQuery("SELECT  v FROM Evaluationemploye v WHERE v.employe.id="+e.getId());
           System.out.println("°°°+°+°+°+"+q);
        return q.getResultList();
        
    }
}
