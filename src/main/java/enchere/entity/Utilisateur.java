/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import static enchere.entity.Enchere_.article;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true)
    private String login;
    
    private String mdp;
    
    @OneToMany (mappedBy = "createur")
    private List<Enchere> encheres = new ArrayList<Enchere>();
    
    @OneToMany (mappedBy = "createur")
    private List<Article> articlesCrees = new ArrayList<Article>();
    
    @OneToMany (mappedBy = "encherisseur")
    private List<Article> articlesEncherit = new ArrayList<Article>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }

    public List<Article> getArticlesCrees() {
        return articlesCrees;
    }

    public void setArticlesCrees(List<Article> articlesCrees) {
        this.articlesCrees = articlesCrees;
    }

    public List<Article> getArticlesEncherit() {
        return articlesEncherit;
    }

    public void setArticlesEncherit(List<Article> articlesEncherit) {
        this.articlesEncherit = articlesEncherit;
    }

   

    public Utilisateur() {
    }

    public Utilisateur(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Utilisateur[ id=" + id + " ]";
    }
    
}
