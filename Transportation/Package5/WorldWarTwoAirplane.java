package Package5;

/**
 *  WorldWarTwoAirplane Class that is-a (extends) the Aircraft class.
 */
public class WorldWarTwoAirplane extends Aircraft{

    protected boolean twinEngine;




    /////////////// Setters, Getters, AND constructors ///////////////

    /**
     * Default constructor that initializes all attributes to the zero of its type.
     */
    public WorldWarTwoAirplane() {
        this.twinEngine = false;
        setPrice(0.0);
        setMaximumElevation(0.0);
    }

    /**
     * Parameterized constructor that initializes its attributes through parameters.
     * @param price a double value
     * @param maximumElevation a double value
     * @param twinEngine a boolean
     */
    public WorldWarTwoAirplane(double price, double maximumElevation, boolean twinEngine) {
        super(price, maximumElevation);
        this.twinEngine = twinEngine;
    }

    /**
     * Copy constructor that takes an object and copies its attributes.
     * @param object Aircraft object taken
     * @param twinEngine a boolean
     */
    public WorldWarTwoAirplane(Aircraft object, boolean twinEngine) {
        super(object);
        this.twinEngine = twinEngine;
    }


    /**
     * Takes a boolean to set it as an attribute.
     * @param twinEngine a boolean
     */
    public void setTwinEngine(boolean twinEngine) {
        this.twinEngine = twinEngine;
    }

    /**
     * Gets the attribute needed.
     * @return a boolean
     */
    public boolean getTwinEngine() {
        return twinEngine;
    }




    ///////////////////// Other Methods /////////////////////

    /**
     * displays the object's attributes.
     * @return a string that contains the attributes
     */
    @Override     // toString method mainly used to print out the object Info in the proper way.
    public String toString() {
        return "The World War II Airplane Price is: " + getPrice() + "\nThe Maximum elevation is: " + getMaximumElevation() +
                "\nTwin Engine: " + getTwinEngine() + "\n";
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
            WorldWarTwoAirplane worldWarTwoAirplane = (WorldWarTwoAirplane) object;
            return (this.getPrice() == worldWarTwoAirplane.getPrice() &&
                    this.getMaximumElevation() == worldWarTwoAirplane.getMaximumElevation() &&
                    this.getTwinEngine() == worldWarTwoAirplane.getTwinEngine());
        }
    }
}
