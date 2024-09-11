import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<String> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addItem(String item) {
        items.add(item);
    }

    public boolean removeItem(String item) {
        return items.remove(item);
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("There are no items here.");
        } else {
            System.out.println("Items in the room: " + String.join(", ", items));
        }
    }
}
