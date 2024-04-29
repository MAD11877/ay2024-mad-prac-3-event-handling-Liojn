package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        Random random = new Random();
        findViewById(R.id.imageView2).setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Profile");
            builder.setMessage("MADness");
            builder.setCancelable(true);
            builder.setPositiveButton("VIEW", (dialog, which) -> {
                int x =  random.nextInt();
                Intent MainActivity = new Intent(ListActivity.this, MainActivity.class);
                MainActivity.putExtra("randomNumber", x);
                startActivity(MainActivity);
            });
            builder.setNegativeButton("Cancel",((dialog, which) -> {
                dialog.cancel();
            }));
            builder.show();
            });

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}
