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

class change_mole3 extends Thread{
    private JButton hole;
    ImageIcon mole = new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/mole1.png");
    //두더지 이미지 불러옴
    public change_mole3(JButton hole) {
        this.hole = hole;
    }
    public void run() {

        int random = (int)(Math.random()*15000);
        while(true) {
            hole.setIcon(mole);//mole의 이미지 불러와 hole버튼형성  
   
            try {
            	Thread.sleep(random);
            }catch(InterruptedException e) {
            	return;
            }
        }
    }
}