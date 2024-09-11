import java.util.ArrayList;

public class Adventurer {
    private String name;
    private Room currentRoom;
    private ArrayList<String> inventory;

    public Adventurer(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void go(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You moved to the " + currentRoom.getName());
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void look() {
        System.out.println(currentRoom.getDescription());
        currentRoom.listItems();
    }

    public void take(String item) {
        if (currentRoom.removeItem(item)) {
            inventory.add(item);
            System.out.println("You took the " + item);
        } else {
            System.out.println("No such item here.");
        }
    }

    public void drop(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            currentRoom.addItem(item);
            System.out.println("You dropped the " + item);
        } else {
            System.out.println("You don't have that item.");
        }
    }

    public void use(String item) {
        if (inventory.contains(item)) {
            System.out.println("You used the " + item);
        } else {
            System.out.println("You don't have that item.");
        }
    }
}
