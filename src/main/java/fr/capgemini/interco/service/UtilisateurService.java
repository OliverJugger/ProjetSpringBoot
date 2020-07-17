package fr.capgemini.interco.service;

import fr.capgemini.interco.domain.Utilisateur;
import fr.capgemini.interco.repository.UtilisateurRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;

	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public List<Utilisateur> getAllUtilisateurs(){
		List<Utilisateur> utilisateurs = new ArrayList<>();
		utilisateurRepository.findAll().forEach(utilisateurs::add);
        return utilisateurs;
	}
	
	public List<Utilisateur> getAllUtilisateursByNom(String nom){
		List<Utilisateur> corrections = new ArrayList<>(utilisateurRepository.findByNom(nom));
        Collections.reverse(corrections);
        return corrections; 
	}
	
	 /**
     * 
     * @param utilisateur
     * L'utilisateur n est pas une entity qu'il connait, il faut passer par 
     * findbyid pour pouvoir mettre à jour.
     */
    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
    }
	
}
