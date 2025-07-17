package com.example.sqldbapp;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
TextView output;
SQLiteDatabase db;
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
EditText input = findViewById(R.id.input);
output= findViewById(R.id.output);
Button save = findViewById(R.id.save);
db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
db.execSQL("CREATE TABLE IF NOT EXISTS student(name TEXT)");
save.setOnClickListener(v -> {
String name = input.getText().toString();
db.execSQL("INSERT INTO student VALUES('" + name + "')");
showNames();
});
showNames();
}
void showNames() {
Cursor c = db.rawQuery("SELECT * FROM student", null);
StringBuilder names = new StringBuilder();
while (c.moveToNext()) names.append(c.getString(0)).append("\n");
output.setText(names.toString());
}
}
