/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Utilisateur;
import enchere.exception.UtilisateurDejaInscritException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InscriptionService {
    
    @Autowired
    private UtilisateurService utilisateurService;

    
    public void inscriptionUtilisateur(Utilisateur u) throws UtilisateurDejaInscritException {

        //Utilisateur tmp = rechercherParLogin(u.getLogin());
        //Utilisateur tmp = rechercherParLogin(u.getLogin());
        if(utilisateurService.findByLogin(u.getLogin())!= null){
            throw new UtilisateurDejaInscritException();
        }
        else{
            utilisateurService.save(u);
        }    
        
    }
    
}
