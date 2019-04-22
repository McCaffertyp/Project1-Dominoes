import java.util.*;

public class PlayGame {

    //Main method just in charge of running the program.
    public static void main(String[] args) {
        PlayGame play = new PlayGame();
        play.run();
    }
    
    //Method that actually runs all the parts of the program.
    public static void run() 
    {
        //Variables to be used
        DRandom random = new DRandom();
        Domino dominoU = new Domino();
        Domino dominoR = new Domino();
        boolean playedDom = false;
        
        //Intro information
        System.out.println("Welcome to the game of Dominos!");
        System.out.println("When you are ready, type the word \"start\" and hit enter, else type \"quit\".");
        
        //this will be true when the user is ready to start
        boolean startGame = false;
        
        //loop until ready to start
        while(startGame == false) {

           //this string will be used throughout the game to read the users input
           String input = "", compStart = "start";
           int compVals = 0, domChoice;
           
           Scanner user = new Scanner(System.in);
           
           //get the users info
           input = user.nextLine().toLowerCase();
           
           //this should see if the user wants to start the game
           //Checks for all spelling errors.
           for (int i = 0; i < input.length(); i++) {
               for (int j = 0; j < compStart.length(); j++) {
                   if (input.substring(i, i+1).equals(compStart.substring(j, j+1))) {
                       compVals++;
                       break;
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
        Players human = new Players("Paul", 10);
        Players AI = new Players("Jack", 10);
        Players hand = new Players("hand", human.getHandLen());
        hand.assignHands(human, AI, gameBoard);
              
        //information about win state
        boolean winner = false;
        String whoWon = "";
        
        //Information about turns
        int turn = random.getRandNum(0, 2);
        Scanner sc = new Scanner(System.in);
        
        //First domino played
        if (turn == 0) { //Human goes if turn is even
            System.out.println(human.getName() + "'s turn.");
            gameBoard.displayHand(human);
            int handLen = human.getHandLen();
            System.out.println();
            System.out.print(" 1");
            for (int i = 2; i <= handLen; i++) {
                System.out.print("    " + i); 
            } 
            System.out.println();
            System.out.print("Which domino will you play (number corresponds to domino)? ");
            int domChoice = sc.nextInt();
            switch(domChoice) { //Switch statement for choice of first domino to play for human.
                case 1: gameBoard.boardPlay(human.getHand()[0]); break;
                case 2: gameBoard.boardPlay(human.getHand()[1]); break;
                case 3: gameBoard.boardPlay(human.getHand()[2]); break;
                case 4: gameBoard.boardPlay(human.getHand()[3]); break;
                case 5: gameBoard.boardPlay(human.getHand()[4]); break;
                case 6: gameBoard.boardPlay(human.getHand()[5]); break;
                case 7: gameBoard.boardPlay(human.getHand()[6]); break;
                case 8: gameBoard.boardPlay(human.getHand()[7]); break;
                case 9: gameBoard.boardPlay(human.getHand()[8]); break;
                case 10: gameBoard.boardPlay(human.getHand()[9]); break;
            }
            gameBoard.drawDom(human, domChoice-1);
            System.out.println(human.getName() + " played the first domino and drew a replacement.");
        } else if (turn == 1) { //AI goes if turn is odd
            System.out.println("\nAI " + AI.getName() + "'s turn.");
            int AIPlace = random.getRandNum(0, AI.getHandLen());
            gameBoard.boardPlay(AI.getHand()[AIPlace]);
            gameBoard.drawDom(AI, AIPlace);
            System.out.println("AI " + AI.getName() + " played the first domino and drew a replacement.");
        }
        
        //show the player their hand
        System.out.println("\n");
        System.out.println("Here is your starting hand:");
        gameBoard.displayHand(human);
        System.out.println("\n");
        
        //loops through each turn that will ocur in the game
        //This loop should end when a winner is found
        while(winner == false) {
            //Increment who's turn
            turn++;
            
            //Assign the most recently played domino.
            dominoR = gameBoard.getRecentDom();
            
            //Insert game play between here
            int domPosPlayed = 0;
            if (turn % 2 == 0) { //Human goes
                System.out.println();
                System.out.println(human.getName() + "'s turn.");
                System.out.print("Your hand: ");
                gameBoard.displayHand(human);
                System.out.println();
                for (int i = 0; i < human.getHandLen(); i++) {
                    dominoU = human.getHand()[i];
                    if (dominoR.getDomNumTwo() == dominoU.getDomNumOne()) { //Checks first number
                        gameBoard.boardPlay(dominoU);
                        playedDom = true;
                        domPosPlayed = i;
                        break;
                    } else if (dominoR.getDomNumTwo() == dominoU.getDomNumTwo()) { //Checks second number
                        //If second number matches, turns the domino around
                        dominoU = dominoU.swapNums(dominoU);
                        gameBoard.boardPlay(dominoU);
                        playedDom = true;
                        domPosPlayed = i;
                        break;
                    }
                }
                if (gameBoard.getDomsAvail().length > 0) { //Determines if there are domino's available
                    if (playedDom) { //Draw a domino
                        System.out.println(human.getName() + " played and drew a domino.");
                        gameBoard.drawDom(human, domPosPlayed);
                    } else {
                        System.out.println(human.getName() + " could not play and drew a domino.");
                        turn--;
                        gameBoard.drawDom(human, human.getHandLen());
                    }
                } else { //No dominos available
                    if (playedDom) {
                        human.shrinkHand(human, domPosPlayed); //Shrinks the hand to be able to keep track of winner.
                        System.out.println(human.getName() + " played and no dominos are left to draw from.");
                    } else {
                        System.out.println(human.getName() + " could not play and no dominos are left to draw from.");
                    }
                }
            } else if (turn % 2 == 1) { //AI goes
                System.out.println("\nAI " + AI.getName() + "'s turn.");
                for (int i = 0; i < AI.getHandLen(); i++) {
                    dominoU = AI.getHand()[i];
                    if (dominoR.getDomNumTwo() == dominoU.getDomNumOne()) { //Checks first number
                        gameBoard.boardPlay(dominoU);
                        playedDom = true;
                        domPosPlayed = i;
                        break;
                    } else if (dominoR.getDomNumTwo() == dominoU.getDomNumTwo()) { //Checks second number
                        //If second number matches, domino gets rotated.
                        dominoU = dominoU.swapNums(dominoU);
                        gameBoard.boardPlay(dominoU);
                        playedDom = true;
                        domPosPlayed = i;
                        break;
                    }
                }
                if (gameBoard.getDomsAvail().length > 0) { //Determines if there are domino's available
                    if (playedDom) { //Draw a domino
                        System.out.println("AI " + AI.getName() + " played and drew a domino.");
                        gameBoard.drawDom(AI, domPosPlayed);
                    } else {
                        System.out.println("AI " + AI.getName() + " could not play and drew a domino.");
                        turn--;
                        gameBoard.drawDom(AI, AI.getHandLen());
                    }
                }  else { //If no dominos are available
                    if (playedDom) {
                        AI.shrinkHand(AI, domPosPlayed); //shrinks hand to keep track of winner.
                        System.out.println("AI " + AI.getName() + " played and no dominos are left to draw from.");
                    } else {
                        System.out.println("AI " + AI.getName() + " could not play and no dominos are left to draw from.");
                    }
                }
            }
            
            //Delay between printing out screens for domino play.
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //and here      
        
            //This is how the game tells if there is a winner
            if(human.getHandLen() <= 0) {
               winner = true;
               whoWon = human.getName();
            } else if(AI.getHandLen() <= 0) {
               winner = true;
               whoWon = AI.getName();
            }
        }//game turn
        
        //print out who won
        System.out.println(whoWon + ", you won!");
        
    }//run

}//Class
