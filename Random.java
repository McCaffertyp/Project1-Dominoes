import java.util.*;
import java.io.*;

/*
   Get a random number in a certain range from lowVal to highVal
   Return value gotten.
*/
public class Random {
   private int randNum;
   Random r = new Random();
   
   public Random() {};
   
   private int getRandNum(int lowVal, int highVal) {
      randNum = r.nextInt(highVal) + lowVal; //Includes lowVal but not highVal
      return randNum;
   }
}
