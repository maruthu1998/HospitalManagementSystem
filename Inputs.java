package hospitals;
import java.util.Scanner;
public class InputsClass {
	MethodsClass mc=new MethodsClass();
		Scanner sc=new Scanner(System.in);
		public void M01() {
			mc.TableCreation();
		}
  public void M1() {
		System.out.print("Enter Patient Name:");
		String name=sc.next();
		System.out.print("Enter Date of Birth:");
	    String dob=sc.next();
	    System.out.print("Enter Age:");
	    int age=sc.nextInt();
		System.out.print("Enter Gender(Male/Female/Transgender):");
		String gen=sc.next();
		System.out.println("Enter Type of Treatment:"
				        + "\nHeart,Lungs,ENT,Kidney,Eye,\nEar,Bone,"
				        + "SkinProblem,Others");
		Scanner sc1=new Scanner(System.in);
		String tot=sc1.next();String dname=""; 
		String tname[]= {"Heart","Lungs","ENT","Kidney","Eye","Ear","Bone",
		        "SkinProblem","Others"};
		String d1name[]={"Dr.APJ Abdul Kalam","Dr.RadhaKrishnan","Dr.Patel"
				,"Dr.Rajaji","Dr.Kamarajar","Dr.Nehru","Dr.Jessica",
				"Dr.Gandhi or Dr.Indra","Dr.MG.Ramachanthiran"};
		for(int i=0;i<tname.length;i++) {
			if(tot.equalsIgnoreCase(tname[i])) {
				dname=d1name[i];
			}
		}
	 System.out.print("Enter Fees:");
		int fees=sc.nextInt();
		mc.ValueInsertion(1,name,dob,age,gen,dname,tot,fees);
	}
  
  //Selection
  
	public void M2() {
		System.out.print("\n1.To Show All Patient Detail."
				+ "\n2.To Show Specific Patient Details."
				+"\n3.To Show Patiens Who Have Not Fully Paid."
				+ "\nChoose an option:");
	   int opt=sc.nextInt();
	   if(opt==1) {
		  mc.Selection(opt,0,"");
	   }else if(opt==2) {  
		   System.out.print("1. By Patient ID\n2. By Patient Name\n3. By Patient Gender"
				+ "\n4. By Doctor Name\n5. By Treatment Type\nChoose an Option :");
		    int op=sc.nextInt();
		    if(op==1) {
		   System.out.print("Enter Patient ID:");
		   int id=sc.nextInt();
		 mc.Selection(2,id,"");
	   }else if(op==2) {   
		   System.out.print("Enter Patient Name:");
		   String x=sc.next();
		 mc.Selection(3,0,x);
	   }else if(op==3) {   
		   System.out.print("Enter Patient Gender:");
		   String x=sc.next();
		 mc.Selection(4,0,x);
	   }else if(op==4) {
		   System.out.println("Dr.APJ Abdul Kalam(Heart),Dr.RadhaKrishnan(Lungs),"
		   		+ "\nDr.Patel(ENT),Dr.Rajaji(Kidney),Dr.Kamarajar(Eye)"
				+",\nDr.Nehru(Ear),Dr.Jessica(Bone),Dr.Gandhi or Dr.Indra(SkinProblem)"
				+",\nDr.MG.Ramachanthiran(Others)");
		   System.out.print("Enter Doctor Name:");
		   String x=sc.next();
		 mc.Selection(5,0,x);
	   }else if(op==5) {   
		   System.out.print("Enter Type of Treatment:");
		   String x=sc.next();
		 mc.Selection(6,0,x);
	   }
	   }else if(opt==3) {   
		 mc.Selection(7,0,"");
	   }else {
		 System.out.println("Enter Valid Option"); }  
	}
	
	//Updating
	
	public void M3(){
		System.out.print("1.To Change Total Bill Amount"
				+ "\n2.To Change Doctor Name\n3.To Pay Bill"
				+ "\nChoose an Option:");
	   int opt=sc.nextInt(); 
    if(opt==1){
		      System.out.print("Enter Patient ID:");
		   int id=sc.nextInt();
		      System.out.print("Enter New Bill Amount:");
		   int fees=sc.nextInt();
		   mc.ValueUpdation(opt,fees,id,"");
	   }else if(opt==2) {
		       System.out.print("Enter Patient ID:");
		   int id=sc.nextInt(); 
		      System.out.print("Enter Doctor Name:");
		   String dname=sc.next();
		        mc.ValueUpdation(opt,id,0,dname);
	   }else if(opt==3) {
		   System.out.print("Enter Patient ID:");
		   int id=sc.nextInt();
		      System.out.print("Enter Bill You want to Pay:");
		   int fees=sc.nextInt();
		   mc.ValueUpdation(opt,fees,id,"");
	   }
	   else
		   System.out.println("Please Enter Valid Option");
	 }
	
	//Deletion
	
	public void M4() {
		System.out.println("Enter Patient  ID:");
		int id=sc.nextInt();
		mc.Deletion(id);
	}  
}
