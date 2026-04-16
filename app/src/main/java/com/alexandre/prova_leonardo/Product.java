package com.alexandre.prova_leonardo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entidade que representa a tabela de produtos no banco de dados Room.
 */
@Entity(tableName = "products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id; // Identificador único automático

    private String name;      // Nome do produto
    private String code;      // Código alfanumérico
    private double price;     // Preço em reais
    private int quantity;    // Quantidade em estoque

    /**
     * Construtor para criar um novo produto.
     */
    public Product(String name, String code, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
