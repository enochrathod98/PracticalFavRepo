package com.example.practicalenoch

import android.content.ContentValues
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.practicalenoch.adapter.SearchRepoAdapter
import com.example.practicalenoch.databinding.ActivityAddRepoBinding
import com.example.practicalenoch.model.RepoResponse
import com.example.practicalenoch.model.RepoResponseItem
import com.google.gson.Gson


class AddRepoActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddRepoBinding
    lateinit var adapter: SearchRepoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Add Repo"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        binding.btnAdd.setOnClickListener {
            adapter.addButtonClick()
            finish()
        }
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                getData(text.toString())
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun getData(text: String) {
        // RequestQueue initialized
        val url = "https://api.github.com/users/$text/repos"

        val mRequestQueue: RequestQueue = Volley.newRequestQueue(this)

        // String Request initialized
        val mStringRequest: StringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                //  Toast.makeText(applicationContext, "Response :$response", Toast.LENGTH_LONG).show() //display the response on screen
                try {
                    val gson = Gson()
                    val trendingRepositoryResponse: List<RepoResponseItem> =
                        gson.fromJson(response, Array<RepoResponseItem>::class.java).toList()
                    if (trendingRepositoryResponse.isNotEmpty()) {
                        adapter =
                            SearchRepoAdapter(trendingRepositoryResponse, this@AddRepoActivity)
                        binding.rvRepository.adapter = adapter
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        ) { error -> Log.i(ContentValues.TAG, "Error :$error") }
        mRequestQueue.add(mStringRequest)
    }
}
