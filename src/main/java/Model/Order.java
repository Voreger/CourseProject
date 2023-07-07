package Model;

public class Order {
    private String customerName;
    private String date;
    private String store;
    private String furniture;

    public Order(String customerName, String date, String store, String furniture) {
        this.customerName = customerName;
        this.date = date;
        this.store = store;
        this.furniture = furniture;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }
}
