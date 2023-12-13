package main;
import purchase.PurchaseAmount;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PurchaseAmount milk = new PurchaseAmount();
        milk.setCountThings(1);
        milk.setPrice(100.1F);
        milk.setDiscount(0.75F);

        PurchaseAmount cheese = new PurchaseAmount();
        cheese.setCountThings(5);
        cheese.setDiscount(42.575F);
        cheese.setPrice(200.2F);

        PurchaseAmount meet = new PurchaseAmount();
        meet.setPrice(500.5F);
        meet.setCountThings(1);
        meet.setDiscount(59.1F);

        ArrayList<PurchaseAmount> purchaseList = new ArrayList<>();
        purchaseList.add(milk);
        purchaseList.add(cheese);
        purchaseList.add(meet);

        for (int i = 0; i < purchaseList.size(); i++) {
            Main.amount(purchaseList.get(i));
        }
    }
    public static void amount(PurchaseAmount obj) {
        System.out.format("Сумма без скидки: %.2f\n", obj.countThings * obj.price);
        System.out.format("Сумма со скидкой: %.2f\n\n", obj.countThings * (obj.price * (1 - obj.discount / 100)));
    }
}