package entities;

// extends, 
// diz que esta classe irá receber TODOS ATRIBUTOS e MÉTODOS DA classe ACCOUNT!
// sintaxe: classe que irá receber extends classe que irá doar!
// Esta é uma SubClasse da Classe Account!!


public class BusinessAccount extends Account{
	
	private Double loanLimit;
	
	public BusinessAccount () {
		super();
	}

	
	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}
	
	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(double amount) {
		if (amount <= loanLimit) {
			deposit(amount);
		}
	}
	

}
