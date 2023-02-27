package com.example.practicalenoch

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.practicalenoch.adapter.CommitAdapter
import com.example.practicalenoch.databinding.ActivityCommitScreenBinding
import com.example.practicalenoch.model.CommitResponse
import com.google.gson.Gson

class CommitScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommitScreenBinding
    var commitUrl = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommitScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Commits"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        if (intent.hasExtra("commit_url")) {
            commitUrl = intent.getStringExtra("commit_url").toString()
        }
        getData()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun getData() {
        // RequestQueue initialized

        val mRequestQueue: RequestQueue = Volley.newRequestQueue(this)

        // String Request initialized
        val mStringRequest: StringRequest = StringRequest(
            Request.Method.GET, commitUrl,
            { response ->
                //  Toast.makeText(applicationContext, "Response :$response", Toast.LENGTH_LONG).show() //display the response on screen
                try {
                    val gson = Gson()
                    val commitResponse = gson.fromJson(response, CommitResponse::class.java)
                    if (commitResponse != null) {
                       val adapter =
                            CommitAdapter(listOf(commitResponse), this@CommitScreenActivity)
                        binding.rvCommit.adapter = adapter
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        ) { error -> Log.i(ContentValues.TAG, "Error :$error") }
        mRequestQueue.add(mStringRequest)
    }
}