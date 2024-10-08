package com.example.lab4_iot;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.Navigation;

public class AppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        //Listeners de los botones
        findViewById(R.id.btLigas).setOnClickListener(v -> {
            Navigation.findNavController(this, R.id.fragmentContainerView).navigate(R.id.ligasFragment);
        });

        findViewById(R.id.btPosiciones).setOnClickListener(v -> {
            Navigation.findNavController(this, R.id.fragmentContainerView).navigate(R.id.posicionesFragment);
        });

        findViewById(R.id.btResultados).setOnClickListener(v -> {
            Navigation.findNavController(this, R.id.fragmentContainerView).navigate(R.id.resultadosFragment);
        });
    }
}
