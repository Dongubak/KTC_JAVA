public class Q7 {
    public static void main(String args[]) {
        String msg = "This is a test"; // 원본 메시지
        String encmsg = "";  // 암호화된 메시지
        String decmsg = "";  // 복호화된 메시지
        String key = "qwerdfab"; // 8문자 키
        System.out.print("Original message: ");
        System.out.println(msg);

        // encode the message
        int keyLength = key.length();
        for (int i = 0; i < msg.length(); i++) {
            char currentKeyChar = key.charAt(i % keyLength); // 키를 순차적으로 반복
            encmsg = encmsg + (char) (msg.charAt(i) ^ currentKeyChar); // XOR 연산
        }
        System.out.print("Encoded message: ");
        System.out.println(encmsg);

        // decode the message
        for (int i = 0; i < encmsg.length(); i++) {
            char currentKeyChar = key.charAt(i % keyLength); // 키를 순차적으로 반복
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ currentKeyChar); // XOR 연산
        }
        System.out.print("Decoded message: ");
        System.out.println(decmsg);
    }
}
