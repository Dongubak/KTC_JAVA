public class NoBreak {
   public static void main(String[] args) {
      for(int i = 0; i <= 5; i++) {
         switch(i) {
            case 0:
               System.out.println("i is less than one");
            case 1:
               System.err.println("i is less than two");
            case 2:
               System.err.println("i is less than Three");
            case 3:
               System.err.println("i is less than Four");
            case 4:
               System.err.println("i is less than Five");
            case 5:
               System.err.println("i is less than six");
         }
      }
   }   
}
