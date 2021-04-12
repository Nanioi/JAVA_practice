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
    private JButton hole;   //버튼 변수 선언
    ImageIcon ground = new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/hole.png");
    //구멍 이미지 불러옴
    public change_mole2(JButton hole) {//객체생성 hole버튼 입력시 변수 hole에 저장  
        this.hole = hole;
    }
    public void run() {

        int random = (int)(Math.random()*3000);//난수형성  
        while(true) {
            hole.setIcon(ground);//setIcon 메소드 이용해 ground 이미지 불러와 hole버튼형성   
 
            try {//hole 의 Thread의 sleep시간랜덤으로 지정해주기  
            	Thread.sleep(random);
            }catch(InterruptedException e) {
            	return;	
            }
        }
    }
}