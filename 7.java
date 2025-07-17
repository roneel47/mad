Step 3: Add menu items to menu_main.xml
write the following code inside menu_main.xml:
  
<menu xmlns:android="http://schemas.android.com/apk/res/android">
<item
android:id="@+id/action_search" android:title="Search" android:showAsAction="ifRoom" />
<item
android:id="@+id/action_settings" android:title="Settings" android:showAsAction="ifRoom" />
</menu>

Step 5: Java Code for Toolbar and Menu
Use the following code in MainActivity.java:
  
package com.example.actionbarr;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
Toolbar toolbar = findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
}
@Override
public boolean onCreateOptionsMenu(android.view.Menu menu) {
getMenuInflater().inflate(R.menu.menu_main, menu);
return true;
}
@Override
public boolean onOptionsItemSelected(android.view.MenuItem item) {
int id = item.getItemId();
if (id == R.id.action_search) {
Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
return true;
} else if (id == R.id.action_settings) {
Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
return true;
}
return super.onOptionsItemSelected(item);
}
}
