import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Game Class (Superclass) -
public class GameFinal {

    // Initialize random variable and list of results which stores all roles.
    private final Random random = new Random(); 
    private final ArrayList<int[]> listOfResults = new ArrayList<>();
    
    // Get Results Method - Returns the list of stored rolls.
    public ArrayList<int[]> GetListOfResults() {
        return listOfResults;
    }

    // Roll One Die Method - Rolls and return a single die (1 to 6). 
    public int RollOneDie(){
        return random.nextInt(6) + 1;
    }

    // Rolling And Storing Two Dice Method - Rolls two dice, stores and 
    // returns the result with the turn number.
    public int[] RollAndStoreTwoDice(int turnNum){
        int die1 = RollOneDie();
        int die2 = RollOneDie();
        int[] turnRollResult = {turnNum, die1, die2};
        listOfResults.add(turnRollResult);
        return turnRollResult;
    }

    // Rolling Animation Method -
    public void RollingAnimation(){

        // Use thread.sleep function to generate three dot (...) animation
        // before the program rolls. Try and catch is used incase of there 
        // is any interrupted exception. If there is the function e.printStackTrace() 
        // will trace the exception and print it. 
        System.out.print("Rolling");
        
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }

        System.out.println("");
    }

    // Game Method -
    public void Game(ArrayList<int[]> playerResults, ArrayList<int[]> computerResults, 
    PlayerClass player, ComputerClass computer, Scanner userInput) {

        // Initialize turn variables.
        int turn = 1;
        boolean firstTurn = true;

        // Loop sequence 10 times.
        while (turn <= 10) {

            // Ask for user if they want to roll or skip.
            System.out.print("\nPress enter to roll or 's' to skip: ");

            // Use an extra input function just for the first turn just to clearn invalid input
            // and prevent scanner bug.
            if (firstTurn){
                userInput.nextLine();
                firstTurn = false;
            }

            String input = userInput.nextLine();
            
            // If the user wants to skip, check if they have skips left and are
            // over 40 points.
            if (input.equalsIgnoreCase("s")) {
                if (player.GetSkips() > 0 && player.GetPoints() >= 40) {

                    // If user meets the conidtions, skip the user's turn, decrease their skips
                    // by 1, and proceed with the rest of the round for the computer
                    System.out.println("\nTurn " + turn + "\n");
                    RollingAnimation();
                    player.DecreaseSkips();
                    System.out.println("\nYou skipped your turn! You have " + player.GetSkips() + " left.");
                }
                
                // If user does not meet conditions to skip, print a message indicating they
                // cannot skip and ask for input again
                else {
                    System.out.println("\nYou cannot skip, as you're out of skips or/and have less than 40 points.\n");
                    continue;
                }
            }
            
            // If the user wants to roll, proceed with the round by using RollAndStoreTwoDice method
            // to roll and store two dice, then print them.
            else if (input.equals("")) {
                System.out.println("\nTurn " + turn + "\n");
                RollingAnimation();
                int[] roll = player.RollAndStoreTwoDice(turn);
                System.out.println("\nYou rolled: " + roll[1]);
                System.out.println("You rolled: " + roll[2]);

                // Penalty (-10 points) for the computer if the user rolls a double.
                if (roll[1] == roll[2]) {
                    computer.ModifyPoints(-10);
                    System.out.println("Double rolled! Computer loses 10 points (" + computer.GetPoints() + ").");
                }

                // Modify and output user's points.
                player.ModifyPoints(roll[1] + roll[2]);
                System.out.println("Your points: " + player.GetPoints());

                // Store rolls in player's list.
                playerResults.add(roll);

            }

            // Incase of any invalid input, print message indicating invalid input and 
            // ask for input again.
            else {
                System.out.println("\nInvalid input. You did not press enter or 's', try again.\n");
                continue;
            }

            // If the computer has over 40 points, there is a 30% chance they can skip
            // their turn (using math.random for skip chance).
            double computerSkipChance = Math.random();
            if (computer.GetPoints() > 40 && computerSkipChance < 0.3) {
                System.out.println("Computer skipped!");
            } 

            // If the computer does not meet conditions to skip,  proceed with the round 
            // by using RollAndStoreTwoDice method to roll and store two dice, then print them.
            else {
                int[] roll = computer.RollAndStoreTwoDice(turn);
                System.out.println("\nComputer rolled: " + roll[1]);
                System.out.println("Computer rolled: " + roll[2]);

                // Penalty (-10 points) for the user if the computer rolls a double.
                if (roll[1] == roll[2]) {
                    player.ModifyPoints(-10);
                    System.out.println("Double rolled! You lose 10 points (" + player.GetPoints() + ").");
                }

                // Modify and output computer's points.
                computer.ModifyPoints(roll[1] + roll[2]);
                System.out.println("Computer's points: " + computer.GetPoints());

                // Store rolls in computer's list.
                computerResults.add(roll);
            }

            // After each turn, check if either both parties busted, both parties
            // are at exactly 50, player is at 50 or busted, or computer is at 50
            // or busted. If any of these conditions are true print the message
            // with the winner (or tie) and break out the while loop. If not, print 
            // that current points along with the fact the game is stll continuingc (if
            // 10 turns have not happened).
            if (player.GetPoints() > 50 && computer.GetPoints() > 50){
                System.out.println("\nIt's a tie, you both lose!");
                break;
            }
            else if (player.GetPoints() == 50 && computer.GetPoints() == 50){
                System.out.println("\nIt's a tie, you both win!");
                break;
            }  
            else if (player.GetPoints() == 50) {
                System.out.println("\n50 points, You win!");
                break;
            } 
            else if (player.GetPoints() > 50) {
                System.out.println("\nYou busted, Computer Wins!");
                break;
            }
            else if (computer.GetPoints() == 50) {
                System.out.println("\n50 points, Computer Wins!");
                break;
            } 
            else if (computer.GetPoints() > 50) {
                System.out.println("\nComputer Busted, You Win!");
                break;
            }
            else{
                if (turn != 10){
                    System.out.println("\nCurrent Points:");
                    System.out.println("Player: " + player.GetPoints());
                    System.out.println("Computer: " + computer.GetPoints());
                    System.out.println("\nContinuing...\n");
                }
            }

            // Increase turn number after every round.
            turn++;
           
        }


        // Final check for a winner (or tie) if there has been no winner after 10 turns.
        if (player.GetPoints() < 50 && computer.GetPoints() < 50){
            if (player.GetPoints() > computer.GetPoints()) {
                System.out.println("\nGame over. You had more points, You Win!");
            } 
            else if (computer.GetPoints() > player.GetPoints()) {
                System.out.println("\nGame over. Computer had more points, Computer Wins!");
            } 
            else if (player.GetPoints() == computer.GetPoints()) {
                System.out.println("\nGame over. Same points, It's a tie!");
            }
        }

        // Check and fix final turn number if needed.
        if (turn == 11){
            turn = 10;
        }

        // Initialie the game statistics class and call the show stats method to calculate
        // and print the statistics.
        GameStatsFinal gameStatsClass = new GameStatsFinal();
        gameStatsClass.ShowStats(playerResults, computerResults, player, computer, turn);
    
    }

}

// Player Class (Subclass for Game Class) -
class PlayerClass extends GameFinal{

    // Initialize user points and user skips variable.
    private int userPoints = 0;
    private int userSkips = 2;
    
    // Default Constructor.
    public PlayerClass(){
        super();
    }

    // Get Points Method - Returns user points.
    public int GetPoints(){
        return userPoints;
    }

    // Get Skips Method - Return user skips.
    public int GetSkips(){
        return userSkips;
    }

    // Modify Points Method - Change user points.
    public void ModifyPoints(int amt){
        this.userPoints += amt;
    }

    // Decrease Skips Method - Decrease the user skip by one.
    public void DecreaseSkips(){
        userSkips--;
    }
}

// Computer Class (Subclass for Game Class) -
class ComputerClass extends GameFinal{

    // Initialize user points and user skips variable.
    private int computerPoints = 0;
    
    // Default Constructor.
    public ComputerClass(){
        super();
    }

    // Get Points Method - Returns computer's points.
    public int GetPoints(){
        return computerPoints;
    }

    // Modify Points Method - Change computer's points.
    public void ModifyPoints(int amt){
        this.computerPoints += amt;
    }
}
