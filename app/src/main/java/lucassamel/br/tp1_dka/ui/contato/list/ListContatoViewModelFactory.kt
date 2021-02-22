package lucassamel.br.tp1_dka.ui.contato.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.tp1_dka.database.dao.ContatoDao

class ListContatoViewModelFactory(
    private val contatoDao: ContatoDao
)
    : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListContatoViewModel::class.java))
            return ListContatoViewModel(contatoDao) as T
        throw IllegalArgumentException("Classe ViewModel deve ser ListContatoViewModel")

    }


}


