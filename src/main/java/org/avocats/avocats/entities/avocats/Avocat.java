package org.avocats.avocats.entities.avocats;


import jakarta.persistence.*;
import org.avocats.avocats.entities.security.Utilisateur;

import java.io.Serializable;
import java.util.Collection;

@Entity
@DiscriminatorValue("AVOCAT")
public class Avocat extends Utilisateur implements Serializable {


	@Id
	@Column(name = "Haya_AVOCATS")
		private Long idBarreau;
		
		@ManyToOne(cascade = CascadeType.REMOVE)
		@JoinColumn(name = "Haya_AVOCAT",referencedColumnName="ID_BARREAU")
		private Barreau barreau;
		
		
		private boolean fonctionalite;
		 @ManyToMany(mappedBy = "avocat",cascade = CascadeType.REMOVE)
		 private Collection<Dossier> dossier;

	public Avocat() {
		super();
	}


	public Collection<Dossier> getDossier() {
			return dossier;
		}
		public void setDossier(Collection<Dossier> dossier) {
			this.dossier = dossier;
		}
		@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
		@JoinTable( name = "client_Avocat", joinColumns = @JoinColumn( name = "avocat_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn( name = "client_id", referencedColumnName = "id"))
		private Collection<Client> client;
		

		public Collection<Client> getClient() {
			return client;
		}
		public void setClient(Collection<Client> client) {
			this.client = client;
		}


		public Long getIdBarreau() {
			return idBarreau;
		}
		public void setIdBarreau(Long idBarreau) {
			this.idBarreau = idBarreau;
		}
		public Barreau getBarreau() {
			return barreau;
		}
		public void setBarreau(Barreau barreau) {
			this.barreau = barreau;
		}
		public boolean isFonctionalite() {
			return fonctionalite;
		}
		public void setFonctionalite(boolean fonctionalite) {
			this.fonctionalite = fonctionalite;
		}

	public Avocat(Long idBarreau, Barreau barreau, boolean fonctionalite, Collection<Dossier> dossier, Collection<Client> client) {
		this.idBarreau = idBarreau;
		this.barreau = barreau;
		this.fonctionalite = fonctionalite;
		this.dossier = dossier;
		this.client = client;
	}

	@Override
	public String toString() {
		return "Avocat{" +
				"idBarreau=" + idBarreau +
				", barreau=" + barreau +
				", fonctionalite=" + fonctionalite +
				", dossier=" + dossier +
				", client=" + client +
				'}';
	}
}
