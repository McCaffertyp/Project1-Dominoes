public class Players
{
    private Domino[] hand = new Domino[21];
    private String name;
    private int howManyDominos;
    public Players()
    {
    }
    public Players(String nametemp, int howManyDominostemp)
    {
         name = nametemp;
         howManyDominos = howManyDominostemp;
    }
    
    //getter methods
    public String getName()
    {
      return name;
    }
    public int gethowManyDominos()
    {
      return howManyDominos;
    }
    public Domino[] gethand()
    {
         return hand;
    }
}
