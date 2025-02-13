package kaplan.shaked.betoken;

public class User {
    private String email;
    private String aboutMe;
    private int profilePicture;
    private String gender;

    public User() {}

    public User(String email) {
        this.email = email;
        this.aboutMe = "";
        this.profilePicture = 0;
        this.gender = "";
    }

    public String getEmail() {
        return email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public String getGender() {
        return gender;
    }
}
