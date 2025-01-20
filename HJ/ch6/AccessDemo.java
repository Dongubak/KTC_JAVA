package HJ.ch4;

public class AccessDemo {
   public static void main(String[] args) {
      MyClass ob = new MyClass();

      ob.setAlpha(100);
      System.out.println(ob.getAlpha());
      // System.out.println(ob.alpha);
      ob.beta = 88;
      ob.gamma = 99;
   }
}
