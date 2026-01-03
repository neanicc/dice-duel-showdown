import java.util.ArrayList;
import java.util.Scanner;

// Main Program Class -
public class MainProgramFinal {
    public static void main(String[]args){

        // Initialize Scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // Initialize Menu class.
        MenuFinal optionClass = new MenuFinal();

        // Print a title message for when the program first opens.
        System.out.println("""

                    ╔══╦╗    ╔══╗      ╔══╦╗      ╔╗
                    ╚╗╗╠╬═╦═╗╚╗╗╠╦╦═╦╗ ║══╣╚╦═╦╦╦╦╝╠═╦╦╦╦═╦╗
                    ╔╩╝║║═╣╩╣╔╩╝║║║╩╣╚╗╠══║║║╬║║║║╬║╬║║║║║║║
                    ╚══╩╩═╩═╝╚══╩═╩═╩═╝╚══╩╩╩═╩══╩═╩═╩══╩╩═╝
                        ╔══╦╦══╦══╦═╦╗     ╔══╦╦╦══╦══╗        
                    ╔══╗║═╦╬╣═╦╩╗╔╩╗║║╔═╦╦╗║╔╗║║║══╬╗╔╝╔══╗    
                    ╚══╝║╔╝║║╔╝ ║║╔╩╗║║╬║╔╝║╔╗║║╠══║║║ ╚══╝    
                        ╚╝ ╚╩╝  ╚╝╚══╝╚═╩╝ ╚══╩═╩══╝╚╝       
                """);
        
        // Repeat the program forever until the user decides to quit.
        while (true){

            // Ask the user for their menu choice.
            int choice = optionClass.menu(scanner);

            // Run the game method in the game class if the user wants to play.
            if (choice == 1){

                // Initialize the game class, player class, and computer class.
                GameFinal gameClass = new GameFinal();
                PlayerClass playerClass = new PlayerClass();
                ComputerClass computerClass = new ComputerClass();

                // Initialize the player and computer's 2D list, where it will include the turn number
                // and each invidual roll for all turns in a single game for both parties.
                ArrayList<int[]> playerList = new ArrayList<>();
                ArrayList<int[]> computerList = new ArrayList<>();
                gameClass.Game(playerList, computerList, playerClass, computerClass, scanner);
            }
            // Run the details method with an integer parameter if the the user wants to learn how to play.
            else if (choice == 2){
                optionClass.Details(1);
            }
            // Run the details method with a double parameter if the user wants to see the purpose of the game.
            else if (choice == 3){
                optionClass.Details(1.0);
            }

            // Print a goodbye message and end the program if the user wants to quit.
            else if (choice == 4){
                System.out.println("\nGoodbye!\n");
                break;
            }
        }

        // Close the scanner.
        scanner.close();
    }
}
