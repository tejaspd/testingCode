import java.lang.Math.random;

public class makeStrings{
  /**
	 * Makes an array of random Strings with random length between 7 and 15 inclusive.
	 * The Strings contain random characters (0 - 255 ASCII vals) up to length 10.
	 * There must be at least one null String.
	 * Some of the array "buckets" may randomly contain null Strings.
	 * @return the array of random Strings
	 */
  public String[] makeStrings() {
    int rand = 7 + (int)(Math.random() * ((7 - 15))+1);
    String[] s = new String[rand];
    

  }
  public static void main(String[] args) {

  }
}
