/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Diplome;
import bean.Emploiprecedent;
import bean.Employe;
import bean.Evaluationemploye;
import bean.Image;
import bean.Poste;
import bean.Service;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface EmployeFacadeLocal {

    void create(Employe employe);

    void edit(Employe employe);

    void remove(Employe employe);

    Employe find(Object id);

    List<Employe> findAll();

    List<Employe> findRange(int[] range);

    int count();
    
     List<Poste> findPostOFservice (Service s);
      List<Emploiprecedent> loadEmploiPrecedents(Employe e);
   
   List<Diplome> loadDiplomes(Employe e);
   
 List<Evaluationemploye> loadEvaluations(Employe e);
List<Image> loadImage(Employe e);
}
