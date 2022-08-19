package com.s1aks.learnappdesign.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.s1aks.learnappdesign.databinding.FragmentHomeBinding
import com.s1aks.learnappdesign.ui.skype_work_classes.ShowInWebClickListener
import com.s1aks.learnappdesign.ui.skype_work_classes.SkypeHelper
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit


class HomeFragment : Fragment(), ShowInWebClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModel()
    private var classesAdapter: HomeFragmentClassesAdapter? = null
    private var homeworksAdapter: HomeFragmentHomeworksAdapter? = null
    private var skypeHelper: SkypeHelper? = null
    private var myTimer: MyTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val endTime = LocalDateTime.of(2022, 8, 26, 20, 0)
        myTimer = MyTimer(
            ChronoUnit.MILLIS.between(LocalDateTime.now(), endTime),
            binding.d1, binding.d2,
            binding.h1, binding.h2,
            binding.m1, binding.m2
        ).start() as MyTimer?
        classesAdapter = HomeFragmentClassesAdapter(this)
        binding.classesRecycler.adapter = classesAdapter
        homeworksAdapter = HomeFragmentHomeworksAdapter(requireContext())
        binding.homeworksRecycler.adapter = homeworksAdapter
        skypeHelper = SkypeHelper(requireContext())
        homeViewModel.classData.observe(viewLifecycleOwner) {
            classesAdapter!!.submitList(it)
        }
        homeViewModel.getClasses()
        homeViewModel.homeworkData.observe(viewLifecycleOwner) {
            homeworksAdapter!!.submitList(it)
        }
        homeViewModel.getHomeworks()
    }

    override fun showInWebClick(skypeUri: String) {
        skypeHelper?.openInSkype(skypeUri)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        myTimer = null
        skypeHelper = null
        _binding = null
    }
}