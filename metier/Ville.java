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
@Table(name="ville")
public class Ville{

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "VERSION", nullable = false)
	@Version
	private int version;

	@Column(name = "NOM", length = 30, nullable = false, unique = true)
	private String nom_ville;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "region_id", nullable = false) 
    private Region region;
	
//	@OneToMany(mappedBy = "ville", cascade = { CascadeType.ALL }) 
//    private Set<Hotel> hotels = new HashSet<Hotel>(); 
//	
//	@OneToMany(mappedBy = "ville", cascade = { CascadeType.ALL }) 
//    private Set<Client> clients = new HashSet<Client>(); 



	// constructeurs
	public Ville() {
	}

	public Ville(String nom_ville, Region region) {
		setNom_ville(nom_ville);
		setRegion(region);
	}

	// toString
	public String toString() {
		return String.format("[%d,%d,%s,%s]", getId(), getVersion(),
				getNom_ville(), region.toString());
	}

	//ACCESSEURS
	public String getNom_ville() {
		return nom_ville;
	}

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
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
	
//	public void addHotel(Hotel hotel){
//		hotels.add(hotel);
//	}
//	
//	public Set<Hotel> getHotel(){
//		return hotels;
//	}
//
//	public void addVClient(Client client){
//		clients.add(client);
//	}
//	
//	public Set<Client> getClient(){
//		return clients;
//	}

}
	