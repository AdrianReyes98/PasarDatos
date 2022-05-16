package fisei.reyespc.pasardatos;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {


    TextView dato;
    Button regreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dato = findViewById(R.id.textView2);
        regreso = findViewById(R.id.button2);

        Bundle receptor = getIntent().getExtras();
        String datosEnviados = receptor.getString("KeyDatos");
        dato.setText(datosEnviados);


        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result",dato.getText().toString()+" SI");
                setResult(78,intent);
                MainActivity2.super.onBackPressed();
            }
        });

    }
}