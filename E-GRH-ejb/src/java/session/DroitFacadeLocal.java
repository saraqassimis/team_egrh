/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Droit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface DroitFacadeLocal {

    void create(Droit droit);

    void edit(Droit droit);

    void remove(Droit droit);

    Droit find(Object id);

    List<Droit> findAll();

    List<Droit> findRange(int[] range);

    int count();
    
}
