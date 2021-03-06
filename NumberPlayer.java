import java.util.Scanner;   // Imports the stuff to take user input

public class NumberPlayer   // The NumberPlayer Class
{
  Scanner scan = new Scanner(System.in);   // Creates a new Scanner named scan
  
  // No constructor because a custom one is not needed.
  
  // Methods
  public int play(int count)
  {
    if (count >= 2) {  // tells how many pieces are left
      System.out.println("\nThere are currently " + count + " playing elements left.  How many will you take?");
    }
    else {
      System.out.println("\nThere is currently " + count + " playing element left.  How many will you take?");
    }
    if (count <= 50) {
      for (int i = 0; i < count/5; i++) {   // Draws however many lines of 5 squares per line nessecary to represent all the pieces not including the remainder when dviding the total number of pieces by 5
        for (int j = 0; j < 5; j++) {   // Draws 5 squares in a line to represent the number of pieces left.
          System.out.print("[]   ");
        }
        System.out.print("\n");
      }
      for (int i = 0; i < count%5; i++) {   // Draws the left over squares in the final line.
        System.out.print("[]   ");
      }
      System.out.print("\n");
    }
    
    int failcount = 0;  // counts the times the user enters an invalid input
    int number = scan.nextInt();   // Takes the player's input to determine how many pieces they will take.
    if (count >= 2) {   // Checks if there are still 2 or more pieces in play.
      while (number != 1 && number != 2)   // Does not allow the game to progress if the player tries to take an amount of pieces that is not equal to 1 or 2.
      {
        failcount ++;
        if (failcount > 3)
        {
          number = (int)(Math.random()*2+1);  // Gives a random input after four invalied entries
          System.out.println("\nThat's it, I'm picking for you!  You took "+number+"!\n");
        }
        else
        {
          System.out.println("\nYou may only take 1 or 2 playing elements.");
          number = scan.nextInt();
        }
      }
    }
    else {
      while (number != 1)   // Does not allow the game to progess if the player tries to take an amount of pieces that is not equal to 1.
      {
        System.out.println("\nNot so fast.  You must take the final playing element.");  // if only one is left, forces player to enter "1"
        number = scan.nextInt();
      }
    }
    return number;
  }
}