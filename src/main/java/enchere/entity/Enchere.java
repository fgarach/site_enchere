/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Enchere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    Date dateEnchere;
    
    private Double sommeEnchere;
    
    @ManyToOne
    @JoinColumn(name = "UTIL_ID")
    private Utilisateur createur;
    
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(Date dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Double getSommeEnchere() {
        return sommeEnchere;
    }

    public void setSommeEnchere(Double sommeEnchere) {
        this.sommeEnchere = sommeEnchere;
    }

    public Enchere() {
    }

    public Enchere(Date dateEnchere, Double sommeEnchere, Utilisateur createur, Article article) {
        this.dateEnchere = dateEnchere;
        this.sommeEnchere = sommeEnchere;
        this.createur = createur;
        this.article = article;
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
        if (!(object instanceof Enchere)) {
            return false;
        }
        Enchere other = (Enchere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Enchere[ id=" + id + " ]";
    }
    
}
