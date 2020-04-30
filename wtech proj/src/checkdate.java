

	import java.util.*;
	import java.sql.*;
	import java.sql.Date;
	public class checkdate{
	public static void main (String arg[])throws Exception
	{
	//	Date d1 = new Date(2000,11,1);
	  //  System.out.println("Date "+d1);
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		ResultSet r=st.executeQuery("select * from user where sno=1");
		r.next();
		Date d=r.getDate("d1");
		System.out.println(""+d);
		// st.executeUpdate("s");
	}
	}

/*	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date d1=dateFormat.parse(b[i].bd[0]);
	Date d2=Calendar. getInstance(). getTime();
	int x=(int)Math.abs(d2.getTime() - d1.getTime());
	*/