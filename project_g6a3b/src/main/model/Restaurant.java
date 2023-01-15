package model;

// Represent a collection of restaurant having restaurant name and type
public class Restaurant {
    private String name;
    private String type;

    // EFFECTS: Construct a restaurant with a given name and type
    public Restaurant(String name,String type) {
        this.name = name;
        this.type = type;
    }


    // EFFECTS: return the type of restaurant
    public String getType() {
        return type;
    }

    // EFFECTS: return the name of restaurant
    public String getName() {
        return name;
    }
}
