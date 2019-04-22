import java.util.*;

public class Players {
    private Domino[] hand;
    private String name;
    private DRandom random = new DRandom(); //To access Random
    
    public Players() {
    }
    
    //Constructor for player.
    public Players(String nameTemp, int howManyDominosTemp) {
        name = nameTemp;
        hand = new Domino[howManyDominosTemp];
    }
    
    //This method assigns the starting hands to the players
    //Randomly selects every other domino for each player
    public void assignHands(Players player1, Players player2, Board board) {
        Domino[] domChange = board.getDomsAvail();
        int boardLen = domChange.length, track = 0, ranNum;
        for (int i = 0; i < hand.length*2; i++) {
            ranNum = random.getRandNum(0, boardLen);
            if (i % 2 == 0) { //Domino goes to human
                player1.hand[i-track] = domChange[ranNum];
                track++;
            } else if (i % 2 == 1) { //Domino goes to AI
                player2.hand[i-track] = domChange[ranNum];
            }
            for (int j = ranNum; j < boardLen-1; j++) {
                domChange[j] = domChange[j+1];
            }
            domChange = Arrays.copyOfRange(domChange, 0, boardLen-1);
            boardLen--;
        }
        board.setDomsAvail(domChange);
    }
    
    //This method changes the hand depending on domino placed, if one gets played.
    public void setHand(Players player, int place, Domino dom) {
        if (place >= player.hand.length) {
            Domino[] grow = new Domino[player.hand.length+1];
            grow = Arrays.copyOfRange(player.hand, 0, player.hand.length);
            grow[grow.length-1] = dom;
            player.hand = Arrays.copyOf(grow, grow.length);
        } else {
            player.hand[place] = dom;
        }
    }
    
    //This method shrinks the players hand to keep size accurate for winner.
    public void shrinkHand(Players player, int domPlayed) {
        for (int i = domPlayed; i < player.getHandLen()-1; i++) {
            player.hand[i] = player.hand[i+1];
        }
        player.hand = Arrays.copyOfRange(player.hand, 0, player.getHandLen()-1);
    }
    
    //getter methods
    public String getName() {
        return name;
    }
    
    public int getHandLen() {
        return hand.length;
    }
    
    public Domino[] getHand() {
        return hand;
    }
}
