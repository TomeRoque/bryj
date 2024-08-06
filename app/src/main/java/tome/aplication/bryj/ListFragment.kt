package tome.aplication.bryj

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import tome.aplication.bryj.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: Adapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter = Adapter(listOf(), requireActivity())
    }

    override fun onStart() {
        super.onStart()
        binding.rvList?.layoutManager = LinearLayoutManager(requireContext())
        binding.rvList?.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using View Binding
        _binding = FragmentListBinding.inflate(inflater, container, false)

        val stringList = arrayListOf("Tomé", "Roque", "Bryj", "Aplication", "PrimeIT", "Android", "Developer", "Lisbon", "August", "2024")

        adapter.updateItems(stringList)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}