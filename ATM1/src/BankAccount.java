import java.util.*;
public class BankAccount {
	String name, username, account, password;
	float balance =0f;
	String transction_history = "";
	int transctions = 0;
	Scanner sc = new Scanner(System.in);
	public void register()
	{
		System.out.println("Give the information for registring your ATM");
		System.out.println("Enter your name ");
		this.name = sc.nextLine();
		System.out.println("Enter your username");
		this.username = sc.nextLine();
		System.out.println("Enter your Account number");
		this.account = sc.nextLine();
		System.out.println("Enter your password");
		this.password = sc.nextLine();
		System.out.println("\n Registration Completed...Kindly Login");
	}
	
	public boolean login()
	{
		boolean islogin = false;
		while(!islogin)
		{
			System.out.println("Enter your username");
			String Username = sc.nextLine();
			if(Username.equals(username))
			{
				while(!islogin)
				{
					System.out.println("Enter Your Password");
					String Password = sc.nextLine();
					if(Password.equals(password))
					{
						System.out.println("You are Successfully login");
						islogin = true;
					}
					else
					{
						System.out.println("Incorrect Password");
					}
				}
			}
			else
			{
				System.out.println("Incorrect Username");
			}
		}
		return islogin;
	}
	
	public void withdraw() {
		System.out.println("Enter amount for withdraw");
		float amount= sc.nextFloat();
		if(balance>=amount)
		{
			balance-=amount;
			System.out.println("Successfully Withdraw");
			String str = amount + "Rs withdrawed";
			transction_history = transction_history.concat(str);
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
	}
	
	public void deposit()
	{
		System.out.println("Enter amount for depoisition");
		float amount = sc.nextFloat();
		try {
			if ( amount <= 100000f ) {
				transctions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transction_history = transction_history.concat(str);
			}
			else {
				System.out.println("\nSorry...Limit is 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name - ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer - ");
		float amount = sc.nextFloat();
		
		try {
			if ( balance >= amount ) {
				if ( amount <= 50000f ) {
					transctions++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = amount + " Rs transfered to " + receipent + "\n";
					transction_history = transction_history.concat(str);
				}
				else {
					System.out.println("\nSorry...Limit is 50000.00");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void check_balance()
	{
		System.out.println(balance+"Rs");
	}
	
	public void history() {
		if(transction_history=="0")
		{
			System.out.println("Transction is Empty");
		}
		else
		{
			System.out.println("\n" +transction_history);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n**********WELCOME TO UBI ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice - ");
		int choice = sc.nextInt();
		BankAccount b = new BankAccount();
		if(choice==1)
		{
			b.register();
			while(true)
			{
				System.out.println("1.login \n2.Exit");
				System.out.println("Enter your choice");
				int ch = sc.nextInt();
				if(ch==1)
				{
					if(b.login())
					{
						System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
						boolean isfinished = false;
						while(!isfinished)
						{
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = sc.nextInt();
							switch(c)
							{
								case 1:
									b.withdraw();
									break;
								case 2:
									b.deposit();
									break;
								case 3:
									b.transfer();
									break;
								case 4:
									b.check_balance();
									break;
								case 5:
									b.check_balance();
									break;
								case 6:
									isfinished=true;
									break;
							}
						}
					}
					else
					{
						System.exit(0);
					}
				}
			}
		}
		else
		{
			System.exit(0);
		}
		
	}

}
