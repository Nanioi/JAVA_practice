import java.awt.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class change_mole2 extends Thread{
    private JButton hole;   //��ư ���� ����
    ImageIcon ground = new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/hole.png");
    //���� �̹��� �ҷ���
    public change_mole2(JButton hole) {//��ü���� hole��ư �Է½� ���� hole�� ����  
        this.hole = hole;
    }
    public void run() {

        int random = (int)(Math.random()*3000);//��������  
        while(true) {
            hole.setIcon(ground);//setIcon �޼ҵ� �̿��� ground �̹��� �ҷ��� hole��ư����   
 
            try {//hole �� Thread�� sleep�ð��������� �������ֱ�  
            	Thread.sleep(random);
            }catch(InterruptedException e) {
            	return;	
            }
        }
    }
}