/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Categorie;
import bean.Competence;
import bean.Formation;
import bean.TypeFormation;
import bean.TypesousFormation;
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
public class FormationFacade extends AbstractFacade<Formation> implements FormationFacadeLocal {
    @PersistenceContext(unitName = "E-GRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormationFacade() {
        super(Formation.class);
    }
    @Override
     public List<Competence> findCompetenceOfCategorie(Categorie c){
        Query q=em.createQuery("SELECT co FROM Competence co WHERE co.categorie.id ="+c.getId());
         System.out.println(q);
          return  q.getResultList();
         
              
     } 
    @Override
      public List<TypesousFormation> findSousTypeOfTypeFormation(TypeFormation t){
        Query q=em.createQuery("SELECT tF FROM TypesousFormation tF WHERE tF.typeformation.id ="+t.getId());
         System.out.println(q);
          return  q.getResultList();
         
              
     } 
}
