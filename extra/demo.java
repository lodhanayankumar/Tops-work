package nayan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class customer{
	int cid;
	String cname, email;
	long c_no;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid=cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname=cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		 this.email=email;
	}
	public long getC_no() {
		return c_no;
	}
	public void setC_no(long c_no) {
		this.c_no=c_no;
	}
}

public class demo {

	public int addCustomer (customer c) throws  SQLException{
		PreparedStatement pstmt =conn.prepareStatement("insert into tbl_customer(cid,cname,c_no,email) values(?,?,?,?)");
	    pstmt.setInt(1,c.getCid());
	    pstmt.setString(2, c.getCname());
	    pstmt.setLong(3, c.getC_no());
	    pstmt.setString(4, c.getEmail());
	    int i=pstmt.executeUpdate();
	    return i;
	}
	public int deleteCustomer(int i) throws SQLException {
		PreparedStatement pstmt =conn.prepareStatement("DELETE FROM tbl_customer WHERE cid = ?");
		pstmt.setInt(1, i);
		int is =pstmt.executeUpdate();
		return is;
	}
	public List<customer> fetchAllCustomer() throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement("select * from tbl_customer");
      ResultSet rs = pstmt.executeQuery();
      List<customer> lst= new ArrayList<customer>();
      while(rs.next()) {
    	  customer c = new customer();
    	  c.setCid(rs.getInt("cid"));
    	  c.setCname(rs.getString("cname"));
    	  c.setEmail(rs.getString("email"));
    	  c.setC_no(rs.getLong("c_no"));
    	  lst.add(c);
    	  }
      return lst;
      
	}
	static Connection conn;
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
		        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db","root","Nayan@2001");
		      
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	public int updateCustomer(customer c) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("UPDATE tbl_customer SET cname=?, c_no=?, email=? WHERE cid=?");
		pstmt.setString(1,c.getCname());
		pstmt.setLong(2,c.getC_no());
		pstmt.setInt(4,c.getCid());
		pstmt.setString(3,c.getEmail());
		int i =pstmt.executeUpdate();
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter customer id ");
		int id = scan.nextInt();

		System.out.println("Enter customer name ");
		String cname = scan.next();

		System.out.println("Enter customer contact number ");
		long cno = scan.nextLong();

		System.out.println("Enter customer email ");
		String email = scan.next();

		customer c = new customer();
		c.setC_no(cno);
		c.setCid(id);
		c.setCname(cname);
		c.setEmail(email);

		demo obj = new demo();
		int i;
		try {
			i = obj.addCustomer(c);
			if (i >= 1) {
				System.out.println("Customer added successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		//
		try {
		System.out.println("Enter customer id to Delete : ");
		int did = scan.nextInt();
		int riz = obj.deleteCustomer(did);
		if(riz>0) {
			System.out.println("Enterd Customer id deleted");
		}else
			System.out.println("Customer not found");
		}catch(SQLException e) {
			e.printStackTrace();
		}

//		
		try {
		
		List<customer> lst = obj.fetchAllCustomer();
		Iterator<customer> ia=lst.iterator();
		while(ia.hasNext())
		{
			customer co=ia.next();
			System.out.println(co.getCid()+"\t"+co.getCname()+"\t"+co.getEmail()+"\t"+co.getC_no());
		}
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
//		
		System.out.println("Enter Customer ID to Update:");
		int id1 = scan.nextInt();

		System.out.println("Enter New Customer Name:");
		String name1 = scan.next();

		System.out.println("Enter New Contact Number:");
		long cno1 = scan.nextLong();   

		System.out.println("Enter New Email:");
		String email1 = scan.next();

		
		c.setCid(id1);
		c.setCname(name1);
		c.setC_no(cno1);
		c.setEmail(email1);

		try {
		    int result = obj.updateCustomer(c);

		    if(result > 0) {
		        System.out.println("Customer Updated Successfully");
		    } else {
		        System.out.println("Customer Not Found");
		    }

		} catch (SQLException e) {
		    e.printStackTrace();
		}
     
	}
	}


