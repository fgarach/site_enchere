/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.enumeration.Statut;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@WebServlet(name = "AjouterEnchereServlet", urlPatterns = {"/ajouter_enchere"})
public class AjouterEnchereServlet extends AutowireServlet {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategorieService categorieService;

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Categorie> categories = new ArrayList<Categorie>();
        categories = (List<Categorie>) categorieService.findAll();
        req.setAttribute("categories", categories);
//        int taille = categories.size();
//        req.setAttribute("taille", taille);
        req.getRequestDispatcher("formulaire_ajout.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Double prix = Double.parseDouble(req.getParameter("prix"));

        Integer duree = Integer.parseInt(req.getParameter("duree"));
        GregorianCalendar c = new GregorianCalendar();
        c.add(Calendar.DATE, duree);
        Date date = c.getTime();
        Utilisateur u = utilisateurService.findByLogin(req.getParameter("util"));
        Long categorieid = Long.parseLong(req.getParameter("categorie"));

        Categorie cat = categorieService.findById(categorieid);

        Article a = new Article(req.getParameter("nom"), req.getParameter("description"), prix, prix, prix, Statut.DISPO, date, u, cat);
        u.getArticlesCrees().add(a);
        cat.getArticles().add(a);
        articleService.save(a);
        Long idArt = a.getId();
        req.setAttribute("id", idArt);
        resp.sendRedirect("HomePage.jsp");
    }

}
