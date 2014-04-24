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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author sara
 */
@Entity
public class Employe implements Serializable {
    @OneToMany(mappedBy = "employe")
    private List<Utilisateur> utilisateurList =new ArrayList<Utilisateur>();
    @OneToMany(mappedBy = "employe")
    private List<EvaluationFormation> evaluationFormationList=new ArrayList<EvaluationFormation>();
    @OneToMany(mappedBy = "employe")
    private List<Image> imageList=new ArrayList<Image>();
   
  
    @OneToMany(mappedBy = "employe")
    private List<Besoinformation> besoinformationList=new ArrayList<Besoinformation>();
    @OneToMany(mappedBy = "employe")
    private List<Inscription> inscriptions=new ArrayList<Inscription>();
    @OneToMany(mappedBy = "employe")
    private List<Diplome> diplomeList=new ArrayList<Diplome>();
    @OneToMany(mappedBy = "employe")
    private List<Emploiprecedent> emploiprecedentList=new ArrayList<Emploiprecedent>();
    @OneToMany(mappedBy = "employe")
    private List<Evaluationemploye> evalueremployeList = new ArrayList<Evaluationemploye>();
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String telephonePro;
    private String telephoneMobile;
    private String telephonePerso;
    private String fax;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String email;
    private String adrRue;
    private String adrVille;
    private String description;
    private Integer nbEnfants;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEntreeFonction;
    private String civilite;
    private String numeroAssuranceSociale;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEmbauche;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    @ManyToOne
    private Service service=new Service ();
    @ManyToOne
    private Poste poste=new Poste();
    
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Besoinformation> getBesoinformationList() {
        return besoinformationList;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    public void setBesoinformationList(List<Besoinformation> besoinformationList) {
        this.besoinformationList = besoinformationList;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

   

   
    
    

    public List<Diplome> getDiplomeList() {
        return diplomeList;
    }

    public void setDiplomeList(List<Diplome> diplomeList) {
        this.diplomeList = diplomeList;
    }

    public List<Emploiprecedent> getEmploiprecedentList() {
        return emploiprecedentList;
    }

    public void setEmploiprecedentList(List<Emploiprecedent> emploiprecedentList) {
        this.emploiprecedentList = emploiprecedentList;
    }

    public List<Evaluationemploye> getEvalueremployeList() {
        return evalueremployeList;
    }

    public void setEvalueremployeList(List<Evaluationemploye> evalueremployeList) {
        this.evalueremployeList = evalueremployeList;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephonePro() {
        return telephonePro;
    }

    public void setTelephonePro(String telephonePro) {
        this.telephonePro = telephonePro;
    }

    public List<EvaluationFormation> getEvaluationFormationList() {
        return evaluationFormationList;
    }

    public void setEvaluationFormationList(List<EvaluationFormation> evaluationFormationList) {
        this.evaluationFormationList = evaluationFormationList;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public String getTelephonePerso() {
        return telephonePerso;
    }

    public void setTelephonePerso(String telephonePerso) {
        this.telephonePerso = telephonePerso;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdrRue() {
        return adrRue;
    }

    public void setAdrRue(String adrRue) {
        this.adrRue = adrRue;
    }

    public String getAdrVille() {
        return adrVille;
    }

    public void setAdrVille(String adrVille) {
        this.adrVille = adrVille;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(Integer nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public Date getDateEntreeFonction() {
        return dateEntreeFonction;
    }

    public void setDateEntreeFonction(Date dateEntreeFonction) {
        this.dateEntreeFonction = dateEntreeFonction;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNumeroAssuranceSociale() {
        return numeroAssuranceSociale;
    }

    public void setNumeroAssuranceSociale(String numeroAssuranceSociale) {
        this.numeroAssuranceSociale = numeroAssuranceSociale;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
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
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom+""+prenom;
    }
    
}