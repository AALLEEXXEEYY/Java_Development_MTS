package purchase;

public class PurchaseAmount {

    /*
     * Класс для подсчета суммы покупок с учетом скидок
     * В классе есть три поля: кол-во вещей, цена и скидка
     * В классе реализованы методы для подсчета и тд.
     */
    public int countThings; /* Кол-во вещей */
    public float price; /* Цена одного товара  */
    public float discount; /* Скидка */

    public void setCountThings(int countThings) {
        this.countThings = countThings;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
}