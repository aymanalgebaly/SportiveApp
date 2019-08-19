package sportiveapp.compubase.com.sportiveapp.ui.model;

public class ActivitesModel {

    private int img;
    private String name,msg,title;

    public ActivitesModel() {
    }

    public ActivitesModel(int img, String name, String msg, String title) {
        this.img = img;
        this.name = name;
        this.msg = msg;
        this.title = title;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
