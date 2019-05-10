package dentry;
import dentry.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.io.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
 
public class home extends JFrame implements ActionListener 
  { 
    JLabel l1, l2, l3, l4, l5, l6, l7, background;
    JTextField tf1, tf2;
    JButton btn1, btn2;
    JPasswordField p1, p2;
 
    home()
     {
        setVisible(true);
        setSize(1240, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("User Registration");
 
	 File secfile = new File("D:/001)DSMP/imgs/mrg.jpg");
	
	BufferedImage img = null;
	try{
		 img = ImageIO.read(secfile);
	}
	catch (Exception ae)
	{
   		System.out.println("img "+ae);
	} 

	background = new JLabel();
	background.setBounds(0,0,1400,800);
	

	Image dimg = img.getScaledInstance(background.getWidth(), background.getHeight(),
       		 Image.SCALE_SMOOTH);

	background.setIcon(new ImageIcon(dimg));

	
	
        l1 = new JLabel("Home");
        
        l1.setFont(new Font("Serif", Font.BOLD, 50)); l1.setForeground(Color.BLUE);
 
        l2 = new JLabel("Admin Login:"); l2.setFont(new Font("Serif", Font.BOLD, 20));l2.setForeground(Color.BLACK);
        l3 = new JLabel("Username:"); //l3.setForeground(Color.RED);
	l4 = new JLabel("Password:"); //l4.setForeground(Color.RED);
        l5 = new JLabel("User Login:");l5.setFont(new Font("Serif", Font.BOLD, 20)); l5.setForeground(Color.BLACK);
        l6 = new JLabel("Username:"); //l6.setForeground(Color.RED);
	l7 = new JLabel("Password:"); //l7.setForeground(Color.RED);
        tf1 = new JTextField();
	tf2 = new JTextField();
        
        p1 = new JPasswordField();
	p2 = new JPasswordField();
        
        
        
 
        btn1 = new JButton("Log In");
        btn2 = new JButton("Log In");
 
        btn1.addActionListener(this);
        btn2.addActionListener(this);


	l1.setBounds(575, 30, 200, 50);
        l2.setBounds(325, 100, 200, 30);
        l3.setBounds(355, 150, 200, 30);
        l4.setBounds(355, 220, 200, 30);
        l5.setBounds(675, 100, 200, 30);
	l6.setBounds(705, 150, 200, 30);
	l7.setBounds(705, 220, 200, 30);
        
        
        tf1.setBounds(445, 150, 200, 30);
	tf2.setBounds(785, 150, 200, 30);
        
        p1.setBounds(445, 220, 200, 30);
	p2.setBounds(785, 220, 200, 30);
        

        
        btn1.setBounds(475, 280, 100, 30);
        btn2.setBounds(815, 280, 100, 30);

        /*l1.setBounds(300, 30, 200, 50);
        l2.setBounds(50, 100, 200, 30);
        l3.setBounds(80, 150, 200, 30);
        l4.setBounds(80, 220, 200, 30);
        l5.setBounds(400, 100, 200, 30);
	l6.setBounds(430, 150, 200, 30);
	l7.setBounds(430, 220, 200, 30);
        
        
        tf1.setBounds(170, 150, 200, 30);
	tf2.setBounds(510, 150, 200, 30);
        
        p1.setBounds(170, 220, 200, 30);
	p2.setBounds(510, 220, 200, 30);
        

        
        btn1.setBounds(200, 280, 100, 30);
        btn2.setBounds(540, 280, 100, 30);*/
 
	add(background);
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(l4);
        background.add(l5);
	background.add(l6);
	background.add(l7);
        
        background.add(p1);
	background.add(p2);
        
        background.add(tf1);
	background.add(tf2);
        
        
        background.add(btn1);
        background.add(btn2);
    }
 
    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == btn1)
         {
            //int x = 0;
            String s1 = tf1.getText();
            
 
            char[] s2 = p1.getPassword();
            
            String s3 = new String(s2);
            String c1 = "";
	    String c2 = "";	
            
            
                try
               {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iamneo");
                    PreparedStatement ps = con.prepareStatement("select * from admino");
             
                    ResultSet rs = ps.executeQuery();
		    if (rs.next())
		    {
                    	c1 = rs.getString(1);
		    	c2 = rs.getString(2);

                    	if (c1.equals(s1) && c2.equals(s3)) 
                    	{
                        	dispose();
				new userreg();
                    	}
	            	else
          	   	{
               		 	JOptionPane.showMessageDialog(btn1, "Incorrect Userid or password");
           	   	} 
                    }
                }
		 catch (Exception ex) 
                 {
                    System.out.println(ex);
                 }
		
            
          
        } 
         if (e.getSource() == btn2)
       {
            String str1 = tf2.getText();
            char[] p = p2.getPassword();
            String str2 = new String(p);
            try
           {
            	Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iamneo");  
           	PreparedStatement stmt=con.prepareStatement("select name from matrousers where userid=? and password=?");
		stmt.setString(1,str1);
		stmt.setString(2,str2);
                ResultSet rs = stmt.executeQuery();
            	if (rs.next())
            	{	
			dispose();
			new addcandi(str1);
                }
		 else
            	{
                	JOptionPane.showMessageDialog(null, "Incorrect Userid or password..Try Again with correct detail");
            	}
           }
           catch (Exception ex)
          {
            	System.out.println(ex);
          }
	
            
        }
    } 

    public static void main(String args[])
   {
        new home();
    }
}
