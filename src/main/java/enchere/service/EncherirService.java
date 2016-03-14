/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class EncherirService {
    
    @Autowired
    ArticleService articleservice;
    
    @Autowired
    EnchereService enchereservice;
    
    @Autowired 
    UtilisateurService utilisateurService;
    
    public void encherir(Utilisateur u, Double somme, Article a){
       
      
        Enchere e = new Enchere(Date.from(Instant.now()), a.getPrixActuel()+somme, u, a);
        a.setPrixActuel(a.getPrixActuel()+somme);
        
        a.setEncherisseur(u);
        
        u.getEncheres().add(e);
        a.getEncheres().add(e);
        
        utilisateurService.save(u);
        articleservice.save(a);
        enchereservice.save(e);
    }
    
}
