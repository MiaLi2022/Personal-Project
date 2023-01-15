package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {
    Restaurant r1;

    @BeforeEach
    public void runBefore() {
        r1 = new Restaurant("JoeFresh","French");
    }

    @Test
    public void testGetName() {
        assertEquals("JoeFresh",r1.getName());
    }

    @Test
    public void testGetType() {
        assertEquals("French",r1.getType());
    }

}
