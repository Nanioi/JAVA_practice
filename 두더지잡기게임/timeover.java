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

class timeover extends Thread{
    JLabel time;
    JPanel startPane;
    JPanel score;
    JPanel endPane;
    JLabel end;
    JLabel evaluation;
    Container c;
    JPanel molePane;
    score s;
    public timeover(JLabel time, JPanel startPane, JPanel score, JPanel endPane, JLabel end, JLabel evaluation, Container c, JPanel molePane, score s) {
        this.time = time;
        this.startPane=startPane;
        this.score= score;
        this.endPane=endPane;
        this.end= end;
        this.evaluation=evaluation;
        this.c=c;
        this.molePane=molePane;
        this.s=s;
    }
    public void run() {
        int n=45; //���� ���ѽð��� 45�ʷ� ��
        while(true) {
            if(n==0) {  //���ѽð��� ���� ��� container c���� startpane, molepane ����   
                c.remove(startPane);
                c.remove(molePane);
                score.setVisible(false);    
                c.add(endPane, BorderLayout.CENTER);//endpane �� �߾ӿ� �߰�   
            
            if(Integer.parseInt(s.getscore_end())<70) { //  �� ȹ�� ������ ���� ������ ���� ��Ʈ  
                    evaluation.setText("�й��ϼ���.");
                }else if(Integer.parseInt(s.getscore_end())<150) {
                    evaluation.setText("����ϳ׿�!");
                }else if(Integer.parseInt(s.getscore_end())<300) {
                    evaluation.setText("������Ʈ��..");
                }
            }
            if(n<0)
                break;
            time.setText("�����ð� : "+n+"��");// ���� �ð��� �����ش�  
            n--;
            
            try {
            	Thread.sleep(1000);// �ʴ��������� tread�� sleep �����ش�   
            }catch(InterruptedException e) {
            	return;
            }
        }
    }
}