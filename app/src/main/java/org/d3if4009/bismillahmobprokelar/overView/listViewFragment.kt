package org.d3if4009.bismillahmobprokelar.overView

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import org.d3if4009.bismillahmobprokelar.R
import org.d3if4009.bismillahmobprokelar.databinding.FragmentListViewBinding
import org.d3if4009.bismillahmobprokelar.overView.listViewAdapter
import org.d3if4009.bismillahmobprokelar.overView.listViewModel


class listViewFragment : Fragment() {

    private val viewModel: listViewModel by lazy {
        ViewModelProviders.of(this).get(listViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListViewBinding.inflate(inflater)
//        val binding = RecyclerviewListItemBinding.inflate(inflater)

        binding.setLifecycleOwner (this)
         binding.viewModel = viewModel

        binding.rvItemList.adapter = listViewAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
