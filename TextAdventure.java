import java.util.Scanner;

public class TextAdventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdventureModel model = new AdventureModel();
        model.initGame();  // Initialize the game

        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("Type 'Go', 'Look', 'Take', 'Drop', 'Use', 'Exit' to interact with the game.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            if (command[0].equalsIgnoreCase("Exit")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }
            model.processCommand(command);
        }
        scanner.close();
    }
}
