/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author sara
 */
@Entity
public class EvaluationFormation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Sessionf sessionf = new Sessionf();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEvaluationformation;
    private String objectif;
    private String annimation;
    private String materielFormation;
    private String qualite;
    private String repas;
    private String attente;
    private String observation ;
    
   
    @ManyToOne
    private Employe employe = new Employe();

    public Sessionf getSessionf() {
        return sessionf;
    }

    public void setSessionf(Sessionf sessionf) {
        this.sessionf = sessionf;
    }

    public Date getDateEvaluationformation() {
        return dateEvaluationformation;
    }

    public void setDateEvaluationformation(Date dateEvaluationformation) {
        this.dateEvaluationformation = dateEvaluationformation;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getAnnimation() {
        return annimation;
    }

    public void setAnnimation(String annimation) {
        this.annimation = annimation;
    }

    public String getMaterielFormation() {
        return materielFormation;
    }

    public void setMaterielFormation(String materielFormation) {
        this.materielFormation = materielFormation;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }

    public String getAttente() {
        return attente;
    }

    public void setAttente(String attente) {
        this.attente = attente;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationFormation)) {
            return false;
        }
        EvaluationFormation other = (EvaluationFormation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.EvaluationFormation[ id=" + id + " ]";
    }
    
}