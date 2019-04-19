import java.util.Scanner;

public class PlayGame {

    public static void main(String[] args) {
        PlayGame play = new PlayGame();
        play.run();
    }
    
    public static void run() 
    {
        //Intro information
        System.out.println("Welcome to the game of Dominos!");
        System.out.println("When you are read type start and hit enter");
        
        //this will be true when the user is ready to start
        boolean startGame = false;
        
        //loop until ready to start
        while(startGame == false)
        {

           //this string will be used throughout the game to read the users input
           String input = "";
           
           Scanner user = new Scanner(System.in);
           
           //get the users info
           input = user.nextLine();
           
           //this should see if the user wants to start the game
           //some of these are for spelling errors.
           if(input.equals("start") || input.equals("go") || input.equals("begin") || input.equals("yes") || input.equals("sart") || input.equals("stat") || input.equals("star"))
           {
               startGame = true;
           }
           else if(input.equals("exit") || input.equals("quit"))
           {
               return;
           }
           else
           {
               System.out.println("Please type start to start the game! If you want to quit type exit!");
           }
           
           
        }//while loop for starting the game
        
        //create the game board that we will use to store Dominos on
        Board gameBoard = new Board();
        gameBoard.createDominos();
        
        //create the players
        Players human = new Players("Paul",7);
        Players AI = new Players("Jack", 0);
        
        //information about win state
        boolean winner = false;
        String whoWon = "";
        
        //loops through each turn that will ocur in the game
        //This loop should end when a winner is found
        while(winner == false)
        {
        
            //This is how the game tells if there is a winner
            if(human.gethowManyCards() <= 0)
            {
               winner = true;
               whoWon = human.getName();
            }
            else if(AI.gethowManyCards() <= 0)
            {
               winner = true;
               whoWon = AI.getName();
            }
        }//game turn
        
        //print out who won
        System.out.println(whoWon + ", you won!");
        
    }//run

}//Class
