/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sara
 */
@Entity
public class Formation implements Serializable {
    @OneToMany(mappedBy = "formation")
    private List<Sessionf> sessionfList=new ArrayList<Sessionf>();
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
   private double prixParPersonne;
   private double duree;
    private String description;
    @ManyToOne
    private TypeFormation typeformation = new TypeFormation();
    @ManyToOne
    private TypesousFormation typesousformation = new TypesousFormation();
    
    @ManyToOne
   private Organisme organisme =new Organisme();
    @ManyToOne
   private Categorie categorie = new Categorie();
    @ManyToOne
    private Competence competence =new Competence();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeFormation getTypeformation() {
        return typeformation;
    }

    public void setTypeformation(TypeFormation typeformation) {
        this.typeformation = typeformation;
    }

    public TypesousFormation getTypesousformation() {
        return typesousformation;
    }

    public void setTypesousformation(TypesousFormation typesousformation) {
        this.typesousformation = typesousformation;
    }
    

    public List<Sessionf> getSessionfList() {
        return sessionfList;
    }

    public void setSessionfList(List<Sessionf> sessionfList) {
        this.sessionfList = sessionfList;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixParPersonne() {
        return prixParPersonne;
    }

    public void setPrixParPersonne(double prixParPersonne) {
        this.prixParPersonne = prixParPersonne;
    }

    public double getDuree() {
        return duree;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   

    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
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
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle+"";
    }
    
}