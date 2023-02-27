package com.example.practicalenoch.fragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.practicalenoch.adapter.IssueAdapter
import com.example.practicalenoch.databinding.FragmentIssueBinding
import com.example.practicalenoch.model.IssueResponseItem
import com.google.gson.Gson

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [IssueFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IssueFragment(var issueUrl: String) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentIssueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIssueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        // RequestQueue initialized
        val url = issueUrl.substring(0, issueUrl.lastIndexOf('/'))
        val url1 = url.dropLast(1)
        val mRequestQueue: RequestQueue = Volley.newRequestQueue(requireContext())

        // String Request initialized
        val mStringRequest: StringRequest = StringRequest(
            Request.Method.GET, url1,
            { response ->
                //  Toast.makeText(applicationContext, "Response :$response", Toast.LENGTH_LONG).show() //display the response on screen
                try {
                    val gson = Gson()
                    val issueResponse: List<IssueResponseItem> =
                        gson.fromJson(response, Array<IssueResponseItem>::class.java).toList()
                    if (issueResponse.isNotEmpty()) {
                        val adapter =
                            IssueAdapter(issueResponse, requireContext())
                        binding.rvIssue.adapter = adapter
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        ) { error -> Log.i(ContentValues.TAG, "Error :$error") }
        mRequestQueue.add(mStringRequest)
    }

}