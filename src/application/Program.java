package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		// Heranças!
		
		System.out.println("HERANÇAS - UPCASTING / DOWNCASTING");
		
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING

		// bacc é um objeto da subclasse, q foi atribuído a uma superclasse
		//BusinessAccount (conta empresarial) é uma Account (Conta)
		// Uma conta empresarial TAMBÉM É UMA conta!
		
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
		
		// DOWNCASTING
		
		BusinessAccount acc4 = (BusinessAccount)acc2;		// é necessário forçar manualmente
		acc4.loan(100.0);
		
		/* por exemplo na acc2 não existe a operação loan, pq ela é do tipo account, e loan só existe
		 * na classe BussinessAccount, caso eu queira executar a função loan, eu devo fazer o downcasting
		 * da acc2 que é uma Account para a acc4 que é uma BusinessAccount
		 */
		
		//BusinessAccount acc5 = (BusinessAccount)acc3;
		
		/* esse downcasting, o compilador entende, porém ele está incorreto
		 * esse erro só irá ser aprensentado na execução do programa.
		 * O Erro é que o acc3 é uma Account + tipo SavingsAccount.
		 * 
		 * Para evitar esse erro é necessário testar se eles são do mesmo tipo!!
		 * se for do tipo BusinessAccount, ele faz o downcasting!
		 * 
		 * para isso irá utilizar o instanceof
		 * 
		 * se (o que tiver na variave acc3 for um objeto que esteja na instacia BusinessAccount)
		 * faça o casting
		 * faça a operação de empréstimo 
		 */
		
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Empréstimo - Loan");
		}  // ESSE IF IRÁ FALHAR pois acc3 não é BusinessAccount!!!
	
		
		
		/* se (o que tiver em acc3 for um objeto do tipo SavingsAccount)
		 * faça o casting do acc5 para SavingsAccount recebendo os dados de acc3
		 * faça o updateBalance, que só existe no SavingsAccount
		 * 
		 */
		
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.setInterestRate(200.0);
			acc5.updateBalance();
			System.out.println("Update!");
			System.out.println(acc5.getNumber() + " - " + acc5.getHolder() + " - " + acc5.getBalance());
		}
		
		
			System.out.println("Account acc = new Account(1001, \"Alex\", 0.0)");
			System.out.println(acc.getNumber() + " - " + acc.getHolder() + " - " + acc.getBalance());
		
		System.out.println("********");
		
			System.out.println("BusinessAccount bacc = new BusinessAccount(1002, \"Maria\", 0.0, 500.0)");
			System.out.println(bacc.getNumber() + " - " + bacc.getHolder() + " - " + bacc.getBalance() + " - " + bacc.getLoanLimit());
		
		System.out.println("********");
		
			System.out.println("Account acc2 = new BusinessAccount(1003, \"Bob\", 0.0, 200.0)");
			System.out.println(acc2.getNumber() + " - " + acc2.getHolder() + " - " + acc2.getBalance());
		
		System.out.println("********");
		
			System.out.println("Account acc3 = new SavingsAccount(1004, \"Anna\", 0.0, 0.01);");
			System.out.println(acc3.getNumber() + " - " + acc3.getHolder() + " - " + acc3.getBalance());
			System.out.println(acc1);
		
		
	}

}
