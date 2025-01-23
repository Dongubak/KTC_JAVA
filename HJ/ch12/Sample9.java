import java.util.ArrayList;

public class Sample9 {
   public static void main(String[] args) {
      ArrayList<Integer> numList = new ArrayList<>();

      numList.add(10);
      numList.add(10);

      int value = numList.get(0);
      System.out.println(value);
   }
}
