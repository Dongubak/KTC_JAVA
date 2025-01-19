public class ST07 {
    public static void main(String[] args) {
        String msg = "Test message.";
        String encmsg = "";
        String decmsg = "";
        String key = "Junius B";

        System.out.print("Original message: ");
        System.out.println(msg);

        for(int i = 0, j = 0; i < msg.length(); i++, j = i%key.length()) {
            encmsg = encmsg + (char) (msg.charAt(i) ^ key.charAt(j));
        }

        System.out.print("Encoded message: ");
        System.out.println(encmsg);

        for(int i = 0, j = 0; i < msg.length(); i++, j = i%key.length()) {
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key.charAt(j));
        }
        System.out.print("Decoded message: ");
        System.out.println(decmsg);
    }
}
