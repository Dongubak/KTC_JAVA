public class Sample2 {
   public static void main(String[] args) {
      enum Transport {
         CAR, TRUCK, BASE
      }
      
      for(Transport t: Transport.values()) {
         System.out.println(t);
      }
   }
}