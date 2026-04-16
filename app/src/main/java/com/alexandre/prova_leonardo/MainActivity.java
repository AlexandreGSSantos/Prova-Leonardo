package com.alexandre.prova_leonardo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Tela principal para cadastro de produtos.
 */
public class MainActivity extends AppCompatActivity {

    private EditText etName, etCode, etPrice, etQuantity;
    private Button btnSave, btnViewList;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa o banco de dados Room
        db = AppDatabase.getInstance(this);

        // Associa os componentes da UI com os objetos Java
        etName = findViewById(R.id.etProductName);
        etCode = findViewById(R.id.etProductCode);
        etPrice = findViewById(R.id.etProductPrice);
        etQuantity = findViewById(R.id.etProductQuantity);
        btnSave = findViewById(R.id.btnSave);
        btnViewList = findViewById(R.id.btnViewList);

        // Botão para salvar o produto
        btnSave.setOnClickListener(v -> saveProduct());

        // Botão para navegar para a tela de listagem
        btnViewList.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProductListActivity.class);
            startActivity(intent);
        });
    }

    /**
     * Valida e salva os dados do produto no banco de dados.
     */
    private void saveProduct() {
        String name = etName.getText().toString().trim();
        String code = etCode.getText().toString().trim();
        String priceStr = etPrice.getText().toString().trim();
        String quantityStr = etQuantity.getText().toString().trim();

        // Validação: Campos em branco
        if (name.isEmpty() || code.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            // Validação: Números positivos
            if (price <= 0 || quantity <= 0) {
                Toast.makeText(this, "Preço e quantidade devem ser positivos!", Toast.LENGTH_SHORT).show();
                return;
            }

            Product product = new Product(name, code, price, quantity);
            db.productDao().insert(product);

            Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            clearFields();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Digite valores numéricos válidos!", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        etName.setText("");
        etCode.setText("");
        etPrice.setText("");
        etQuantity.setText("");
    }
}
