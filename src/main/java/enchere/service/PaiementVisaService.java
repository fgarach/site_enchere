/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.enumeration.Statut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PaiementVisaService {
    
    @Autowired
    ArticleService articleService;
    
    public void paiement(Long Id){
        Article a = articleService.findOne(Id);
        a.setStatut(Statut.PAYE);
        articleService.save(a);
    }
    
}
