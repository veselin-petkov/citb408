package com.company;

public class Company {
    private String name;
    private double income;
    private double expenses;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public Company higherIncome(Company second){
        if(this.getIncome() > second.getIncome()) return this;
        return second;
    }

    public boolean higherIncomeThanNum(double num){
        if (this.getIncome() > num) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", income=" + income +
                ", expenses=" + expenses +
                '}';
    }
}
