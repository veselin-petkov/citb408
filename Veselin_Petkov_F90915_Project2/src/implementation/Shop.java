package implementation;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Goods> goodsList = new ArrayList<Goods>();
    private ArrayList<Cashier> cashierList = new ArrayList<Cashier>();

    public Shop() {
    }

    public void displayList(){
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
        System.out.println();
    }

    public ArrayList<Cashier> getCashierList() {
        return cashierList;
    }

    public void storeItem(Goods goods){
        goodsList.add(goods);
    }

    public void addCashierToList(Cashier cashier){
        cashierList.add(cashier);
    }

    @Override
    public String toString() {
        return "Shop{" +
               "itemList=" + goodsList +
               ", cashierList=" + cashierList +
               '}';
    }
}
