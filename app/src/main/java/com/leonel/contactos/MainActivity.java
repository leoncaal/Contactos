package com.leonel.contactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final Locale LOCALE = new Locale("es", "MX");
    private static final SimpleDateFormat fmtFecha = new SimpleDateFormat("dd/MM/yyyy");
    private TextInputEditText txtNombre;
    private DatePicker dtpicker;
    private TextInputEditText txtTelefono;
    private TextInputEditText txtEmail;
    private TextInputEditText txtDescripcion;
    private Button btnSiguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (TextInputEditText) findViewById(R.id.txtinNombre);
        dtpicker = (DatePicker) findViewById(R.id.dpFechaNacimiento);
        txtTelefono = (TextInputEditText) findViewById(R.id.txtinTelefono);
        txtEmail = (TextInputEditText) findViewById(R.id.txtinEmail);
        txtDescripcion = (TextInputEditText) findViewById(R.id.txtinDescripcion);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DetalleContacto.class);
                i.putExtra(getResources().getString(R.string.nombre_completo), txtNombre.getText().toString());
                i.putExtra(getResources().getString(R.string.telefono), txtTelefono.getText().toString());
                i.putExtra(getResources().getString(R.string.email), txtEmail.getText().toString());
                i.putExtra(getResources().getString(R.string.descripcion_contacto), txtDescripcion.getText().toString());
                final Calendar dPicker = Calendar.getInstance();
                dPicker.set(Calendar.DAY_OF_MONTH, dtpicker.getDayOfMonth());
                dPicker.set(Calendar.YEAR, dtpicker.getYear());
                dPicker.set(Calendar.MONTH, dtpicker.getMonth());
                String fecha = fmtFecha.format(dPicker.getTime());

                i.putExtra(getResources().getString(R.string.fecha_nacimiento), fecha);
                startActivity(i);
            }
        });
    }
}
