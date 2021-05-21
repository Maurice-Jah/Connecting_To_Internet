package com.example.connectingtointernet.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.connectingtointernet.Repository
import com.example.connectingtointernet.api.Api
import com.example.connectingtointernet.api.Info
import com.example.connectingtointernet.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null

    private var info = mutableListOf<Info>()


  private val viewModel:MainViewModel by lazy {
      ViewModelProvider(this,MainViewModeFactory(Repository(Api.apiService)))
          .get(MainViewModel::class.java)
  }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentMainBinding.inflate(layoutInflater)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.infoLiveData.observe(viewLifecycleOwner, Observer {
            info.addAll(it)
        })
        val adapter = MainAdapter(info)
        binding?.rickyMortyRv?.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding?.rickyMortyRv?.adapter = adapter
    }

    companion object {


    }
}