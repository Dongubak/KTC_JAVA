import java.io.*;

class ShowFile {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0])) {
            int i;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i); // 파일 내용을 한 문자씩 출력
            }
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}
//try-with-resources
//5