package com.example.permissionrequestexample.view.file

import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.permissionrequestexample.R
import com.example.permissionrequestexample.view.utils.toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.*

class FileFragment : Fragment(R.layout.fragment_file) {

    private lateinit var path: File

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manageUi()
    }

    private fun manageUi() {
        val fileWasCreated = createExternalFile()
        if (fileWasCreated) readFileContent()
    }

    private fun showFileContent(readText: String?) {
        val tvContent = requireView().findViewById<TextView>(R.id.tv_content)
        val progressBar = requireView().findViewById<ProgressBar>(R.id.progress_bar)
        lifecycleScope.launch {
            delay(3000)
            progressBar.isVisible = false
            tvContent.text = readText
        }
    }


    private fun readFileContent() {
        try {
            val file = File(path.absolutePath, "prueba.txt")
            val bufferedReader = BufferedReader(InputStreamReader(FileInputStream(file)))
            val readText = bufferedReader.readLine()
            bufferedReader.close()
            showFileContent(readText)
        }catch (e:Exception) {
            toast(e.message ?: "Unknown error")
        }
    }

    private fun createExternalFile(): Boolean {
        return try {
            path = Environment.getExternalStorageDirectory()
            val file = File(path.absolutePath, "prueba.txt")
            val outputStreamWriter = OutputStreamWriter(FileOutputStream(file))

            outputStreamWriter.write("Hola Mundo")
            outputStreamWriter.close()
            true
        }catch (e: Exception) {
            toast(e.message ?: "Unknown error")
            false
        }
    }
}