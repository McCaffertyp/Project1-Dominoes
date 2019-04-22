/*
    Holds and stores information about each domino.
*/
public class Domino 
{
    //hold both numbers that the dominos has
    private int firstNumber;
    private int secondNumber;
    
    Domino() {
    }
    
    //Creates a Domino with two numbers in position one and two
    Domino(int numberOne, int numberTwo) {
         firstNumber = numberOne;
         secondNumber = numberTwo;
    }
    
    //Number swap method in case the second number matches the first.
    public Domino swapNums(Domino domTemp) {
        int swap = domTemp.secondNumber;
        domTemp.secondNumber = domTemp.firstNumber;
        domTemp.firstNumber = swap;
        return domTemp;
    }
    
    //two getter methods
    public int getDomNumOne() {
         return firstNumber;
    }
    
    public int getDomNumTwo() {
         return secondNumber;
    }
}
