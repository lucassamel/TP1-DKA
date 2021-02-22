package lucassamel.br.tp1_dka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import lucassamel.br.tp1_dka.database.AppDatabase
import lucassamel.br.tp1_dka.model.Contato

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appDatabase = AppDatabase.getInstance(this.applicationContext)

        GlobalScope.launch {
            val contato = Contato("Lucas",12345678)
            val contatoDao = appDatabase.contatoDao()
            contatoDao.create(contato)
        }

    }
}