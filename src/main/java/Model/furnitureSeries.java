package Model;

public class furnitureSeries {
    private String furniture, name;

    public furnitureSeries(String furniture, String name) {
        this.furniture = furniture;
        this.name = name;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
