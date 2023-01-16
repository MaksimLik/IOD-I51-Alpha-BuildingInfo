package pl.put.poznan.logic;

import org.apache.tomcat.util.digester.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.*;

class FloorTest {
    Floor floor1, floor2, floor3;
    Room room1, room2, room3, room4, room5;
    @BeforeEach
    public void setUp()
    {
        floor1 = new Floor(1, "Carpet");
        floor2 = new Floor(2, "Restaurant");
        floor3 = new Floor(3, "Saloon");

        room1 = new Room(4, "Bathroom", 25, 85, 25, 40);
        room2 = new Room(5, "Kitchen", 40, 160, 45, 150);
        room3 = new Room(6, "Bedroom", 20, 55, 30, 30);
        room4 = new Room(7, "Living room", 125, 130, 215, 115);
        room5 = new Room(8, "Fake room", 1, -1, -1, -1);
        floor1.addRoom(room1);
        floor1.addRoom(room2);
        floor1.addRoom(room3);
        floor1.addRoom(room4);
        try {
            floor2.addRoom(room5);
        }
        catch (IllegalArgumentException ignored){}
    }

    @Test
    void testAddRoom()
    {
        assertThrows(IllegalArgumentException.class,
                () -> floor2.addRoom(room5));
    }

    @Test
    void testGetRooms()
    {
        Set<Room> floorRooms1 = new HashSet<Room>();
        Set<Room> floorRooms2 = new HashSet<Room>();
        Set<Room> floorRooms3 = new HashSet<Room>();
        floorRooms1.add(room1);
        floorRooms1.add(room2);
        floorRooms1.add(room3);
        floorRooms1.add(room4);
        Assert.assertEquals(floorRooms1, floor1.getRooms());
        Assert.assertEquals(floorRooms2, floor2.getRooms());
        Assert.assertEquals(floorRooms3, floor3.getRooms()); // empty floor
    }

    @Test
    void testGetArea()
    {
        Assert.assertEquals(210, floor1.getArea());
        Assert.assertEquals(0, floor2.getArea());
        Assert.assertEquals(0, floor3.getArea());
    }

    @Test
    void testGetLight()
    {
        Assert.assertEquals(335, floor1.getLight());
        Assert.assertEquals(0, floor2.getLight());
        Assert.assertEquals(0, floor3.getLight());
    }

    @Test
    void testGetCube()
    {
        Assert.assertEquals(430, floor1.getCube());
        Assert.assertEquals(0, floor2.getCube());
        Assert.assertEquals(0, floor3.getCube());
    }

    @Test
    void testGetHeating()
    {
        Assert.assertEquals(315, floor1.getHeating());
        Assert.assertEquals(0, floor2.getHeating());
        Assert.assertEquals(0, floor3.getHeating());
    }

    @Test
    void testLevelHeating()
    {
        Set<Room> chosenRooms = new HashSet<Room>();
        chosenRooms.add(room4);     // overheated with border 0.6
        Assert.assertEquals(chosenRooms, floor1.levelHeating(0.6f));
    }
}