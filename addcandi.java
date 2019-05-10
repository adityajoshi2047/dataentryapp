package dentry;
import dentry.*;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
import java.text.DateFormat;
import java.text.*;
import java.util.Date;
import javax.swing.JFormattedTextField;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.swing.text.MaskFormatter;
import javax.swing.text.DateFormatter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.Object;
import java.util.Calendar;

 




 
public class addcandi extends JFrame implements ActionListener 
  { 
    JLabel user, userid, picLabel, gender, l1, l2, l3, l4, l5, l51, l52, l6, l61, l62, l7, l71, l8, l9, l10, l11, l12, l12a, l13, l14, l15, l160, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26;
    JTextField picname ; 
    
    JFormattedTextField tf15, tf2 , tf4, tf12, tf12a, tf13,tf16, tf17, tf18, tf19, tf20, tf21, tf25 , tf5, tf51, tf52, tf7, tf9 ;
    JPhoneNumberFormattedTextField tf26;
    
    
    JTextArea ta22, ta23, ta24;
    JButton btn1, btn2, btn3, btn4, button;
    JFormattedTextField tfd3;
    
    String Candi_id, photopath, USER_id ; 
    JPanel jp1, jp2, jp3; 
    JRadioButton gd1, gd2, py, pn, pry, prn;
    ButtonGroup bgp1, bgp2, bgp3;
    JComboBox<String> c1, c2, c3, c40, c41; 
    
    DateFormat format;
    DateFormatter df;
    MaskFormatter mask, masksal, masktime, maskweight, maskqual;
    
 
    public addcandi()
    {
	System.out.println("In default constructor");
    }

    public addcandi(String str)
     {

	try
               {
		USER_id=str;
		//USER_id="vk";change it
            	Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iamneo");  
          	PreparedStatement stmt=con.prepareStatement("select name from matrousers where userid=? ");
		stmt.setString(1,USER_id);
                ResultSet rs = stmt.executeQuery();
		rs.next();
		



        setVisible(true);
        setSize(1350, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cadidate Registration");

	
	String cs1[] = { "Fair", "wheatish ", "Dark"};
	c1 = new JComboBox<String>(cs1);
	c1.setBounds(300, 470, 200, 30);
	add(c1);

	String cs2[] = { "Married", "Unmarried ", "Divorced", "Widowed", "Seperated"};
	c2 = new JComboBox<String>(cs2);
	c2.setBounds(300, 590, 200, 30);
	add(c2);

	String cs3[] = { "Hinduism", "Jainism ", "Islam", "Christianity", "Buddhism", "Sikhism", "Other"};
	c3 = new JComboBox<String>(cs3);
	c3.setBounds(920, 150, 300, 30);
	add(c3);
	
	String cs40[] = { "4", "5 ", "6"};//4'5''  6' 12'' 
	c40 = new JComboBox<String>(cs40);
	c40.setBounds(300, 390, 40, 30);
	add(c40);

	String cs41[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	c41= new JComboBox<String>(cs41);
	c41.setBounds(348, 390, 40, 30);
	add(c41);



	jp1 = new JPanel();
	gd1 = new JRadioButton("Male");
	gd2 = new JRadioButton("Female");
	jp1.setLayout(new GridLayout(1,2));
	jp1.add(gd1);
	jp1.add(gd2);
	jp1.setBounds(300, 173, 170, 30);
	bgp1 = new ButtonGroup();
        bgp1.add(gd1);
	bgp1.add(gd2);
	

	jp2 = new JPanel();
	py = new JRadioButton("Yes");
	pn= new JRadioButton("No");
	jp2.setLayout(new GridLayout(1,2));
	jp2.add(py);
	jp2.add(pn);
	jp2.setBounds(300, 550, 170, 30);
	bgp2 = new ButtonGroup();
        bgp2.add(py);
	bgp2.add(pn);

	jp3 = new JPanel();
	pry = new JRadioButton("Yes");
	prn= new JRadioButton("No");
	jp3.setLayout(new GridLayout(1,2));
	jp3.add(pry);
	jp3.add(prn);
	jp3.setBounds(920, 70, 170, 30);
	bgp3 = new ButtonGroup();
        bgp3.add(pry);
	bgp3.add(prn);


	add(jp1);
	add(jp2);
	add(jp3);

	picname = new JTextField();
	button = new JButton("Select File");
	picLabel = new JLabel(new ImageIcon());
	user = new JLabel();
	userid = new JLabel();
	user.setText("User:  " + rs.getString(1));
	userid.setText("UserID:  " + USER_id);
	user.setForeground(Color.red);
        user.setFont(new Font("Serif", Font.BOLD, 15));
	userid.setForeground(Color.red);
        userid.setFont(new Font("Serif", Font.BOLD, 15));
		

	gender = new JLabel("Gender:");
	picname.setBounds(250,110,150,30);
	gender.setBounds(250,173,100,30);
	button.setBounds(250,70,150,30 );
	picLabel.setBounds(70,10,140,180);
	user.setBounds(500,70,150,30);
	userid.setBounds(500,110,150,30);

	button.addActionListener(this);
	add(button);
	add(gender);
	add(picname);
	add(picLabel);
	add(user);
	add(userid);
 
        l1 = new JLabel("Candidate Registration Form:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
 
        l2 = new JLabel("Name:");
        l3 = new JLabel("Date of Birth:");
	l4 = new JLabel("Place of Birth:");
        l5 = new JLabel("Time of Birth:");
	l51 = new JLabel(":");
	l52 = new JLabel(":");
        l6 = new JLabel("Height:");
	l61 = new JLabel("|");
	l62 = new JLabel("||");
        l7 = new JLabel("Weight:"); 
	l71 = new JLabel("Kg"); 
	l8 = new JLabel("Complexion:");
	l9 = new JLabel("Qualification:");
	l10 = new JLabel("Physically challenged:");
	l11 = new JLabel("Status:");
	l12 = new JLabel("Native:");
	l12a = new JLabel("Current:");

	l13 = new JLabel("Service/Business:");
	l14 = new JLabel("Permanent Yes/no:");
	l15 = new JLabel("Salary:");
	l160 = new JLabel("Religion:");
	l16 = new JLabel("Caste:");
	l17 = new JLabel("Gotra:");
	l18 = new JLabel("Father's Name:");
	l19 = new JLabel("Father's Service:");
	l20 = new JLabel("Mother's Name:");

	l21 = new JLabel("Mother's Service:");
	l22 = new JLabel("Permanent Address:");
	l23 = new JLabel("Current Address:");
	l24 = new JLabel("Expectations:");
	l25 = new JLabel("Surname of Relative:");
	l26 = new JLabel("Mobile No:");

        

	mask = new MaskFormatter("*************************");
	mask.setValidCharacters("qwertyuiopasdfghjklzxcvbnm"+"QWERTYUIOPASDFGHJKLZXCVBNM"+" ");
	mask.setPlaceholderCharacter(' ');

	masksal = new MaskFormatter("**********");
	masksal.setValidCharacters("0123456789"+" ");
	masksal.setPlaceholderCharacter(' ');

	masktime = new MaskFormatter("**");
	masktime.setValidCharacters("0123456789"+" ");
	masktime.setPlaceholderCharacter(' ');

	maskweight = new MaskFormatter("***");
	maskweight.setValidCharacters("0123456789"+" ");
	maskweight.setPlaceholderCharacter(' ');

	maskqual = new MaskFormatter("***************");
	maskqual.setValidCharacters("qwertyuiopasdfghjklzxcvbnm"+"QWERTYUIOPASDFGHJKLZXCVBNM"+"."+" ");
	maskqual.setPlaceholderCharacter(' ');

	tf2 = new JFormattedTextField(mask);
	

	DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        DateFormatter df = new DateFormatter(format);
        tfd3 = new JFormattedTextField(df);
	tfd3.setValue(new Date());
	
	tf4= new JFormattedTextField(mask);
	
	tf5=new JFormattedTextField(masktime);
	tf51=new JFormattedTextField(masktime);
	tf52=new JFormattedTextField(masktime);

	tf7 = new JFormattedTextField(maskweight);	

	tf9= new JFormattedTextField(maskqual);

	tf12= new JFormattedTextField(mask);
	tf12a= new JFormattedTextField(mask);
	tf13= new JFormattedTextField(mask);

	tf15 = new JFormattedTextField(masksal);

	tf16= new JFormattedTextField(mask);
	tf17= new JFormattedTextField(mask);
	tf18= new JFormattedTextField(mask);
	tf19= new JFormattedTextField(mask);
	tf20= new JFormattedTextField(mask);
	tf21= new JFormattedTextField(mask);
	tf25= new JFormattedTextField(mask);
	
	tf26 = new JPhoneNumberFormattedTextField();


	ta22 = new JTextArea();
	ta23 = new JTextArea();
	ta24 = new JTextArea();



        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
	btn3 = new JButton("Log Out");
	btn4 = new JButton("create .jpg");
 
        btn1.addActionListener(this);
        btn2.addActionListener(this);
	btn3.addActionListener(this);
	btn4.addActionListener(this);
 
	l1.setBounds(400, 8, 400, 30);
        l2.setBounds(80, 230, 200, 30);
        l3.setBounds(80, 270, 200, 30);
        l4.setBounds(80, 310, 200, 30);
        l5.setBounds(80, 350, 200, 30);
	l51.setBounds(320, 350, 3, 30);
	l52.setBounds(345, 350, 3, 30);

        l6.setBounds(80, 390, 200, 30);
	l61.setBounds(341, 385, 5, 20);
	l62.setBounds(389,385, 20, 20);
	l7.setBounds(80, 430, 200, 30);
	l71.setBounds(327, 430, 20, 30);
	l8.setBounds(80, 470, 200, 30);
	l9.setBounds(80, 510, 200, 30);
	l10.setBounds(80, 550, 200, 30);
	l11.setBounds(80, 590, 200, 30);
	l12.setBounds(80, 670, 200, 30);
	l12a.setBounds(320, 670, 200, 30);
	l13.setBounds(700, 30, 200, 30);

	l14.setBounds(700, 70, 200, 30);
	l15.setBounds(700, 110, 200, 30);
	l160.setBounds(700, 150, 200, 30);
	l16.setBounds(700, 190, 200, 30);
	l17.setBounds(700, 230, 200, 30);
	l18.setBounds(700, 270, 200, 30);
	l19.setBounds(700, 310, 200, 30);
	l20.setBounds(700, 350, 200, 30);
	l21.setBounds(700, 390, 200, 30);

	l22.setBounds(700, 440, 200, 30);
	l23.setBounds(700, 510, 200, 30);
	l24.setBounds(700, 580, 200, 30);
	l25.setBounds(700, 630, 200, 30);
	l26.setBounds(80, 630, 200, 30);
        
        tf2.setBounds(300, 230, 200, 30);
	
        tfd3.setBounds(300, 270, 200, 30);
	tf4.setBounds(300, 310, 200, 30);

	tf5.setBounds(300, 350, 20, 30);
	tf51.setBounds(324, 350, 20, 30);
	tf52.setBounds(349, 350, 20, 30);

	tf7.setBounds(300, 430, 25, 30);
	
	tf9.setBounds(300, 510, 200, 30);
	
	tf12.setBounds(130, 670, 180, 30);
	tf12a.setBounds(380, 670, 180, 30);


	tf13.setBounds(920, 30, 300, 30);
	
	tf15.setBounds(920, 110, 300, 30);
	
	tf16.setBounds(920, 190, 300, 30);
	tf17.setBounds(920, 230, 300, 30);
	tf18.setBounds(920, 270, 300, 30);
	tf19.setBounds(920, 310, 300, 30);
	tf20.setBounds(920, 350, 300, 30);
	tf21.setBounds(920, 390, 300, 30);

	ta22.setBounds(920, 430, 300, 60);
	ta23.setBounds(920, 500, 300, 60);
	ta24.setBounds(920, 570, 300, 50);

	tf25.setBounds(920, 630, 300, 30);
	
	tf26.setBounds(300, 630, 200, 30);	

        
        btn1.setBounds(920, 670, 100, 30);
        btn2.setBounds(1030, 670, 100, 30);
	btn3.setBounds(1140, 670, 100, 30);
	btn4.setBounds(810, 670, 100, 30);
 
        add(l1); add(l2); add(l3); add(l4); add(l5); add(l51); add(l52); add(l6);add(l61); add(l62);  add(l7); add(l71); add(l8); add(l9); add(l10);add(l11);add(l12);
	add(l12a); add(l13);add(l14);add(l15);add(l160);add(l16);add(l17);add(l18);add(l19);add(l20);add(l21);add(l22);add(l23);add(l24);add(l25);add(l26);
		

        add(tf2);add(tfd3);add(tf4);add(tf5);add(tf51);add(tf52);add(tf7);add(tf9);add(tf12); add(tf12a);
	add(tf13);  add(tf15); add(tf16); add(tf17); add(tf18); add(tf19); add(tf20); add(tf21); add(ta22); add(ta23); add(ta24);
	add(tf25); add(tf26);
        
        add(btn1);
        add(btn2);
	add(btn3);
	add(btn4);


	}
	catch (Exception ex)
        	{
            		System.out.println("in constructor "+ex);
        	}
    }
 
    public void actionPerformed(ActionEvent e) 
     {
	if (e.getSource() == button)
	{
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) 
		{
              		File secfile = fileChooser.getSelectedFile();
		BufferedImage img = null;
		try {
    			img = ImageIO.read(secfile);
		    } 
		catch (IOException ae)
		   {
   			 System.out.println("img "+ae);
		   }

		Image dimg = img.getScaledInstance(picLabel.getWidth(), picLabel.getHeight(),
       		 Image.SCALE_SMOOTH);

		picLabel.setIcon(new ImageIcon(dimg));

		photopath = secfile.getPath();
		
		picname.setText(secfile.getName());
		}
	}
	
        if (e.getSource() == btn1)
         {
		
            int x = 0;
	    
	    String gender="";
	    if(gd1.isSelected())
		gender = "Male";
	    if(gd2.isSelected())
		gender = "Female";
	    
	    String name = tf2.getText().trim();
	    
	    String dob = tfd3.getText();
	    
	    String pob = tf4.getText().trim();

	    String  tob0 = tf5.getText();
	    String  tob1 = tf51.getText();
	    String  tob2 = tf52.getText();

	    String height0 = (String)c40.getSelectedItem();
	    String height1 = (String)c41.getSelectedItem();
	   
            String weight = tf7.getText();
	    String complex = (String)c1.getSelectedItem();
	  
            String qual = tf9.getText().trim();

	    String phy = "";
	    if(py.isSelected())
		phy = "Yes";
	    if(pn.isSelected())
		phy = "NO";

	    String status = (String)c2.getSelectedItem();
	   
	    String nativer = tf12.getText().trim();
	    String current = tf12a.getText().trim();
	    String occup = tf13.getText().trim(); 
	    
	    String permanent = "";
	    if(pry.isSelected())
		permanent = "Yes";
	    if(prn.isSelected())
		permanent = "No";


	    String tempsal= tf15.getText().replaceAll("\\s+", "");
	  
            String salary=tempsal;


	    String religion = (String)c3.getSelectedItem();


	    String caste = tf16.getText().trim();
	    String gotra = tf17.getText().trim();
	    String fathername = tf18.getText().trim();
	    String fatheroccup = tf19.getText().trim();
	    String mothername = tf20.getText().trim();
	    String motheroccup = tf21.getText().trim();


	    String pmaddr = ta22.getText();
	    String curraddr = ta23.getText();
	    String expect = ta24.getText();

	    String rltv = tf25.getText().trim();

	    String mob = tf26.getText();

	    String tob = tob0+":"+tob1+":"+tob2;
	    String height = height0+"\'"+height1+"\"";

	 /*   if(gender.equals("")){JOptionPane.showMessageDialog(btn1, "Select Gender");}
	    if(name.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Name");}
	    if(weight.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Weight");}
	    if(qual.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Qualification ");}
	    if(phy.equals("")){JOptionPane.showMessageDialog(btn1, "Select Physical status : Yes/NO");}
	    if(mob.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Mobile Number ");}
	    if(occup.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Service/Buisiness ");}
	    if(salary.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Salary");}
	    if(caste.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Caste");}
	    if(pmaddr.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Permanant Address");}
	    if(curraddr.equals("")){JOptionPane.showMessageDialog(btn1, "Enter Current Address");}*/

	
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    long myid=0;

	    try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iamneo");
			String sqlIdentifier = "select seq_candi.nextval from candidate1";
		     PreparedStatement pst = con.prepareStatement(sqlIdentifier);
                     //synchronized( this ) {
                     ResultSet rs = pst.executeQuery();
                     if(rs.next())
                         myid = rs.getLong(1);
			
		}
		catch(Exception ae){System.out.println("takin nxt seq "+ae);}
            
	     try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iamneo");
                      
		      PreparedStatement ps = con.prepareStatement("insert into candidate1 values(?,?,TO_DATE(?, 'yyyy/mm/dd hh24:mi:ss'), ? ,?, ?, TO_DATE(?, 'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ? )");
		
		     Candi_id =  Long.toString(myid);
		     FileInputStream fin=new FileInputStream(photopath);  
		     ps.setBinaryStream(4,fin,fin.available());			

		     ps.setString(1, Candi_id);
		     ps.setString(2, USER_id);
		     ps.setString(3, timeStamp);
		     ps.setString(5, gender);
		     ps.setString(6, name);
		     
		     ps.setString(7, dob);
		     
		     ps.setString(8, pob);
		     ps.setString(9, tob);
		     ps.setString(10, height);
		     ps.setString(11, weight);
		     ps.setString(12, complex);
		     ps.setString(13, qual);
		     ps.setString(14, phy);
		     ps.setString(15, status);
		     ps.setString(16, nativer);
		     ps.setString(17, current);
		     ps.setString(18, mob);
		     ps.setString(19, occup);
		     ps.setString(20, permanent);
		     ps.setString(21, salary);
		     ps.setString(22, religion);
		     ps.setString(23, caste);
		     ps.setString(24, gotra);
		     ps.setString(25, fathername);
		     ps.setString(26, fatheroccup);
		     ps.setString(27, mothername);
		     ps.setString(28, motheroccup);
		     ps.setString(29, pmaddr);
		     ps.setString(30, curraddr);		     
		     ps.setString(31, expect);
		     ps.setString(32, rltv);
		    

                    ResultSet rs = ps.executeQuery();
                    x++;
		   
                    if (x > 0) 
                    {
                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
			
                    }
                }
          catch (Exception ex) 
                {
                    	//ex.printStackTrace();
			System.out.println("Inserting "+ex);
                }

            
           
        } 
          if (e.getSource() == btn2)
       {
             picLabel.setIcon(null); picname.setText("");
	   bgp1.clearSelection();  bgp2.clearSelection();   bgp3.clearSelection();
	   c1.setSelectedIndex(0); c2.setSelectedIndex(0); c3.setSelectedIndex(0); c40.setSelectedIndex(0); c41.setSelectedIndex(0);
	   tf2.setText("");tf4.setText("");tf5.setText(""); tf51.setText(""); tf52.setText("");tf7.setText("");tf9.setText("");
	   tf12.setText(""); tf12a.setText(""); tf13.setText("");tf15.setText("");tf16.setText("");tf17.setText("");tf18.setText("");
	    tf19.setText("");tf20.setText("");tf21.setText("");ta22.setText("");ta23.setText("");ta24.setText("");tf25.setText("");tf26.setText("");           
            
        }

	if (e.getSource() == btn3)
	{
		dispose();
		new home();
	}

	if (e.getSource() == btn4)
	{
		new phuto3(Candi_id);
		JOptionPane.showMessageDialog(btn1, ".jpeg file generated succesfully ");
	}
	

    } 

	public static void main(String args[])
   {
        new addcandi();
    }
    

	 private static final class JPhoneNumberFormattedTextField extends JFormattedTextField{

        
        public JPhoneNumberFormattedTextField() throws ParseException{
            
	    super(new MaskFormatter("##########"));
	   
        }

    }

	
}
