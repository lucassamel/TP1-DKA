package lucassamel.br.tp1_dka.ui.contato.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.list_contato_fragment.*
import lucassamel.br.tp1_dka.R
import lucassamel.br.tp1_dka.database.AppDatabase
import lucassamel.br.tp1_dka.model.Contato
import lucassamel.br.tp1_dka.model.ContatoUtil

class ListContatoFragment : Fragment() {

    private lateinit var viewModel: ListContatoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_contato_fragment, container, false)

        val appDatabase = AppDatabase.getInstance(requireContext().applicationContext)
        val contatoDao = appDatabase.contatoDao()
        val listContatoVMF = ListContatoViewModelFactory(contatoDao)

        viewModel = ViewModelProvider(this,listContatoVMF).get(ListContatoViewModel::class.java)

        viewModel = ViewModelProvider(this)
            .get(ListContatoViewModel::class.java)

        viewModel.contatos.observe(viewLifecycleOwner){
            setUpLitsViewContatos(it)
        }
        viewModel.atualizarQuantidade()

        return view
    }

    private fun setUpLitsViewContatos(contatos: List<Contato>) {
        listViewContato.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            contatos
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabFormContato.setOnClickListener {
            ContatoUtil.contatoSelecionado = null

            findNavController().navigate(R.id.formContatoFragment)
        }
    }

}