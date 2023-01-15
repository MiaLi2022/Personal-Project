package persistence;

import model.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantReaderTest {
    private static final String TEST_FILE = "./data/restaurants.txt";
    List<Restaurant> restaurants;
    RestaurantReader reader;

    @BeforeEach
    public void runBefore() throws IOException {
        reader = new RestaurantReader();
        restaurants = RestaurantReader.readRestaurant(new File(TEST_FILE));
    }

    @Test
    public void readFileTest() {
        assertEquals("The Flying Pig",restaurants.get(0).getName());
        assertEquals("Chambar",restaurants.get(3).getName());
        assertEquals("Belgian",restaurants.get(3).getType());

    }
}
