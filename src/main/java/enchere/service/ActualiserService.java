/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import enchere.enumeration.Statut;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ActualiserService {

    @Autowired
    ArticleService articleService;

    public void actualiser() {

        List<Article> articles = new ArrayList();
        articles = (List<Article>) articleService.findAll();

        for (Article art : articles) {
            if (art.getStatut() == Statut.DISPO) {
                art.getDateFinal();

                Date aujourdhui = new Date();
                if (aujourdhui.after(art.getDateFinal())) {
                    if (art.getEncherisseur() == null) {
                        art.setStatut(Statut.FININUL);
                        articleService.save(art);
                    } else {
                        art.setPrixVente(art.getPrixActuel());
                        art.setStatut(Statut.FINIGAGNE);
                        articleService.save(art);
                    }
                }
            }

        }

    }

}
