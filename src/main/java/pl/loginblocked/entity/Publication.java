package pl.loginblocked.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Publication {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String annexNumber;
	@Lob
	private String description;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "species_id")
	private Species species;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "image_id")
	private Image image;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE
	})
	@JoinTable(name = "species_publications",
	joinColumns = {@JoinColumn(name = "publication_id")},
	inverseJoinColumns = {@JoinColumn(name = "species_id")})
	private Set<Species> speciesList = new HashSet<>();
	private boolean favourites = false;
	
	
	public Publication() {
		super();
	}
	public Publication(Long id, String name, String annexNumber, String description, Category category, Species species,
			Image image) {
		super();
		this.id = id;
		this.name = name;
		this.annexNumber = annexNumber;
		this.description = description;
		this.category = category;
		this.species = species;
		this.image = image;
	}
	
	
	public Publication(Long id, String name, String annexNumber, String description, Category category, Species species,
			Image image, boolean favourites) {
		super();
		this.id = id;
		this.name = name;
		this.annexNumber = annexNumber;
		this.description = description;
		this.category = category;
		this.species = species;
		this.image = image;
		this.favourites = false;
	}
	
	
	public Publication(Long id, String name, String annexNumber, String description, Category category, Species species,
			Image image, Set<Species> speciesList, boolean favourites) {
		super();
		this.id = id;
		this.name = name;
		this.annexNumber = annexNumber;
		this.description = description;
		this.category = category;
		this.species = species;
		this.image = image;
		this.speciesList = speciesList;
		this.favourites = false;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnnexNumber() {
		return annexNumber;
	}
	public void setAnnexNumber(String annexNumber) {
		this.annexNumber = annexNumber;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	public Set<Species> getSpeciesList() {
		return speciesList;
	}
	
	public void setSpeciesList(Set<Species> speciesList) {
		this.speciesList = speciesList;
	}
	public boolean isFavourites() {
		return favourites;
	}
	public void setFavourites(boolean favourites) {
		this.favourites = favourites;
	}
	
	
	
}