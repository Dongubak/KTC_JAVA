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

      Transport tp = Transport.A;
      System.out.println(tp);
   }
}