/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Planformation;
import bean.Sessionf;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface PlanformationFacadeLocal {

    void create(Planformation planformation);

    void edit(Planformation planformation);

    void remove(Planformation planformation);

    Planformation find(Object id);

    List<Planformation> findAll();

    List<Planformation> findRange(int[] range);

    int count();
    List<Sessionf> loadSessionf(Planformation p);
}
