package fr.capgemini.interco.repository;

import java.util.List;

import fr.capgemini.interco.domain.Utilisateur;

public interface UtilisateurRepository extends UtilityRepository<Utilisateur, Long>{
	List<Utilisateur> findByNom(String nom);
}
