package lucassamel.br.tp1_dka.ui.contato.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import lucassamel.br.tp1_dka.R
import lucassamel.br.tp1_dka.database.AppDatabase

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
        val formContatoViewModelFactory = FormContatoViewModelFactory(carroDao, application)

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}