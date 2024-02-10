import java.util.Scanner;
public class ATM {
	
	static long accountno;
	static String name;
	static double balance=100;
	static Scanner sc=new Scanner(System.in);
	
	public void withdraw() {
		
	System.out.println("Enter the amount you want to withdraw: ");
		double withdraw=sc.nextDouble();
		
		if(withdraw>balance){
			
			System.out.println("You have insufficient balance");
			
			
		}
		else {
			
		double	newbalancew=balance-withdraw;
			System.out.println("Your remaning balance is " +newbalancew);
		}
	}
    public void show(double balance){
        System.out.println("Your current balance is: "+balance);
    }
		
		
	public void deposit() {
		System.out.println("Enter the amount you want to deposit: ");
		double deposit=sc.nextDouble();
		
	double 	newbalanced=balance+deposit;
		System.out.println("Your updated balance is: "+newbalanced);
		
		
	
		
	
	
	}
		public static void main(String[] args) {
			
			
			System.out.println("Enter your Account Number: ");
            accountno=sc.nextLong();
			System.out.println("Enter Your name: ");
            name=sc.next();
			
			
			char mode;
            System.out.println("Please type w for withdraw ,d for deposit and c to check the existing balance");
			System.out.println("Enter your mode: ");
			mode=sc.next().charAt(0);
			
			ATM obj=new ATM();
				
			
			if(mode=='w') {
				
				
				obj.withdraw();
			}
			else if(mode=='d') {
				
				obj.deposit();
				
			}
            else if(mode=='c') {
				
                obj.show(balance);
				
			}
			
			else {
				
				System.out.println("Wrong mode");
			}
			
			
		}	}
	
	
	

