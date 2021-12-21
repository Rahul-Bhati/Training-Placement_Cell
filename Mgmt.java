import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mgmt extends JFrame implements ActionListener {
	JLabel jl,body;
	JButton jb,jb1,jb2,jb3;
	Font f,f1;
	Mgmt(String s){
		super(s);
		setLayout(null);
		f = new Font("verdana",Font.BOLD,20);
		f1 = new Font("arial",Font.BOLD,15);
		jl = new JLabel(new ImageIcon("mgmt.jpg"));
		body = new JLabel(new ImageIcon("mgmt_body.jpg"));
		jl.setFont(f);
		jb = new JButton("Student");
		jb1 = new JButton("Company");
		jb2 = new JButton("Search");
		jb3 = new JButton("Logout");
		jb.setFont(f1);
		jb1.setFont(f1);
		jb2.setFont(f1);
		jb3.setFont(f1);
		
		jl.setBounds(0,0,1000,200);
		body.setBounds(0,200,1000,800);
		jb.setBounds(370,350,200,30);
		jb1.setBounds(370,430,200,30);
		jb2.setBounds(370,510,200,30);
		jb3.setBounds(370,590,200,30);
		
		jb.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		add(jl);
		add(jb);
		add(jb1);
		add(jb2);
		add(jb3);
		add(body);
	}
	public void actionPerformed(ActionEvent et){
		 if(et.getSource()==jb){
			Student obj = new Student("Student Data");
			obj.setSize(1000,1000);
			obj.setVisible(true);
			this.setVisible(false);
		}
		else if(et.getSource()==jb1){
			Company dr = new Company("Company Data");
			dr.setSize(1000,1000);
			dr.setVisible(true);	
			this.setVisible(false);
		}
		else if(et.getSource()==jb2){
			Search dr = new Search("search");
			dr.setSize(1000,1000);
			dr.setVisible(true);	
			this.setVisible(false);
		}
		else if(et.getSource()==jb3){
			Login dr = new Login("logout");
			dr.setSize(1000,1000);
			dr.setVisible(true);	
			this.setVisible(false);
		}
	}
}
