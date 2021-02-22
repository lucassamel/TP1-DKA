package lucassamel.br.tp1_dka.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import lucassamel.br.tp1_dka.model.Pessoa

@Dao
interface PessoaDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun create(vararg pessoa: Pessoa){

    }
}