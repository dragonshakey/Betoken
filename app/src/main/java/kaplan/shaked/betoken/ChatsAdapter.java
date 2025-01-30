package kaplan.shaked.betoken;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatViewHolder> {

    ChatItem[] chatsList;

    public ChatsAdapter(ChatItem[] chatsList) {
        this.chatsList = chatsList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View chatItem = inflater.inflate(R.layout.chat_item_view, parent, false);
        return new ChatViewHolder(chatItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        final ChatItem chatItem = chatsList[position];
        holder.mail.setText(chatItem.getMail());
        holder.lastMessage.setText(chatItem.getLastMessage());
        holder.lastMessageDateTime.setText(chatItem.getLastMessageDateTime().toString());
        holder.profilePicture.setImageResource(chatItem.getProfilePicture());
    }

    @Override
    public int getItemCount() {
        return chatsList.length;
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView mail, lastMessage, lastMessageDateTime;
        ImageView profilePicture;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            mail = itemView.findViewById(R.id.textViewChatItemMail);
            lastMessage = itemView.findViewById(R.id.textViewChatItemLastMessage);
            lastMessageDateTime = itemView.findViewById(R.id.textViewChatItemLastMessageDateTime);
            profilePicture = itemView.findViewById(R.id.imageViewChatItmeProfile);
        }
    }
}
