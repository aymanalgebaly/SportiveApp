package sportiveapp.compubase.com.sportiveapp.ui.model;

public class CentersModel {

    private int img;
    private String km,name;

    public CentersModel(int img, String km, String name) {
        this.img = img;
        this.km = km;
        this.name = name;
    }

    public CentersModel() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
