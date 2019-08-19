package sportiveapp.compubase.com.sportiveapp.ui.model;

public class RegisterModel {
    private String response = "True";

    public RegisterModel() {
    }

    public RegisterModel(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
