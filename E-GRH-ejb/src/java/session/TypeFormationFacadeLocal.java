/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.TypeFormation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface TypeFormationFacadeLocal {

    void create(TypeFormation typeFormation);

    void edit(TypeFormation typeFormation);

    void remove(TypeFormation typeFormation);

    TypeFormation find(Object id);

    List<TypeFormation> findAll();

    List<TypeFormation> findRange(int[] range);

    int count();
    
}
