package fisei.reyespc.pasardatos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editar;
    TextView dato;
    Button accion;


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 78){
                        Intent intent = result.getData();
                        if(intent != null){
                            dato.setText(intent.getStringExtra("result"));
                        }else{
                            dato.setText("SIN DATA");
                            Toast.makeText(MainActivity.this,"NO se trajo los datos",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editar = findViewById(R.id.editTextTextPersonName);
        dato = findViewById(R.id.textView);
        accion = findViewById(R.id.button);

        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle datos = new Bundle();
                datos.putString("KeyDatos",editar.getText().toString());

                Intent dos = new Intent(MainActivity.this, MainActivity2.class);
                dos.putExtras(datos);
                activityResultLauncher.launch(dos);
            }
        });
    }
}