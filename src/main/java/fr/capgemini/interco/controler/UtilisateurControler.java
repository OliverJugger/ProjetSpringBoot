package fr.capgemini.interco.controler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.capgemini.interco.domain.Utilisateur;
import fr.capgemini.interco.service.UtilisateurService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author omignot
 * Controller REST de la gestion des {@link Utilisateur} de l'application
 * Le {@link org.mapstruct.Mapper} sert à passer d'un POJO en entrée du front
 */
@RestController
@Api(value = "Operations de gestion des utilisateurs")
@RequestMapping(value = "/utilisateur")
public class UtilisateurControler {
	
	private UtilisateurService utilisateurService;

	@Autowired
    public void setCorrectionService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
	}
	
	@GetMapping
	@ApiOperation(value = "Retourne les données de tous les utilisateurs")
	public ResponseEntity<List<Utilisateur>> listCorrections(){
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");  
		List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.ok().headers(headers);
		return responseBuilder.body(utilisateurs);
        //return new ResponseEntity<>(utilisateurs, headers, HttpStatus.OK);
    }
	
	@GetMapping(value="/rechercher/nom/{nom}")
	@ApiOperation(value = "Recherche des utilisateurs par nom")
	public ResponseEntity<List<Utilisateur>> listCorrectionsByEtat(@PathVariable(value="nom") String nom){
		List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateursByNom(nom);
		return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    } 
	
	@PostMapping("/enregistrer")
	@ApiOperation(value = "Enregistre ou met à  jour un utilisateur")
    public ResponseEntity<Utilisateur> enregistrerCorrection(@RequestBody @Valid Utilisateur utilisateur) {
		Utilisateur utilisateurCree = utilisateurService.enregistrerUtilisateur(utilisateur);
		if(utilisateurCree != null)
            return new ResponseEntity<>(utilisateurCree, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
