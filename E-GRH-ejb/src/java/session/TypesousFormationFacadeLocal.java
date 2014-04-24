/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.TypesousFormation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface TypesousFormationFacadeLocal {

    void create(TypesousFormation typesousFormation);

    void edit(TypesousFormation typesousFormation);

    void remove(TypesousFormation typesousFormation);

    TypesousFormation find(Object id);

    List<TypesousFormation> findAll();

    List<TypesousFormation> findRange(int[] range);

    int count();
    
}
