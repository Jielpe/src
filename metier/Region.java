package metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


@SuppressWarnings("unused")
@Entity
@Table(name="region")
public class Region{

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "VERSION", nullable = false)
	@Version
	private int version;

	@Column(name = "NOM", length = 30, nullable = false, unique = true)
	private String nom_region;
	
	@OneToMany(mappedBy = "region", cascade = { CascadeType.ALL }) 
    private Set<Ville> villes = new HashSet<Ville>(); 
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "pays_id", nullable = false) 
    private Pays pays;



	// constructeurs
	public Region() {
	}

	public Region(String nom_region, Pays pays) {
		setNom_region(nom_region);
		setPays(pays);
	}

	// toString
	public String toString() {
		return String.format("[%d,%d,%s,%s]", getId(), getVersion(),
				getNom_region(), pays.toString());
	}

	
	//ACCESSEURS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	public String getNom_region() {
		return nom_region;
	}

	public void setNom_region(String nom_region) {
		this.nom_region = nom_region;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	public void addVille(Ville ville){
		villes.add(ville);
	}
	
	public Set<Ville> getVille(){
		return villes;
	}

}
	