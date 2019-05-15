package atmMachine;

import java.io.IOException;
import java.util.Scanner;

public class Account {

	private static int Id=10;
	private static int balance=100;
	private static int withdrow;
	private static int deposit;
	private static int transaction;

	public static void mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Main menu\n1.Check Balance\n2.Withdrow\n3.Deposit\n4.Exit\n");
		int input= sc.nextInt();
		if (input==1) {
			Balance();
		}	 else if (input ==2){
			Withdrow();
		}else if(input ==3){
			Deposit();
		}else if(input == 4) {
			Id();
		}else {
			System.out.println("Please enter a valid input.");

		}

	}
	public static void Balance() {
		balance = 100;
		balance = (balance + deposit)-withdrow;
		System.out.println("Your balance is" +balance+"\nDo you want to do othe transanction?\n1.Yes\n2.No?");
		anotherTransaction();
	}



	public  static void Withdrow() {
		System.out.println("How much you want to withdrow?");
		Scanner sc = new Scanner(System.in);
		withdrow = sc.nextInt();
		if(withdrow>balance) {
			System.out.println("Sorry! you dont have suffecient balance.\n Do you want to do othe transanction?\n\n1.Yes\n2.No");
			anotherTransaction();
			Id();
		}else if(withdrow<=0) {
			System.out.println("Please enter a valid input.");
			Withdrow();
		}else if (withdrow<balance) {
			balance = balance-withdrow;
			System.out.println("you have withdrow "+withdrow+" "+"Your new balance is "+balance);
			System.out.println("Do you want to do othe transanction?\n\n1.Yes\n2.No");
			anotherTransaction();

		}
	}
	public static void anotherTransaction() {
		Scanner sc = new Scanner(System.in);
		transaction=sc.nextInt();
		if(transaction==1) {
			Id();
		}else if(transaction==2){
			System.out.println("Good Bye! Thank you for Choosing Bank of Dhurba.");
			Id();
		} else {
			System.out.println("Please enter a valid input.");
		}
		sc.close();
	}

	public static void Deposit() {
		System.out.println("How much you want to Deposit?");
		Scanner sc = new Scanner(System.in);
		deposit = sc.nextInt();
		if(deposit >0) {
			balance = deposit+balance;
			System.out.println("You have deposited "+deposit+" "+"Your new balance is "+balance);
			System.out.println("Do you want to do othe transanction?\n1.Yes\n2.No");
			anotherTransaction();
		}
		sc.close();
	}



	public static void Id() {
		System.out.println("Welcome to the Bank Of Dhurba.\nPlease enter an id");
		Scanner sc = new Scanner(System.in);
		try{
			int input =sc.nextInt();


			if( input ==Id) {
				mainMenu();
				//System.out.println("*************#################1*****************************************");
			} else {


				System.out.println("Please enter an valid Id");
				Id();}
		}catch (Exception e) {
			//System.out.println("******************************************************");
			e.printStackTrace();
			System.out.println("Please enter an valid Id");
			Id();
		}
		sc.close();
	}


	public static void main (String []args) {

		Account ac = new Account ();
		Id();
		
	}	
	//
}


