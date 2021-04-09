import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JC18012628Q8 extends JFrame {
	JComboBox<String> combo= new JComboBox<String>();
	JTextField tf= new JTextField(10);

	JC18012628Q8() {
		setTitle("Java Quiz 8");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		tf.addKeyListener(new TextFieldListener());
		add(tf);
		add(combo);
		tf.requestFocus(true);
		
		setVisible(true);
	}
	class TextFieldListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				
				combo.addItem(tf.getText());
				tf.setText("");
			}
		}
	}
	public static void main(String[] args) {
		new JC18012628Q8();
	}
}