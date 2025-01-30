package kaplan.shaked.betoken;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ChatsActivity extends AppCompatActivity {

    FirebaseUser user;
    RecyclerView chatsRecyclerView;
    ChatItem[] chatsList;
    ChatsAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        context = this;
        chatsRecyclerView = findViewById(R.id.recyclerViewChats);
        user = FirebaseUtil.getCurrentUser();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            chatsList = new ChatItem[] {
                    new ChatItem("oogaBooga@gmail.com", "hfudskhjf", LocalDateTime.now(ZoneId.systemDefault()),R.drawable.betoken_logo),
                    new ChatItem("oogaBooga@gmail.com", "hfudskmjf", LocalDateTime.now(ZoneId.systemDefault()),R.drawable.betoken_logo),
                    new ChatItem("oogaBooga@gmail.com", "hfudsk3jf", LocalDateTime.now(ZoneId.systemDefault()),R.drawable.betoken_logo),
                    new ChatItem("oogaBooga@gmail.com", "hfudsk9jf", LocalDateTime.now(ZoneId.systemDefault()),R.drawable.betoken_logo),
                    new ChatItem("oogaBooga@gmail.com", "hfudsknjf", LocalDateTime.now(ZoneId.systemDefault()),R.drawable.betoken_logo),
            };

            adapter = new ChatsAdapter(chatsList);
            chatsRecyclerView.setHasFixedSize(true);
            chatsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            chatsRecyclerView.setAdapter(adapter);
        }
    }
}