package kaplan.shaked.betoken;

import android.os.Build;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MessageItem {
    private final String mail;
    private final String message;
    private final LocalDateTime messageDateTime;
    private final int profilePicture;

    public MessageItem(String mail, String message, LocalDateTime messageDateTime, int profilePicture) {
        this.mail = mail;
        this.message = message;
        this.messageDateTime = messageDateTime;
        this.profilePicture = profilePicture;
    }


    public String getMail() {
        return mail;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getMessageDateTime() {
        return messageDateTime;
    }

    public LocalDate getMessageDate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return messageDateTime.toLocalDate();
        }

        return null;
    }

    public LocalTime getMessageTime() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return messageDateTime.toLocalTime();
        }

        return null;
    }

    public int getProfilePicture() {
        return profilePicture;
    }
}
