package com.example.lab4_iot;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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

        //Verificar conexion, en caso no haya redirigir a configuraciones del dispositivo
        //Me apoye de Internet para la redireccion del dispositivo
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            new AlertDialog.Builder(this)
                    .setMessage("No hay conexión a Internet. ¿Desea ir a Configuración?")
                    .setPositiveButton("Configuración", (dialog, which) -> {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        } else if (networkInfo.isConnected()) {
            Button enterButton = findViewById(R.id.enterButton);
            enterButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, LigasActivity.class);
                startActivity(intent);
            });
        }
    }

}