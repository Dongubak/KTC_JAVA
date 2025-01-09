import javax.swing.*;
import java.awt.event.*;

public class SwingButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Button Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click Me!");
        frame.add(button);

        // 버튼에 이벤트 리스너 추가
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button was clicked!");
            }
        });

        frame.setVisible(true);
    }
}
