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
        
        
        
    }//run

}//Class
