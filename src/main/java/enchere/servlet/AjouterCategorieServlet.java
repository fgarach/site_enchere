/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Categorie;
import enchere.service.CategorieService;
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
@WebServlet(name = "AjouterCategorieServlet", urlPatterns = {"/ajouter_categorie"})
public class AjouterCategorieServlet extends AutowireServlet {
    
    
    @Autowired
    CategorieService categorieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Categorie> categories = new ArrayList<Categorie>();
        categories = (List<Categorie>) categorieService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("formulaire_ajoutCategorie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
        Categorie categorie = new Categorie();
        categorie.setNom(req.getParameter("nom"));
        categorieService.save(categorie);
        resp.sendRedirect("HomePage.jsp");
        
    }
    
    
    

   

}
