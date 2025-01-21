class sample {
   public static void main(String[] args) {
      enum Transport {
         CAR, Truck, AIRPLANE, TRIAN, BOAT 
      }

      Transport tp = Transport.CAR;

      if(tp == Transport.CAR) {
         System.out.println("It's car");
      }
   }
}