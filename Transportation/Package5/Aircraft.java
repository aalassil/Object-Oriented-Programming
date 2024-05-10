package Package5;
import DriverPackage.Air;

/**
 * Aircraft Class that is-a (extends) the Air class.
 */
public class Aircraft extends Air {

    protected double price;
    protected double maximumElevation;


    /////////////// Setters, Getters, AND constructors ///////////////

    /**
     * Default constructor that initializes all attributes to the zero of its type.
     */
    public Aircraft(){  // constructor
        this.price = 0.0;
        this.maximumElevation = 0.0;
    }

    /**
     * Parameterized constructor that initializes its attributes through parameters.
     * @param price a double value
     * @param maximumElevation a double value
     */
    public Aircraft(double price, double maximumElevation) { // parametrized constructor
        this.price = price;
        this.maximumElevation = maximumElevation;
    }

    /**
     * Copy constructor that takes an object and copies its attributes.
     * @param object object taken
     */
    public Aircraft(Aircraft object){ // copy constructor
        this.price = object.price;
        this.maximumElevation = object.maximumElevation;
    }


    /**
     * Takes a double to set it as an attribute.
     * @param price a double value
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the attribute needed.
     * @return the double value of the attribute
     */
    public double getPrice() {
        return price;
    }


    /**
     * Takes a double to set it as an attribute.
     * @param maximumElevation a double value
     */
    public void setMaximumElevation(double maximumElevation) {
        this.maximumElevation = maximumElevation;
    }

    /**
     * Gets the attribute needed.
     * @return the double value of the attribute
     */
    public double getMaximumElevation() {
        return maximumElevation;
    }




    ///////////////////// Other Methods /////////////////////

    /**
     * accepts an array of mixed objects and then compares two Aircraft objects' prices.
     * @param object Aircraft object taken
     * @return a statement that says what's least and most expensive,
     * or if they're equal (or an error if none is found)
     */
    public boolean compareAircraftPrices(Object object){
        if (object == null || this.getClass() != object.getClass())
        {
            return false;
        }else
        {
            Aircraft aircraftObject = (Aircraft) object;
            if ( aircraftObject.getPrice() > this.getPrice())
            {
                System.out.println("The Least Expensive Aircraft is: " + this.getPrice() + "$");
                System.out.println("The Most Expensive Aircraft is: " + aircraftObject.getPrice() + "$");
            } else if (aircraftObject.getPrice() < this.getPrice())
            {
                System.out.println("The Least Expensive Aircraft is: " + aircraftObject.getPrice() + "$");
                System.out.println("The Most Expensive Aircraft is: " + this.getPrice() + "$");
            } else if (aircraftObject.getPrice() == this.getPrice())
            {
                System.out.println("They Have The Same Price, Which Equals To: " + this.getPrice());
            }else
            {
                System.out.println("There's no Aircraft Object! ");
            }
            return true;
        }
    }

    /**
     * displays the object's attributes.
     * @return a string that contains the attributes
     */
    @Override     // toString method mainly used to print out the object Info in the proper way.
    public String toString() {
        return "The Aircraft Price is: " + getPrice() + "\nThe Maximum elevation is: " + getMaximumElevation() + "\n";
    }

    /**
     * Compares two object's attributes.
     * @param object object taken
     * @return a boolean which would return ether true or false
     */
    @Override     // Equals method compare two objects attributes and return true/false value.
    public boolean equals(Object object){
        if (object == null || this.getClass() != object.getClass())
        {
            return false;
        }else
        {
            Aircraft aircraftObject = (Aircraft) object;
            return (this.price == aircraftObject.getPrice() &&
                    this.maximumElevation == aircraftObject.maximumElevation);
        }
    }

}
