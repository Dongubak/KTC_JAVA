public class Q7 {
    public static void main(String args[]) {
        String msg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        String key = "qwerdfab";
        System.out.print("Original message: ");
        System.out.println(msg);

        // encode the message
        int keyLength = key.length();
        for (int i = 0; i < msg.length(); i++) {
            char currentKeyChar = key.charAt(i % keyLength);
            encmsg = encmsg + (char) (msg.charAt(i) ^ currentKeyChar);
        }
        System.out.print("Encoded message: ");
        System.out.println(encmsg);

        // decode the message
        for (int i = 0; i < encmsg.length(); i++) {
            char currentKeyChar = key.charAt(i % keyLength);
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ currentKeyChar);
        }
        System.out.print("Decoded message: ");
        System.out.println(decmsg);
    }
}
