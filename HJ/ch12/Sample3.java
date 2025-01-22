public class Sample3 {
   public static void main(String[] args) {
      enum Transport {
         AIR
      }

      Transport tp = Transport.valueOf("AIR");
      System.out.println(tp);
   }   
}
