import java.io.IOException;
public class ST01 {
    public static void main(String[] args) throws IOException {
        char ch;
        int spaces = 0;
        do {
            ch = (char) System.in.read();
            if(ch == ' ') {
                spaces++;
            }
        } while(ch != '.' );
        System.out.println("Found " + spaces + " spaces.");
    }
}