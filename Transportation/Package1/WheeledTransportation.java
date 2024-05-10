package Package1;
import DriverPackage.Land;


/**
 * WheeledTransportation Class that numberOfWheels and MaximumSpeed Attributes. Plus its methods.
 */
public class WheeledTransportation extends Land { // a WheeledTransportation class that inherit Land class.

    protected int numberOfWheels;       // Attributes
    protected double maximumSpeed;



    /////////////// Setters, Getters, AND constructors ///////////////

    /**
     * WheeledTransportation default constructor that initialize its attributes.
     */
    public WheeledTransportation(){ // constructor
        this.numberOfWheels = 0;
        this.maximumSpeed = 0.0;
    }

    /**
     * WheeledTransportation parameterized constructor that initializes its attributes.
     * @param numberOfWheels an integer value
     * @param maximumSpeed a double value
     */
    public WheeledTransportation(int numberOfWheels, double maximumSpeed) { // parametrized constructor
        this.numberOfWheels = numberOfWheels;
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * WheeledTransportation copy constructor that takes an object to initialize the attributes.
     * @param object takes an object (that we want to copy)
     */
    public WheeledTransportation(WheeledTransportation object){ // copy constructor
        this.numberOfWheels = object.numberOfWheels;
        this.maximumSpeed = object.maximumSpeed;
    }


    /**
     * Takes an integer to set it as an attribute.
     * @param numberOfWheels an integer value
     */
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    /**
     * Gets the attribute needed.
     * @return the integer value of the attribute
     */
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    /**
     * Takes a double to set it as an attribute.
     * @param maximumSpeed a double value
     */
    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Gets the attribute needed.
     * @return the double value of the attribute
     */
    public double getMaximumSpeed() {
        return maximumSpeed;
    }



    /////////////// Other Methods ///////////////

    /**
     * displays the object's attributes.
     * @return a string that contains the attributes
     */
    @Override    // toString method mainly used to print out the object Info in the proper way.
    public String toString() {
        return "The Number of Wheels is: " + getNumberOfWheels() + "\nThe Maximum Speed is: " + getMaximumSpeed() + "\n";
    }

    /**
     * Compares two object's attributes
     * @param object takes an object
     * @return a boolean which would be true or false
     */
    @Override    // Equals method compare two objects attributes and return true/false value.
    public boolean equals(Object object){
        if (object == null || this.getClass() != object.getClass())
        {
            return false;
        }else
        {
            WheeledTransportation wheeledObject = (WheeledTransportation) object;
            return (this.getMaximumSpeed() == wheeledObject.getMaximumSpeed() &&
                    this.getNumberOfWheels() == wheeledObject.getNumberOfWheels());
        }
    }

}
