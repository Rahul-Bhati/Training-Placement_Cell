import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Student extends JFrame implements ActionListener{
	JTextField sid,sname,fname,mname,email,phone,ten,tew,btech,nob,jt11;
    JLabel bg,body,jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12;
	JRadioButton jr,jr1,jr2,jr3,jr4,jr5,jr6,jr7;
	ButtonGroup Gender,Branch;
    JButton jb,jb1,jb2,jb3,exit;
	int flag=0;
	Font f1;
    Student(String s){
        super(s);
        setLayout(null);
		f1 = new Font("arial",Font.BOLD,15);
		Gender = new ButtonGroup();
		Branch = new ButtonGroup();
		bg = new JLabel(new ImageIcon("student.jpg"));
		body = new JLabel(new ImageIcon("student_body.jpg"));
        jl1 = new JLabel("Student-id:");
        sid = new JTextField(20);
        jl2 = new JLabel("Name:");
        sname = new JTextField(20);
        jl3 = new JLabel("Father-Name:");
        fname = new JTextField(20);
		jl4 = new JLabel("Mother-Name:");
        mname = new JTextField(20);
		jl5 = new JLabel("Email-id :");
        email = new JTextField(20);
		jl6 = new JLabel("Phone no. :");
        phone = new JTextField(20);
		
		jl7 = new JLabel("Gender :");
        jr = new JRadioButton("Male");
        jr1 = new JRadioButton("Female");
		Gender.add(jr);
		Gender.add(jr1);
		
		jl8 = new JLabel("Branch :");
        jr2 = new JRadioButton("CSE");
        jr3 = new JRadioButton("IT");
        jr4 = new JRadioButton("ECE");
        jr5 = new JRadioButton("EE");
        jr6 = new JRadioButton("CE");
        jr7 = new JRadioButton("ME");
		Branch.add(jr2);
		Branch.add(jr3);
		Branch.add(jr4);
		Branch.add(jr5);
		Branch.add(jr6);
		Branch.add(jr7);
		
		jl9 = new JLabel("10th % :");
		ten = new JTextField(20);
		jl10 = new JLabel("12th % :");
		tew = new JTextField(20);
		jl11 = new JLabel("B.tech Agg. :");
		btech = new JTextField(20);
		jl12 = new JLabel("No. Of Back :");
		nob = new JTextField(20);
		
        jb = new JButton("Submit");
		jb1 = new JButton("Edit");
		jb2 = new JButton("Delete");
		jb3 = new JButton("Logout");
		exit = new JButton("Exit");

		bg.setBounds(0,0,1000,200);
		body.setBounds(0,200,1000,800);
        jl1.setBounds(150,230,100,30);
        sid.setBounds(300,230,200,30);
		jb1.setBounds(520,230,100,30);
        jl2.setBounds(150,280,100,30);
        sname.setBounds(300,280,200,30);
        jb2.setBounds(520,280,100,30);
        jl3.setBounds(150,320,100,30);
        fname.setBounds(300,320,200,30);
        jb3.setBounds(520,320,100,30);
		jl4.setBounds(150,360,100,30);
        mname.setBounds(300,360,200,30);
		exit.setBounds(520,360,100,30);
		
		jl5.setBounds(150,400,100,30);
        email.setBounds(300,400,200,30);
		jl6.setBounds(150,440,100,30);
        phone.setBounds(300,440,200,30);
		jl7.setBounds(150,480,100,30);
		jr.setBounds(300,480,100,30);
		jr1.setBounds(400,480,100,30);
		jl8.setBounds(150,520,100,30);
		jr2.setBounds(300,520,100,30);
		jr3.setBounds(400,520,100,30);
		jr4.setBounds(500,520,100,30);
		jr5.setBounds(600,520,100,30);
		jr6.setBounds(700,520,100,30);
		jr7.setBounds(800,520,100,30);
		
		jl9.setBounds(150,570,100,30);
        ten.setBounds(300,570,200,30);
		jl10.setBounds(150,600,100,30);
        tew.setBounds(300,600,200,30);
		jl11.setBounds(150,640,100,30);
        btech.setBounds(300,640,200,30);
		jl12.setBounds(150,690,100,30);
        nob.setBounds(300,690,200,30);
		
		jb.setBounds(300,740,100,50); 

		jl1.setFont(f1);
		jl2.setFont(f1);
		jl3.setFont(f1);
		jl4.setFont(f1);
		jl5.setFont(f1);
		jl6.setFont(f1);
		jl7.setFont(f1);
		jl8.setFont(f1);
		jl9.setFont(f1);
		jl10.setFont(f1);
		jl11.setFont(f1);
		jl12.setFont(f1);
		jb.setFont(f1);
		jb1.setFont(f1);
		jb2.setFont(f1);
		jb3.setFont(f1);
		exit.setFont(f1);
	
        jb.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		exit.addActionListener(this);
        
		add(jl1);
        add(sid);

        add(jl2);
        add(sname);

        add(jl3);
        add(fname);
		add(jl4);
        add(mname);
		add(jl5);
        add(email);
		add(jl6);
        add(phone);
        
		add(jl7);
		add(jr);
		add(jr1);
		
		add(jl8);
		add(jr2);
		add(jr3);
		add(jr4);
		add(jr5);
		add(jr6);
		add(jr7);
		
		add(jl9);
		add(ten);
		add(jl10);
		add(tew);
		add(jl11);
		add(btech);
		add(jl12);
		add(nob);

        add(jb);
		add(jb1);
		add(jb2);
		add(jb3);
		add(exit);
		add(bg);
		add(body);
    }
	
	public void actionPerformed(ActionEvent et){
		    if(et.getSource()==jb1){
			    try{
					String rsid = sid.getText();
					System.out.println(rsid);
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
					Statement st=cn.createStatement();
					ResultSet rs=st.executeQuery("select * from mgmt where student_id='"+rsid+"' ");
					if(rs.next()){
						sname.setText(rs.getString(2));
						fname.setText(rs.getString(3));
						mname.setText(rs.getString(4));
						email.setText(rs.getString(5));
						phone.setText(rs.getString(6));
						ten.setText(rs.getInt(9)+"");
						tew.setText(rs.getInt(10)+"");
						btech.setText(rs.getInt(11)+"");
						nob.setText(rs.getInt(12)+"");
						if(rs.getString(7).equals("Male")){
							jr.setSelected(true);
						}
						else if(rs.getString(7).equals("Female")){
							jr1.setSelected(true);
						}
						if(rs.getString(8).equals("CSE")){
							jr2.setSelected(true);
						}
						else if(rs.getString(8).equals("IT")){
							jr3.setSelected(true);
						}
						else if(rs.getString(8).equals("ECE")){
							jr4.setSelected(true);
						}
						else if(rs.getString(8).equals("EE")){
							jr5.setSelected(true);
						}
						else if(rs.getString(8).equals("CE")){
							jr6.setSelected(true);
						}
						else if(rs.getString(8).equals("ME")){
							jr7.setSelected(true);
						}
						flag=1;
					}
					else{
						flag=0;
						JOptionPane.showMessageDialog(null,"Record not found");
						Student dr = new Student("Insert Record");
						dr.setSize(1000,1000);
						dr.setVisible(true);	
						this.setVisible(false);	
					}
					cn.close();
				}
				catch(ClassNotFoundException e){
					System.out.println("Driver : "+ e.getMessage());
				}
				catch(SQLException e){
					System.out.println("SQL :  "+e.getMessage());
				}   
		    }
			else if(et.getSource()==jb2){
			    try{
					String rsid = sid.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
					Statement st=cn.createStatement();
					ResultSet rs=st.executeQuery("select * from mgmt where student_id='"+rsid+"' ");
					if(rs.next()){
						sname.setText(rs.getString(2));
						fname.setText(rs.getString(3));
						mname.setText(rs.getString(4));
						email.setText(rs.getString(5));
						phone.setText(rs.getString(6));
						ten.setText(rs.getInt(9)+"");
						tew.setText(rs.getInt(10)+"");
						btech.setText(rs.getInt(11)+"");
						nob.setText(rs.getInt(12)+"");
						if(rs.getString(7).equals("Male")){
							jr.setSelected(true);
						}
						else if(rs.getString(7).equals("Female")){
							jr1.setSelected(true);
						}
						if(rs.getString(8).equals("CSE")){
							jr2.setSelected(true);
						}
						else if(rs.getString(8).equals("IT")){
							jr3.setSelected(true);
						}
						else if(rs.getString(8).equals("ECE")){
							jr4.setSelected(true);
						}
						else if(rs.getString(8).equals("EE")){
							jr5.setSelected(true);
						}
						else if(rs.getString(8).equals("CE")){
							jr6.setSelected(true);
						}
						else if(rs.getString(8).equals("ME")){
							jr7.setSelected(true);
						}
						flag=2;
					}
					else{
						flag=0;
						JOptionPane.showMessageDialog(null,"Record not found");
						Student dr = new Student("Insert Record");
						dr.setSize(1000,1000);
						dr.setVisible(true);	
						this.setVisible(false);	
					}
					cn.close();
				}
				catch(ClassNotFoundException e){
					System.out.println("Driver : "+ e.getMessage());
				}
				catch(SQLException e){
					System.out.println("SQL :  "+e.getMessage());
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
				String rsid = sid.getText();
				String rsname = sname.getText();
				String rfname = fname.getText();
				String rmname = mname.getText();
				String remail = email.getText();
				String rphone = phone.getText();
				String Gender = null;
				if(jr.isSelected()){
					Gender = jr.getText();
				}
				else if(jr1.isSelected()){
					Gender = jr1.getText();
				}
				
				String Branch = null;
				if(jr2.isSelected()){
					Branch = jr2.getText();
				}
				else if(jr3.isSelected()){
					Branch = jr3.getText();
				}
				else if(jr4.isSelected()){
					Branch = jr4.getText();
				}
				else if(jr5.isSelected()){
					Branch = jr5.getText();
				}
				else if(jr6.isSelected()){
					Branch = jr6.getText();
				}
				else if(jr7.isSelected()){
					Branch = jr7.getText();
				}
				int rten = Integer.parseInt(ten.getText());
				int rtew = Integer.parseInt(tew.getText());
				int rbtech = Integer.parseInt(btech.getText());
				int rnob = Integer.parseInt(nob.getText());
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
					PreparedStatement ps=null;
					String msg="";
					if(flag==0){
						ps=cn.prepareStatement("insert into mgmt values(?,?,?,?,?,?,?,?,?,?,?,?)");
						ps.setString(1,rsid);
						ps.setString(2,rsname);
						ps.setString(3,rfname);
						ps.setString(4,rmname);
						ps.setString(5,remail);
						ps.setString(6,rphone);
						ps.setString(7,Gender);
						ps.setString(8,Branch);
						ps.setInt(9,rten);
						ps.setInt(10,rtew);
						ps.setInt(11,rbtech);
						ps.setInt(12,rnob);
						msg="Record Inserted";
					}	
					else if(flag==1){
						ps=cn.prepareStatement("update mgmt set student_name=?,father_name=?,mother_name=?,email_id=?,phone=?,gender=?,branch=?,10th=?,12th=?,btech_agg=?,nob=? where student_id=?");
						ps.setString(12,rsid);
						ps.setString(1,rsname);
						ps.setString(2,rfname);
						ps.setString(3,rmname);
						ps.setString(4,remail);
						ps.setString(5,rphone);
						ps.setString(6,Gender);
						ps.setString(7,Branch);
						ps.setInt(8,rten);
						ps.setInt(9,rtew);
						ps.setInt(10,rbtech);
						ps.setInt(11,rnob);
						msg="Record Updated";
					}	
					else if(flag==2){
						ps=cn.prepareStatement("delete from mgmt where student_id=?");
						ps.setString(1,rsid);
						msg="Record Deleted";
					}					
							
					if(ps.executeUpdate()>0){
					   JOptionPane.showMessageDialog(null,msg); 
					   this.setVisible(false);
					   Student dr = new Student("Insert Record");
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
				catch(SQLException e){
					System.out.println("SQL :  "+e.getMessage());
				}   
		    }		   	   
	}
}


