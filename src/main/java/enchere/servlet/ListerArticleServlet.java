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
@WebServlet(name = "ListerArticleServlet", urlPatterns = {"/lister_article"})
public class ListerArticleServlet extends AutowireServlet {

    @Autowired
    ArticleService articleService;
    @Autowired
    ActualiserService actualiserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        actualiserService.actualiser();
        List<Article> articles = (List<Article>) articleService.findAll();
        List<Article> articlesdispo = new ArrayList();
        for (Article art : articles) {
            if (art.getStatut() == Statut.DISPO) {
                articlesdispo.add(art);
            }
        }

        req.setAttribute("articles", articlesdispo);
        req.getRequestDispatcher("liste_enchere.jsp").forward(req, resp);
    }

}
