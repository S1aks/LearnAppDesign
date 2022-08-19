package com.s1aks.learnappdesign.ui.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.s1aks.learnappdesign.databinding.FragmentClassesBinding
import com.s1aks.learnappdesign.ui.skype_work_classes.ShowInWebClickListener
import com.s1aks.learnappdesign.ui.skype_work_classes.SkypeHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClassesFragment : Fragment(), ShowInWebClickListener {

    private var _binding: FragmentClassesBinding? = null
    private val binding get() = _binding!!
    private val classesViewModel: ClassesViewModel by viewModel()
    private var classesAdapter: ClassesFragmentAdapter? = null
    private var skypeHelper: SkypeHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        classesAdapter = ClassesFragmentAdapter(this)
        binding.classesRecycler.adapter = classesAdapter
        skypeHelper = SkypeHelper(requireContext())
        classesViewModel.classData.observe(viewLifecycleOwner) {
            classesAdapter!!.submitList(it)
        }
        classesViewModel.getClasses()
    }

    override fun showInWebClick(skypeUri: String) {
        skypeHelper?.openInSkype(skypeUri)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        skypeHelper = null
        _binding = null
    }
}