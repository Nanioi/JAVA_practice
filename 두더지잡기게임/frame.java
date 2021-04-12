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
    static score s = new score();//score클래스 생성
    static Container c;
        JPanel score = new JPanel(new GridLayout(1,3,10,10));//1*3 크기의 score패널 생성(점수판)
        static JPanel startPane = new JPanel();
            BufferedImage startimage = null;
            JButton start = new JButton("게임시작");//게임시작 버튼
        
          static JPanel molePane = new JPanel(new GridLayout(3,3,10,10));
          //3*3 격자의 molePane 생성, 상하, 좌우간 컴포넌트 사이의 간격은 10픽셀로 설정
            static JButton hole[]=new JButton[9];//9개의 버튼 생성
            change_mole2 m2[]=new change_mole2[9];    
            change_mole3 m3[]=new change_mole3[9];
            change_mole3 m3_2[]=new change_mole3[8];
            ImageIcon ground = new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/hole.png");
            //이미지를 이용하여 구멍 아이콘을 만듦
            ImageIcon mole = new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/mole1.png");
            //이미지를 이용하여 두더지 아이콘을 만듦
            JLabel scorecount = new JLabel(s.getscore());//점수를 나타내는 문자열을 가진 레이블 생성
            JLabel tab = new JLabel("");
            JLabel time = new JLabel("");
        
            static JPanel feverstartPane =new JPanel(new GridLayout(1,1,10,10));//피버타임의 시작을 나타내는 패널 생성
            JLabel fevernotify = new JLabel(new ImageIcon("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/fever.png"));
            //피버타임 이미지 아이콘을 생성하여 이미지 레이블 생성
        
            static JPanel feverPane = new JPanel(new GridLayout(3,3));//3*3격자의 feverPane 생성
            static JButton feverhole[]=new JButton[8];//피버타임때의 두더지 버튼을 생성
            static JLabel counter = new JLabel("13");//피버타임때 가운데 칸 초 레이블
            Toolkit toolkit = Toolkit.getDefaultToolkit();
        static JPanel endPane = new JPanel(new GridLayout(1,1,10,10));//endPane 패널 생성
            JLabel gameover = new JLabel("GAME OVER");//"GAME OVER"문자열 레이블 생성
            JLabel end = new JLabel("");
            JLabel evaluation = new JLabel("");
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image hammer1 = toolkit.getImage("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/hammer1.png");
    //toolkit을 이용하여 hammer1이미지 생성

    Cursor cursor1 = tk.createCustomCursor(hammer1, new Point(10,10), "hammer1");//마우스 커서를 hammer1이미지로 설정

    public static void sound(String file) {
        try {//예외 처리를 위해 try-catch문을 사용
            AudioInputStream music = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
            //오디오 클립에 오디오 스트림 연결하고 스트림 객체를 생성
            Clip clip;
            clip = AudioSystem.getClip();//오디오 클립을 생성(AudioSystem 클래스의 static 메소드 getClip())
            clip.open(music);//오디오 클립은 music에 존재하는 오디오의 형식과 데이터를 인식하고 재생할 수 있는 준비를 갖춤
            clip.start();//오디오 재생 시작
        }catch(Exception e) {
            e.printStackTrace();//예외 결과를 화면에 출력
        }
    }
    
    class MyPanel extends JPanel{
        public void paint(Graphics g) {
            g.drawImage(startimage,0,0,null);
        }
    }
    
    public frame() {//프레임 생성자
    	c= getContentPane();//프레임에 부착된 컨텐트팬을 알아냄
        setTitle("두더지 게임");//프레임 제목
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new BorderLayout());//hGap, vGap이 0인 BorderLayout으로 배치
        c.setBackground(new Color(178,217,74));//배경색 설정
        setCursor(cursor1);//커서설정
        sound("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/music.wav");//sound메소드 호출
        
        //StartPane
        try {
            startimage = ImageIO.read(new File("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/gamestart.png"));
            //시작이미지 물러옴
        }catch(IOException e) {
            JOptionPane.showMessageDialog(null, "스타트 이미지 불러오기 실패");//예외 발생 시 Dialog출력
            System.exit(0);
        }
        
        MyPanel panel = new MyPanel();
        panel.setSize(700,700);//패널 사이즈 700*700
        startPane.add(panel);//startPane에 panel부착
        startPane.setLayout(null);
        start.setFont(start.getFont().deriveFont(39.0f));//게임시작 폰트 설정
        start.setBackground(Color.PINK);//게임시작 버튼 배경색 핑크로 설정
        start.addActionListener(new MyActionListener());//버튼에 액션리스너 부착
        start.setSize(200,100);//버튼 크기
        start.setLocation(230, 500);//버튼 위치
        startPane.add(start);//startPane에 시작버튼 부착
        
        
        //molePane
        score.setBackground(Color.PINK);//상단에 위치한 score패널 배경색 설정
        molePane.setBackground(new Color(178,217,74));//molePane패널 배경색 설정
        for(int i=0; i<9; i++) {
            hole[i]= new JButton(ground);//버튼 생성
            hole[i].setBackground(new Color(178,217,74));//버튼 배경색 설정
            hole[i].addActionListener(new MyActionListener());//버튼 이벤트리스너 
            molePane.add(hole[i]);//molePane패널에 버튼 부착
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
        feverstartPane.add(fevernotify);//피버타임 시작 판에 피버타임을 알려주는 이미지 부착
        for(int i=0; i<8; i++) {
            feverhole[i]= new JButton(mole);//두더지 버튼 생성
            feverhole[i].setBackground(new Color(178,217,74));//배경색 설정
            feverhole[i].addActionListener(new MyActionListener());//버튼의 이벤트 리스너
            m3_2[i] = new change_mole3(feverhole[i]);
            m3_2[i].start();
        }
        feverPane.setBackground(Color.MAGENTA);//피버타임의 가운데 칸의 배경색 설정
        counter.setFont(counter.getFont().deriveFont(120.0f));
        counter.setForeground(Color.WHITE);//레이블 색 설정
        counter.setHorizontalAlignment(JLabel.CENTER);//레이블 내용 가운데로 정렬
        for(int i=0; i<4; i++) {
            feverPane.add(feverhole[i]);
            feverhole[i].addActionListener(new MyActionListener());
        }
        feverPane.add(counter); //피버타임 시간초
        for(int i=4; i<8; i++) {
            feverPane.add(feverhole[i]);
            feverhole[i].addActionListener(new MyActionListener());
        }
        
        
        //endPane
        endPane.setBackground(Color.BLACK);//마지막 Panel배경색 설정
        endPane.setLayout(null);
        endPane.add(gameover);//게임오버 레이블 부착
        endPane.add(end);//end레이블 부착
        endPane.add(evaluation);//evaluation레이블 부착
        gameover.setFont(gameover.getFont().deriveFont(80.0f));//게임오버 레이블 폰트 설정
        gameover.setForeground(Color.RED);//게임오버 레이블 색 설정
        gameover.setSize(600,300);//게임오버 레이블 사이즈
        gameover.setLocation(105,150);//게임오버 레이블 위치
        end.setFont(end.getFont().deriveFont(40.0f));//점수 레이블 폰트 설정
        end.setForeground(Color.WHITE);//점수 레이블 색 설정
        end.setSize(560,100);//점수 레이블 사이즈 설정
        end.setLocation(135, 300);//점수 레이블 위치 설정
        evaluation.setForeground(Color.WHITE);//평가부분 레이블 색 설정
        evaluation.setFont(end.getFont().deriveFont(40.0f));//평가 레이블 폰트 설정
        evaluation.setSize(560,100);//평가 레이블 사이즈 설정
        evaluation.setLocation(220,400);//평가 레이블 위치 설정
        
        c.add(startPane,BorderLayout.CENTER);
        setSize(700,700);//사이즈 설정
        setVisible(true);
        timethread.start();//timeover쓰레드 시작
    }
    
    class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==start) {//만약 시작 버튼이 클릭되면
                startPane.setVisible(false);//startPane은 감춘다.
                c.add(score, BorderLayout.NORTH);//score패널은 컨테이너의 위쪽으로 배치한다.
                c.add(molePane, BorderLayout.CENTER);//molePane 패널은 컨테이너의 중앙으로 배치한다.
                
            }
            for(int i=0; i<9; i++) {
                if(e.getSource()==hole[i]) {//만약 hole버튼이 클릭되면    
                    if(hole[i].getIcon().toString().equals("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/mole1.png")) {
                        s.start();//만약 두더지 그림이 클릭되면 점수를 1씩 증가시킨다.
                        hole[i].setIcon(ground);//클릭되면 버튼 아이콘을 ground로 설정한다.
                    }
                }
            }
            for(int i=0; i<8; i++) {
                if(e.getSource()==feverhole[i]) {//만약 feverhole이 클릭되면(피버타임의 버튼)
                    if(feverhole[i].getIcon().toString().equals("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/mole1.png")) {
                        s.fever();//만약 두더지 그림이 클린되면 점수를 2씩 증가시킨다.
                        feverhole[i].setIcon(ground);//클릭되면 버튼 아이콘을 ground로 설정한다.
                    }
                }
            }
            for(int i=4; i<8; i++) {
                if(e.getSource()==feverhole[i]) {
                    if(feverhole[i].getIcon().toString().equals("C:\\Users\\kjw01\\Desktop\\Documents\\2-2\\자바\\프로젝트/mole1.png")) {
                        s.fever();
                        feverhole[i].setIcon(ground);
                    }
                }
            }
            scorecount.setText(s.getscore());//scorecount레이블에 현재점수를 저장한다.
            
            if(counter.getText().equals("0")) {
                feverPane.setVisible(false);//피버타임의 counter가 0이 되면 feverPane안 보이게 함
                molePane.setVisible(true);//molePane보이게 함
            }
            end.setText("당신의 총 점수는 "+s.getscore_end()+"점!!");//end레이블에 문자열 설정
            if(s.getscore_end().equals("15")||s.getscore_end().equals("100")){//점수가 15점 이상이거나 100정이면 fever호출
                fever();
            }
        }
    }
    public static void fever() {
        molePane.setVisible(false);
        c.add(feverstartPane);//feverstartpane 추가
        int timer=8;//타이머 설정
        feverstarttime ft = new feverstarttime(timer,c,feverstartPane, feverPane, molePane, counter);
        ft.start();    
    }
}