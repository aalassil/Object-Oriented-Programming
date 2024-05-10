package Package6;
import DriverPackage.Sea;

/**
 * Ferry Class that is-a (extends) the Sea class.
 */
public class Ferry extends Sea {

    protected double maximumSpeedFerry;
    protected double maximumLoad;


    /////////////// Setters, Getters, AND constructors ///////////////

    /**
     * Default constructor that initializes all attributes to the zero of its type.
     */
    public Ferry(){ // constructor
        this.maximumSpeedFerry = 0.0;
        this.maximumLoad = 0.0;
    }

    /**
     * Parameterized constructor that initializes its attributes through parameters.
     * @param maximumSpeedFerry a double value
     * @param maximumLoad a double value
     */
    public Ferry(double maximumSpeedFerry, double maximumLoad) { // parametrized constructor
        this.maximumSpeedFerry = maximumSpeedFerry;
        this.maximumLoad = maximumLoad;
    }

    /**
     * Copy constructor that takes an object and copies its attributes.
     * @param object object taken
     */
    public Ferry(Ferry object){ // copy constructor
        this.maximumSpeedFerry = object.maximumSpeedFerry;
        this.maximumLoad = object.maximumLoad;
    }


    /**
     * Takes a double to set it as an attribute.
     * @param maximumSpeedFerry a double
     */
    public void setMaximumSpeedFerry(double maximumSpeedFerry) {
        this.maximumSpeedFerry = maximumSpeedFerry;
    }

    /**
     * Gets the attribute needed.
     * @return the double value of the attribute
     */
    public double getMaximumSpeedFerry() {
        return maximumSpeedFerry;
    }


    /**
     * Takes a double to set it as an attribute.
     * @param maximumLoad a double
     */
    public void setMaximumLoad(double maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    /**
     * Gets the attribute needed.
     * @return the double value of the attribute
     */
    public double getMaximumLoad() {
        return maximumLoad;
    }



    ///////////////////// Other Methods /////////////////////

    /**
     * displays the object's attributes.
     * @return a string that contains the attributes
     */
    @Override    // toString method mainly used to print out the object Info in the proper way.
    public String toString() {
       return "The Maximum Speed of The Ferry is: " + getMaximumSpeedFerry() +
               "\nThe Maximum Load is: " + getMaximumLoad() + "\n";
    }

    /**
     * Compares two object's attributes.
     * @param object object taken
     * @return a boolean which would return ether true or false
     */
    @Override    // Equals method compare two objects attributes and return true/false value.
    public boolean equals(Object object){
        if (object == null || this.getClass() != object.getClass())
        {
            return false;
        }else
        {
            Ferry ferryObject = (Ferry) object;
            return (this.maximumSpeedFerry == ferryObject.getMaximumSpeedFerry() &&
                    this.maximumLoad == ferryObject.getMaximumLoad());
        }
    }

}
