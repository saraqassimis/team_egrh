/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Categorie;
import bean.Competence;
import bean.Formation;
import bean.TypeFormation;
import bean.TypesousFormation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface FormationFacadeLocal {

    void create(Formation formation);

    void edit(Formation formation);

    void remove(Formation formation);

    Formation find(Object id);

    List<Formation> findAll();

    List<Formation> findRange(int[] range);

    int count();
    List<Competence> findCompetenceOfCategorie(Categorie c);
    List<TypesousFormation> findSousTypeOfTypeFormation(TypeFormation t);
    
}
