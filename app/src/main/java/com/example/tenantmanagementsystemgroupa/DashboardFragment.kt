package com.example.tenantmanagementsystemgroupa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystemgroupa.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onCreateView")
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onViewCreated")

        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()
        binding.tenantCountTextView.text = "Tenants\n$tenantCount"
        binding.totalRentTextView.text = "Total rent\nKSh %,.0f".format(totalRent)

        binding.addTenantButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToAddTenantFragment()
            findNavController().navigate(action)
        }
        binding.viewTenantsButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToViewTenantsFragment()
            findNavController().navigate(action)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE_TAG, "   DashboardFragment: onDestroy")
    }

    private companion object {
        const val LIFECYCLE_TAG = "TENANT_LIFECYCLE"
    }
}
