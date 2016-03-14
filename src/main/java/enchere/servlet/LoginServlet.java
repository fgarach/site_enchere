/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.exception.LoginNonExistant;
import enchere.exception.MotDePasseIncorrect;
import enchere.service.ConnexionService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login_servlet"})
public class LoginServlet extends AutowireServlet {

    @Autowired
    ConnexionService connexionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("formulaire_login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");

        try {
            connexionService.connexion(login, mdp);
        } catch (LoginNonExistant ex) {
            String information = "Votre login n'est pas reconnu";
            req.setAttribute("info", information);
            req.getRequestDispatcher("login2").forward(req, resp);
            return;
        } catch (MotDePasseIncorrect ex) {
            String information = "Votre mot de passe est incorrect";
            req.setAttribute("info", information);
            req.getRequestDispatcher("login2").forward(req, resp);
            return;
        }
        req.getSession().setAttribute("login", login);
        resp.sendRedirect("home");

    }

}
