package entities;

// extends, 
// diz que esta classe ir� receber TODOS ATRIBUTOS e M�TODOS DA classe ACCOUNT!
// sintaxe: classe que ir� receber extends classe que ir� doar!
// Esta � uma SubClasse da Classe Account!!


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
			balance += amount - 10.0;
			/* ao fazer essa implementa��o, a variavel balance da classe account n�o estar� visivel
			 * pois na classe Account, a mesma est� como private... para que esteja visivel, � necess�rio
			 * utilizar o protected... isso n�o deixar� a variavel p�blica, evitando q esta classe possa alterar
			 * por�m outras classes n�o. essa consegue pois est� herdando!
			 * substituindo ent�o o "private balance".... por "protected balance"
			 */
		}
	}
	

}
