package org.d3if4009.bismillahmobprokelar.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import org.d3if4009.bismillahmobprokelar.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        val BuahProperty = DetailFragmentArgs.fromBundle(arguments!!).SELECTEDDETAILPROPERTY
        val viewModelFactory = DetailViewModelFactory(BuahProperty, application)

        binding.viewModel = ViewModelProviders.of(
            this,viewModelFactory).get(DetailViewModel::class.java)

        return binding.root
    }
}

