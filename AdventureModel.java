import java.util.HashMap;

public class AdventureModel {
    private Adventurer adventurer;
    private HashMap<String, Room> rooms;

    public void initGame() {
        adventurer = new Adventurer("Player 1");
        rooms = new HashMap<>();
        
        // Create rooms and items
        Room room1 = new Room("Living Room", "A cozy living room with a sofa and a TV.");
        Room room2 = new Room("Kitchen", "A kitchen with a table and a fridge.");
        Room room3 = new Room("Bedroom", "A quiet bedroom with a bed and a lamp.");
        
        room1.setExit("north", room2);
        room2.setExit("south", room1);
        room2.setExit("east", room3);
        room3.setExit("west", room2);
        
        room1.addItem("remote");
        room2.addItem("apple");
        room3.addItem("book");
        
        rooms.put("Living Room", room1);
        rooms.put("Kitchen", room2);
        rooms.put("Bedroom", room3);

        adventurer.setCurrentRoom(room1);
    }

    public void processCommand(String[] command) {
        String action = command[0].toLowerCase();
        switch (action) {
            case "go":
                if (command.length > 1) adventurer.go(command[1]);
                else System.out.println("Go where?");
                break;
            case "look":
                adventurer.look();
                break;
            case "take":
                if (command.length > 1) adventurer.take(command[1]);
                else System.out.println("Take what?");
                break;
            case "drop":
                if (command.length > 1) adventurer.drop(command[1]);
                else System.out.println("Drop what?");
                break;
            case "use":
                if (command.length > 1) adventurer.use(command[1]);
                else System.out.println("Use what?");
                break;
            default:
                System.out.println("Unknown command.");
        }
    }
}
