public class Sample5 {
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

      if(Transport.A.compareTo(Transport.B) < 0) {
         System.out.println("B is before A");
      }
   }
}