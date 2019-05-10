package dentry;
import dentry.*;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.*;
import java.sql.*; 
import java.io.IOException;

import javax.imageio.ImageIO;


public class phuto3
{
	String candi;
	Blob b;

	phuto3()
	{
		System.out.println("In default Constructor");
	}
	phuto3(String candy)
	{
		candi = candy;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
                    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iamneo");
			PreparedStatement stmt=con.prepareStatement("select  name,fathername, mothername, nativer, currento,  caste, gotra, mob, status, phy, dob, tob, pob, height, complex, qual, occup, salary, photo , gender, religion from candidate1 where cand_id=?");
			stmt.setString(1,candi);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
			{
				String name = rs.getString(1);
				String father= rs.getString(2);
				String mother= rs.getString(3);
				String nativ= rs.getString(4);
				String current= rs.getString(5);
				String cast= rs.getString(6);
				String gotra= rs.getString(7); 
				String contact= rs.getString(8); 
				String status= rs.getString(9); 
				String phy= rs.getString(10); 
				
				String dob= rs.getString(11);
				
				String tob= rs.getString(12); 
				String pob= rs.getString(13); 
				String height= rs.getString(14); 
				String complex= rs.getString(15); 
				String educ= rs.getString(16); 
				String occup= rs.getString(17); 
				String salary = rs.getString(18);
				Blob b=rs.getBlob(19);
				byte barr[]=b.getBytes(1,(int)b.length());
				String gender=rs.getString(20);
				String religion=rs.getString(21);
				FileOutputStream fout=new FileOutputStream("D:/001)DSMP/created jpeg/tmp/"+candi+".jpeg");  
				fout.write(barr);  
              
				fout.close();  

			


		


		
		
		
        File file = new File("D:/001)DSMP/imgs/format.jpg");
	File pic = new File("D:/001)DSMP/created jpeg/tmp/"+candi+".jpeg");


	BufferedImage image = ImageIO.read(file);
	BufferedImage photo = ImageIO.read(pic);

        int rectHeight = image.getHeight() / 6;
	

        Graphics g = image.getGraphics();

	Image dimg = photo.getScaledInstance(360, 530,
       		 Image.SCALE_SMOOTH);

	g.drawImage(dimg, 25, 170, null);

	int fontSize = 22;
	g.setFont(new Font("Calisto MT (Body)", Font.PLAIN, fontSize));
        g.setColor(Color.WHITE);
   	g.drawString(name, 800, 152);
	g.drawString(father, 800, 182);
	g.drawString(mother, 800, 212);
	g.drawString(nativ, 800, 242);
	g.drawString(current, 800, 269);
	g.drawString(cast, 800, 298);
	g.drawString(gotra, 800, 328);
	g.drawString(contact, 800, 357);

	g.drawString(status, 800, 444);
	g.drawString(phy, 800, 472);
	g.drawString(dob, 800, 501);
	g.drawString(tob, 800, 531);
	g.drawString(pob, 800, 560);
	g.drawString(height, 800, 589);
	g.drawString(complex, 800, 618);
	g.drawString(educ, 800, 646);
	g.drawString(occup, 800, 676);
	g.drawString(salary, 800, 705);

	
	fontSize = 25;
	g.setFont(new Font("Calisto MT (Body)", Font.PLAIN, fontSize));
	g.setColor(Color.RED);
	g.drawString("Akash Vadhu-Var", 110, 472);

        g.dispose();

        ImageIO.write(image, "jpeg", new File("D:/001)DSMP/created jpeg/"+candi+".jpeg"));

	pic.delete();                        

	}
    	}
	catch(Exception e)
	{
		System.out.println(e);
	}



	}



public static void main(String[] args) throws Exception  
{
	   
	new phuto3();
 
}

}