public class ST10 {
    public static void main(String[] args) {
        final int MAX = 100;
        final int MIN = 2;

        int m, n;
        boolean isPrime;
        for(m = MIN; m <= MAX; m++) {
            isPrime = true;
            for(n = MIN; n < m; n++ ) {
                if(m%n == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.println(m +" is prime");
            }
        }
    }
}