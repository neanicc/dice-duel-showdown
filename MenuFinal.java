import java.util.Scanner;

// Menu Class - 
public class MenuFinal {

    // Menu Method - 
    public int menu(Scanner choice) { 
    
            // Display options to the user.
            System.out.println(""" 
                    1. Play
                    2. How To Play
                    3. Purpose
                    4. Quit
                    """);
    
            // Ask for user choice and return if it is an integer from 1 to 3. Try and catch is used
            // to avoid any errors incase user enters invalid input.
            while (true){
                try{
                    System.out.print("Selection: ");
                    int userChoice = choice.nextInt();
                    if ((userChoice >= 1) && (userChoice <= 4)){
                        return userChoice;
                    }
                    else{
                        System.out.println("Please enter a number from 1-4.");
                    }
                }
                catch (Exception e){
                    System.out.println("Please enter a number from 1-4.");
    
                    // Use an input function to clear invalid input.
                    choice.nextLine();
                }
    
            }
        }

    /* In the following methods, overloading occurs. If the user selects "How To Play" 
       in the menu, the main program will make the parameter a integer so it prints the guide.
       If the user selects "Purpose" in the menu, the main program will make te parameter a double
       so it prints the purpose. */

    // Details Method (For How To Play) -
    public void Details(int num){

        // Output the guide. 
        System.out.println("""

                Welcome to Dice Duel Showdown - Fifty or Bust.

                In this game, your goal is to roll two dice and get the closest to 50 points
                within 10 turns without going over 50 points. While you are rolling, you are
                competing against a computer. If either you or the computer rolls the same
                number twice (eg. roll a 5 and 5, or 6 and 6, etc), the opposite player will
                lose 10 points. If you have more than 40 points, you will have 2 skips where
                you can skip your roll if you choose to. If the computer is over 40 points,
                they have a 30% chance of skipping their turn, and have infinite skips. If
                you go over 50 points, the computer will automatically win, and if the
                computer goes over 50 points, you will automatically win. In case there is
                winner after the 10 turns, the party with the most points will be
                victorious (same points is a tie). If a party hits exactly 50 points,
                they will automatically win. Good luck and have fun!
                """);
    }

    // Details Method (For Purpose) - 
    public void Details(double num){

        // Output the purpose of the game.
        System.out.println("""

                The purpose of the program is to give the user a chance to think about how a 
                computer plays and make decisions based on that. The first few parts of the 
                game the user has a chance to analyze the computer rolls, their rolls, and how 
                the special rule would help or hurt their chances of winning. The final part 
                (after the parties are at 40 points and can use skips) gives the user the ability
                to critically think of how the skips can benefit them or can obstruct their chances 
                of winning. After a few rounds of playing, the user learns how the game works and 
                how they can strategize & analyze to win.
                """);
    }


}