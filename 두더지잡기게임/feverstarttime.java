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

class feverstarttime extends Thread{
    int timer;
    Container c;
    JPanel feverstartPane;
    JPanel feverPane;
    JPanel molePane;
    JLabel counter;
    
    public feverstarttime(int timer,Container c, JPanel feverstartPane, JPanel feverPane, JPanel moiePane, JLabel counter) {
        this.timer=timer;
        this.c=c;
        this.feverstartPane=feverstartPane;
        this.feverPane=feverPane;
        this.counter=counter;
    }//feverstarttime 클래스 객체생성  
    
    public void run() {
        while(true) {
            if(timer==0) { // 피버타임 종료시 
                counter.setText("0");//counter를 0으로 
                feverPane.setVisible(false); //feverpane 을 화면에서 숨기기  
                molePane.setVisible(true);//molepane을 보이게 한다.
                break;
            }
            timer--;
            feverstartPane.setVisible(true);  
            if(timer==5){//피버타임 시작시간인timer가 5초가 된경우 c에 feverpane을 추가해 보이게 한다.
                c.remove(feverstartPane);
                c.add(feverPane);
                feverPane.setVisible(true);
            }
            counter.setText(String.valueOf(timer));
            try {// timer가 5초가 기 전까지 thread를 sleep시켜준다.
            	Thread.sleep(1000);
            }catch(InterruptedException e) {
            	return;
            }
        }
    }
}