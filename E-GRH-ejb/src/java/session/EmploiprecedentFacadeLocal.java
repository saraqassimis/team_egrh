/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Emploiprecedent;
import bean.Employe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface EmploiprecedentFacadeLocal {

    void create(Emploiprecedent emploiprecedent);

    void edit(Emploiprecedent emploiprecedent);

    void remove(Emploiprecedent emploiprecedent);

    Emploiprecedent find(Object id);

    List<Emploiprecedent> findAll();

    List<Emploiprecedent> findRange(int[] range);
    
    List<Emploiprecedent> loadEmploiPrecedents(Employe e);

    int count();
    
}
