package EmailApp;

import java.util.Random;
import java.util.Scanner;

public class Email {
	
	public Scanner sc = new Scanner(System.in);
	
    //setting up the variables
    private String fname;
	private String lname;
	private String dept;
	private String email;
	private String password;
	private String alter_email;
	private int mailCapacity = 500;
	
   public Email(String fname , String lname) 
   {
	this.fname = fname;
	this.lname = lname;
	
    System.out.println("*********NEW STUDENT NAME : "+this.fname+ " "+this.lname);
	
	//call a method asking for the department
	this.dept = this.setDept();
	
	//call a method that returns a random password
	this.password = this.generate_password(8);
	
	//combine elements to generate an email
    this.email = this.generate_email();
    
	}
    private String generate_email() 
  
     {
        return this.fname.toLowerCase() + this.lname.toLowerCase() 
        + "@" + this.dept.toUpperCase() +"."+ "UCEV.com";
	
     }

    //Ask for the department
      private String setDept() 
     {
	      System.out.println( "SELECT DEPARTMENT CODES :\n1 for ECE\n2 for EEE\n3 for MECH\n4 for CSE");
	      boolean flag=true;
	    do { 
		   
		 System.out.println("Enter Department Code :");
		 int  choice= sc.nextInt();
		 switch (choice)
		 {
		  case 1:
			 return "ECE";
			 
		  case 2: 
			 return "EEE";
			 
		  case 3:
			 return"MECH";
			 
		  case 4:
			 return"CSE";
			 
		  default:
				 System.out.println("****INVALID CHOICE****");
		}
		 
	  }while (!flag);
	
	  return null;
}

      //Generating a random password
      private String generate_password(int length) 
       {
	       Random r = new Random();
	
	      String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String Small_chars = "abcdefghijklmnopqrstuvwxyz";
	      String numbers = "0123456789";
	      String symbols = "!@#%&?";
	      String values = Capital_chars + Small_chars + numbers + symbols;
	
	      String password = "";
	      for (int i=0; i<length;i++)
	      {
		        password = password + values.charAt(r.nextInt(values.length()));
		   }
	     return password;
}
        // change the password
         public void set_password()
            {
	            boolean flag = true;
	         do
	             {
		              System.out.println("ARE YOU SURE YOU WANT CHANGE YOUR PASSWORD ? (Y/N) : ");
		              char choice = sc.next().charAt(0);
		              if (choice=='Y'|| choice=='y')
		                 {
			                  flag = true;
			                  System.out.println("Enter current password : ");
			                  String temp =sc.next();
			          if (temp.equals(this.password))
			            {
				              System.out.println("Enter new password :");
				              this.password = sc.next();
				              System.out.println("********PASSWORD CHANGED SUCCESSFULLY!********* ");
				
			             }
			          else
			             {
				              System.out.println("Incorrect password! ");
			             }
 }
		
		             else if (choice =='N'|| choice=='n')
		                 {
			                  flag = true;
			                  System.out.println("*******PASSWORD CHANGE CANCELED!********");
		                 }
		
		              else
		                 {
			                   System.out.println("*****ENTER A VALID CHOICE*****");
		                  }
			
	                 }while(!flag);
				
}
    //set the mailbox capacity
   public void set_mailCap()
   {
	   System.out.println("current capacity = "+this.mailCapacity +"mb");
	   System.out.print("Enter new capacity : ");
	   this.mailCapacity = sc.nextInt();
	   System.out.println("MAIL BOX CAPACITY CHANGED SUCCESSFULLY");
	}
   
  public void getInfo() 
   
   {
	System.out.println("************** STUDENT INFORMATIONS***************");
	System.out.println("FIRST NAME : " + this.fname);
	
	System.out.println("LAST NAME : " + this.lname);
	
	System.out.println("DEPARTMENT : " + this.dept);
	
	System.out.println("EMAIL Id :" + this.email);
	
	System.out.println("PASSWORD :" + this.password);
	
    System.out.println("MAILBOX CAPACITY: " +this.mailCapacity + "mb");
   }
   
   public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your Firstname and Lastname :");
		Email em1= new Email(input.next(),input.next());
		em1.getInfo();
		em1.set_password();
		
		

	}

}
