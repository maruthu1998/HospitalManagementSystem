package hospitals;
import java.util.Scanner;
 public class UserEnd {
	public static void main(String[] args) {
	  InputsClass m=new InputsClass();
	  MethodsClass mc=new MethodsClass();
	 // m.M01();
	  Scanner sc=new Scanner(System.in);
	try {
	 while(true) {
		 System.out.println();
	   System.out.println("Welcome to TamilNadu Hospital Portal.....!");
	    System.out.print("1.Admin Login\n2.Old Patient"
	    		+ "\n3.Book Appointment\n4.Exit"
	    		+ "\nPlease Choose an Option:");
			int opt=sc.nextInt();
		if(opt==1) {
			System.out.print("Enter User Name:");
			 String un=sc.next();
			System.out.print("Enter Password:");
			 String pw=sc.next();
			if(mc.login(1,un,pw)) {
		while(true) {
	      System.out.print("Welcome to Hospital TamilNadu Admin Portal....!"
			     		+ "\n1.To admit new Patient"
			     		+ "\n2.To View Old Patient Details"
			     		+ "\n3.To Change Old Patient Details"
			     		+ "\n4.To Delete a Patient Detail"
			     		+ "\n5.Show Appoinment Messages"
			     		+ "\n6.Exit and Logout"
			     		+ "\nChoose an Option:");
	      int op=sc.nextInt();
		if(op==1) {
				m.M1();
		}else if(op==2) {
				m.M2();
		}else if(op==3) {
				m.M3();
		}else if(op==4) {
				m.M4();
		}else if(op==5) {
			mc.Selection(8,0,"");
		}	
		else if(op==6) {
			System.out.println("Logout Successfully...\nExiting......");	
		  break;				
	    }
		else {
	    	    System.out.println();
			  System.out.println("Please Enter Valid Option");
		        System.out.println();
	    }
		} 
		}else {
    	  System.out.println("Wrong Credits......"
    	  		+ "\nEnter Valid Password,Options");
    	  System.out.println();
      }
	  }else if(opt==2) {
		  System.out.println("Welcomes you......");
		  System.out.print("Enter User Name:");
		     String un=sc.next();
		  System.out.print("Enter Password:");
		     String pw=sc.next();
		  if(mc.login(2, un, pw)) {
			  System.out.println("Welcome.....");
			  System.out.print("Enter Your ID:");
			   int id=sc.nextInt();
			  mc.Selection(2, id,"");;
		  }else {
			  System.out.println("Invalid Password or UserName....");
		  }	   
	  }else if(opt==3) {
		 System.out.print("Enter Your Name:");
		  Scanner sc1=new Scanner(System.in);
		  String name=sc1.nextLine();
	    System.out.print("Enter Age:");
		  int age=sc.nextInt();
	    System.out.print("Enter Your Gender:");
		  String gen=sc.next();
	    System.out.println("Enter Type of Treatment:"
		  		+  "\nHeart,Lungs,ENT,Kidney,Eye,\nEar,Bone,"
		  		+ "SkinProblem,Others");
		System.out.print("Enter here:");
		  String tot=sc.next();
		  mc.ValueInsertion(2,name,"",age,gen,tot,"",0);
	  }else if(opt==4) {
		  System.out.println("Thank You...!");
		  break;
	  }	  
	  else {
	    System.out.println("Please Enter Valid Option....");
	  }
	 }
	}catch(Exception e) {
		  System.out.println("Error: Run Again And Enter Valid Option");		  
   }
 }
}
