/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

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
public class PlanformationFacade extends AbstractFacade<Planformation> implements PlanformationFacadeLocal {
    @PersistenceContext(unitName = "E-GRH-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanformationFacade() {
        super(Planformation.class);
    }
    @Override
     public List<Sessionf> loadSessionf(Planformation p)
    {Query q= em.createQuery("SELECT s FROM Sessionf s WHERE s.planformation.id ="+ p.getId());
        System.out.println(q);
    return q.getResultList();
    }
}
