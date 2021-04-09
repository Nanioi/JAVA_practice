package Num1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.Vector;

public class JC18012628E1 extends JFrame {
	JPanel radioPanel=new JPanel();
	JLabel imageLabel = new JLabel();
	Vector<ImageIcon> imageVector = new Vector<ImageIcon>();
	JRadioButton left=new JRadioButton("left");
	JRadioButton right=new JRadioButton("right");
	
	public JC18012628E1() {
		setSize(500, 400);
		setTitle("Image Gallery Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ButtonGroup g = new ButtonGroup();
		g.add(left);
		g.add(right);
		c.add(left);
		c.add(right);
		loadImages("image");
		
		c.add(radioPanel,BorderLayout.NORTH);
		c.add(imageLabel,BorderLayout.CENTER);
		
		imageLabel.setIcon(imageVector.get(0));
		left.addMouseListener(new myMouseListener(0));
		right.addMouseListener(new myMouseListener(0));
		
		setVisible(true);
	
	}
	class myMouseListener extends MouseAdapter{
		int index;
		public myMouseListener(int startIndex) {
			index=startIndex;
		}
		public void mouseClicked(MouseEvent e) {
			if(left.isSelected()) {
				index--;
				if(index==-1)
					index=imageVector.size()-1;
				imageLabel.setIcon(imageVector.get(index));
			}
			if(right.isSelected()) {
				index++;
				index %=imageVector.size();
				imageLabel.setIcon(imageVector.get(index));
			}
		}
	}
	public void loadImages(String path) {
		File file=new File(path);
		File [] files = file.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				ImageIcon icon=new ImageIcon(f.getPath());
				imageVector.add(icon);
			}
		}
	}
	public static void main(String[] args) {
		new JC18012628E1();
	}
}
