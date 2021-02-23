package lucassamel.br.tp1_dka.ui.contato.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.form_contato_fragment.*
import lucassamel.br.tp1_dka.R
import lucassamel.br.tp1_dka.database.AppDatabase
import lucassamel.br.tp1_dka.model.Contato
import lucassamel.br.tp1_dka.model.ContatoUtil

class FormContatoFragment : Fragment() {

    companion object {
        fun newInstance() = FormContatoFragment()
    }

    private lateinit var formContatoViewModel: FormContatoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireActivity().application
        val appDatabase = AppDatabase.getInstance(application)
        val carroDao = appDatabase.contatoDao()
        val formContatoViewModelFactory = FormContatoViewModelFactory(carroDao)

        formContatoViewModel = ViewModelProvider(this, formContatoViewModelFactory)
            .get(FormContatoViewModel::class.java)

        formContatoViewModel.status.observe(viewLifecycleOwner){ status ->
            if (status)
                findNavController().popBackStack()
        }

        formContatoViewModel.msg.observe(viewLifecycleOwner){ msg ->
            if (!msg.isNullOrBlank())
                Toast.makeText(
                    requireContext(),
                    msg,
                    Toast.LENGTH_LONG
                ).show()
        }


        val view = inflater.inflate(R.layout.form_contato_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (ContatoUtil.contatoSelecionado != null)
            fillContactForm(ContatoUtil.contatoSelecionado!!)

            btnSalvarContato.setOnClickListener {
            val name = textFormName.text.toString()
            val phoneNumber = textFormNumber.text.toString()

            formContatoViewModel.store(name)
        }
    }

    private fun fillContactForm(contactSelected: Contato) {
        textFormName.setText(contactSelected.nome)
//        editTextFormHomePhoneNumber.setText(phoneSelected.phoneNumber)
        btnSalvarContato.text = "Atualizar"
    }

}