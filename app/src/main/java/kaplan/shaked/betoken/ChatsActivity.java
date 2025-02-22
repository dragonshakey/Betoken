package kaplan.shaked.betoken;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class ChatsActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    FirebaseUser user;
    RecyclerView chatsRecyclerView;
    ChatItem[] chatsList;
    ChatsAdapter adapter;
    Button personalProfileButton;
    EditText searchEmailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        context = this;
        user = FirebaseUtil.getCurrentUser();
        chatsRecyclerView = findViewById(R.id.recyclerViewChats);
        personalProfileButton = findViewById(R.id.buttonPersonalProfile);
        searchEmailEditText = findViewById(R.id.editTextEmailSearch);

        personalProfileButton.setOnClickListener(this);

        FirebaseUtil.firestoreGetUsers(user.getEmail())
                .addOnSuccessListener((QuerySnapshot q) -> {
                    List<DocumentSnapshot> documents = q.getDocuments();
                    chatsList = new ChatItem[documents.size()];
                    for (int i = 0; i < documents.size(); i++) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            chatsList[i] = new ChatItem(
                                    documents.get(i).getString("email"),
                                    "hello",
                                    LocalDateTime.now(ZoneId.systemDefault()),
                                    R.drawable.betoken_logo);
                        }
                    }

                    adapter = new ChatsAdapter(chatsList);
                    chatsRecyclerView.setHasFixedSize(true);
                    chatsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
                    chatsRecyclerView.setAdapter(adapter);
                });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.buttonPersonalProfile) {
            Intent intent = new Intent("android.intent.action.personal");
            startActivity(intent);
        }
    }
}