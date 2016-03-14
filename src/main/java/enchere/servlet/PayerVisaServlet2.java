/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "PayerVisaServlet2", urlPatterns = {"/saisi_visa"})
public class PayerVisaServlet2 extends AutowireServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idArticle = req.getParameter("idArticle");
        
        req.setAttribute("idArticle", idArticle);
               
        req.getRequestDispatcher("paiement_visa_ok").include(req, resp);
        
        req.getRequestDispatcher("paiement_en_cours.jsp").include(req, resp);
    }
    
    

}
