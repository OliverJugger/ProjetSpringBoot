package fr.capgemini.interco.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="UTILISATEUR")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Utilisateur implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="ALIAS")
	private String alias;
	
	@Column(name="SALAIRE")
	private int salaire;
	
}
