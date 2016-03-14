/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.service.PaiementVisaService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PaiementVisaOK", urlPatterns = {"/paiement_visa_ok"})
public class PaiementVisaOK extends AutowireServlet {

    @Autowired
    PaiementVisaService paiementVisaService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idArticle = req.getParameter("idArticle");
        Long idLong = Long.parseLong(idArticle);
        paiementVisaService.paiement(idLong);

    }

}
