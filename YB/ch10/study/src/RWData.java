import java.io.*;

class RWData {
    public static void main(String args[]) {
        int i = 10;
        double d = 1023.56;
        boolean b = true;

        // 데이터 쓰기
        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("testdata"))) {
            System.out.println("Writing " + i);
            dataOut.writeInt(i); // int 값 기록
            System.out.println("Writing " + d);
            dataOut.writeDouble(d); // double 값 기록
            System.out.println("Writing " + b);
            dataOut.writeBoolean(b); // boolean 값 기록
        } catch (IOException exc) {
            System.out.println("Write error.");
            return;
        }

        System.out.println();

        // 데이터 읽기
        try (DataInputStream dataIn = new DataInputStream(new FileInputStream("testdata"))) {
            i = dataIn.readInt(); // int 값 읽기
            System.out.println("Reading " + i);
            d = dataIn.readDouble(); // double 값 읽기
            System.out.println("Reading " + d);
            b = dataIn.readBoolean(); // boolean 값 읽기
            System.out.println("Reading " + b);
        } catch (IOException exc) {
            System.out.println("Read error.");
        }
    }
}
//6
