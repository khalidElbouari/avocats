package org.avocats.avocats.entities.avocats;



import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
public class BureauAvocat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nom;
	private String email;
	private String tel;
	private String telfex;
	private String adresse;
	private String maps;
	@Lob
	@Column(columnDefinition="MEDIUMBLOB")
	private String image;
	private int Supp;
	
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinTable( name = "bureau_client", joinColumns = @JoinColumn( name = "bureau_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn( name = "client_id", referencedColumnName = "id"))
	private Collection<Client> clients;
	
	
	
	public String getTelfex() {
		return telfex;
	}
	public void setTelfex(String telfex) {
		this.telfex = telfex;
	}

	
	@OneToMany(mappedBy = "bureau", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Collection<Dossier> dossier;
	

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getSupp() {
		return Supp;
	}
	public void setSupp(int supp) {
		Supp = supp;
	}
	public Collection<Client> getClients() {
		return clients;
	}
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMaps() {
		return maps;
	}
	
	
	  @Override 
	  public String toString() {
		  return "BureauAvocat [id=" + id +", nom=" + nom + ", email=" + email + ", tel=" + tel + ", telfex=" + telfex +
	  ", adresse=" + adresse + ", Supp=" + Supp + ", image=" + image + ", clients="
	  + clients + "]"; }
}
