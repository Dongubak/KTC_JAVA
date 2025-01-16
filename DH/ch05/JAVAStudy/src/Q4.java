public class Q4 {
    public static void main(String[] args) {

        String names[] = { "John", "Alice", "Zara", "Bob", "Charlie",
                "Eve", "Mallory", "Oscar", "Peggy", "Trent" };
        int a, b;
        String tmp;
        int size;
        size = 10; // number of elements to sort

        // Display original array
        System.out.print("Original array is: ");
        for(int i = 0; i < size; i++)
            System.out.print(names[i] + " ");
        System.out.println();

        // This is the Bubble sort for strings.
        for(a = 1; a < size; a++) {
            for(b = size - 1; b >= a; b--) {
                if(names[b - 1].compareTo(names[b]) > 0) { // if out of order
                    // Exchange elements
                    tmp = names[b - 1];
                    names[b - 1] = names[b];
                    names[b] = tmp;
                }
            }
        }

        // Display sorted array
        System.out.print("Sorted array is: ");
        for(int i = 0; i < size; i++)
            System.out.print(names[i] + " ");
        System.out.println();

    }
}
