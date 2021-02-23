package lucassamel.br.tp1_dka.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import lucassamel.br.tp1_dka.database.dao.ContatoDao
import lucassamel.br.tp1_dka.database.dao.PessoaDao
import lucassamel.br.tp1_dka.model.Contato
import lucassamel.br.tp1_dka.model.Pessoa

@Database(
    entities = [
        Contato::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contatoDao(): ContatoDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "contact_list.db"
            ).build()
        }
    }

}