package receipts;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private ArrayList<Cashier> cashierList = new ArrayList<Cashier>();

    public Shop() {
    }

    public void displayList(){
        for (Item item: itemList) {
            System.out.println(item);
        }
        System.out.println();
    }

    public ArrayList<Cashier> getCashierList() {
        return cashierList;
    }

    public void storeItem(Item item){
        itemList.add(item);
    }

    public void addCashierToList(Cashier cashier){
        cashierList.add(cashier);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "itemList=" + itemList +
                ", cashierList=" + cashierList +
                '}';
    }
}
