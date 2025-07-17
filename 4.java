package com.example.emailapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
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
ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
v.setPadding(systemBars.left, systemBars.top, systemBars.right,
systemBars.bottom);
return insets;
});
EditText et1 = findViewById(R.id.usr);
EditText et2 = findViewById(R.id.pwd);
Button buttonLogin = findViewById(R.id.btn);
buttonLogin.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
String username = et1.getText().toString().trim();
String password = et2.getText().toString().trim();
if (username.isEmpty() || password.isEmpty()) {
Toast.makeText(MainActivity.this, "Username or Password is empty", Toast.LENGTH_SHORT).show();
} else if (username.equals("admin") && password.equals("welcome")) {
Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
} else {
Toast.makeText(MainActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
}
}
});
}
}
