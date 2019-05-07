package sg.edu.rp.c346.billplease;

import android.hardware.camera2.TotalCaptureResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    EditText numofpax;

    ToggleButton btnsvc;
    ToggleButton btngst;
    Button btnsplit;
    Button btnreset;

    TextView bill;
    TextView eachpays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.etxtamount);
        numofpax = findViewById(R.id.etxtpax);

        btnsvc = findViewById(R.id.toggleButtonsvs);
        btngst = findViewById(R.id.toggleButtongst);
        btnsplit = findViewById(R.id.btnsplit);
        btnreset = findViewById(R.id.btnreset);

        bill = findViewById(R.id.txtbill);
        eachpays = findViewById(R.id.txteachpay);

       btnsplit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               double total = 0.0;
               int pax = 0;
               double PerPax = 0.0;

               amount.getText().toString();
               numofpax.getText().toString();

               total = Double.parseDouble(amount.getText().toString());
               pax = Integer.parseInt(numofpax.getText().toString());

               PerPax = total/pax;

               if (btngst.isChecked() && btnsvc.isChecked()) {

                   PerPax = PerPax * 1.17;
               } else if (btnsvc.isChecked()) {
                   PerPax = PerPax * 1.1;
               } else if (btngst.isChecked()) {
                   PerPax = PerPax * 1.07;
               } else {
                   PerPax = PerPax;
               }

               String stringtotal = amount.getText().toString();
               bill.setText(String.format("%.2f",total));
               eachpays.setText(String.format("%.2f",PerPax));
           }
       });

       btnreset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               btnsvc.setChecked(false);
               btngst.setChecked(false);
               amount.setText("");
               numofpax.setText("");
               bill.setText("");
               eachpays.setText("");
           }
       });
    }
}
