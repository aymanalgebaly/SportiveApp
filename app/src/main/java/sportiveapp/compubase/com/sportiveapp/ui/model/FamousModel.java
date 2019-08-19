package sportiveapp.compubase.com.sportiveapp.ui.model;

public class FamousModel {

    private int img;
    private String name,type;

    public FamousModel() {
    }

    public FamousModel(int img, String name, String type) {
        this.img = img;
        this.name = name;
        this.type = type;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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
}
