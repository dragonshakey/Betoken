package kaplan.shaked.betoken;

import android.os.Build;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    public LocalDate getLastMessageDate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return lastMessageDateTime.toLocalDate();
        }

        return null;
    }

    public LocalTime getLastMessageTime() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return lastMessageDateTime.toLocalTime();
        }

        return null;
    }

    public int getProfilePicture() {
        return profilePicture;
    }
}
