package com.alexandre.prova_leonardo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Classe de banco de dados do Room que serve como o ponto de acesso principal para a conexão com os dados persistidos.
 */
@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    /**
     * Retorna o DAO de produtos.
     */
    public abstract ProductDao productDao();

    /**
     * Método Singleton para obter a instância única do banco de dados.
     */
    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "product_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // Permite consultas na thread principal para fins de teste/simplificação
                    .build();
        }
        return instance;
    }
}
