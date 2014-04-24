/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author sara
 */
@Entity
public class Sessionf implements Serializable {
    @OneToMany(mappedBy = "sessionf")
    private List<EvaluationFormation> evaluationFormationList = new ArrayList<EvaluationFormation>();
    @OneToMany(mappedBy = "session")
    private List<Inscription> inscriptions=new ArrayList<Inscription>();
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    @ManyToOne
     private Formation  formation = new Formation();
    @ManyToOne
     private Planformation planformation = new Planformation();

    public List<EvaluationFormation> getEvaluationFormationList() {
        return evaluationFormationList;
    }

    public void setEvaluationFormationList(List<EvaluationFormation> evaluationFormationList) {
        this.evaluationFormationList = evaluationFormationList;
    }
  


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

   
    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }



    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Planformation getPlanformation() {
        return planformation;
    }

    public void setPlanformation(Planformation planformation) {
        this.planformation = planformation;
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
        if (!(object instanceof Sessionf)) {
            return false;
        }
        Sessionf other = (Sessionf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return formation.getLibelle()+"";
    }
    
}