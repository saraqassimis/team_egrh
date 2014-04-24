/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Employe;
import bean.Evaluationemploye;
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
public class EvaluationemployeFacade extends AbstractFacade<Evaluationemploye> implements EvaluationemployeFacadeLocal {
    @PersistenceContext(unitName = "E-GRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluationemployeFacade() {
        super(Evaluationemploye.class);
    }
    
     @Override
    public List<Evaluationemploye> loadEvaluations(Employe e){
        Query q=em.createQuery("SELECT  v FROM Evaluationemploye v WHERE v.employe.id="+e.getId());
           System.out.println("°°°+°+°+°+"+q);
        return q.getResultList();
        
    }
    
}
