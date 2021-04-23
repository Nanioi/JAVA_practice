import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class JC18012628M1 extends JFrame implements ActionListener {
	JButton btnBook, btnOrders, btnCustomer, btn4, btn5, btn6, btnInput, btnReset;
	JTextArea txtResult, txtStatus;
	JPanel pn1;

	static Connection con;
	Statement stmt;
	ResultSet rs;
	String Driver = "";
	String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
	String userid = "madang";
	String pwd = "madang";

	public JC18012628M1() {
		super("18012628/곽나연");
		layInit();
		conDB();
		setVisible(true);
		setBounds(200, 200, 800, 400); // 가로위치,세로위치,가로길이,세로길이
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void layInit() {
		btnBook = new JButton("검색1");
		btnOrders = new JButton("검색2");
		btnCustomer = new JButton("검색3");
		btn4 = new JButton("검색4");
		btn5 = new JButton("검색5");
		btn6 = new JButton("검색6");
		btnInput = new JButton("입력1");
		btnReset = new JButton("화면초기화");
		txtResult = new JTextArea();
		txtStatus = new JTextArea(5, 30);

		pn1 = new JPanel();
		pn1.add(btnBook);
		pn1.add(btnOrders);
		pn1.add(btnCustomer);
		pn1.add(btn4);
		pn1.add(btn5);
		pn1.add(btn6);
		pn1.add(btnInput);
		pn1.add(btnReset);

		txtResult.setEditable(false);
		txtStatus.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResult);
		JScrollPane scrollPane2 = new JScrollPane(txtStatus);

		add("North", pn1);
		add("Center", scrollPane);
		add("South", scrollPane2);

		btnBook.addActionListener(this);
		btnOrders.addActionListener(this);
		btnCustomer.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btnInput.addActionListener(this);
		btnReset.addActionListener(this);
	}

	public void conDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("드라이버 로드 성공");
			txtStatus.append("드라이버 로드 성공...\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try { /* 데이터베이스를 연결하는 과정 */
			// System.out.println("데이터베이스 연결 준비...");
			txtStatus.append("데이터베이스 연결 준비...\n");
			con = DriverManager.getConnection(url, userid, pwd);
			// System.out.println("데이터베이스 연결 성공");
			txtStatus.append("데이터베이스 연결 성공...\n");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		try {
			stmt = con.createStatement();
			if (obj == btnBook) {
				String query = "SELECT * FROM Book ";
				txtResult.setText("");
				txtResult.setText(
						"BOOKNO               BOOK NAME                            PUBLISHER             PRICE\n");
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					String str = rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t" + rs.getInt(4)
							+ "\n";
					txtResult.append(str);
				}
			} else if (obj == btnOrders) {
				String query = "SELECT * FROM Orders ";
				txtResult.setText("");
				txtResult.setText("ORDERNO 	CUSTNO         BOOKID         SALEPRICE             ORDERDATE\n");
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					String str = rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t"
							+ rs.getDate(5) + "\n";
					txtResult.append(str);
				}
			} else if (obj == btnCustomer) {
				String query = "SELECT * FROM Customer ";
				txtResult.setText("");
				txtResult.setText(
						"CUSTNO           NAME                   ADDRESS                                  PHONE\n");
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					String str = rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t"
							+ rs.getString(4) + "\n";
					txtResult.append(str);
				}
			} else if (obj == btn4) {
				// 박지성이 구매하지 않은 도서의 이름 검색
				String query = "SELECT bookname FROM Book WHERE bookname "
						+ "NOT IN(SELECT Book.bookname FROM Book,Orders,Customer WHERE Orders.custid = Customer.custid and Book.bookid = Orders.bookid and Customer.name ='박지성');";
				txtResult.setText("");
				txtResult.setText("박지성이 구매하지 않은 도서의 이름 : \n");
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					String str = rs.getString(1) + "\n";
					txtResult.append(str);
				}
			} else if (obj == btn5) {
				// 박지성이 구매한 도서의 출판사 수 검색
				String query = "SELECT count(distinct publisher) FROM Book "
						+ "WHERE bookid in (SELECT bookid FROM orders WHERE custid = (SELECT custid FROM Customer WHERE name = '박지성'));";
//				String query = "SELECT count(distinct publisher) FROM Book, Orders WHERE Book.bookid = Orders.bookid "
//				+ "and custid = (SELECT custid FROM Customer WHERE name = '박지성');";
				txtResult.setText("");
				txtResult.setText("박지성이 구매한 도서의 출판사 수 : \n");
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					String str = rs.getInt(1) + "\n";
					txtResult.append(str);
				}
			} else if (obj == btn6) {
				// 박지성이 구매한 도서의 숫자 검색
				String query = "SELECT count(bookid) FROM Orders "
						+ "WHERE custid = (SELECT custid FROM Customer WHERE name = '박지성');";
				txtResult.setText("");
				txtResult.setText("박지성이 구매한 도서의 수 : \n");
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					String str = rs.getInt(1) + "\n";
					txtResult.append(str);
				}
			} else if (obj == btnInput) {
				txtResult.setText("");
				int orderid;
				int custid;
				int bookid;
				int saleprice;
				String orderdate;
				Scanner sc = new Scanner(System.in);

				try {
					System.out.println("orderID를 입력하세요.");
					orderid = sc.nextInt();
					System.out.println("custID를 입력하세요.");
					custid = sc.nextInt();
					System.out.println("bookID를 입력하세요");
					bookid = sc.nextInt();
					System.out.println("salePrice를 입력하세요");
					saleprice = sc.nextInt();
					System.out.println("orderDate를 입력하세요");
					orderdate = sc.next();
					StringBuilder sb = new StringBuilder();
					String query = sb.append("INSERT INTO Orders VALUES(").append(orderid + ",").append(custid + ",")
							.append(bookid + ",").append(saleprice + ", STR_TO_DATE('")
							.append(orderdate + "','%Y-%m-%d'));").toString();

					stmt.executeUpdate(query);
					txtStatus.append("입력성공!\n");
				} catch (Exception e1) {
					txtStatus.append("입력실패 : "+e1.getMessage()+" \n");
					System.err.println("SQL exception: " + e1.getMessage());
				}

			} else if (obj == btnReset) {
				try {
					String query = "DELETE FROM Orders WHERE orderid >10;";
					stmt.execute(query);
					txtResult.setText("");
					txtStatus.append("초기화성공!\n");
				} catch (SQLException e3) {
					txtStatus.append("초기화실패 : " + e3 + "\n");
				}
			}
		} catch (Exception e2) {
			System.out.println("쿼리 읽기 실패 :" + e2);
			/*
			 * } finally { try { if (rs != null) rs.close(); if (stmt != null) stmt.close();
			 * if (con != null) con.close(); } catch (Exception e3) { // TODO: handle
			 * exception }
			 */
		}

	}

	public static void main(String[] args) {
		JC18012628M1 BLS = new JC18012628M1();

		// BLS.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// BLS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BLS.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					con.close();
				} catch (Exception e4) {
				}
				System.out.println("프로그램 완전 종료!");
				System.exit(0);
			}
		});
	}
}
