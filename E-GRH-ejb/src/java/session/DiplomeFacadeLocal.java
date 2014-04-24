/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Diplome;
import bean.Employe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface DiplomeFacadeLocal {

    void create(Diplome diplome);

    void edit(Diplome diplome);

    void remove(Diplome diplome);

    Diplome find(Object id);

    List<Diplome> findAll();

    List<Diplome> findRange(int[] range);
    
      List<Diplome> loadDiplomes(Employe e);

    int count();
    
}
