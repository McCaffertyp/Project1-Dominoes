public class Players
{
    private Domino[] hand;
    private String name;
    private DRandom random = new DRandom(); //To access Random
    
    public Players() {
    }
    
    public Players(String nameTemp, int howManyDominosTemp) {
         name = nameTemp;
         hand = new Domino[howManyDominosTemp];
    }
    
    public void assignHands(Players player1, Players player2, Board board) {
        Domino[] domChange = board.getDomsAvail();
        int boardLen = domChange.length, track = 0, ranNum;
        for (int i = 0; i < hand.length*2; i++) {
            ranNum = random.getRandNum(0, boardLen);
            if (i % 2 == 0) { //Domino goes to human
                player1.hand[i-track] = domChange[ranNum];
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
    
    //getter methods
    public String getName() {
      return name;
    }
    public int gethowManyDominos() {
      return hand.length;
    }
    public Domino[] gethand() {
         return hand;
    }
}
