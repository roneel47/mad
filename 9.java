package com.example.userprefapp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
EdgeToEdge.enable(this);
setContentView(R.layout.activity_main);
ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets)
-> {
Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
return insets;
});
EditText editName = findViewById(R.id.editName);
Button btnSave = findViewById(R.id.btnSave);
TextView txtResult = findViewById(R.id.txtResult);
SharedPreferences prefs = getPreferences(MODE_PRIVATE);
txtResult.setText("Hello " + prefs.getString("name", ""));
btnSave.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
prefs.edit().putString("name", editName.getText().toString()).apply();
txtResult.setText("Hello " + editName.getText().toString());
}
});
}
}
