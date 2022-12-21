package pl.put.poznan.logic;

import java.util.ArrayList;

/**
 * Contains info about single floor.
 */
public class Floor extends Location
{
    /**
     * Array List with information about all our rooms in floor
     */
    private ArrayList<Room> rooms = new ArrayList<Room>();
    /**
     * Class constructor
     * @see Floor#Floor(int id, String name)
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     */
    public Floor(int id, String name)
    {
        super(id, name);
    }

    /**
     * This method returns our Rooms
     * @return all our rooms of one floor
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    /**
     * This method add Room objects to list of rooms
     * @param object room
     */
    public void add(Room object)
    {
        rooms.add(object);
    }
    /**
     * This method uses for show information about all rooms in floor
     * Their name as table
     */
    public void show()
    {
        System.out.println("List of rooms on the floor " + this.name + ": ");
        rooms.forEach((n) -> System.out.println(" - " + n.name));
    }
    /**
     * This method uses to calculate the all area in all rooms
     * @return sum of area all room in building as [m^2]
     */
    public float sumArea() {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getArea();
        return sum;
    }

    /**
     * Calculate light on the whole floor
     * @return sum of area all room in building as [m^2]
     */
    public float sumLight() {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getLight();
        return sum;
    }
    /**
     * This method is used to display information about the area of one floor
     * Their name as table
     */
    public void showArea()
    {
        System.out.println(this.name + " floor area: " + sumArea());
    }

    /**
     * Show average value power of lightning on the floor
     */
    public void showLightPower()
    {
        float sum_area = this.sumArea();
        float sum_light = this.sumLight();
        System.out.print("Power of lightning on the floor " + this.name +": ");
        if (sum_area != 0)
            System.out.println(sum_light / sum_area);
        else
            System.out.println("0");
    }

    /**
     * This method sum cubes
     * @return sum as [m^3] all rooms of one floor
     */
    public float sumCube()
    {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getCube();
        return sum;
    }

    /**
     * Select overheated rooms
     * @param border heating value which cannot be overrated
     * @return list of overheated rooms
     */
    public ArrayList<Room> levelHeating(float border)
    {
        ArrayList<Room> group = new ArrayList<Room>();
        for (Room room : rooms)
        {
            if (room.heatingLevel(border))
            {
                group.add(room);
            }
        }
        return group;
    }
}
