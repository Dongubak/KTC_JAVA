public class Sample4 {
   public static void main(String[] args) {
      enum Transport {
         A(1), B(2), C(3);
         
         private int speed;

         Transport(int s) {
            speed = s;
         }

         int getSpeed() {
            return speed;
         }
      }

      System.out.println(Transport.A.ordinal());
      System.out.println(Transport.B.ordinal());
      System.out.println(Transport.C.ordinal());
   }
}
