package sg.edu.np.mad.madpractical3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        User user = new User("John Doe", "MAD Developer", 1, false);

        TextView tvName = findViewById(R.id.textView2);
        TextView tvDescription = findViewById(R.id.textView3);


        tvDescription.setText(user.description);

        Intent receivedIntent = getIntent();
        int receivedNumber = receivedIntent.getIntExtra("randomNumber", -1);
        tvName.setText("MAD " + receivedNumber);


        findViewById(R.id.button1).setOnClickListener(v ->{
            boolean Followed = user.followed;

            if(!Followed){
                user.followed = true;
                ((Button)v).setText("Unfollow");
                Toast.makeText(this,"Followed",Toast.LENGTH_SHORT).show();
            }
            else{
                user.followed = false;
                ((Button)v).setText("Follow");
                Toast.makeText(this,"Unfollowed",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button2).setOnClickListener(v ->{
            Intent MessageActivity = new Intent(MainActivity.this, MessageGroup.class);
            startActivity(MessageActivity);
        });
    }}