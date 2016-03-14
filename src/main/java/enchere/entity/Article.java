/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import enchere.enumeration.Statut;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;
    
    private String description;
    
    private Double prixVente;
    
    private Double prixActuel;
    
    private Double prixDepart;
    
    @Enumerated(EnumType.STRING)
    private Statut statut;
    
    @Temporal(TemporalType.TIMESTAMP)
    Date dateFinal;
    
    @ManyToOne
    @JoinColumn(name = "CREAT_ID")
    private Utilisateur createur;
    
    @OneToMany (mappedBy = "article")
    private List<Enchere> encheres = new ArrayList<Enchere>();
    
    @ManyToOne
    @JoinColumn(name = "CAT_ID")
    private Categorie categorie;
    
    @ManyToOne
    @JoinColumn(name = "UTIL_ID")
    private Utilisateur encherisseur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public Double getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(Double prixActuel) {
        this.prixActuel = prixActuel;
    }

    public Double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Double prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Utilisateur getEncherisseur() {
        return encherisseur;
    }

    public void setEncherisseur(Utilisateur encherisseur) {
        this.encherisseur = encherisseur;
    }
    


    
    
    public Article() {
    }

    public Article(String nom, String description, Double prixVente, Double prixActuel, Double prixDepart, Statut statut, Date dateFinal, Utilisateur createur, Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.prixVente = prixVente;
        this.prixActuel = prixActuel;
        this.prixDepart = prixDepart;
        this.statut = statut;
        this.dateFinal = dateFinal;
        this.createur = createur;
        this.categorie = categorie;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Article[ id=" + id + " ]";
    }
    
}
