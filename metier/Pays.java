package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name = "Pays")
public class Pays {
	
	@Id
	@Column(name = "PAYS_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "VERSION", nullable = false)
	@Version
	private int version;

	@Column(name = "NOM_PAYS", length = 30, nullable = false, unique = true)
	private String nom_pays;
	
	@OneToMany(mappedBy = "Pays", cascade = {CascadeType.ALL})
	private Set<Region> regions = new HashSet <Region>();
	
	public Pays(){}
	
	public Pays ( String pNom_pays )
	{
		super();
		setNom_pays( pNom_pays );
	}
	
	public String toString ()
	{
		return String.format("[%d,%d,%s]", getId(), getVersion(),
				getNom_pays());
	}

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

	public String getNom_pays() {
		return nom_pays;
	}

	public void setNom_pays(String nom_pays) {
		this.nom_pays = nom_pays;
	}
	
	

}
