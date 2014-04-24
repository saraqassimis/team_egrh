/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Employe;
import bean.Evaluationemploye;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface EvaluationemployeFacadeLocal {

    void create(Evaluationemploye evaluationemploye);

    void edit(Evaluationemploye evaluationemploye);

    void remove(Evaluationemploye evaluationemploye);

    Evaluationemploye find(Object id);

    List<Evaluationemploye> findAll();

    List<Evaluationemploye> findRange(int[] range);
    List<Evaluationemploye> loadEvaluations(Employe e);

    int count();
    
}
