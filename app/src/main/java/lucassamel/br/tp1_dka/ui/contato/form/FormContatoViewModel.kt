package lucassamel.br.tp1_dka.ui.contato.form

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import lucassamel.br.tp1_dka.database.dao.ContatoDao
import lucassamel.br.tp1_dka.model.Contato
import lucassamel.br.tp1_dka.model.ContatoUtil

class FormContatoViewModel(
    private val contatoDao: ContatoDao,
    application: Application
) : AndroidViewModel(application)
 {

     private val app = application

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

     init {
         _status.value = false
         _msg.value = null
     }

    fun store(nome: String, telefone: Int){
        _status.value = false
        viewModelScope.launch {
            try {
                val contato = Contato(nome, telefone)
                if (ContatoUtil.contatoSelecionado != null){
                    contato.id = ContatoUtil.contatoSelecionado!!.id
                    contatoDao.update(contato)
                } else
                    contatoDao.create(contato)
                _status.value = true
                _msg.value = "Persistência realizada com sucesso."
            } catch (e: Exception) {
                _msg.value = "Problemas ao persistir os dados."
                Log.i("SQLRoom", "${e.message}")
            }
        }
    }
}