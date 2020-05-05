package org.d3if4009.bismillahmobprokelar.overView

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

import org.d3if4009.bismillahmobprokelar.R
import org.d3if4009.bismillahmobprokelar.databinding.FragmentListViewBinding


class ListViewFragment : Fragment() {

    private val viewModel: ListViewModel by lazy {
        ViewModelProviders.of(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListViewBinding.inflate(inflater)
//        val binding = RecyclerviewListItemBinding.inflate(inflater)

        binding.setLifecycleOwner (this)
         binding.viewModel = viewModel

        (activity as AppCompatActivity).supportActionBar?.title = "My Fruity"

        binding.rvItemList.adapter = ListViewAdapter(ListViewAdapter.OnClickListener{
           viewModel.displayItemDetails(it)
        })

        viewModel.navigateToSelectedItem.observe(this, Observer {
            if(null != it){
                this.findNavController().navigate(
                   ListViewFragmentDirections.actionListviewFragmentToDetailFragment(it))
                viewModel.displayItemDetailsComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController())
    }
}
