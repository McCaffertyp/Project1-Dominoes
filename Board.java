import java.util.*;

public class Board {
    private Domino[] domsAvail = new Domino[28];
    private LinkedList<Domino> list = new LinkedList<Domino>();
    private DRandom random = new DRandom();
    private Domino recentDom = new Domino();
   
    public Board() {
    }
    
    //This method creates a very basic board for playing on.
    public void boardPlay(Domino domPlayed) {
        recentDom = domPlayed;
        list.add(domPlayed);
        System.out.println(); //The board is 200 -'s long.
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); //200 -'s wide "table"
        System.out.print(list.get(0).getDomNumOne() + "|" + list.get(0).getDomNumTwo());
        for (int i = 1; i < list.size(); i++) {
            System.out.print("<->" + list.get(i).getDomNumOne() + "|" + list.get(i).getDomNumTwo());
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }
    
    //cheat sheet
    //Z = Zero
    //O = One
    //TW = Two
    //TH = Three
    //FO = Four
    //FI = Five
    //S = Six
    public void createDominos() {
        Domino pieceZZ = new Domino(0,0);
        Domino pieceZO = new Domino(0,1);
        Domino pieceZTW = new Domino(0,2);
        Domino pieceZTH = new Domino(0,3);
        Domino pieceZFO = new Domino(0,4);
        Domino pieceZFI = new Domino(0,5);
        Domino pieceZS = new Domino(0,6);
        Domino pieceOO = new Domino(1,1);
        Domino pieceOTW = new Domino(1,2);
        Domino pieceOTH = new Domino(1,3);
        Domino pieceOFO = new Domino(1,4);
        Domino pieceOFI = new Domino(1,5);
        Domino pieceOS = new Domino(1,6);
        Domino pieceTWTW = new Domino(2,2);
        Domino pieceTWTH = new Domino(2,3);
        Domino pieceTWFO = new Domino(2,4);
        Domino pieceTWFI = new Domino(2,5);
        Domino pieceTWS = new Domino(2,6);
        Domino pieceTHTH = new Domino(3,3);
        Domino pieceTHFO = new Domino(3,4);
        Domino pieceTHFI = new Domino(3,5);
        Domino pieceTHS = new Domino(3,6);
        Domino pieceFOFO = new Domino(4,4);
        Domino pieceFOFI = new Domino(4,5);
        Domino pieceFOS = new Domino(4,6);
        Domino pieceFIFI = new Domino(5,5);
        Domino pieceFIS = new Domino(5,6);
        Domino pieceSS = new Domino(6,6);
      
        domsAvail[0] = pieceZZ;
        domsAvail[1] = pieceZO;
        domsAvail[2] = pieceZTW;
        domsAvail[3] = pieceZTH;
        domsAvail[4] = pieceZFO;
        domsAvail[5] = pieceZFI;
        domsAvail[6] = pieceZS;
        domsAvail[7] = pieceOO;
        domsAvail[8] = pieceOTW;
        domsAvail[9] = pieceOTH;
        domsAvail[10] = pieceOFO;
        domsAvail[11] = pieceOFI;
        domsAvail[12] = pieceOS;
        domsAvail[13] = pieceTWTW;
        domsAvail[14] = pieceTWTH;
        domsAvail[15] = pieceTWFO;
        domsAvail[16] = pieceTWFI;
        domsAvail[17] = pieceTWS;
        domsAvail[18] = pieceTHTH;
        domsAvail[19] = pieceTHFO;
        domsAvail[20] = pieceTHFI;
        domsAvail[21] = pieceTHS;
        domsAvail[22] = pieceFOFO;
        domsAvail[23] = pieceFOFI;
        domsAvail[24] = pieceFOS;
        domsAvail[25] = pieceFIFI;
        domsAvail[26] = pieceFIS;
        domsAvail[27] = pieceSS;
      
    }
     
    //This method has the given player draw a domino from the currently available.
    public void drawDom(Players player, int placement) {
        Domino[] change = getDomsAvail();
        int ranNum = random.getRandNum(0, change.length);
        player.setHand(player, placement, change[ranNum]); //Calls setHand method from Players.
        change[ranNum] = change[change.length-1];
        change = Arrays.copyOfRange(change, 0, change.length-1);
        setDomsAvail(change);
    }
    
    //this method will show what the player currently has in his or her hand.
    public void displayHand(Players temp) {
        Domino[] display = temp.getHand();
        System.out.print(display[0].getDomNumOne() + "|" + display[0].getDomNumTwo());
        for(int i = 1; i < temp.getHandLen(); i++) {
            System.out.print(", " + display[i].getDomNumOne() + "|" + display[i].getDomNumTwo());
        }
    }
    
    //domsAvail setter method
    public void setDomsAvail(Domino[] domSet) {
        domsAvail = new Domino[domSet.length];
        for (int i = 0; i < domSet.length; i++) {
            domsAvail[i] = domSet[i];
        }
    }
    
    //getters method
    public Domino[] getDomsAvail() {
        return domsAvail;
    }
    
    public Domino getRecentDom() {
        return recentDom;
    }
}
