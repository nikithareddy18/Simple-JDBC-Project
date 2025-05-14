package AutoMobileManagementSystems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import AutoMobilesManagementSystem.AutoMobileInterface;

interface AutoMobliesInterface
{
	
		 void add();
		 void Update();
		void delete() throws Exception;
		 void display();
}
public class AutoMobiles implements AutoMobliesInterface{
	
	public boolean login()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The 10 digit Mobile Number...");
		long mobileNumber=sc.nextLong();
		boolean status=false;
		if(mobileNumber>6000000000l && mobileNumber<9999999999l)
		{
			int generatedOTP=generateOTP();
			System.out.println("Your OTP : "+generatedOTP);
			System.out.println("Enter the OTP");
			int enteredOTP=sc.nextInt();
			if(enteredOTP==generatedOTP)
			{
				System.out.println("Login Successfull...👍👍👍👍👍👍");
				status=true;
			}
			else
			{
				System.out.println("Invalid otp😂😂😂😂");
				System.out.println("please try Again");
			}
		}
		else
		{
			System.out.println("enter valid mobile NUmber ");
		}
		return status;
	}
	public int generateOTP()
	{
		Random random=new Random();
		int otp=random.nextInt(10000);
		
		return otp;
	}
	
	public static Connection getConnection() throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/database_m70", "root", "root");
        return con;
	    
	}
	@Override
	public void add()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
				Connection con=getConnection();
				PreparedStatement ps=con.prepareStatement("insert into Automobile values(?,?,?,?,?,?)");
				System.out.println("Inserting Values");
				System.out.println("enter vehicle Type ");
				String vehicleType=sc.next();
				System.out.println("enter vehicle Brand ");
				String vehicleBrand=sc.next();
				System.out.println("enter vehicle Color ");
				String vehicleColor=sc.next();
				System.out.println("enter vehicle Price ");
				int vehiclePrice=sc.nextInt();
				sc.nextLine(); 
				System.out.println("enter vehicle Model ");
				String vehicleModel=sc.next();
				System.out.println("enter  engineType ");
				String engineType=sc.next();
				ps.setString(1,vehicleType);
				ps.setString(2,vehicleBrand);
				ps.setString(3,vehicleColor);
				ps.setInt(4,vehiclePrice);
				ps.setString(5,vehicleModel);
				ps.setString(6,engineType);
				ps.executeUpdate();
				System.out.println("INsertion successfull");
				con.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void Update() {
		Scanner sc=new Scanner(System.in);
		try
		{
			
		
					Connection con=getConnection();
					PreparedStatement ps=con.prepareStatement("update AutoMoblie where ?=? set ?=?");
					System.out.println("what you need to update");
					
					System.out.println("1.vehicleType");
					System.out.println("2.vehicleBrand");
					System.out.println("3.vehicleColor");
					System.out.println("4.vehiclePrice");
					System.out.println("5.vehicleModel");
					System.out.println("6.EngineType");
				    int option=sc.nextInt();
		   
				    switch (option) {
		    	    case 1:
		    	        System.out.println("Enter old vehicle type");
		    	        String oldValue = sc.next();
		    	        System.out.println("Enter new vehicle type");
		    	        String newValue = sc.next();
		    	        ps =con.prepareStatement("update Automobile set vehicleType = ? where vehicleType = ?");
		    	        ps.setString(1, newValue);
		    	        ps.setString(2, oldValue);
		    	        break;
		    	    case 2:
		    	        System.out.println("Enter old vehicle brand");
		    	        oldValue = sc.next();
		    	        System.out.println("Enter new vehicle brand");
		    	        newValue = sc.next();
		    	        ps = con.prepareStatement("update Automobile set vehicleBrand = ? where vehicleBrand = ?");
		    	        ps.setString(1, newValue);
		    	        ps.setString(2, oldValue);
		    	        break;
		    	    case 3:
		    	        System.out.println("Enter old vehicle color");
		    	        oldValue = sc.next();
		    	        System.out.println("Enter new vehicle color");
		    	        newValue = sc.next();
		    	        ps = con.prepareStatement("update Automobile set vehicleColor = ? where vehicleColor = ?");
		    	        ps.setString(1, newValue);
		    	        ps.setString(2, oldValue);
		    	        break;
		    	    case 4:
		    	        System.out.println("Enter old vehicle price");
		    	        oldValue = sc.next();
		    	        System.out.println("Enter new vehicle price");
		    	        newValue = sc.next();
		    	        ps = con.prepareStatement("update Automobile set vehiclePrice = ? where vehiclePrice = ?");
		    	        ps.setInt(1, Integer.parseInt(newValue));
		    	        ps.setInt(2, Integer.parseInt(oldValue));
		    	        break;
		    	    case 5:
		    	        System.out.println("Enter old vehicle model");
		    	        oldValue = sc.next();
		    	        System.out.println("Enter new vehicle model");
		    	        newValue = sc.next();
		    	        ps = con.prepareStatement("update Automobile set vehicleModel = ? where vehicleModel = ?");
		    	        ps.setString(1, newValue);
		    	        ps.setString(2, oldValue);
		    	        break;
		    	    case 6:
		    	        System.out.println("Enter old engine type");
		    	        oldValue = sc.next();
		    	        System.out.println("Enter new engine type");
		    	        newValue = sc.next();
		    	        ps = con.prepareStatement("update Automobile set engineType = ? where engineType = ?");
		    	        ps.setString(1, newValue);
		    	        ps.setString(2, oldValue);
		    	        break;
		    	    default:
		    	        System.out.println("Invalid option");
		    	}


        

		        ps.executeUpdate();
		        System.out.println("Update successful");
		        ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		
	}

	@Override
	public void delete() throws Exception {
		Scanner sc=new Scanner(System.in);
		PreparedStatement ps=AutoMobileInterface.getConnection().prepareStatement("update AutoMoblie where ?=? set ?=?");
		System.out.println("what you need to update");
		
			System.out.println("1.vehicleType");
			System.out.println("2.vehicleBrand");
			System.out.println("3.vehicleColor");
			System.out.println("4.vehiclePrice");
			System.out.println("5.vehicleModel");
			System.out.println("6.EngineType");
		    int option=sc.nextInt();
		    Connection con=getConnection();
		   
		    	switch (option) {
		    		
		    	 case 1:
		    	 {
		    		    
		    	        System.out.println("enter the Element you need to delete:");
		    	        String element=sc.next();
		    	        ps = con.prepareStatement("Delete Automobile where vehicleType=?");
		    	        ps.setString(1, element);
		    	        ps.execute();
		    	        break;
		    	 }
		    	 case 2:
		    	 {	
		    		 
		    	        System.out.println("enter the Element you need to delete:");
		    	        String element=sc.next();
		    	        ps = con.prepareStatement("Delete Automobile where vehicleBrand=?");
		    	        ps.setString(1, element);
		    	        ps.execute();
		    	        break;
		    	 }
		    	 case 3:
		    	 {
		    		 
		    	        System.out.println("enter the Element you need to delete:");
		    	        String element=sc.next();
		    	        ps =con.prepareStatement("Delete Automobile where vehicleColor=?");
		    	        ps.setString(1, element);
		    	        ps.execute();
		    	        break;
		    	 }
		    	 case 4:
		    	 {
		    		
		    	        System.out.println("enter the Element you need to delete:");
		    	        int element=sc.nextInt();
		    	        ps = con.prepareStatement("Delete Automobile where vehicleprice=?");
		    	        ps.setInt(1, element);
		    	        ps.execute();
		    	        break;
		    	 }
		    	 case 5:
		    	 {
		    		
		    	        System.out.println("enter the Element you need to delete:");
		    	        String element=sc.next();
		    	        ps =con.prepareStatement("Delete Automobile where vehicleModel=?");
		    	        ps.setString(1, element);
		    	        ps.execute();
		    	        break;
		    	 }
		    	 case 6:
		    	 {
		    		 
		    	        System.out.println("enter the Element you need to delete:");
		    	        String element=sc.next();
		    	        ps =con.prepareStatement("Delete Automobile where engineType=?");
		    	        ps.setString(1, element);
		    	        ps.execute();
		    	        break;
		    	 }
		    	 default:
		    	        System.out.println("Invalid option");
		    	 
		    	 
		    	}
		    	
		         System.out.println("Deleted successful");
		         con.close();

		
	}

	@Override
	public void display() 
	{
		try
		{
		    Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Automobile");
			ResultSet result=ps.executeQuery();
			while(result.next())
				{
					System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getInt(4)+" "+result.getString(5)+" "+result.getString(6)+" ");
				}
			
			System.out.println("query executed");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
