/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.enumeration.Statut;
import enchere.service.ActualiserService;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "DetailsCompteServlet", urlPatterns = {"/detail_compte"})
public class DetailsCompteServlet extends AutowireServlet {

    @Autowired
    ArticleService articleService;
    @Autowired
    EnchereService enchereService;
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    ActualiserService actualiserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateur u = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));

        actualiserService.actualiser();
        List<Article> articlesCrees = new ArrayList<Article>();
        articlesCrees = u.getArticlesCrees();
        List<Article> articlesEncheris = new ArrayList<Article>();
        articlesEncheris = u.getArticlesEncherit();
        List<Article> articlesGagnees = new ArrayList<Article>();
        for (Article art : articlesEncheris) {
            if ((art.getStatut() == Statut.FINIGAGNE) || (art.getStatut() == Statut.PAYE)) {
                if (art.getEncherisseur() == u) {
                    articlesGagnees.add(art);
                }
            }
        }
        List<Enchere> encheres = u.getEncheres();

        req.setAttribute("articlesCrees", articlesCrees);
        req.setAttribute("articlesGagnees", articlesGagnees);
        req.setAttribute("encheres", encheres);
        req.getRequestDispatcher("detail_compte.jsp").forward(req, resp);
    }

    private void or(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
