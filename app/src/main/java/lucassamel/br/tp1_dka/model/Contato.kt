package lucassamel.br.tp1_dka.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contato(
    var nome: String? = null,
    var telefone: Int? = null,

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
) {
    override fun toString(): String = "$nome: $telefone"

}


