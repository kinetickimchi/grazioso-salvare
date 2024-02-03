import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Create monkey ArrayList
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    
    // Instance variables (if needed)

    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();

        // Create scanner for input
        Scanner scnr = new Scanner(System.in);
        
        // Initialize variable as a blank string to store user input
        String userInput = "";
        
        // Loop to show menu to user, get input, and take appropriate actions
        while (!userInput.equals("q")) { // 20231001: may consider changing this to do while loop
        	displayMenu(); // Call displayMenu method
        	userInput = scnr.nextLine(); // Getting user input
        	
        	// Switch statement to choose action, pass scnr input as argument
        	switch (userInput) {
        	case "1":
        		intakeNewDog(scnr);
        		break;
        		
        	case "2":
        		intakeNewMonkey(scnr);
        		break;
        	
        	case "3":
        		reserveAnimal(scnr);
        		break;
        	
        	case "4": // List all dogs
        		printAnimals("dog");
        		break;
        	
        	case "5": // List all monkeys
        		printAnimals("monkey");
        		break;
        	
        	case "6": // List available animals
        		printAnimals("available");
        		break;
        	
        	case "q": // if user decides to quit
        		System.out.println("Thanks for visiting.");
        		break;
        		
        	default: // If the user does not pick a valid option
        		System.out.println("Please enter a valid input from the menu options.");
        		
        	}
        	
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Jim", "Capuchin", "Male", "2", "22", "16", "15", "17", "01-01-2022", "France", "intake", false, "United States");
    	Monkey monkey2 = new Monkey("Mike", "Capuchin", "Male", "2", "22", "16", "15", "17", "01-01-2022", "United States", "in service", false, "United States");
    	Monkey monkey3 = new Monkey("Bill", "marmoset", "Male", "2", "22", "16", "15", "17", "01-01-2022", "Canada", "in service", false, "Canada");
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    }


    // Instantiate and add a new dog to the appropriate list
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        // Ensure dog doesn't exist already by name
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Instantiate a new dog if it doesn't exist already, get information, add to proper list
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine().toLowerCase(); // Ensure lowercase for consistency
        System.out.println("What is the dog's gender? [male/female]"); // Ensure lowercase for consistency
        String gender = scanner.nextLine().toLowerCase();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight? [in pounds]"); // Added units
        String weight = scanner.nextLine();
        System.out.println("What is the dog's acquisition date? [MM-DD-YYYY]"); // Fixed date format to match example
        String acquisitionDate = scanner.nextLine();
        System.out.println("What country was the dog acquired?");
        String acquisitionLocation = scanner.nextLine();
        System.out.println("What is the dog's training status? [intake, in service, phase I/II/III/IV/V]");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog reserved? If no, enter 0. If yes, enter 1.");
        String isReserved = scanner.nextLine(); // variable to hold input value for reserved status
        boolean reserved = false;
        // Loop to validate reserved status input
        	if (isReserved.equals("0")) {
        		reserved = false;
        	}
        	else if (isReserved.equals("1")) {
        		reserved = true;
        	}
        	else {
        		System.out.println("Please enter a valid input.");
        		return;
        	}
        System.out.println("What country is the dog in service?");
        String inServiceCountry = scanner.nextLine();
        
        // Create new dog
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);
        System.out.println("Dog has been added.");
    }


		// Instantiate and add the new monkey to the appropriate list
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            // Initialize species variable for validation
            String species = "";
            
            // Ensure monkey doesn't exist already by name
            for(Monkey monkey: monkeyList) {
            	if(monkey.getName().equalsIgnoreCase(name)) {
            		System.out.println("\n\nThis monkey is already in our system\n\n");
            		return; // Return to menu
            	}
            }
            
            // Validate species
            System.out.println("What is the monkey's species?");
            System.out.println("Valid options are capuchin, guenon, macaque, marmoset, squirrel monkey, or tamarin.");
            species = scanner.nextLine().toLowerCase(); // Ensures validation is not case sensitive
            if (!species.equals("capuchin") && !species.equals("guenon") && !species.equals("macaque") && !species.equals("marmoset") && !species.equals("squirrel monkey") && !species.equals("tamarin")) {
            	System.out.println("\n\nSorry, that is not a species we accept.\n\n");
            	return; // Return to menu
            }
            
            // Instantiate new monkey if it doesn't exist already, get information, add to proper list
            System.out.println("What is the monkey's gender? [male/female]");
            String gender = scanner.nextLine().toLowerCase(); // Ensure lowercase for consistency
            System.out.println("What is the monkey's age?");
            String age = scanner.nextLine();
            System.out.println("What is the monkey's weight? [in pounds]"); // Added units as appropriate
            String weight = scanner.nextLine();
            System.out.println("What is the monkey's height? [in inches]");
            String height = scanner.nextLine();
            System.out.println("What is the monkey's tail length? [in inches]");
            String tailLength = scanner.nextLine();
            System.out.println("What is the monkey's body length? [in inches]");
            String bodyLength = scanner.nextLine();
            System.out.println("What is the monkey's acquisition date? [MM-DD-YYYY]"); // Fixed date format to match example
            String acquisitionDate = scanner.nextLine();
            System.out.println("What country was the monkey acquired?");
            String acquisitionLocation = scanner.nextLine();
            System.out.println("What is the monkey's training status? [intake, in service, phase I/II/III/IV/V]");
            String trainingStatus = scanner.nextLine();
            System.out.println("Is the monkey reserved? If no, enter 0. If yes, enter 1.");
            String isReserved = scanner.nextLine(); // variable to hold input value for reserved status
            boolean reserved = false;
            // Loop to validate reserved status input
            	if (isReserved.equals("0")) {
            		reserved = false;
            	}
            	else if (isReserved.equals("1")) {
            		reserved = true;
            	}
            	else {
            		System.out.println("Please enter a valid input.");
            		return;
            	}
            System.out.println("What country is the monkey in service?");
            String inServiceCountry = scanner.nextLine();
            
            // Create new monkey
            Monkey newMonkey = new Monkey(name, species, gender, age, weight, height, tailLength, bodyLength, acquisitionDate, acquisitionLocation, trainingStatus, reserved, inServiceCountry);
            monkeyList.add(newMonkey);
            System.out.println("Monkey has been added.");
        }

        // Prompts the user to select an animal to reserve
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("What kind of animal are you reserving? [dog/monkey]");
            String animalType = scanner.nextLine();
            System.out.println("What country will the animal be serving in?");
            String requestedLocation = scanner.nextLine(); // Variable to temporarily store requested service country
            
            // If loop to check for available dogs
            if (animalType.equalsIgnoreCase("dog"))
            	// Check dogList
            	for(Dog dog: dogList) // If type is dog, inServiceLocation matches requestedLocation, and reserved is false
            		if (true && dog.getInServiceLocation().equalsIgnoreCase(requestedLocation) && !dog.getReserved()) {
            			// Set reserved  to true and match inServiceCountry to requestedLocation
            			dog.setReserved(true); 
            			dog.setInServiceCountry(requestedLocation);
            			System.out.println("Reservation for " + dog.getName() + " in " + dog.getInServiceLocation() + " was successful!");
            			return;
            		}
            
            // If loop to check for available monkeys
            if (animalType.equalsIgnoreCase("monkey"))
            	// Check monkeyList
            	for(Monkey monkey: monkeyList) // If type is monkey, inServiceLocation matches requestedLocation, and reserved is false
            		if (true && monkey.getInServiceLocation().equalsIgnoreCase(requestedLocation) && !monkey.getReserved()) {
            			// Set reserved to true and match inServiceCountry to requestedLocation
            			monkey.setReserved(true);
            			monkey.setInServiceCountry(requestedLocation);
            			System.out.println("Reservation for " + monkey.getName() + " in " + monkey.getInServiceLocation() + " was successful!");
            			return;
            		}
            
            // If conditions are not met for reservation
            System.out.println("Sorry, there doesn't appear to be an available " + animalType + " in " + requestedLocation + " at the moment.");

        }

        // Display animal name, training status, acquisition country, and reserved status based on chosen menu option
        public static void printAnimals(String listType) { // listType parameter to print lists depending on menu option
        	// Formats table header
            System.out.printf("%-10s | %-15s | %-20s | %-10s\n", "Name", "Training Status", "Acquisition Country", "Reserved");
            System.out.printf("----------------------------------------------------------------\n");
            
            // Switch statement to choose option based on requested listType
            switch(listType) {
            // Iterate through dogList and print name, trainingStatus, acquisitionLocation, and reserved status
            case "dog":
            	for (Dog dog: dogList) {
            		String name = dog.getName();
            		String trainingStatus = dog.getTrainingStatus();
            		String acquisitionLocation= dog.getAcquisitionLocation();
            		boolean reserved = dog.getReserved();
            		System.out.printf("%-10s | %-15s | %-20s | %-10s\n",  name, trainingStatus, acquisitionLocation, reserved);
            		System.out.printf("----------------------------------------------------------------\n");
            	}
            	break;
            	
            // Iterate through monkeyList and print name, trainingStatus, acquisitionLocation, and reserved status
            case "monkey":
            	for (Monkey monkey: monkeyList) {
            		String name = monkey.getName();
            		String trainingStatus = monkey.getTrainingStatus();
            		String acquisitionLocation = monkey.getAcquisitionLocation();
            		boolean reserved = monkey.getReserved();
            		System.out.printf("%-10s | %-15s | %-20s | %-10s\n",  name, trainingStatus, acquisitionLocation, reserved);
            		System.out.printf("----------------------------------------------------------------\n");
            	}
            	break;
            	
            case "available":
            	// Print available dogs (not reserved and graduated)
            	System.out.printf("                            DOGS                                \n");
            	for (Dog dog: dogList) {
            		String name = dog.getName();
            		String trainingStatus = dog.getTrainingStatus();
            		String acquisitionLocation = dog.getAcquisitionLocation();
            		boolean reserved = dog.getReserved();
            		// Dog is available if reserved is false AND training status is in service (graduated)
            		boolean available = !reserved && trainingStatus.equalsIgnoreCase("in service");
            		
            		// Skip dog if conditions not met
            		if (!available) {
            			continue;
            		}
            		
            		System.out.printf("%-10s | %-15s | %-20s | %-10s\n",  name, trainingStatus, acquisitionLocation, reserved);
            	}
            	
            	// Print available monkeys (not reserved and graduated)
            	System.out.printf("----------------------------------------------------------------\n");
            	System.out.printf("                           MONKEYS                              \n");
            	for (Monkey monkey: monkeyList) {
            		String name = monkey.getName();
            		String trainingStatus = monkey.getTrainingStatus();
            		String acquisitionLocation= monkey.getAcquisitionLocation();
            		boolean reserved = monkey.getReserved();
            		// Monkey is available if reserved is false AND training status is in service (graduated)
            		boolean available = !reserved && trainingStatus.equalsIgnoreCase("in service");
            		
            		// Skip monkey if conditions not met
            		if (!available) {
            			continue;
            		}
            		
            		System.out.printf("%-10s | %-15s | %-20s | %-10s\n",  name, trainingStatus, acquisitionLocation, reserved);
            	}
            	System.out.printf("----------------------------------------------------------------\n");
            	break;
            }
            

        }
}

