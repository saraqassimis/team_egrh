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
public class Evaluationemploye implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_evaluation;
    private String nom_complet;
    private String qualite;
    private String rythme_travail;
    private String autonomie;
    private String capacite_adaptation;
    private String discretion;
    private String esprit_inniciative;
    private String methode_orde;
    private String ponctualite;
    private String relation_interpersonnelles;
    private String sens_responsabilite;
    private String communication;
    private String commentaire;
    private String note;
    
    @ManyToOne
    private Employe employe=new Employe();
    public Long getId() {
        return id;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_evaluation() {
        return date_evaluation;
    }

    public void setDate_evaluation(Date date_evaluation) {
        this.date_evaluation = date_evaluation;
    }

    public String getNom_complet() {
        return nom_complet;
    }

    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getRythme_travail() {
        return rythme_travail;
    }

    public void setRythme_travail(String rythme_travail) {
        this.rythme_travail = rythme_travail;
    }

    public String getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(String autonomie) {
        this.autonomie = autonomie;
    }

    public String getCapacite_adaptation() {
        return capacite_adaptation;
    }

    public void setCapacite_adaptation(String capacite_adaptation) {
        this.capacite_adaptation = capacite_adaptation;
    }

    public String getDiscretion() {
        return discretion;
    }

    public void setDiscretion(String discretion) {
        this.discretion = discretion;
    }

    public String getEsprit_inniciative() {
        return esprit_inniciative;
    }

    public void setEsprit_inniciative(String esprit_inniciative) {
        this.esprit_inniciative = esprit_inniciative;
    }

    public String getMethode_orde() {
        return methode_orde;
    }

    public void setMethode_orde(String methode_orde) {
        this.methode_orde = methode_orde;
    }

    public String getPonctualite() {
        return ponctualite;
    }

    public void setPonctualite(String ponctualite) {
        this.ponctualite = ponctualite;
    }

    public String getRelation_interpersonnelles() {
        return relation_interpersonnelles;
    }

    public void setRelation_interpersonnelles(String relation_interpersonnelles) {
        this.relation_interpersonnelles = relation_interpersonnelles;
    }

    public String getSens_responsabilite() {
        return sens_responsabilite;
    }

    public void setSens_responsabilite(String sens_responsabilite) {
        this.sens_responsabilite = sens_responsabilite;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
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
        if (!(object instanceof Evaluationemploye)) {
            return false;
        }
        Evaluationemploye other = (Evaluationemploye) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Evaluationemploye[ id=" + id + " ]";
    }
    
}