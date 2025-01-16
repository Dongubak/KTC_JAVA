package HJ.ch4;

public class FSDemo {
   public static void main(String[] args) {
      FailSoftArray fs = new FailSoftArray(5, - 1);

      for(int i = 0; i < 2 * fs.length; i++) {
         if(!fs.put(i, i * 10)) {
            System.out.println("Out of index");
         }
      }

      for(int i = 0; i < fs.length * 2; i++) {
         int x = fs.get(i);
         if(x != -1) System.out.println(x);
         else System.out.println("Out of index");
      }
   }
}
