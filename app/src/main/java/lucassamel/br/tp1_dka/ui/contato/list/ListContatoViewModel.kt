package lucassamel.br.tp1_dka.ui.contato.list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lucassamel.br.tp1_dka.database.dao.ContatoDao
import lucassamel.br.tp1_dka.model.Contato

class ListContatoViewModel(
    private val contatoDao: ContatoDao,
    application: Application
) : ViewModel() {

    private val _quantidade = MutableLiveData<List<Contato>>()
    val quantidade: LiveData<List<Contato>> = _quantidade



    fun atualizarQuantidade(){
        viewModelScope.launch {
            _quantidade.value = contatoDao.all()
        }

    }
}