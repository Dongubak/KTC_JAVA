import java.io.IOException;
public class ST10 {
    public static void main(String[] args) throws IOException {
        char c;
        int changeCount = 0;

        System.out.println("Enter period to stop.");

        do {
            c = (char) System.in.read();
            if((c >= 'a' & c <= 'z' ) || (c == 'å') || (c == 'ä') || (c == 'ö')) {
                c -= 32;
                changeCount++;
                System.out.print(c);
            }
            else if((c >= 'A' & c <= 'Z' )  || (c == 'Å') || (c == 'Ä') || (c == 'Ö')) {
                c += 32;
                changeCount++;
                System.out.print(c);
            }
        } while(c != '.');
        System.out.println("\nChangend " + changeCount + " letters.");
    }
}
