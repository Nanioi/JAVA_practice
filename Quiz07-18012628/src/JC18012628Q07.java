import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JC18012628Q07 extends JFrame{
	JPanel contentPane = new JPanel();
	JC18012628Q07() {
		setSize(500,300);
		setTitle("드래깅동안 YELLOW");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setBackground(Color.GREEN);
		contentPane.addMouseMotionListener(new MouseMotion());
		contentPane.addMouseListener(new MouseNoMotion());
		
		setVisible(true);
	}
	class MouseMotion extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e) {
			contentPane.setBackground(Color.YELLOW);
		}
	}
	class MouseNoMotion extends MouseAdapter{
		public void mouseReleased(MouseEvent e) {
			contentPane.setBackground(Color.GREEN);
		}
	}
	public static void main(String[] args) {
		new JC18012628Q07();
	}
}
