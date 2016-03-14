/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Utilisateur;
import enchere.exception.UtilisateurDejaInscritException;
import enchere.service.InscriptionService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends AutowireServlet {
    
    @Autowired
    InscriptionService inscriptionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("formulaire_inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        Utilisateur u = new Utilisateur(req.getParameter("login"), req.getParameter("mdp"));
        try {
            inscriptionService.inscriptionUtilisateur(u);
            resp.sendRedirect("login_servlet");
        } catch (UtilisateurDejaInscritException ex) {
            String information = "Vous êtes déjà inscrit";
            req.setAttribute("info", information);
            req.getRequestDispatcher("login2").forward(req, resp);
            return;
        }
        
    }

}
