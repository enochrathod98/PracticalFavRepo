package com.example.practicalenoch.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.practicalenoch.model.RepoResponse
import com.example.practicalenoch.model.RepoResponseItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class SharedPreference(context: Context) {

    private val appSharedPrefs: SharedPreferences
    private val prefsEditor: SharedPreferences.Editor

    init {
        appSharedPrefs =
            context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        prefsEditor = appSharedPrefs.edit()
    }

    fun saveArrayList(list: ArrayList<RepoResponseItem?>?, key: String?) {
        val gson = Gson()
        val json = gson.toJson(list)
        prefsEditor.putString(key, json)
        prefsEditor.apply() // This line is IMPORTANT !!!
    }

    fun getArrayList(key: String?): ArrayList<RepoResponseItem?>? {
        val gson = Gson()
        val json = appSharedPrefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<RepoResponseItem?>?>() {}.type
        return gson.fromJson(json, type)
    }
}