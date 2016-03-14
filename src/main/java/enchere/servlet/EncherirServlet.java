/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.EncherirService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
@WebServlet(name = "EncherirServlet", urlPatterns = {"/encherir"})
public class EncherirServlet extends AutowireServlet {
    
    @Autowired
    EncherirService encherirService;
    @Autowired
    ArticleService articleService;
    @Autowired
    UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idSTring = req.getParameter("idArticle");
        Long idLong = Long.parseLong(idSTring);
        Article a = articleService.findOne(idLong);
        req.setAttribute("article", a);
        req.getRequestDispatcher("encherir.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Utilisateur u = utilisateurService.findByLogin(req.getParameter("util"));
        Utilisateur u = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        String idSTring = req.getParameter("id");
        Long idLong = Long.parseLong(idSTring);
        Article a = articleService.findOne(idLong);
        Double s = Double.parseDouble(req.getParameter("somme"));
        if ( a.getEncherisseur()==null || !a.getEncherisseur().getId().equals(u.getId()) ){
             encherirService.encherir(u, s , a);
            resp.sendRedirect("HomePage.jsp");
        }
        else{
           resp.sendRedirect("HomePage.jsp");
        }
        
    }
    
    

}
