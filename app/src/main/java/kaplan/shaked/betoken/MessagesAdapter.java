package kaplan.shaked.betoken;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>{

    MessageItem[] messagesList;

    public MessagesAdapter(MessageItem[] messagesList) {
        this.messagesList = messagesList;
    }

    @NonNull
    @Override
    public MessagesAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View messageItem = inflater.inflate(R.layout.message_item_view, parent, false);
        return new MessageViewHolder(messageItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesAdapter.MessageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return messagesList.length;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
