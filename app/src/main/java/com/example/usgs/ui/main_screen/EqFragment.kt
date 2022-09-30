package com.example.usgs.ui.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.usgs.databinding.FragmentEqBinding
import com.example.usgs.domain.models.Eq
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EqFragment : Fragment() {

    private val viewModel by viewModels<EqViewModel>()
    private val adapter: EqAdapter by lazy { EqAdapter(::onEqClicked) }
    private lateinit var binding: FragmentEqBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEqBinding.inflate(layoutInflater, container, false)
        binding.recyclerViewEq.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.eq.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun onEqClicked(eq: Eq) {
        findNavController().navigate(
            EqFragmentDirections.actionEqFragmentToDetailsFragment(eq))
    }

}