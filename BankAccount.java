package BankInfo;
import java.lang.*;

public class BankAccount {

	
	private
	
		String account = "123456789";
		double balance = 50.0;
		String name = "Chong Liu";
		String email = "cashleo@outlook.com";
		String phone = "4256330972";
		

	public
		void deposit(double amount) {
			balance = balance + amount;
		}
		void withdraw (double amount){
			if(amount > balance) {
				System.out.println("Customer"+ name);
				System.out.println("You have insufficient balance, the max you can withdraw is: " + balance );
			}
			else {
				balance = balance - amount;
			}
		}
		double get_balance() {
			return balance;
		}
		void display_info () {
			System.out.println(name);
			System.out.println(account);
			System.out.println(balance);
			System.out.println(email);
			System.out.println(phone);
				
		}
		

}

