package com.example.wheaterapplication.presentation.localweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.wheaterapplication.R
import com.example.wheaterapplication.databinding.FragmentLocalWeatherBinding

class LocalWeatherFragment : Fragment() {

    private var _binding: FragmentLocalWeatherBinding? = null
    private val binding: FragmentLocalWeatherBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_local_weather, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}