public class LogicalOpTable {
   public static void main(String[] args) {
      System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");

      int p, q;
      p = 0; q = 0;
      System.out.println(p + "\t" + q + "\t" + (p & q) + 
         "\t" + (p | q) + "\t" + (p ^ q) + "\t" + !(p == 1)
      );

      p = 0; q = 1;
      System.out.println(p + "\t" + q + "\t" + (p & q) + 
         "\t" + (p | q) + "\t" + (p ^ q) + "\t" + !(p == 1)
      );

      p = 1; q = 0;
      System.out.println(p + "\t" + q + "\t" + (p & q) + 
         "\t" + (p | q) + "\t" + (p ^ q) + "\t" + !(p == 1)
      );

      p = 1; q = 1;
      System.out.println(p + "\t" + q + "\t" + (p & q) + 
         "\t" + (p | q) + "\t" + (p ^ q) + "\t" + !(p == 1)
      );
   }
}