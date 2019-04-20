import java.util.*;

public class PlayGame {

    public static void main(String[] args) {
        PlayGame play = new PlayGame();
        play.run();
    }
    
    public static void run() {
        //Intro information
        System.out.println("Welcome to the game of Dominos!");
        System.out.println("When you are ready, type the word \"start\"and hit enter.");
        
        //this will be true when the user is ready to start
        boolean startGame = false;
        
        //loop until ready to start
        while(startGame == false) {

           //this string will be used throughout the game to read the users input
           String input = "", compStart = "start";
           int compVals = 0;
           
           Scanner user = new Scanner(System.in);
           
           //get the users info
           input = user.nextLine().toLowerCase();
           
           //this should see if the user wants to start the game
           //Put in a for loop that checks for all possible spelling errors.
           for (int i = 0; i < compStart.length(); i++) {
               for (int j = 0; j < input.length(); j++) {
                   if (compStart.substring(i, i+1).equals(input.substring(j, j+1))) {
                       compVals++;
                   }
               }
           }
           
           if(compVals >= 4) {
               startGame = true;
           } else if(input.equals("exit") || input.equals("quit")) {
               return;
           } else {
               System.out.println("Please type \"start\" to start the game! If you want to quit type exit!");
           }
           
           
        }//while loop for starting the game
        
        //create the game board that we will use to store Dominos on
        Board gameBoard = new Board();
        gameBoard.createDominos();
        
        //create the players
        Players human = new Players("Paul",10);
        Players AI = new Players("Jack", 10);
        Players hand = new Players();
        hand.assignHands(human, AI, gameBoard);
              
        //information about win state
        boolean winner = false;
        String whoWon = "";
        
        //loops through each turn that will ocur in the game
        //This loop should end when a winner is found
        while(winner == false) {
        
            //show the player there hand
            System.out.println("Here is your hand: ");
            gameBoard.displayHand(human);
                       
        
            //This is how the game tells if there is a winner
            if(human.gethowManyDominos() <= 0) {
               winner = true;
               whoWon = human.getName();
            } else if(AI.gethowManyDominos() <= 0) {
               winner = true;
               whoWon = AI.getName();
            }
        }//game turn
        
        //print out who won
        System.out.println(whoWon + ", you won!");
        
    }//run

}//Class
