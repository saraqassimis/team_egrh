/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Poste;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface PosteFacadeLocal {

    void create(Poste poste);

    void edit(Poste poste);

    void remove(Poste poste);

    Poste find(Object id);

    List<Poste> findAll();

    List<Poste> findRange(int[] range);

    int count();
    
}
