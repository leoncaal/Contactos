package com.leonel.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        btnEditar = (Button) findViewById(R.id.btnEditar);

        Bundle b = this.getIntent().getExtras();

        String nombre = b.getString(getResources().getString(R.string.nombre_completo));
        String fecha = b.getString(getResources().getString(R.string.fecha_nacimiento));
        String telefono = b.getString(getResources().getString(R.string.telefono));
        String email = b.getString(getResources().getString(R.string.email));
        String descripcion = b.getString(getResources().getString(R.string.descripcion_contacto));

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }
}