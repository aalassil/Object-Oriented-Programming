package Package2;

import Package1.WheeledTransportation;

/**
 * Train Class that is-a (extends) the WheeledTransportation class.
 */
public class Train extends WheeledTransportation {  // Train Class that inherit WheeledTransportation Class.

    protected int numberOfVehicles;          // Attributes
    protected String startingStation;
    protected String destinationStation;



    /////////////// Setters, Getters, AND constructors ///////////////

    /**
     * Default constructor that initializes all attributes to the zero of its type.
     */
    public Train(){  // constructor
        this.setMaximumSpeed(0.0);
        this.setNumberOfWheels(0);
        this.numberOfVehicles = 0;
        this.startingStation = null;
        this.destinationStation = null;
    }

    /**
     * Parameterized constructor that initializes its attributes through parameters.
     * @param numberOfWheels an integer value
     * @param maximumSpeed a double value
     * @param numberOfVehicles an integer value
     * @param startingStation a string
     * @param destinationStation a string
     */
    public Train(int numberOfWheels, double maximumSpeed, int numberOfVehicles,
                 String startingStation, String destinationStation) { // parametrized constructor
        super(numberOfWheels, maximumSpeed);
        this.numberOfVehicles = numberOfVehicles;
        this.startingStation = startingStation;
        this.destinationStation = destinationStation;
    }

    /**
     * Copy constructor that takes an object and copies its attributes.
     * @param object object taken
     */
    public Train(Train object){  // copy constructor
        this.setMaximumSpeed(object.getMaximumSpeed());
        this.setNumberOfWheels(object.getNumberOfWheels());
        this.numberOfVehicles = object.numberOfVehicles;
        this.startingStation = object.startingStation;
        this.destinationStation = object.destinationStation;
    }


    /**
     * Takes an integer to set it as an attribute.
     * @param numberOfVehicles an integer value
     */
    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    /**
     * Gets the attribute needed.
     * @return the integer value of the attribute
     */
    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }


    /**
     * Takes a string to set it as an attribute.
     * @param startingStation a string object/value
     */
    public void setStartingStation(String startingStation) {
        this.startingStation = startingStation;
    }

    /**
     * Gets the attribute needed.
     * @return the string value of the attribute
     */
    public String getStartingStation() {
        return startingStation;
    }


    /**
     * Takes a string to set it as an attribute.
     * @param destinationStation a string object/value
     */
    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    /**
     * Gets the attribute needed.
     * @return the string value of the attribute
     */
    public String getDestinationStation() {
        return destinationStation;
    }



    ///////////////////// Other Methods /////////////////////

    /**
     * displays the object's attributes.
     * @return a string that contains the attributes
     */
    @Override      // toString method mainly used to print out the object Info in the proper way.
    public String toString() {
        return "The Number of Wheels is: " + getNumberOfWheels() + "\nThe Maximum Speed is: " + getMaximumSpeed() +
                "\nThe Number of Vehicles is: " + getNumberOfVehicles() +
                "\nThe Name of The Starting Station is: " + getStartingStation() +
                "\nThe Name of The Destination Station is: " + getDestinationStation() + "\n";
    }

    /**
     * Compares two object's attributes.
     * @param object takes an object
     * @return a boolean which would be true or false
     */
    @Override      // Equals method compare two objects attributes and return true/false value.
    public boolean equals(Object object){
        if (object == null || this.getClass() != object.getClass())
        {
            return false;
        }else
        {
            Train trainObject = (Train) object;
            return (this.getMaximumSpeed() == trainObject.getMaximumSpeed() &&
                    this.getNumberOfWheels() == trainObject.getNumberOfWheels() &&
                    this.getNumberOfVehicles() == trainObject.getNumberOfVehicles() &&
                    this.getDestinationStation() == trainObject.getDestinationStation() &&
                    this.getStartingStation() == trainObject.getStartingStation());
        }
    }
}
