import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel extends JLabel {
	private int barSize = 0;
	private int maxBarSize;
	
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width=(int)(((double)(this.getWidth()))/maxBarSize*barSize);
		if(width==0)return;
		g.fillRect(0,0,width,this.getHeight());
	}
	synchronized public void fill() {
		if(barSize == maxBarSize) {
			try {
				wait();
			}catch(InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint();
		notify();
	}
	synchronized public void consume() {
		if(barSize == 0) {
			try {
				wait();
			}catch(InterruptedException e) {
				return;
			}
		}
		barSize--;
		repaint();
		notify();
	}
}
class ConsumerRunnable implements Runnable{
	private MyLabel bar;
	public ConsumerRunnable(MyLabel bar) {
		this.bar=bar;
	}
	public void run() {
		while(true) {
			try {
				bar.consume();
				Thread.sleep(200);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}
public class JC18012628Q09 extends JFrame{
	private MyLabel bar = new MyLabel(100);
	public JC18012628Q09() {
		setSize(350,200);
		setTitle("아무키나 빨리 눌러 바 채우기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
		bar.setLocation(20,50);
		bar.setSize(300,20);
		c.add(bar);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				bar.fill();
			}
		});
		
		c.setFocusable(true);
		c.requestFocus();
		ConsumerRunnable C = new ConsumerRunnable(bar);
		Thread th = new Thread(C);
		th.start();
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new JC18012628Q09();
	}
}
