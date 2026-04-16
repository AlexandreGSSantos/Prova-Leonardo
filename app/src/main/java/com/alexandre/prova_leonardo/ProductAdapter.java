package com.alexandre.prova_leonardo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

/**
 * Adapter para o RecyclerView que gerencia a exibição da lista de produtos.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout de cada item da lista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        // Vincula os dados do produto aos componentes visuais
        Product product = productList.get(position);
        holder.tvName.setText(product.getName());
        holder.tvCode.setText("Código: " + product.getCode());
        holder.tvPrice.setText(String.format(Locale.getDefault(), "R$ %.2f", product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }

    /**
     * ViewHolder que mantém as referências para as Views de cada item.
     */
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCode, tvPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvProductName);
            tvCode = itemView.findViewById(R.id.tvProductCode);
            tvPrice = itemView.findViewById(R.id.tvProductPrice);
        }
    }
}
