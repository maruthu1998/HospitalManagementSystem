//HospitalManagementSystem
//Methods 
package hospitals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 public class MethodsClass {
    private Connection con;
	
	
	//ConnectionMethod(Constructor)
 public  MethodsClass() {  
	 String dburl="jdbc:mysql://localhost:3306/javademodb";
	 String dbuser="root";
	 String pass="";
  try{
    con=DriverManager.getConnection(dburl,dbuser,pass);
	    System.out.println("Connected.......");		
	 }catch(SQLException e) {
        System.out.println("Error:"+e);
	 }
   }
  
   //Login Code 
   boolean login(int opt,String un,String pw) {
       boolean r=false;
     try{ String query="";
     if(opt==1) {
    	 query="select *from admin where user='"+un+"' "
    			+ "and pass='"+pw+"'";
      }else if(opt==2) {
    	query="select *from user where user='"+un+"' "
    			+ "and pass='"+pw+"'";
    	 }
    	Statement smt=con.createStatement();
    	ResultSet rst=smt.executeQuery(query);
    while(rst.next()) {
    		r=true;
    	}
      }catch(SQLException e) {
    	   System.out.println("Error:"+e);
      } 	
    	return r;
    }
 
  
  //TableCreation
  public void TableCreation(){
	try {
	String query="create table patients(PatientID int primary key "
			+ "auto_increment,PatientName varchar(60) not null,"
			+ "DOB date,Age int(3),Gender varchar(10),"
			+ "TypeOfTreatment varchar(80),DoctorName varchar(80),"
			+ "TotalBill float not null,BalanceAmount int default 0)";
	   PreparedStatement pst=con.prepareStatement(query);
	    int r=pst.executeUpdate();
	       System.out.println((r>0)?"Table not created":"Table Created");
	  }catch(SQLException e) {
	       System.out.println("Error:"+e);
	}
  }
  
  
  //ValueInsertion
  public void ValueInsertion(int opt,String name,
		String dob,int age,String gen,String Dname,
		String treatment,int bill) {
	  String query="";
	try {
		if(opt==1) {
	  query="insert into patients(PatientName,DOB,Age,Gender,"
	  		+ "TypeOfTreatment,DoctorName,TotalBill,BalanceAmount)"
			+ " values(?,?,?,?,?,?,?,?)";
	  PreparedStatement pst=con.prepareStatement(query);
	    pst.setString(1,name);pst.setString(2,dob);
	    pst.setInt(3,age);pst.setString(4,gen);
	    pst.setString(5,treatment);pst.setString(6,Dname);
	    pst.setFloat(7,bill); pst.setFloat(8,bill);
	    int r=pst.executeUpdate();
	      System.out.println((r>0)?"Value Inserted":"Value not Inserted");
		}else if(opt==2) {
			query="insert into appointment(PatientName,Age,Gender,TypeOfTreatment)"
					+ "values(?,?,?,?)";
		 PreparedStatement pst=con.prepareStatement(query);
			   pst.setString(1,name);
			   pst.setInt(2,age);pst.setString(3,gen);
			   pst.setString(4,treatment);
			  int r=pst.executeUpdate();
			 System.out.println((r>0)?"Booked Appointment":"Failed Booking Try Again");
		}
	  }catch(SQLException e) {
	      System.out.println("Error:"+e);
	}
  }
  
  
  //ShowValues
  
  public void Selection(int opt,int id,String x) {
	   try {
		   String query="";  
		   if(opt==1) {
		   query="select *from patients";
		   }else if (opt==2) {
			   query="select *from patients where PatientID=?";
		   }else if(opt==3) {
			   query="select *from patients where Patientname=?";
		   }else if(opt==4) {
			   query="select *from patients where Gender=?";
		   }else if(opt==5) {
			   query="select *from patients where DoctorName=?";
		   }else if(opt==6) {
			   query="select *from patients where TypeOfTreatment=?";
		   }else if(opt==7) {
			   query="select *from patients where BalanceAmount>0";
		   }else if(opt==8) {
			   query="select *from appointment";
		   }
	    PreparedStatement pst=con.prepareStatement(query);
	    if(opt==2) {
		      pst.setInt(1,id);
		   }else if (opt==3||opt==4||opt==5||opt==6) {
			   pst.setString(1,x);
		   }
	    ResultSet rst=pst.executeQuery();
	    if(opt==1||opt==2||opt==3||opt==4||opt==5||opt==6||opt==7) {
		  System.out.println("PatientID\tName\tDOB\tAge\tGender\t"
			   		+ "\tDoctorName\tTreatment"
			   		+ "\tTotalBill\tBalanceAmount");
		 
	while(rst.next()) {	 
	     System.out.println(rst.getInt(1)+" \t"+rst.getString(2)+" \t"
			                +rst.getString(3)+" \t "+rst.getInt(4)
			                +" \t"+rst.getString(5)+" \t" +rst.getString(6)
			                +" \t"+rst.getString(7)+" \t"+rst.getInt(8)
			                +" \t"+rst.getInt(9));
		 }
    }else if(opt==8) {
	   System.out.println("PatientID\tName\tAge\tGender\t"
				   		+ "\tTreatment");		 
   while(rst.next()) {	 
	System.out.println(rst.getInt(1)+" \t"+rst.getString(2)+" \t "
       +rst.getInt(3)+" \t"+rst.getString(4)+" \t" +rst.getString(5));
			 }
	    }
	  }catch(SQLException e) {
			    System.out.println("Error:"+e);
	   }
	}

 

 
  //UpdatingValues
  public void ValueUpdation(int opt,int fees,int id,String x){
	  try {	
		  String query="";float amt=0;
	    if(opt==1){  
	     query="update patients set TotalBill=? where PatientID=?";
	    }else if(opt==2) {
		  query="update patients set DoctorName=? where PatientID=?";
	    }else if(opt==3) {      
	      String q1="select TotalBill from patients where PatientID=?";
	      PreparedStatement pst=con.prepareStatement(q1);
	      pst.setInt(1,id);
	      ResultSet rst=pst.executeQuery();
	      float bill=0;
	      while(rst.next()) {
	         bill=rst.getFloat(1);
	      }
	          amt=bill-fees;     
	      query="update patients set BalanceAmount=? where PatientID=?";
	    }else {
	    	System.out.println("Enter Valid Option");
	    }
	 PreparedStatement pst=con.prepareStatement(query);
	    if(opt==1||opt==3) {
		  pst.setFloat(1,fees);
		  pst.setInt(2,id);
	    }else if(opt==2) {
	      pst.setString(1,x);
		  pst.setInt(2,id);
	    }else if(opt==3) {
	      pst.setFloat(1,amt);
	      pst.setInt(2,id);
	    } 
	    else {
	         System.out.println("Enter Valid Option");
	    }
	  int r=pst.executeUpdate();
		 System.out.println((r>0)?"Value Updated":"Value not Updated");
   }catch(SQLException e) {
	     System.out.println("Error:"+e);
   }
 }
  
  
  
  
  //DeletingValues
  public void Deletion(int id) {
	  try {
	String query="delete *from patients where PatientID=?";
	PreparedStatement pst=con.prepareStatement(query);
	pst.setInt(1,id);
	int r=pst.executeUpdate();
	System.out.println((r>0)?"Value Deleted":"Value not Deleted");
	
	  }catch(SQLException e) {
	      System.out.println("Error:"+e);
	}
  }
  
  //Connection Close
  
  public void closer() {
	  try {
	  con.close();
  }catch(SQLException e) {
	  System.out.println("Error"+e);
  }
}	
}
