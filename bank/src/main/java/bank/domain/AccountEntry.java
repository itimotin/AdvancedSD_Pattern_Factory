package bank.domain;

import java.util.Date;

public class AccountEntry {
	private final Date date;
	private final double amount;
	private final String description;
	private final String fromAccountNumber;
	private final String fromPersonName;
        
	private AccountEntry(Builder builder) {
            this.date = builder.date;
            this.amount = builder.amount;
            this.description = builder.description;
            this.fromAccountNumber = builder.fromAccountNumber;
            this.fromPersonName = builder.fromPersonName;
	}

	public double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public String getFromPersonName() {
		return fromPersonName;
	}

        public static class Builder{
            private Date date = null;
            private double amount = 0.0;
            private String description = "";
            private String fromAccountNumber = "";
            private String fromPersonName = "";
            
            public AccountEntry build(){
                return new AccountEntry(this);
            }

            public Builder withDate(Date date) {
                this.date = date;
                return this;
            }

            public Builder withAmount(double amount) {
                this.amount = amount;
                return this;
            }

            public Builder withDescription(String description) {
                this.description = description;
                return this;
            }

            public Builder withFromAccountNumber(String fromAccountNumber) {
                this.fromAccountNumber = fromAccountNumber;
                return this;
            }

            public Builder withFromPersonName(String fromPersonName) {
                this.fromPersonName = fromPersonName;
                return this;
            }     
        }
}

