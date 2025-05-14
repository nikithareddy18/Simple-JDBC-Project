package AutoMobileManagementSystems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import AutoMobilesManagementSystem.AutoMobileInterface;

public class CreateAutiMobilesTable {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/database_m70", "root", "root");
        
	    String Query="create table Automobile(vehicleType varchar(10),vehicleBrand varchar(10),vehicleColor varchar(10),vehiclePrice int(10),vehicleModel varchar(10),engineType varchar(10))";
	       
	       Statement st=AutoMobileInterface.getConnection().createStatement();
	       st.execute(Query);
	       System.out.println("table created");
	      con.close();
	}

}
