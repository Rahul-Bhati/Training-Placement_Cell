import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Search extends JFrame implements ActionListener{
	JComboBox jc;
	JButton jb,exit;
	JLabel header,body;
	String company[] = {};
	int agg;
	String back = null;
	Font f;
	DefaultTableModel dtm = null ;
	JTable jt = null ;
	JScrollPane js = null ;
	Search(String s){
        super(s);
        setLayout(null);
		f = new Font("verdana",Font.BOLD,15);
		header = new JLabel(new ImageIcon("search.jpg"));
		jb = new JButton("search");
		exit = new JButton("Exit");
		jc = new JComboBox(company);
		
		dtm = new DefaultTableModel();
		jt = new JTable();
		jt.setFont(f);
		dtm.addColumn("Student-Id");
		dtm.addColumn("Name");
		dtm.addColumn("Email");
		dtm.addColumn("Phone");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("select * from company");
			while(rs.next()){
				jc.addItem(rs.getString("cname"));
			}	
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver : "+ e.getMessage());
		}
		catch(SQLException ec){
			System.out.println("SQL : "+ec.getMessage());
		} 
		
		header.setBounds(0,0,1000,200);
		jc.setBounds(350,300,150,30);
		jb.setBounds(520,300,100,30);
		exit.setBounds(650,300,100,30);
		
		jb.setFont(f);
		exit.setFont(f);
		jc.setFont(f);
		
		jt.setModel(dtm);
		js = new JScrollPane(jt);
		js.setBounds(50,360,800,200);
		add(js);
		
		jb.addActionListener(this);
		exit.addActionListener(this);
		add(header);
		add(jc);
		add(jb);
		add(exit);
	}	
	
	public void actionPerformed(ActionEvent et){
		if(et.getSource()==jb){
			String cname = ""+jc.getSelectedItem() ;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery("select * from company where cname='"+cname+"'");
				if(rs.next()){
					agg = rs.getInt(4);
					back = rs.getString(5);
				}
				int flag = 0 ;
				Statement st1 = cn.createStatement();
				ResultSet rs1 = st1.executeQuery("select * from mgmt where btech_agg >="+agg+" AND nob<="+back);
				while(rs1.next()){
					flag = 1 ;
					//System.out.println(rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4));
					dtm.addRow(new Object[]{rs1.getString(1),rs1.getString(2),rs1.getString(5),rs1.getString(6)});
				}
				if(flag==0){
					JOptionPane.showMessageDialog(null,"Record not found");
				}
			}
			catch(Exception ec){
				JOptionPane.showMessageDialog(null,ec.getMessage());
			} 
		}
		else if(et.getSource()==exit){
			Mgmt dr = new Mgmt("Management");
			dr.setSize(1000,1000);
			dr.setVisible(true);	
			this.setVisible(false);
		}
	}
}