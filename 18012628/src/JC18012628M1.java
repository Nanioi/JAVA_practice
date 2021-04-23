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
		super("18012628/������");
		layInit();
		conDB();
		setVisible(true);
		setBounds(200, 200, 800, 400); // ������ġ,������ġ,���α���,���α���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void layInit() {
		btnBook = new JButton("�˻�1");
		btnOrders = new JButton("�˻�2");
		btnCustomer = new JButton("�˻�3");
		btn4 = new JButton("�˻�4");
		btn5 = new JButton("�˻�5");
		btn6 = new JButton("�˻�6");
		btnInput = new JButton("�Է�1");
		btnReset = new JButton("ȭ���ʱ�ȭ");
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
			// System.out.println("����̹� �ε� ����");
			txtStatus.append("����̹� �ε� ����...\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try { /* �����ͺ��̽��� �����ϴ� ���� */
			// System.out.println("�����ͺ��̽� ���� �غ�...");
			txtStatus.append("�����ͺ��̽� ���� �غ�...\n");
			con = DriverManager.getConnection(url, userid, pwd);
			// System.out.println("�����ͺ��̽� ���� ����");
			txtStatus.append("�����ͺ��̽� ���� ����...\n");
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
				// �������� �������� ���� ������ �̸� �˻�
				String query = "SELECT bookname FROM Book WHERE bookname "
						+ "NOT IN(SELECT Book.bookname FROM Book,Orders,Customer WHERE Orders.custid = Customer.custid and Book.bookid = Orders.bookid and Customer.name ='������');";
				txtResult.setText("");
				txtResult.setText("�������� �������� ���� ������ �̸� : \n");
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					String str = rs.getString(1) + "\n";
					txtResult.append(str);
				}
			} else if (obj == btn5) {
				// �������� ������ ������ ���ǻ� �� �˻�
				String query = "SELECT count(distinct publisher) FROM Book "
						+ "WHERE bookid in (SELECT bookid FROM orders WHERE custid = (SELECT custid FROM Customer WHERE name = '������'));";
//				String query = "SELECT count(distinct publisher) FROM Book, Orders WHERE Book.bookid = Orders.bookid "
//				+ "and custid = (SELECT custid FROM Customer WHERE name = '������');";
				txtResult.setText("");
				txtResult.setText("�������� ������ ������ ���ǻ� �� : \n");
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					String str = rs.getInt(1) + "\n";
					txtResult.append(str);
				}
			} else if (obj == btn6) {
				// �������� ������ ������ ���� �˻�
				String query = "SELECT count(bookid) FROM Orders "
						+ "WHERE custid = (SELECT custid FROM Customer WHERE name = '������');";
				txtResult.setText("");
				txtResult.setText("�������� ������ ������ �� : \n");
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
					System.out.println("orderID�� �Է��ϼ���.");
					orderid = sc.nextInt();
					System.out.println("custID�� �Է��ϼ���.");
					custid = sc.nextInt();
					System.out.println("bookID�� �Է��ϼ���");
					bookid = sc.nextInt();
					System.out.println("salePrice�� �Է��ϼ���");
					saleprice = sc.nextInt();
					System.out.println("orderDate�� �Է��ϼ���");
					orderdate = sc.next();
					StringBuilder sb = new StringBuilder();
					String query = sb.append("INSERT INTO Orders VALUES(").append(orderid + ",").append(custid + ",")
							.append(bookid + ",").append(saleprice + ", STR_TO_DATE('")
							.append(orderdate + "','%Y-%m-%d'));").toString();

					stmt.executeUpdate(query);
					txtStatus.append("�Է¼���!\n");
				} catch (Exception e1) {
					txtStatus.append("�Է½��� : "+e1.getMessage()+" \n");
					System.err.println("SQL exception: " + e1.getMessage());
				}

			} else if (obj == btnReset) {
				try {
					String query = "DELETE FROM Orders WHERE orderid >10;";
					stmt.execute(query);
					txtResult.setText("");
					txtStatus.append("�ʱ�ȭ����!\n");
				} catch (SQLException e3) {
					txtStatus.append("�ʱ�ȭ���� : " + e3 + "\n");
				}
			}
		} catch (Exception e2) {
			System.out.println("���� �б� ���� :" + e2);
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
				System.out.println("���α׷� ���� ����!");
				System.exit(0);
			}
		});
	}
}
