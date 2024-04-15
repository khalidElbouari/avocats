package org.avocats.avocats.entities.avocats;



import java.sql.Date;
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
import org.avocats.avocats.entities.security.Role;


@Entity
public class Client{
	
	 @Id
	    @Column(unique = true, nullable = false)
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    

		private String firstName;
	    private String lastName;
	    private String email;
	    private String tel;
	    private String telfixe;
	    private String adresse;
	    private Date DateCreation;
	    private String CarteNational;
	    @Column(length = 60)
	    private String password;
	    @Lob
		@Column(columnDefinition="MEDIUMBLOB")
		private String imguser;
	    
	public String getImguser() {
			return imguser;
		}
		public void setImguser(String imguser) {
			this.imguser = imguser;
		}
	@ManyToMany(mappedBy ="clients",cascade = CascadeType.REMOVE)
	private Collection<BureauAvocat> bureau;
	
	  @ManyToMany(mappedBy = "client",cascade = CascadeType.REMOVE) 
	  private Collection<Avocat> avocat;
	 
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinTable( name = "dossier_Client", joinColumns = @JoinColumn( name = "client_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn( name = "dossier_id", referencedColumnName = "id"))
	private Collection<Dossier> dossier;
	
	
	public Collection<Avocat> getAvocat() {
		return avocat;
	}
	public void setAvocat(Collection<Avocat> avocat) {
		this.avocat = avocat;
	}
	public Collection<Dossier> getDossier() {
		return dossier;
	}
	public void setDossier(Collection<Dossier> dossier) {
		this.dossier = dossier;
	}
	
	public Collection<BureauAvocat> getBureau() {
		return bureau;
	}
	public void setBureau(Collection<BureauAvocat> bureau) {
		this.bureau = bureau;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getTelfixe() {
		return telfixe;
	}
	public void setTelfixe(String telfixe) {
		this.telfixe = telfixe;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public String getCarteNational() {
		return CarteNational;
	}
	public void setCarteNational(String carteNational) {
		CarteNational = carteNational;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Client(Long id, String firstName, String lastName, String email, String tel, String telfixe, String adresse,
			Date dateCreation, String carteNational, String password, Collection<BureauAvocat> bureau,
			Collection<Avocat> avocat, Collection<Dossier> dossier) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tel = tel;
		this.telfixe = telfixe;
		this.adresse = adresse;
		DateCreation = dateCreation;
		CarteNational = carteNational;
		this.password = password;
		this.bureau = bureau;
		this.avocat = avocat;
		this.dossier = dossier;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Long id, String firstName, String lastName, String email, String tel, String telfixe, String adresse,
			Date dateCreation, String carteNational, String imguser, String password, boolean enabled,
			boolean isUsing2FA, String secret, Collection<Role> roles) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
