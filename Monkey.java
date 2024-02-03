// Inherits from RescueAnimal class
public class Monkey extends RescueAnimal {
	
	// Instance variables
	private String species;
	private String tailLength;
	private String height;
	private String bodyLength;
	
	// Constructor
	public Monkey(String name, String species, String gender, String age, String weight, String height, String tailLength, String bodyLength, String acquisitionDate, String acquisitionCountry, 
	String trainingStatus, boolean reserved, String inServiceCountry) {
		setName(name);
		setSpecies(species);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setHeight(height);
		setTailLength(tailLength);
		setBodyLength(bodyLength);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
	}
	
	// Default constructor for monkey-specific values
	public Monkey() {
		species = "Unknown";
		height = "Unknown";
		tailLength = "Unknown";
		bodyLength = "Unknown";
	}
	
	// Accessors and mutators
	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String getHeight() {
		return height;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getTailLength() {
		return tailLength;
	}
	
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}
	
	public String getBodyLength() {
		return bodyLength;
	}
	
	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}
}
