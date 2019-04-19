public class Board
{
    public Board()
    {
    }
    
    //cheat sheet
    //Z = Zero
    //O = One
    //TW = Two
    //TH = Three
    //FO = Four
    //FI = Five
    //S = Six
    public void createDominos()
    {
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
    }
}
