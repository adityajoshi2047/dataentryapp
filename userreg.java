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
 
public class userreg extends JFrame implements ActionListener 
  { 
    JLabel l1, l2, l3, l4, l5, l6, l7, background;
    JTextField tf1, tf2, tf3, tf4;
    JButton btn1, btn2, btn3;
    JPasswordField p1, p2;
 
    userreg()
     {
        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("User Registration");

	File secfile = new File("D:/001)DSMP/imgs/pink1.jpg");//here to
	
	BufferedImage img = null;
	try{
		 img = ImageIO.read(secfile);
	}
	catch (Exception ae)
	{
   		System.out.println("img "+ae);
	} 

	background = new JLabel();
	background.setBounds(0,0,1500,900);
	

	Image dimg = img.getScaledInstance(background.getWidth(), background.getHeight(),
       	Image.SCALE_SMOOTH);

	background.setIcon(new ImageIcon(dimg));//here

 
        l1 = new JLabel("User Registration Form:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
 
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email-ID:");
	l4 = new JLabel("User-ID:");
        l5 = new JLabel("Create Passowrd:");
        l6 = new JLabel("Confirm Password:");
        l7 = new JLabel("Phone No:"); 
        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        
 
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
	btn3 = new JButton("Log Out");
 
        btn1.addActionListener(this);
        btn2.addActionListener(this);
 	btn3.addActionListener(this);

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
	l7.setBounds(80, 270, 200, 30);
        
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
	tf3.setBounds(300, 150, 200, 30);

        p1.setBounds(300, 190, 200, 30);
        p2.setBounds(300, 230, 200, 30);
        tf4.setBounds(300, 270, 200, 30);

        
        btn1.setBounds(300, 360, 100, 30);
        btn2.setBounds(400, 360, 100, 30);
	btn3.setBounds(350, 420, 100, 30);
 
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
        background.add(tf3);
        background.add(tf4);
        
        background.add(btn1);
        background.add(btn2);
	background.add(btn3);
    }
 
    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == btn1)
         {
            int x = 0;
            String s1 = tf1.getText();
            String s2 = tf2.getText();
	    String s3 = tf3.getText();
 
            char[] s4 = p1.getPassword();
            char[] s5 = p2.getPassword(); 
            String s6 = new String(s4);
            String s7 = new String(s5);
 
            String s8 = tf4.getText();
            
            if (s6.equals(s7))
           {
                try
               {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iamneo");
                    PreparedStatement ps = con.prepareStatement("insert into matrousers values(?,?,?,?,?)");
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setString(3, s3);
		    ps.setString(4, s6);
		    ps.setString(5, s8);
		    

                    ResultSet rs = ps.executeQuery();
                    x++;
                    if (x > 0) 
                    {
                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
			
                    }
                }
          catch (Exception ex) 
                {
                    System.out.println(ex);
                }
            }
          else
           {
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
            } 
        } 
        
	if (e.getSource() == btn2)
       {
            tf1.setText("");
            tf2.setText("");
	    tf3.setText("");
            p1.setText("");
            p2.setText("");
            tf4.setText("");
            
        }
	
	if (e.getSource() == btn3)
	{
		dispose();
		new home();
	}


    } 
    public static void main(String args[])
   {
        new userreg();
    }
}
