class Quicksort {
   // Set up a call to the actual Quicksort method.
   static void qsort(char items[]) {
      qs(items, 0, items.length-1);
   }
   private static void qs(char items[], int left, int right) {
      int i, j;
      char x, y;
      i = left; j = right;
      x = items[(left+right)/2]; /// fivot
      do {
         while((items[i] < x) && (i < right)) i++;
         while((x < items[j]) && (j > left)) j--;
         if(i <= j) {
            y = items[i];
            items[i] = items[j];
            items[j] = y;
            i++; j--;
         }
      } while(i <= j);

      if(left < j) qs(items, left, j);
      if(i < right) qs(items, i, right);
   }
}
class QSDemo {
   public static void main(String args[]) {
      char a[] = { 'd', 'x', 'a', 'r', 'p', 'j', 'i' };
      int i;

      System.out.print("Original array: ");

      for(i = 0; i < a.length; i++)
         System.out.print(a[i]);
      System.out.println();

      // now, sort the array
      Quicksort.qsort(a);
      System.out.print("Sorted array: ");
      for(i=0; i < a.length; i++)
         System.out.print(a[i]);
   }
}

/*
quick sort 로직

fivot <- last element

i j 로 시작함
i와 j 번째를 비교해서 피벗을 기준으로 잘 못된 위치에 있는 경우에 대해
두개의 값을 교환한다.
 */