package com.example.usgs.ui.details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.usgs.R
import com.example.usgs.data.mapper.toFormattedDate
import com.example.usgs.databinding.FragmentDetailsBinding


class DetailsFragment() : Fragment() {


    private lateinit var binding: FragmentDetailsBinding
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvmagDetails.text = context?.getString(R.string.magnitude_format, args.eq.mg)
            tvPlaceDetails.text = args.eq.place
            tvLongDetails.text = context?.getString(R.string.coordinates_format, args.eq.long)
            tvLatDetails.text = context?.getString(R.string.coordinates_format, args.eq.lat)
            tvTimeDetails.text = args.eq.time.toString()

        }
    }

}