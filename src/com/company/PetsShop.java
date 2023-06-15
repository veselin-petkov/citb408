package com.company;
import java.util.List;

public class PetsShop {
    private String name;
    private List<PetsShop> newDogs;
    private List<PetsShop> soldDogs;

    public PetsShop(String name, List<PetsShop> newDogs, List<PetsShop> soldDogs) {
        this.name = name;
        this.newDogs = newDogs;
        this.soldDogs = soldDogs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PetsShop> getNewDogs() {
        return newDogs;
    }

    public void setNewDogs(List<PetsShop> newDogs) {
        this.newDogs = newDogs;
    }

    public List<PetsShop> getSoldDogs() {
        return soldDogs;
    }

    public void setSoldDogs(List<PetsShop> soldDogs) {
        this.soldDogs = soldDogs;
    }

    public void addDogToSoldList(PetsShop pet){
        soldDogs.add(pet);
    }

    @Override
    public String toString() {
        return "PetsShop{" +
                "name='" + name + '\'' +
                ", newDogs=" + newDogs +
                ", soldDogs=" + soldDogs +
                '}';
    }
}
