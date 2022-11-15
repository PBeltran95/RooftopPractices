package com.example.permissionrequestexample.view.room

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.permissionrequestexample.R
import com.example.permissionrequestexample.view.DataBaseApp
import com.example.permissionrequestexample.view.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomFragment : Fragment(R.layout.fragment_room) {

    private val roomDB = DataBaseApp
    private val adapter by lazy { HumanAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = requireView().findViewById<RecyclerView>(R.id.rv_humans)
        recyclerView.adapter = adapter
    }

    private fun setupButtons() {
        val btnShowInfo = requireView().findViewById<Button>(R.id.btn_show_info)
        val btnSaveHuman = requireView().findViewById<Button>(R.id.btn_save_human)

        btnSaveHuman.setOnClickListener {
            checkFields()
        }
        btnShowInfo.setOnClickListener {
            recoverInfoFromBD()
        }
    }

    private fun checkFields() {
        val name = requireView().findViewById<EditText>(R.id.et_name).text.toString()
        val lastName = requireView().findViewById<EditText>(R.id.et_last_name).text.toString()
        if (name.isNotBlank() && lastName.isNotBlank()) {
            saveHuman(name, lastName)
        } else {
            toast("Both fields must be filled")
        }
    }

    private fun saveHuman(name: String, lastName: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            roomDB.getInMemoryDatabase(requireContext()).humanDao().saveHuman(HumanEntity(name = name, lastName = lastName))
        }
    }

    private fun recoverInfoFromBD() {
        lifecycleScope.launch(Dispatchers.IO) {
            val humanList = roomDB.getInMemoryDatabase(requireContext()).humanDao().recoverHumanThatMatches()
            withContext(Dispatchers.Main) {
                println(humanList)
                adapter.fillData(humanList)
            }
        }
    }
}