/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Organisme;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Acer
 */
@Local
public interface OrganismeFacadeLocal {

    void create(Organisme organisme);

    void edit(Organisme organisme);

    void remove(Organisme organisme);

    Organisme find(Object id);

    List<Organisme> findAll();

    List<Organisme> findRange(int[] range);

    int count();
    
}
