/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.EvaluationFormation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface EvaluationFormationFacadeLocal {

    void create(EvaluationFormation evaluationFormation);

    void edit(EvaluationFormation evaluationFormation);

    void remove(EvaluationFormation evaluationFormation);

    EvaluationFormation find(Object id);

    List<EvaluationFormation> findAll();

    List<EvaluationFormation> findRange(int[] range);

    int count();
    
}
