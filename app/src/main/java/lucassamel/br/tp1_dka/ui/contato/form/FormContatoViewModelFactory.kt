package lucassamel.br.tp1_dka.ui.contato.form

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp1_dka.database.dao.ContatoDao
import lucassamel.br.tp1_dka.ui.contato.list.ListContatoViewModel

class FormContatoViewModelFactory(private val contatoDao: ContatoDao,
                                  private val application: Application
)
    : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FormContatoViewModel::class.java))
            return ListContatoViewModel(contatoDao, application) as T
        throw IllegalArgumentException("Classe ViewModel desconhecida.")

    }
}
