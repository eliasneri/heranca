package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		// Heran�as!
		
		System.out.println("HERAN�AS - UPCASTING / DOWNCASTING");
		
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING

		// bacc � um objeto da subclasse, q foi atribu�do a uma superclasse
		//BusinessAccount (conta empresarial) � uma Account (Conta)
		// Uma conta empresarial TAMB�M � UMA conta!
		
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
		
		// DOWNCASTING
		
		BusinessAccount acc4 = (BusinessAccount)acc2;		// � necess�rio for�ar manualmente
		acc4.loan(100.0);
		
		/* por exemplo na acc2 n�o existe a opera��o loan, pq ela � do tipo account, e loan s� existe
		 * na classe BussinessAccount, caso eu queira executar a fun��o loan, eu devo fazer o downcasting
		 * da acc2 que � uma Account para a acc4 que � uma BusinessAccount
		 */
		
		//BusinessAccount acc5 = (BusinessAccount)acc3;
		
		/* esse downcasting, o compilador entende, por�m ele est� incorreto
		 * esse erro s� ir� ser aprensentado na execu��o do programa.
		 * O Erro � que o acc3 � uma Account + tipo SavingsAccount.
		 * 
		 * Para evitar esse erro � necess�rio testar se eles s�o do mesmo tipo!!
		 * se for do tipo BusinessAccount, ele faz o downcasting!
		 * 
		 * para isso ir� utilizar o instanceof
		 * 
		 * se (o que tiver na variave acc3 for um objeto que esteja na instacia BusinessAccount)
		 * fa�a o casting
		 * fa�a a opera��o de empr�stimo 
		 */
		
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Empr�stimo - Loan");
		}  // ESSE IF IR� FALHAR pois acc3 n�o � BusinessAccount!!!
	
		
		
		/* se (o que tiver em acc3 for um objeto do tipo SavingsAccount)
		 * fa�a o casting do acc5 para SavingsAccount recebendo os dados de acc3
		 * fa�a o updateBalance, que s� existe no SavingsAccount
		 * 
		 */
		
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		
		System.out.println("Account acc = new Account(1001, \"Alex\", 0.0)");
		System.out.println(acc.getNumber() + " - " + acc.getHolder() + " - " + acc.getBalance());
		
		System.out.println("********");
		
		System.out.println("BusinessAccount bacc = new BusinessAccount(1002, \"Maria\", 0.0, 500.0)");
		System.out.println(bacc.getNumber() + " - " + bacc.getHolder() + " - " + bacc.getBalance() + " - " + bacc.getLoanLimit());
		
		System.out.println("********");
		
		System.out.println("Account acc2 = new BusinessAccount(1003, \"Bob\", 0.0, 200.0)");
		System.out.println(acc2.getNumber() + " - " + acc2.getHolder() + " - " + acc2.getBalance());
		
	}

}
