class test2_2 {
    public static char prompt(String str) throws java.io.IOException {
        System.out.print(str + ": ");
        return (char) System.in.read();  // 사용자 입력을 받으려면 예외가 발생할 수 있음
    }

    public static void main(String args[]) {
        char ch;
        try {

            ch = prompt("Enter a letter");  // prompt 메서드에서 IOException이 발생할 수 있음
        }
        catch(java.io.IOException exc) {
            System.out.println("I/O exception occurred.");
            ch = 'X';  // 예외 발생 시 기본값 지정
        }
        System.out.println("You pressed " + ch);
    }
}