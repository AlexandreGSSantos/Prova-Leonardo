package com.alexandre.prova_leonardo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Interface DAO para definir as operações de banco de dados do Room.
 */
@Dao
public interface ProductDao {
    /**
     * Insere um novo produto no banco de dados.
     */
    @Insert
    void insert(Product product);

    /**
     * Retorna todos os produtos cadastrados.
     */
    @Query("SELECT * FROM products")
    List<Product> getAllProducts();
}
