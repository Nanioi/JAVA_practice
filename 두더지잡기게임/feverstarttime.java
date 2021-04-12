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
    }//feverstarttime Ŭ���� ��ü����  
    
    public void run() {
        while(true) {
            if(timer==0) { // �ǹ�Ÿ�� ����� 
                counter.setText("0");//counter�� 0���� 
                feverPane.setVisible(false); //feverpane �� ȭ�鿡�� �����  
                molePane.setVisible(true);//molepane�� ���̰� �Ѵ�.
                break;
            }
            timer--;
            feverstartPane.setVisible(true);  
            if(timer==5){//�ǹ�Ÿ�� ���۽ð���timer�� 5�ʰ� �Ȱ�� c�� feverpane�� �߰��� ���̰� �Ѵ�.
                c.remove(feverstartPane);
                c.add(feverPane);
                feverPane.setVisible(true);
            }
            counter.setText(String.valueOf(timer));
            try {// timer�� 5�ʰ� �� ������ thread�� sleep�����ش�.
            	Thread.sleep(1000);
            }catch(InterruptedException e) {
            	return;
            }
        }
    }
}