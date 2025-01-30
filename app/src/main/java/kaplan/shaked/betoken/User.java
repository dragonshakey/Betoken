package kaplan.shaked.betoken;

public class User {
    private String email;
    private String aboutMe;
    // private something profilePicture
    private String gender;

    public User() {}

    public User(String email) {
        this.email = email;
        this.aboutMe = "";
        // this.profilePicture =
        this.gender = "";
    }

    public String getEmail() {
        return email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getGender() {
        return gender;
    }
}
