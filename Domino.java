public class Domino 
{

    //hold both numbers that the dominos has
    private int firstNumber;
    private int secondNumber;
    Domino()
    {
    }
    Domino(int numberOne, int numberTwo)
    {
         firstNumber = numberOne;
         secondNumber = numberTwo;
    }
    
    //two getter methods
    public int getDominoNumberOne()
    {
         return firstNumber;
    }
    public int getDominoNumberTwo()
    {
         return secondNumber;
    }
}
