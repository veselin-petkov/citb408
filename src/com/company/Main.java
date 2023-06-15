package com.company;

public class Main {

  public static void main(String[] args) {
    Company first = new Company("IKEA");
    Company second = new Company("METRO");

    first.setIncome(9500);
    second.setIncome(12000);

    first.setExpenses(4000.5);
    second.setExpenses(6000);

    System.out.println(first.higherIncome(second));
    System.out.println(second.higherIncomeThanNum(13000));

    Breed breed = Breed.BEAGLE;
    Dog dog = new Dog("Terry", breed, 500.9, 750, "f");

    String fileName = "dog.ser";

    dog.serialize(fileName);

    System.out.println(dog.deserialize(fileName));
  }
}
