package com.intellias.vitkovska;

public class User {
    private final String id;
    private final String fistName;
    private final String lastName;
    private Double amountOfMoney;

    public User(String id, String fistName, String lastName, Double amountOfMoney) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public String getId() {
        return id;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(fistName);
        sb.append(" ").append(lastName);
        sb.append(" {");
        sb.append("id=").append(id);
        sb.append(", amountOfMoney=").append(amountOfMoney);
        sb.append('}');
        return sb.toString();
    }
}
