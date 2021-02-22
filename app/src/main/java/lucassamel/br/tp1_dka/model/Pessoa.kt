package lucassamel.br.tp1_dka.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Pessoa {
    val nome: String? = null
    val telefone: Int? = null
    val contatos: List<Contato>? = null
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}