package Package2;
import Package3.Metro;

/**
 * Tram class that is-a (extends) the Metro class.
 */
public class Tram extends Metro {

    protected int yearOfCreation;



    /////////////// Setters, Getters, AND constructors ///////////////

    /**
     * Default constructor that initializes all attributes to the zero of its type.
     */
    public Tram(){ // constructor
        this.yearOfCreation = 0;
        this.setYearOfCreation(0);
        this.setNumberOfWheels(0);
        this.setMaximumSpeed(0.0);
        this.setNumberOfVehicles(0);
        this.setStartingStation(null);
        this.setDestinationStation(null);
    }

    /**
     * Parameterized constructor that initializes its attributes through parameters.
     * @param numberOfWheels an integer value
     * @param maximumSpeed a double value
     * @param numberOfVehicles an integer value
     * @param startingStation a string
     * @param destinationStation a string
     * @param totalNumberOfStops an integer value
     * @param yearOfCreation an integer value
     */
    public Tram(int numberOfWheels, double maximumSpeed, int numberOfVehicles,
                String startingStation, String destinationStation, int totalNumberOfStops, int yearOfCreation) { // parametrized constructor
        super(numberOfWheels, maximumSpeed, numberOfVehicles, startingStation, destinationStation, totalNumberOfStops);
        this.yearOfCreation = yearOfCreation;
    }

    /**
     * Copy constructor that takes an object and copies its attributes.
     * @param object object taken
     */
    public Tram(Tram object){ // copy constructor
        this.yearOfCreation = object.yearOfCreation;
        setDestinationStation(object.getDestinationStation());
        setNumberOfVehicles(object.getNumberOfVehicles());
        setStartingStation(object.getStartingStation());
        setMaximumSpeed(object.getMaximumSpeed());
        setNumberOfWheels(object.getNumberOfWheels());
        setTotalNumberOfStops(object.getTotalNumberOfStops());
    }

    /**
     * Takes an integer to set it as an attribute.
     * @param yearOfCreation an integer value
     */
    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    /**
     * Gets the attribute needed.
     * @return the integer value of the attribute
     */
    public int getYearOfCreation() {
        return yearOfCreation;
    }



    ///////////////////// Other Methods /////////////////////

    /**
     * displays the object's attributes.
     * @return a string that contains the attributes
     */
    @Override    // toString method mainly used to print out the object Info in the proper way.
    public String toString() {
        return "The Number of Wheels is: " + getNumberOfWheels() + "\nThe Maximum Speed is: " + getMaximumSpeed() +
                "\nThe Number of Vehicles is: " + getNumberOfVehicles() +
                "\nThe Name of The Starting Station is: " + getStartingStation() +
                "\nThe Name of The Destination Station is: " + getDestinationStation() +
                "\nThe Total Number of Stops is: " + getTotalNumberOfStops() +
                "\nThe Year Creation is: " + getYearOfCreation() + "\n";
    }


    /**
     * Compares two object's attributes.
     * @param object takes an object
     * @return a boolean which would be true or false
     */
    @Override     // Equals method compare two objects attributes and return true/false value.
    public boolean equals(Object object){
        if (object == null || this.getClass() != object.getClass())
        {
            return false;
        }else
        {
            Tram tramObject = (Tram) object;
            return (this.getMaximumSpeed() == tramObject.getMaximumSpeed() &&
                    this.getNumberOfWheels() == tramObject.getNumberOfWheels() &&
                    this.getNumberOfVehicles() == tramObject.getNumberOfVehicles() &&
                    this.getDestinationStation() == tramObject.getDestinationStation() &&
                    this.getStartingStation() == tramObject.getStartingStation()) &&
                    this.getTotalNumberOfStops() == tramObject.getTotalNumberOfStops() &&
                    this.getYearOfCreation() == tramObject.getYearOfCreation();
        }
    }
}
