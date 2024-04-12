package com.fabiansuarez.tiendavirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


public class FormProductActivity extends AppCompatActivity {

    private Button btnSaveForm;
    private TextInputLayout nameTextField, descriptionTextField, priceTextField;
    private TextInputLayout imageUrlTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_product);

        btnSaveForm = findViewById(R.id.btn_save_product_form);

        nameTextField = findViewById(R.id.et_name_product_form);
        descriptionTextField = findViewById(R.id.et_description_product_form);
        priceTextField = findViewById(R.id.et_price_product_form);
        imageUrlTextField = findViewById(R.id.et_image_url_product_form);

        btnSaveForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo lo que escriban de aqui para abajo dse activa
                //cuando el usuario click en el boton


                String name = nameTextField.getEditText().getText().toString().trim();
                String descripcion = descriptionTextField.getEditText().getText().toString().trim();
                String price = priceTextField.getEditText().getText().toString().trim();
                String urlImage = priceTextField.getEditText().getText().toString().trim();


                if(name.isEmpty()){
                    nameTextField.setError("Por favor ingresar el nombre");
                    return;
                }else if(name.length()>20){
                    nameTextField.setError("Epa se paso de 20!");
                    return;
                }
                if(descripcion.isEmpty()){
                    descriptionTextField.setError("Por favor ingresar el Descripcion");
                    return;
                }
                if(price.isEmpty()){
                    priceTextField.setError("Por favor ingresar el Price");
                    return;
                }
                if(urlImage.isEmpty()){
                    imageUrlTextField.setError("Por favor ingresar el UrlImage");
                    return;
                }

                Product myNewProduct = new Product("Computador","descripcion",5000.0, "No hay por ahora");

                Toast.makeText(FormProductActivity.this, "EPAAAA", Toast.LENGTH_SHORT).show();

            }
        });

    }
}