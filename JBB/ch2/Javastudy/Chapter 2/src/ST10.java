public class ST10 {
    static final int MAX = 100;
    static final int MIN = 2;

    public static void main(String[] args) {
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