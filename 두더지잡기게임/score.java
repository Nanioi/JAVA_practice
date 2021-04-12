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

public class score {
	int cnt;
    public score() {
        cnt = 0;
    }
    public void start() { //두더지를 잡으면 점수 1증가   
        cnt++;
    }
    public void fever() {// 피버타임 시작후 두더지를 잡은 경우 점수 2증가  
        cnt+=2;
    }
    public String getscore() {// 현재점수를 반환해준다   
        return " 현재 점수: "+cnt+"점 !";
    }
    public String getscore_end() {//  총 획득점수 반환  
        return cnt+"";
    }
}