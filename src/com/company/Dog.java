package com.company;
import java.io.*;

public class Dog {
    private String name;
    private Breed breed;
    private double deliveryPrice;
    private double salePrice;
    private String sex;

    public Dog(String name, Breed breed, double deliveryPrice, double salePrice, String sex) {
        this.name = name;
        this.breed = breed;
        this.deliveryPrice = deliveryPrice;
        this.salePrice = salePrice;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void serialize(String fileName) {
        File file = new File("files");
        file.mkdir();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getName() + "/" + fileName);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
            outputStream.writeObject(name);
            outputStream.writeObject(breed);
            outputStream.writeObject(deliveryPrice);
            outputStream.writeObject(salePrice);
            outputStream.writeObject(sex);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dog deserialize(String fileName) {
        Dog dog = null;
        try (FileInputStream fileInputStream = new FileInputStream("files/" + fileName);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {

            String name = (String) inputStream.readObject();
            Breed breed = (Breed) inputStream.readObject();
            double deliveryPrice = (double) inputStream.readObject();
            double salePrice = (double) inputStream.readObject();
            String sex = (String) inputStream.readObject();

           dog = new Dog(name, breed, deliveryPrice, salePrice, sex);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return dog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed=" + breed +
                ", deliveryPrice=" + deliveryPrice +
                ", salePrice=" + salePrice +
                ", sex='" + sex + '\'' +
                '}';
    }
}
