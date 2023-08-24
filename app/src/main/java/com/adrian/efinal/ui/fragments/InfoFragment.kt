package com.adrian.efinal.ui.fragments

import android.app.UiModeManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.adrian.efinal.databinding.FragmentInfoBinding
import com.adrian.efinal.ui.LoginActivity


class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize sharedPreferences
        sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.btnLogout.setOnClickListener {
            logout()
        }

        binding.swDark.setOnCheckedChangeListener { _, isSelected ->
            if (isSelected) {
                enableDarkMode()
            } else {
                disableDarkMode()
            }
        }

        // Initialize switch state based on saved preference
        binding.swDark.isChecked = isDarkModeEnabled()
    }

    private fun logout() {

        sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()

        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        saveDarkModePreference(true)
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        saveDarkModePreference(false)
    }

    private fun isDarkModeEnabled(): Boolean {
        return sharedPreferences.getBoolean("isDarkModeEnabled", false)
    }

    private fun saveDarkModePreference(enabled: Boolean) {
        sharedPreferences.edit().putBoolean("isDarkModeEnabled", enabled).apply()
    }
}