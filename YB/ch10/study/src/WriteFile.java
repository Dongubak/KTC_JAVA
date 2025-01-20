import java.io.*;

class PrintWriterDemoWriteFile {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.println("Hello, world!");
        writer.println("This is a test.");
        writer.close();
    }
}

//1



//자바는 알아서 관리하지만 c++은 close가 명시적임. 자바는 객체직렬화가 지원됨.
//BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
//String line;
//while ((line = reader.readLine()) != null) {
//        System.out.println(line);
//}
//        reader.close();
//
//c++
//
//#include <fstream>
//#include <iostream>
//using namespace std;
//
//int main() {
//    ifstream file("file.txt");
//    string line;
//    while (getline(file, line)) {
//        cout << line << endl;
//    }
//    file.close();
//    return 0;
//}
