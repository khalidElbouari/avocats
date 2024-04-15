package org.avocats.avocats.entities.avocats;

import jakarta.persistence.*;

import java.util.Collection;


@Entity
@Table(name = "barreau")
public class Barreau {
	

	@Column(unique = true, nullable = false, name = "ID_BARREAU")
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBarreau;
	
	@Column(length = 40, name = "NOM_BARREAU")
	private String nomBarreau;
	
	@OneToMany(mappedBy = "barreau", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Collection<Avocat> avocats;



	public Long getIdBarreau() {
		return idBarreau;
	}

	public void setIdBarreau(Long idBarreau) {
		this.idBarreau = idBarreau;
	}

	public String getNomBarreau() {
		return nomBarreau;
	}

	public void setNomBarreau(String nomBarreau) {
		this.nomBarreau = nomBarreau;
	}

	public Barreau(Long idBarreau, String nomBarreau) {
		super();
		this.idBarreau = idBarreau;
		this.nomBarreau = nomBarreau;
	}

	public Barreau() {
		super();
		// TODO Auto-generated constructor stub
	}



}
