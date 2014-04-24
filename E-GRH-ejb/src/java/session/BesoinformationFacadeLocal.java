/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Besoinformation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface BesoinformationFacadeLocal {

    void create(Besoinformation besoinformation);

    void edit(Besoinformation besoinformation);

    void remove(Besoinformation besoinformation);

    Besoinformation find(Object id);

    List<Besoinformation> findAll();

    List<Besoinformation> findRange(int[] range);

    int count();
    
}
