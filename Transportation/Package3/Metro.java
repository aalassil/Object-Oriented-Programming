package Package3;
import Package2.Train;

/**
 * Metro class that is-a (extends) the Train class.
 */
public class Metro extends Train {

    protected int totalNumberOfStops;



    /////////////// Setters, Getters, AND constructors ///////////////

    /**
     * Default constructor that initializes all attributes to the zero of its type.
     */
    public Metro(){ // constructor
        this.setNumberOfWheels(0);
        this.setMaximumSpeed(0.0);
        this.setNumberOfVehicles(0);
        this.setStartingStation(null);
        this.setDestinationStation(null);
        this.totalNumberOfStops = 0;
    }

    /**
     * Parameterized constructor that initializes its attributes through parameters.
     * @param numberOfWheels an integer value
     * @param maximumSpeed a double value
     * @param numberOfVehicles an integer value
     * @param startingStation a string
     * @param destinationStation a string
     * @param totalNumberOfStops an integer value
     */
    public Metro(int numberOfWheels, double maximumSpeed, int numberOfVehicles,
                 String startingStation, String destinationStation, int totalNumberOfStops) { // parametrized constructor
        super(numberOfWheels, maximumSpeed, numberOfVehicles, startingStation, destinationStation);
        this.totalNumberOfStops = totalNumberOfStops;
    }

    /**
     * Copy constructor that takes an object and copies its attributes.
     * @param object object taken
     */
    public Metro(Metro object) { // copy constructor
        this.totalNumberOfStops = object.totalNumberOfStops;
        setDestinationStation(object.getDestinationStation());
        setStartingStation(object.getStartingStation());
        setNumberOfVehicles(object.getNumberOfVehicles());
        setMaximumSpeed(object.getMaximumSpeed());
        setNumberOfWheels(object.getNumberOfWheels());
    }


    /**
     * Takes an integer to set it as an attribute.
     * @param totalNumberOfStops an integer value
     */
    public void setTotalNumberOfStops(int totalNumberOfStops) {
        this.totalNumberOfStops = totalNumberOfStops;
    }

    /**
     * Gets the attribute needed.
     * @return the integer value of the attribute
     */
    public int getTotalNumberOfStops() {
        return totalNumberOfStops;
    }




    ///////////////////// Other Methods /////////////////////

    /**
     * displays the object's attributes.
     * @return a string that contains the attributes
     */
    @Override     // toString method mainly used to print out the object Info in the proper way.
    public String toString() {
        return "The Number of Wheels is: " + getNumberOfWheels() + "\nThe Maximum Speed is: " + getMaximumSpeed() +
                "\nThe Number of Vehicles is: " + getNumberOfVehicles() +
                "\nThe Name of The Starting Station is: " + getStartingStation() +
                "\nThe Name of The Destination Station is: " + getDestinationStation() +
                "\nThe Total Number of Stops is: " + getTotalNumberOfStops() + "\n";
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
            Metro metroObject = (Metro) object;
            return (this.getMaximumSpeed() == metroObject.getMaximumSpeed() &&
                    this.getNumberOfWheels() == metroObject.getNumberOfWheels() &&
                    this.getNumberOfVehicles() == metroObject.getNumberOfVehicles() &&
                    this.getDestinationStation() == metroObject.getDestinationStation() &&
                    this.getStartingStation() == metroObject.getStartingStation()) &&
                    this.getTotalNumberOfStops() == metroObject.getTotalNumberOfStops();
        }
    }

}
