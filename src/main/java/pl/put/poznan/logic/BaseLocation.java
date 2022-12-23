package pl.put.poznan.logic;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Our abstract class containing information for all objects
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class BaseLocation implements Location {
    /** Our unique element for identification our other objects  */
    protected int id;
    /** Our name information */
    protected String name;
    /**
     * Constructor - creating a new object with certain values
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     * */
    public BaseLocation(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     * Return id, used in other functions
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Return name, used in other functions
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Return area, used in other functions
     * @return default 0
     */
    public float getArea() {
        return 0;
    }

    /**
     * This method sum size of rooms
     * @return size as [m^3]
     */
    public float getCube(){
        return 0;
    }

    /**
     * Method feeding the heating of one room
     * @return amount of energy
     */
    public float getHeating() {
        return 0;
    }

    /**
     * Method feeding the light of one room
     * @return amount of energy
     */
    public float getLight() {
        return 0;
    }

}
