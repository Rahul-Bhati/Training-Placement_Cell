import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
	JLabel back,jl1,jl2;
	JTextField email;
	JPasswordField pass;
	JButton jb;
	Font f;
	Login(String s){
		super(s);
		setLayout(null);
		back = new JLabel(new ImageIcon("login.jpg"));
		jl1 = new JLabel("Email : ");
		jl2 = new JLabel("Password : ");
		jb = new JButton("Login");
		email = new JTextField(100);
		pass = new JPasswordField(100);
		f = new Font("verdana",Font.BOLD,15);
		jl1.setBounds(300,350,200,30);
		email.setBounds(400,350,200,30);
		jl2.setBounds(300,400,200,30);
		pass.setBounds(400,400,200,30);
		jb.setBounds(300,450,150,30);
		back.setBounds(0,0,1000,1000);
		jl1.setFont(f);
		jl2.setFont(f);
		
		add(jl1);
		add(email);
		add(jl2);
		add(pass);
		add(jb);
		add(back);
		jb.addActionListener(this);
	}
	public void actionPerformed(ActionEvent et){
		String remail = email.getText();
		String rpass = pass.getText();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from admin where email='"+remail+"'");
			if(rs.next()){
				if(rs.getString(2).equals(rpass)){
					Mgmt obj = new Mgmt("Management Table");
					obj.setSize(1000,1000);
					obj.setVisible(true);
					this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null,"invalid password");
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"invalid email-id");
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver : "+ e.getMessage());
		}
		catch(SQLException e){
			System.out.println("SQL :  "+e.getMessage());
		}
	}
	public static void main(String []arr){
		Login obj = new Login("Login");
		obj.setSize(1000,1000);
		obj.setVisible(true);
	}
}
