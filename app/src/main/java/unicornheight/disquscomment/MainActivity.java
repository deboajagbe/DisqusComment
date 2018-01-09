package unicornheight.disquscomment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button load_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load_comment = findViewById(R.id.comments);
        load_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Disqus.class);
                i.putExtra("DISQUS", "DISQUS ID HERE");//PASS THE DISQUS ID
                startActivity(i);
            }
        });
    }
}
