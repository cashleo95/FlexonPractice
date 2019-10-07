package BankInfo;
import BankInfo.BankAccount;
import java.util.Scanner; 
import java.io.*; 
import java.util.*; 

public class Menu {
	
	private int choice;
	private int deposite_count;
	private BankAccount cash; 
	private ArrayList<Double> history;
	private Date date;
	//private ArrayList<String> daily;
	public Menu () {
		choice = 0;
		cash = new BankAccount();
		history = new ArrayList<Double>();
		//daily = new ArrayList<String>();
		deposite_count = 0;
		date = new Date();
	}
	public void menu_display() {
		
		System.out.println("Welcom to Flexon Bank");
		System.out.println("Currently Avaiable Services: ");
		System.out.println("1 -> Deposite");
		System.out.println("2 -> Withdraw");
		System.out.println("3 -> Show accunt Info & Balance");
		System.out.println("4 -> Transatction History");
		System.out.println("5 -> Exit");
		get_choice();
			
		
	}
	public void get_choice() {
		Scanner sc = new Scanner(System.in); 
		do {
			
			choice = sc.nextInt();
			if(choice<1 ||choice >5) {
				System.out.println("Invalid Choice, No service could be found. Please re-enter your choice: ");
			}
		}while(choice<1 ||choice >5);
	}
	public int getchoice() {
		return choice;
	}
	public void deposite_service() {
		if(deposite_count<3) {
			double amount = 0;
			do {
				System.out.println("enter your amount");
				amount =  new Scanner(System.in).nextDouble();
				if(amount<50 || amount> 500) {
					System.out.println("Invalid deposit amount, please re-enter: ");
				}
			}while(amount<50 || amount > 500);
		
			cash.deposit(amount);
			history.add(amount);
			deposite_count++;
		}
		else {
			System.out.println("You have deposite 3 times today, come tmw! ");
		}
	}
	public double total_withdraw() {
		double total=0;
		for(int i =0; i< history.size();i++) {
			if(history.get(i)<0) {
				total = total + Math.abs(history.get(i));
			}
		}
		return total;
	}
	public void withdraw_service() {
		if(total_withdraw()>=1000) {
			System.out.println("You have reached your withdraw limited");
		}else {
			double amount = 0;
			do {
				amount = new Scanner(System.in).nextDouble();
				if(amount > (1000-total_withdraw())) {
					System.out.println("the amount over the limit you can withdraw today, re-enter an amount: ");
				}
			}while(amount>(1000-total_withdraw()));
			cash.withdraw(amount);
			history.add(amount*-1);//represent the withdraw in the list
			System.out.println("The remaining amount you can withdraw today: "+ (1000-total_withdraw()));
			System.out.println("Balance: "+cash.get_balance());
		}
	}
	public void show_info() {
		cash.display_info();
		System.out.println(date);
	}
	public void see_trans() {
		for(int i = 0; i<history.size();i++) {
			if(history.get(i)<0) {
				System.out.println("Withdra"+history.get(i));
			}
			else {
				System.out.println("Deposite"+history.get(i));
			}
		}
	}
	public void service() {
		switch (choice) {
						
			case 1: deposite_service();
			//System.out.println("here");
				break;
			case 2: withdraw_service();
				break;
			case 3: show_info();
				break;
			case 4: see_trans();
		}
	}
	
	
	
	
	
	public static void main(String agr[]) {
		BankAccount user1 = new BankAccount();
		Menu test = new Menu();
		do {
			test.menu_display();
			test.service();
		}while(test.getchoice()!=5);
		
		System.out.println("Thanks for using Flexon Bank! ");
		
		
	}
}
