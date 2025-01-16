class Resource {
    String fileName;

    Resource(String fileName) {
        this.fileName = fileName;
        System.out.println("Opening file: " + fileName);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Closing file: " + fileName);
        super.finalize();
    }
}

public class FinalizeDemo {
    public static void main(String[] args) {
        Resource res = new Resource("example.txt");
        res = null; // 객체 참조 제거

        // 가비지 컬렉션 요청
        System.gc();

        System.out.println("End of program.");
    }
}
