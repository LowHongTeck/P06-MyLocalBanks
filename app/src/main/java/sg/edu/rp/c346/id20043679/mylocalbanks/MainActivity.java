package sg.edu.rp.c346.id20043679.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;

    String viewSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Favourite");
        menu.add(0,3,3,"Un-favourite");



        if (v == btnDBS){
            viewSelected = "DBS";
        } else if (v == btnOCBC){
            viewSelected = "OCBC";
        } else if (v == btnUOB){
            viewSelected = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (viewSelected.equalsIgnoreCase("dbs")){
            if(item.getItemId() == 0){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
            } else if (item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18001111111L));
                startActivity(intentCall);
            } else if (item.getItemId() == 2){
                btnDBS.setTextColor(Color.RED);
            } else if (item.getItemId() == 3){
                btnDBS.setTextColor(Color.BLACK);
            }
        } else if (viewSelected.equalsIgnoreCase("ocbc")){
            if(item.getItemId() == 0){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
            } else if (item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18003633333L));
                startActivity(intentCall);
            } else if (item.getItemId() == 2){
                btnOCBC.setTextColor(Color.RED);
            } else if (item.getItemId() == 3){
                btnOCBC.setTextColor(Color.BLACK);
            }
        } else if (viewSelected.equalsIgnoreCase("uob")){
            if(item.getItemId() == 0){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
            } else if (item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18002222121L));
                startActivity(intentCall);
            }  else if (item.getItemId() == 2){
                btnUOB.setTextColor(Color.RED);
            } else if (item.getItemId() == 3){
                btnUOB.setTextColor(Color.BLACK);
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.English) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.Chinese){
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
        }

        return super.onOptionsItemSelected(item);
    }
}