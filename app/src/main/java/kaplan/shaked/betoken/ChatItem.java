package kaplan.shaked.betoken;

import java.time.LocalDateTime;

public class ChatItem {
    private final String mail;
    private final String lastMessage;
    private final LocalDateTime lastMessageDateTime;
    private final int profilePicture;

    public ChatItem(String mail, String lastMessage, LocalDateTime lastMessageDateTime, int profilePicture) {
        this.mail = mail;
        this.lastMessage = lastMessage;
        this.lastMessageDateTime = lastMessageDateTime;
        this.profilePicture = profilePicture;
    }

    public String getMail() {
        return mail;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public LocalDateTime getLastMessageDateTime() {
        return lastMessageDateTime;
    }

    public int getProfilePicture() {
        return profilePicture;
    }
}
