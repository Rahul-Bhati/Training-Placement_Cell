import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Company extends JFrame implements ActionListener{
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7,body;
    JButton jb,jb1,jb2,jb3,exit;
	JCheckBox jc1,jc2,jc3,jc4,jc5,jc6;
	int flag=0;
	Font f;
	Company(String s){
        super(s);
        setLayout(null);
		f = new Font("verdana",Font.BOLD,15);
		jl = new JLabel(new ImageIcon("company01.jpg"));
		body = new JLabel(new ImageIcon("company_body.jpg"));
        jl1=new JLabel("company :");
        jt1=new JTextField(20);
		jl2=new JLabel("Email-id :");
        jt2=new JTextField(20);
		jl3=new JLabel("Pkg(in LPA)");
        jt3=new JTextField(20);
		jl4 = new JLabel("B.tech Agg.");
		jt4 = new JTextField(20);
		
		jl5 = new JLabel("Backlogs");
		jt5 = new JTextField(20);
		
		jl6 = new JLabel("Eligible Branch");
		jc1 = new JCheckBox("CSE");
		jc2 = new JCheckBox("IT");
		jc3 = new JCheckBox("ECE");
		jc4 = new JCheckBox("EE");
		jc5 = new JCheckBox("CE");
		jc6 = new JCheckBox("ME");
		
		jl7 = new JLabel("Location");
		jt6 = new JTextField(20);
		
        jb=new JButton("Submit");
		jb1=new JButton("Edit");
		jb2=new JButton("Delete");
		jb3=new JButton("Logout");
		exit=new JButton("Exit");

        jl.setBounds(0,0,1000,200);
        body.setBounds(0,200,1000,800);
        jl1.setBounds(150,250,100,30);
        jt1.setBounds(300,250,200,30);
		jb1.setBounds(550,250,100,30);
        jl2.setBounds(150,290,100,30);
        jt2.setBounds(300,290,200,30);
        jb2.setBounds(550,290,100,30);
		
        jl3.setBounds(150,325,100,30);
        jt3.setBounds(300,325,200,30);
        jb3.setBounds(550,325,100,30);
		
		jl4.setBounds(150,360,100,30);
        jt4.setBounds(300,360,200,30);
		exit.setBounds(550,360,100,30);
		
		jl5.setBounds(150,395,100,30);
        jt5.setBounds(300,395,200,30);
		
		jl6.setBounds(150,435,100,30);
		jc1.setBounds(300,435,80,30);
		jc2.setBounds(380,435,80,30);
		jc3.setBounds(460,435,80,30);
		jc4.setBounds(540,435,80,30);
		jc5.setBounds(620,435,80,30);
		jc6.setBounds(700,435,80,30);
		
		jl7.setBounds(150,475,100,30);
        jt6.setBounds(300,475,200,30);
		jb.setBounds(300,520,100,50);  
	
        jb.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		exit.addActionListener(this);
		
		jl1.setFont(f);
		jl2.setFont(f);
		jl3.setFont(f);
		jl4.setFont(f);
		jl5.setFont(f);
		jl6.setFont(f);
		jl7.setFont(f);
		jb.setFont(f);
		jb1.setFont(f);
		jb2.setFont(f);
		jb3.setFont(f);
		exit.setFont(f);
		
        add(jl);
		add(jl1);
        add(jt1);

        add(jl2);
        add(jt2);

        add(jl3);
        add(jt3);
		add(jl4);
        add(jt4);
		add(jl5);
        add(jt5);
		add(jl6);
		add(jc1);
        add(jc2);
        add(jc3);
        add(jc4);
        add(jc5);
        add(jc6);
        add(jl7);
        add(jt6);
		
        add(jb);
		add(jb1);
		add(jb2);
		add(jb3);
		add(exit);
		add(body);
    }
	
	public void actionPerformed(ActionEvent et){
		if(et.getSource()==jb1){
			String name=jt1.getText();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery("select * from company where cname='"+name+"'");
				if(rs.next()){
					jt2.setText(rs.getString(2));
					jt3.setText(rs.getInt(3)+"");
					jt4.setText(rs.getInt(4)+"");
					jt5.setText(rs.getInt(5)+"");
					jt6.setText(rs.getString(6));
					Statement st1 = cn.createStatement();
					ResultSet rs1 = st1.executeQuery("select * from branch where cname='"+name+"'");
					while(rs1.next()){
						if(rs1.getString(2).equals("CSE")){
							jc1.setSelected(true);
						}
						else if(rs1.getString(2).equals("IT")){
							jc2.setSelected(true);
						}
						else if(rs1.getString(2).equals("ECE")){
							jc3.setSelected(true);
						}
						else if(rs1.getString(2).equals("EE")){
							jc4.setSelected(true);
						}
						else if(rs1.getString(2).equals("CE")){
							jc5.setSelected(true);
						}
						else if(rs1.getString(2).equals("ME")){
							jc6.setSelected(true);
						}
					}
					flag=1;
				}
				else{
					flag=0;
					JOptionPane.showMessageDialog(null,"Record not found");
					Company dr = new Company("Insert Record");
					dr.setSize(1000,1000);
					dr.setVisible(true);	
					this.setVisible(false);	
				}
			}
			catch(ClassNotFoundException e){
				System.out.println("Driver : "+ e.getMessage());
			}
			catch(SQLException ec){
				System.out.println("SQL :  "+ec.getMessage());
			}  
		}
		else if(et.getSource()==jb2){
			String name=jt1.getText();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery("select * from company where cname='"+name+"'");
				if(rs.next()){
					jt2.setText(rs.getString(2));
					jt3.setText(rs.getInt(3)+"");
					jt4.setText(rs.getInt(4)+"");
					jt5.setText(rs.getInt(5)+"");
					jt6.setText(rs.getString(6));
					Statement st1 = cn.createStatement();
					ResultSet rs1 = st1.executeQuery("select * from branch where cname='"+name+"'");
					while(rs1.next()){
						if(rs1.getString(2).equals("CSE")){
							jc1.setSelected(true);
						}
						else if(rs1.getString(2).equals("IT")){
							jc2.setSelected(true);
						}
						else if(rs1.getString(2).equals("ECE")){
							jc3.setSelected(true);
						}
						else if(rs1.getString(2).equals("EE")){
							jc4.setSelected(true);
						}
						else if(rs1.getString(2).equals("CE")){
							jc5.setSelected(true);
						}
						else if(rs1.getString(2).equals("ME")){
							jc6.setSelected(true);
						}
					}
					flag=2;
				}
				else{
					flag=0;
					JOptionPane.showMessageDialog(null,"Record not found");
					Company dr = new Company("Insert Record");
					dr.setSize(1000,1000);
					dr.setVisible(true);	
					this.setVisible(false);	
				}
			}
			catch(ClassNotFoundException e){
				System.out.println("Driver : "+ e.getMessage());
			}
			catch(SQLException ec){
				System.out.println("SQL :  "+ec.getMessage());
			}  
		}
		else if(et.getSource()==jb3){
			Login dr = new Login("logout");
			dr.setSize(1000,1000);
			dr.setVisible(true);	
			this.setVisible(false);
		}
		else if(et.getSource()==exit){
			Mgmt dr = new Mgmt("Management");
			dr.setSize(1000,1000);
			dr.setVisible(true);	
			this.setVisible(false);
		}
		else{
			String name = jt1.getText();
			String email = jt2.getText();
			int pkg = Integer.parseInt(jt3.getText());
			int agg = Integer.parseInt(jt4.getText());
			int back = Integer.parseInt(jt5.getText());
			String loc = jt6.getText();
				try{	
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
					String msg="";
					PreparedStatement py= null ;
					if(flag==0){
						PreparedStatement ps=cn.prepareStatement("insert into branch values(?,?)");
						if(jc1.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"CSE");
							ps.execute();
						}
						if(jc2.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"IT");
							ps.execute();
						}
						if(jc3.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"ECE");
							ps.execute();
						}
						if(jc4.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"EE");
							ps.execute();
						}
						if(jc5.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"CE");
							ps.execute();
						}
						if(jc6.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"ME");
							ps.execute();
						}
						
						py=cn.prepareStatement("insert into company values(?,?,?,?,?,?)");
						py.setString(1,name);
						py.setString(2,email);
						py.setInt(3,pkg);
						py.setInt(4,agg);
						py.setInt(5,back);
						py.setString(6,loc);
						msg="Record Inserted";
					}
					else if(flag==1){
						PreparedStatement pb=cn.prepareStatement("delete from branch where cname=?");
						pb.setString(1,name);
						pb.execute();
						
						PreparedStatement ps=cn.prepareStatement("insert into branch values(?,?)");
						if(jc1.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"CSE");
							ps.execute();
						}
						if(jc2.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"IT");
							ps.execute();
						}
						if(jc3.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"ECE");
							ps.execute();
						}
						if(jc4.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"EE");
							ps.execute();
						}
						if(jc5.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"CE");
							ps.execute();
						}
						if(jc6.isSelected()){
							ps.setString(1,name);
							ps.setString(2,"ME");
							ps.execute();
						}
						
						py=cn.prepareStatement("update company set email=?,pkg=?,agg=?,backlog=?,loc=? where cname=?");
						py.setString(1,email);
						py.setInt(2,pkg);
						py.setInt(3,agg);
						py.setInt(4,back);
						py.setString(5,loc);
						py.setString(6,name);
						py.execute();
						msg="Record Updated";
					}	
					else if(flag==2){
						PreparedStatement pb=cn.prepareStatement("delete from branch where cname=?");
						pb.setString(1,name);
						pb.execute();
						py=cn.prepareStatement("delete from company where cname=?");
						py.setString(1,name);
						msg="Record Deleted";
					}	
					if(py.executeUpdate()>0){
					   JOptionPane.showMessageDialog(null,msg); 
					   this.setVisible(false);
					   Company dr = new Company("Insert Record");
					   dr.setSize(1000,1000);
					   dr.setVisible(true);	 
					}
					else{
						JOptionPane.showMessageDialog(null,"Try Again"); 
					}
					cn.close();
				}
				catch(ClassNotFoundException e){
					System.out.println("Driver : "+ e.getMessage());
				}
				catch(SQLException ec){
					System.out.println("SQL :  "+ec.getMessage());
				}  	
		}
	}
}


