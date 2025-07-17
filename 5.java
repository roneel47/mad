package com.example.intent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
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
v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
return insets;
});
Button b1=findViewById(R.id.btn1);
Button b2=findViewById(R.id.btn2);
Button b3=findViewById(R.id.btn3);
b1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Intent exintent=new Intent(MainActivity.this, MainActivity2.class);
startActivity(exintent);
}
});
b2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Intent impintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
startActivity(impintent);
}
});
b3.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
startActivity(intent);
}
});
}
}
