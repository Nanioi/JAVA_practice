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
        int n=45; //게임 제한시간을 45초로 지
        while(true) {
            if(n==0) {  //제한시간이 끝난 경우 container c에서 startpane, molepane 제거   
                c.remove(startPane);
                c.remove(molePane);
                score.setVisible(false);    
                c.add(endPane, BorderLayout.CENTER);//endpane 을 중앙에 추가   
            
            if(Integer.parseInt(s.getscore_end())<70) { //  총 획득 점수에 따라 다음과 같은 멘트  
                    evaluation.setText("분발하세요.");
                }else if(Integer.parseInt(s.getscore_end())<150) {
                    evaluation.setText("대단하네요!");
                }else if(Integer.parseInt(s.getscore_end())<300) {
                    evaluation.setText("신의컨트롤..");
                }
            }
            if(n<0)
                break;
            time.setText("남은시간 : "+n+"초");// 남은 시간을 보여준다  
            n--;
            
            try {
            	Thread.sleep(1000);// 초단위당으로 tread를 sleep 시켜준다   
            }catch(InterruptedException e) {
            	return;
            }
        }
    }
}