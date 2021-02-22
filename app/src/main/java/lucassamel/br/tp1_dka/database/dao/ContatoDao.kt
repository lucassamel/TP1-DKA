package lucassamel.br.tp1_dka.database.dao

import androidx.room.*
import lucassamel.br.tp1_dka.model.Contato

@Dao
interface ContatoDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun create(vararg contato: Contato){
    }

    @Update
    suspend fun update(contato: Contato)
    @Delete
    suspend fun delete(contato: Contato)

//    @Query("SELECT * FROM Contato WHERE id = :key")
//    suspend fun get(key: Long): CarroAndMotorista

    @Query("SELECT * FROM Contato")
    suspend fun all(): List<Contato>
}