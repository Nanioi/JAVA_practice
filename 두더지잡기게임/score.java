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
    public void start() { //�δ����� ������ ���� 1����   
        cnt++;
    }
    public void fever() {// �ǹ�Ÿ�� ������ �δ����� ���� ��� ���� 2����  
        cnt+=2;
    }
    public String getscore() {// ���������� ��ȯ���ش�   
        return " ���� ����: "+cnt+"�� !";
    }
    public String getscore_end() {//  �� ȹ������ ��ȯ  
        return cnt+"";
    }
}