package pojo;

public class Stock {
    private int id;
    private String name;
    private String type;
    private String price;
    private int amount;
    private int estimatedQuantity;
    private int purchase;

    public Stock(int id, String name, String type, String price, int amount, int estimatedQuantity, int purchase) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.estimatedQuantity = estimatedQuantity;
        this.purchase = purchase;
    }

    public Stock() {
    }

    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getEstimatedQuantity() {
        return estimatedQuantity;
    }

    public void setEstimatedQuantity(int estimatedQuantity) {
        this.estimatedQuantity = estimatedQuantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", amount=" + amount +
                ", estimatedQuantity=" + estimatedQuantity +
                ", purchase=" + purchase +
                '}';
    }
}
