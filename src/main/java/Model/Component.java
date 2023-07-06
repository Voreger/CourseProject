package Model;

public class Component {
    private String type = "";
    private String price = "";
    private String componentId = "";

    public Component(String type, String price, String componentId) {
        this.type = type;
        this.price = price;
        this.componentId = componentId;
    }
    public Component(String type, String price) {
        this.type = type;
        this.price = price;
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

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }
}
