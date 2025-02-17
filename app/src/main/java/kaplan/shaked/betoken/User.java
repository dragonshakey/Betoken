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

    public User(String email, String aboutMe, int profilePicture, String gender) {
        this.email = email;
        this.aboutMe = aboutMe;
        this.profilePicture = profilePicture;
        this.gender = gender;
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
