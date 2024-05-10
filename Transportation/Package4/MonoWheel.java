package Package4;
import Package1.WheeledTransportation;

/**
 * Train Class that is-a (extends) the WheeledTransportation class.
 */
public class MonoWheel extends WheeledTransportation {

    protected double maximumWeight;



    /////////////// Setters, Getters, AND constructors ///////////////


    /**
     * Default constructor that initializes all attributes to the zero of its type.
     */
    public MonoWheel() { // constructor
        this.maximumWeight = maximumWeight;
        this.setNumberOfWheels(0);
        this.setMaximumSpeed(0.0);
    }

    /**
     * Parameterized constructor that initializes its attributes through parameters.
     * @param numberOfWheels an integer value
     * @param maximumSpeed a double value
     * @param maximumWeight a double value
     */
    public MonoWheel(int numberOfWheels, double maximumSpeed, double maximumWeight) { // parametrized constructor
        super(numberOfWheels, maximumSpeed);
        this.maximumWeight = maximumWeight;
    }

    /**
     * Copy constructor that takes an object and copies its attributes.
     * @param object object taken
     */
    public MonoWheel(MonoWheel object) { // copy constructor
        this.maximumWeight = object.maximumWeight;
        setMaximumSpeed(object.getMaximumSpeed());
        setNumberOfWheels(object.getNumberOfWheels());
    }


    /**
     * Takes a double to set it as an attribute.
     * @param maximumWeight a double value
     */
    public void setMaximumWeight(double maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    /**
     * Gets the attribute needed.
     * @return the double value of the attribute
     */
    public double getMaximumWeight() {
        return maximumWeight;
    }



    ///////////////////// Other Methods /////////////////////

    /**
     * displays the object's attributes.
     * @return a string that contains the attributes
     */
    @Override   // toString method mainly used to print out the object Info in the proper way.
    public String toString() {
        return "The Number of Wheels is: " + getNumberOfWheels() + "\nThe Maximum Speed is: " + getMaximumSpeed() +
                "\nThe Number Maximum Weight is: " + getMaximumWeight() + "\n";
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
            MonoWheel monowheelObject = (MonoWheel) object;
            return (this.getMaximumSpeed() == monowheelObject.getMaximumSpeed() &&
                    this.getNumberOfWheels() == monowheelObject.getNumberOfWheels() &&
                    this.getMaximumWeight() == monowheelObject.getMaximumWeight());
        }
    }



}
