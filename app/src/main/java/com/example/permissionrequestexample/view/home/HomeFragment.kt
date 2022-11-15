package com.example.permissionrequestexample.view.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.permissionrequestexample.R
import com.example.permissionrequestexample.view.utils.toast

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
    }

    private fun setupButtons() {
        val btnFile = requireView().findViewById<Button>(R.id.btn_to_file)
        val btnToRoom = requireView().findViewById<Button>(R.id.btn_room)
        val btnToRetrofit = requireView().findViewById<Button>(R.id.btn_retrofit)
        btnFile.setOnClickListener {
            checkPermissions()
        }
        btnToRoom.setOnClickListener {
            navigateTo(R.id.action_homeFragment_to_roomFragment)
        }
        btnToRetrofit.setOnClickListener {
            navigateTo(R.id.action_homeFragment_to_retrofitFragment)
        }

    }

    private fun navigateTo(action:Int) {
        findNavController().navigate(action)
    }

    private fun checkPermissions() {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q) {
            navigateTo(R.id.action_homeFragment_to_fileFragment)
        }else {
            if ( hasWritePermissions() == PackageManager.PERMISSION_GRANTED) {
                navigateTo(R.id.action_homeFragment_to_fileFragment)
            }else {
                requestWritePermissions.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    }

    private val requestWritePermissions = registerForActivityResult(
        ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) navigateTo(R.id.action_homeFragment_to_fileFragment)
        else toast("We need permissions to continue")
    }

    private fun hasWritePermissions(): Int {
        return ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }
}