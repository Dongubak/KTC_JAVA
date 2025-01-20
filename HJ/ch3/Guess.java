public class Guess {
   public static void main(String[] args) throws java.io.IOException {
      char answer = 'K';
      char ch;
      System.out.print("Enter ch : ");
      ch = (char) System.in.read();
      if(ch == answer) {
         System.out.println("right");
      } else {
         System.out.println("wrong");
      }
   }
}
