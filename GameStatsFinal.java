import java.util.ArrayList;

// Game Statistics Class -
public class GameStatsFinal {

    // Computer's Highest Points Method - Recursively finds the round and score with the highest computer roll total.
    public int[] ComputerMaxPoints(ArrayList<int[]> computerResults, int index, int[] greatestPoints) {

        // Base case: return the max after cycling through list.
        if (index >= computerResults.size()) {
            return greatestPoints;
        }
        
        // Initialize total turn points variable.
        int totalTurnPoints = computerResults.get(index)[1] + computerResults.get(index)[2];
    
        // Compare turn points to current greatest points. If greater, update the round number and points
        // to new turn's round number and points.
        if (totalTurnPoints > greatestPoints[1]) {
            greatestPoints[0] = computerResults.get(index)[0]; 
            greatestPoints[1] = totalTurnPoints;
        }
    
        // Recursively calls itself with next index.
        return ComputerMaxPoints(computerResults, index + 1, greatestPoints);
    }

    // Computer's Lowest Points Method - Recursively finds the round and score with the lowest computer roll total.
    public int[] ComputerMinPoints(ArrayList<int[]> computerResults, int index, int[] leastPoints) {

        // Base case: return the min after cycling through list.
        if (index >= computerResults.size()) {
            return leastPoints;
        }

        // Initialize total turn points variable.
        int totalTurnPoints = computerResults.get(index)[1] + computerResults.get(index)[2];
    
        // Compare turn points to current smallest points. If smaller, update the round number and points
        // to new turn's round number and points.
        if (totalTurnPoints < leastPoints[1]) {
            leastPoints[0] = computerResults.get(index)[0]; 
            leastPoints[1] = totalTurnPoints;
        }
    
        // Recursively calls itself with next index.
        return ComputerMinPoints(computerResults, index + 1, leastPoints);
    }

    // Player's Highest Points Method - Recursively finds the round and score with the highest player roll total.
    public int[] PlayerMaxPoints(ArrayList<int[]> playerResults, int index, int[] greatestPoints) {

        // Base case: return the max after cycling through list.
        if (index >= playerResults.size()) {
            return greatestPoints;
        }
    
        // Initialize total turn points variable.
        int totalTurnPoints = playerResults.get(index)[1] + playerResults.get(index)[2];
    
        // Compare turn points to current greatest points. If greater, update the round number and points
        // to new turn's round number and points.
        if (totalTurnPoints > greatestPoints[1]) {
            greatestPoints[0] = playerResults.get(index)[0]; 
            greatestPoints[1] = totalTurnPoints;
        }
    
        // Recursively calls itself with next index.
        return PlayerMaxPoints(playerResults, index + 1, greatestPoints);
    }

    // Player's Lowest Points Method - Recursively finds the round and score with the lowest player roll total.
    public int[] PlayerMinPoints(ArrayList<int[]> playerResults, int index, int[] leastPoints) {

        // Base case: return the min after cycling through list.
        if (index >= playerResults.size()) {
            return leastPoints;
        }
    
        // Initialize total turn points variable.
        int totalTurnPoints = playerResults.get(index)[1] + playerResults.get(index)[2];
    
        // Compare turn points to current smallest points. If smaller, update the round number and points
        // to new turn's round number and points.
        if (totalTurnPoints < leastPoints[1]) {
            leastPoints[0] = playerResults.get(index)[0]; 
            leastPoints[1] = totalTurnPoints;
        }
        
        // Recursively calls itself with next index.   
        return PlayerMinPoints(playerResults, index + 1, leastPoints);
    }
    
    // Computer Average Point Method - Calculates and returns the computer's average points per turn 
    // (rounded to 2 decimals).
    public double ComputerAveragePoints(ComputerClass computer, int turn){
        double computerPoints = computer.GetPoints();
        double computerAvg = computerPoints / (turn);
        double computerAvgRounded = Math.round(computerAvg * 100.0) / 100.0;
        return computerAvgRounded;
    }

    // Player Average Point Method - Calculates and returns the player's average points per turn 
    // (rounded to 2 decimals).
    public double PlayerAveragePoints(PlayerClass player, int turn){
        double playerPoints = player.GetPoints();
        double playerAvg = playerPoints / (turn);
        double playerAvgRounded = Math.round(playerAvg * 100.0) / 100.0;
        return playerAvgRounded;
    }

    // Show Statistics Method - Displays full end-of-game statistics for both the player and computer.
    public void ShowStats(ArrayList<int[]> playerResults, ArrayList<int[]> computerResults, 
    PlayerClass player, ComputerClass computer, int turn){

        // Calculate all statistics.
        double finalPlayerAverage = PlayerAveragePoints(player, turn);
        double finalComputerAverage = ComputerAveragePoints(computer, turn);
        int[] finalPlayerMax = PlayerMaxPoints(playerResults, 0, new int[]{0, Integer.MIN_VALUE});
        int[] finalPlayerMin = PlayerMinPoints(playerResults, 0, new int[]{0, Integer.MAX_VALUE});
        int[] finalComputerMax = ComputerMaxPoints(computerResults, 0, new int[]{0, Integer.MIN_VALUE});
        int[] finalComputerMin = ComputerMinPoints(computerResults, 0, new int[]{0, Integer.MAX_VALUE});

        // Output all statistics.
        System.out.println("\n\n        Statistics:\n");
        System.out.println("Turns played: " + turn + "\n");

        System.out.println("You ended with " + player.GetPoints() + " points.");
        System.out.println("Computer ended with " + computer.GetPoints() + " points.\n");

        System.out.println("Your least points in a single turn were " + finalPlayerMin[1] + " in Round " + 
        finalPlayerMin[0] + ".");
        System.out.println("Your highest points in a single turn were " + finalPlayerMax[1] + " in Round " + 
        finalPlayerMax[0] + ".");
        System.out.println("Your average points per turn were " + finalPlayerAverage + ".\n");

        System.out.println("The computer's least points in a single turn were " + finalComputerMin[1] + " in Round " + 
        finalComputerMin[0] + ".");
        System.out.println("The computer's highest points in a single turn were " + finalComputerMax[1] + " in Round " + 
        finalComputerMax[0] + ".");
        System.out.println("Computer's average points per turn were " + finalComputerAverage + ".\n");
        
        System.out.println("Note: the turn number for the least and highest points are based off of the " +
         "first occurrence of those points.\n\n");
    }

}
