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

class frame extends JFrame{
    static score s = new score();//scoreŬ���� ����
    static Container c;
        JPanel score = new JPanel(new GridLayout(1,3,10,10));//1*3 ũ���� score�г� ����(������)
        static JPanel startPane = new JPanel();
            BufferedImage startimage = null;
            JButton start = new JButton("���ӽ���");//���ӽ��� ��ư
        
          static JPanel molePane = new JPanel(new GridLayout(3,3,10,10));
          //3*3 ������ molePane ����, ����, �¿찣 ������Ʈ ������ ������ 10�ȼ��� ����
            static JButton hole[]=new JButton[9];//9���� ��ư ����
            change_mole2 m2[]=new change_mole2[9];    
            change_mole3 m3[]=new change_mole3[9];
            change_mole3 m3_2[]=new change_mole3[8];
            ImageIcon ground = new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/hole.png");
            //�̹����� �̿��Ͽ� ���� �������� ����
            ImageIcon mole = new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/mole1.png");
            //�̹����� �̿��Ͽ� �δ��� �������� ����
            JLabel scorecount = new JLabel(s.getscore());//������ ��Ÿ���� ���ڿ��� ���� ���̺� ����
            JLabel tab = new JLabel("");
            JLabel time = new JLabel("");
        
            static JPanel feverstartPane =new JPanel(new GridLayout(1,1,10,10));//�ǹ�Ÿ���� ������ ��Ÿ���� �г� ����
            JLabel fevernotify = new JLabel(new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/fever.png"));
            //�ǹ�Ÿ�� �̹��� �������� �����Ͽ� �̹��� ���̺� ����
        
            static JPanel feverPane = new JPanel(new GridLayout(3,3));//3*3������ feverPane ����
            static JButton feverhole[]=new JButton[8];//�ǹ�Ÿ�Ӷ��� �δ��� ��ư�� ����
            static JLabel counter = new JLabel("13");//�ǹ�Ÿ�Ӷ� ��� ĭ �� ���̺�
            Toolkit toolkit = Toolkit.getDefaultToolkit();
        static JPanel endPane = new JPanel(new GridLayout(1,1,10,10));//endPane �г� ����
            JLabel gameover = new JLabel("GAME OVER");//"GAME OVER"���ڿ� ���̺� ����
            JLabel end = new JLabel("");
            JLabel evaluation = new JLabel("");
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image hammer1 = toolkit.getImage("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/hammer1.png");
    //toolkit�� �̿��Ͽ� hammer1�̹��� ����

    Cursor cursor1 = tk.createCustomCursor(hammer1, new Point(10,10), "hammer1");//���콺 Ŀ���� hammer1�̹����� ����

    public static void sound(String file) {
        try {//���� ó���� ���� try-catch���� ���
            AudioInputStream music = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
            //����� Ŭ���� ����� ��Ʈ�� �����ϰ� ��Ʈ�� ��ü�� ����
            Clip clip;
            clip = AudioSystem.getClip();//����� Ŭ���� ����(AudioSystem Ŭ������ static �޼ҵ� getClip())
            clip.open(music);//����� Ŭ���� music�� �����ϴ� ������� ���İ� �����͸� �ν��ϰ� ����� �� �ִ� �غ� ����
            clip.start();//����� ��� ����
        }catch(Exception e) {
            e.printStackTrace();//���� ����� ȭ�鿡 ���
        }
    }
    
    class MyPanel extends JPanel{
        public void paint(Graphics g) {
            g.drawImage(startimage,0,0,null);
        }
    }
    
    public frame() {//������ ������
    	c= getContentPane();//�����ӿ� ������ ����Ʈ���� �˾Ƴ�
        setTitle("�δ��� ����");//������ ����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new BorderLayout());//hGap, vGap�� 0�� BorderLayout���� ��ġ
        c.setBackground(new Color(178,217,74));//���� ����
        setCursor(cursor1);//Ŀ������
        sound("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/music.wav");//sound�޼ҵ� ȣ��
        
        //StartPane
        try {
            startimage = ImageIO.read(new File("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/gamestart.png"));
            //�����̹��� ������
        }catch(IOException e) {
            JOptionPane.showMessageDialog(null, "��ŸƮ �̹��� �ҷ����� ����");//���� �߻� �� Dialog���
            System.exit(0);
        }
        
        MyPanel panel = new MyPanel();
        panel.setSize(700,700);//�г� ������ 700*700
        startPane.add(panel);//startPane�� panel����
        startPane.setLayout(null);
        start.setFont(start.getFont().deriveFont(39.0f));//���ӽ��� ��Ʈ ����
        start.setBackground(Color.PINK);//���ӽ��� ��ư ���� ��ũ�� ����
        start.addActionListener(new MyActionListener());//��ư�� �׼Ǹ����� ����
        start.setSize(200,100);//��ư ũ��
        start.setLocation(230, 500);//��ư ��ġ
        startPane.add(start);//startPane�� ���۹�ư ����
        
        
        //molePane
        score.setBackground(Color.PINK);//��ܿ� ��ġ�� score�г� ���� ����
        molePane.setBackground(new Color(178,217,74));//molePane�г� ���� ����
        for(int i=0; i<9; i++) {
            hole[i]= new JButton(ground);//��ư ����
            hole[i].setBackground(new Color(178,217,74));//��ư ���� ����
            hole[i].addActionListener(new MyActionListener());//��ư �̺�Ʈ������ 
            molePane.add(hole[i]);//molePane�гο� ��ư ����
            m2[i] = new change_mole2(hole[i]);
            m3[i] = new change_mole3(hole[i]);
            m2[i].start();
            m3[i].start();
            molePane.add(hole[i]);
        }
        timeover timethread = new timeover(time, startPane,score, endPane,end, evaluation,c, molePane,s);
        score.add(scorecount);
        score.add(tab);
        score.add(time);
        
        
        //feverPane
        feverstartPane.add(fevernotify);//�ǹ�Ÿ�� ���� �ǿ� �ǹ�Ÿ���� �˷��ִ� �̹��� ����
        for(int i=0; i<8; i++) {
            feverhole[i]= new JButton(mole);//�δ��� ��ư ����
            feverhole[i].setBackground(new Color(178,217,74));//���� ����
            feverhole[i].addActionListener(new MyActionListener());//��ư�� �̺�Ʈ ������
            m3_2[i] = new change_mole3(feverhole[i]);
            m3_2[i].start();
        }
        feverPane.setBackground(Color.MAGENTA);//�ǹ�Ÿ���� ��� ĭ�� ���� ����
        counter.setFont(counter.getFont().deriveFont(120.0f));
        counter.setForeground(Color.WHITE);//���̺� �� ����
        counter.setHorizontalAlignment(JLabel.CENTER);//���̺� ���� ����� ����
        for(int i=0; i<4; i++) {
            feverPane.add(feverhole[i]);
            feverhole[i].addActionListener(new MyActionListener());
        }
        feverPane.add(counter); //�ǹ�Ÿ�� �ð���
        for(int i=4; i<8; i++) {
            feverPane.add(feverhole[i]);
            feverhole[i].addActionListener(new MyActionListener());
        }
        
        
        //endPane
        endPane.setBackground(Color.BLACK);//������ Panel���� ����
        endPane.setLayout(null);
        endPane.add(gameover);//���ӿ��� ���̺� ����
        endPane.add(end);//end���̺� ����
        endPane.add(evaluation);//evaluation���̺� ����
        gameover.setFont(gameover.getFont().deriveFont(80.0f));//���ӿ��� ���̺� ��Ʈ ����
        gameover.setForeground(Color.RED);//���ӿ��� ���̺� �� ����
        gameover.setSize(600,300);//���ӿ��� ���̺� ������
        gameover.setLocation(105,150);//���ӿ��� ���̺� ��ġ
        end.setFont(end.getFont().deriveFont(40.0f));//���� ���̺� ��Ʈ ����
        end.setForeground(Color.WHITE);//���� ���̺� �� ����
        end.setSize(560,100);//���� ���̺� ������ ����
        end.setLocation(135, 300);//���� ���̺� ��ġ ����
        evaluation.setForeground(Color.WHITE);//�򰡺κ� ���̺� �� ����
        evaluation.setFont(end.getFont().deriveFont(40.0f));//�� ���̺� ��Ʈ ����
        evaluation.setSize(560,100);//�� ���̺� ������ ����
        evaluation.setLocation(220,400);//�� ���̺� ��ġ ����
        
        c.add(startPane,BorderLayout.CENTER);
        setSize(700,700);//������ ����
        setVisible(true);
        timethread.start();//timeover������ ����
    }
    
    class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==start) {//���� ���� ��ư�� Ŭ���Ǹ�
                startPane.setVisible(false);//startPane�� �����.
                c.add(score, BorderLayout.NORTH);//score�г��� �����̳��� �������� ��ġ�Ѵ�.
                c.add(molePane, BorderLayout.CENTER);//molePane �г��� �����̳��� �߾����� ��ġ�Ѵ�.
                
            }
            for(int i=0; i<9; i++) {
                if(e.getSource()==hole[i]) {//���� hole��ư�� Ŭ���Ǹ�    
                    if(hole[i].getIcon().toString().equals("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/mole1.png")) {
                        s.start();//���� �δ��� �׸��� Ŭ���Ǹ� ������ 1�� ������Ų��.
                        hole[i].setIcon(ground);//Ŭ���Ǹ� ��ư �������� ground�� �����Ѵ�.
                    }
                }
            }
            for(int i=0; i<8; i++) {
                if(e.getSource()==feverhole[i]) {//���� feverhole�� Ŭ���Ǹ�(�ǹ�Ÿ���� ��ư)
                    if(feverhole[i].getIcon().toString().equals("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/mole1.png")) {
                        s.fever();//���� �δ��� �׸��� Ŭ���Ǹ� ������ 2�� ������Ų��.
                        feverhole[i].setIcon(ground);//Ŭ���Ǹ� ��ư �������� ground�� �����Ѵ�.
                    }
                }
            }
            for(int i=4; i<8; i++) {
                if(e.getSource()==feverhole[i]) {
                    if(feverhole[i].getIcon().toString().equals("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\�ڹ�\\������Ʈ/mole1.png")) {
                        s.fever();
                        feverhole[i].setIcon(ground);
                    }
                }
            }
            scorecount.setText(s.getscore());//scorecount���̺� ���������� �����Ѵ�.
            
            if(counter.getText().equals("0")) {
                feverPane.setVisible(false);//�ǹ�Ÿ���� counter�� 0�� �Ǹ� feverPane�� ���̰� ��
                molePane.setVisible(true);//molePane���̰� ��
            }
            end.setText("����� �� ������ "+s.getscore_end()+"��!!");//end���̺� ���ڿ� ����
            if(s.getscore_end().equals("15")||s.getscore_end().equals("100")){//������ 15�� �̻��̰ų� 100���̸� feverȣ��
                fever();
            }
        }
    }
    public static void fever() {
        molePane.setVisible(false);
        c.add(feverstartPane);//feverstartpane �߰�
        int timer=8;//Ÿ�̸� ����
        feverstarttime ft = new feverstarttime(timer,c,feverstartPane, feverPane, molePane, counter);
        ft.start();    
    }
}