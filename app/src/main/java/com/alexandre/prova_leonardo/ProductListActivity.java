package com.alexandre.prova_leonardo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Activity responsável por listar todos os produtos cadastrados no banco de dados.
 */
public class ProductListActivity extends AppCompatActivity {

    private RecyclerView rvProducts;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // Ativar o botão de voltar na barra superior
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Lista de Produtos");
        }

        db = AppDatabase.getInstance(this);
        rvProducts = findViewById(R.id.rvProducts);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));

        // Carregar os dados do banco para a lista
        loadProducts();
    }

    /**
     * Busca os produtos no banco de dados e configura o Adapter.
     */
    private void loadProducts() {
        List<Product> products = db.productDao().getAllProducts();
        ProductAdapter adapter = new ProductAdapter(products);
        rvProducts.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
