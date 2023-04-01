package com.myprojects.evc3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myprojects.evc3.ApiCliente.ApiClient.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentListaDogs : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_lista_dogs, container, false)
        recyclerView = view.findViewById(R.id.rv_dogs)
        val gridLayoutManager = GridLayoutManager(context, 1)
        recyclerView.layoutManager = gridLayoutManager
        getUsers()
        return view
    }

    private fun getUsers() {
        val apiService: DogApiService = apiService
        apiService.getDogs(10).enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful) {
                    val breedsList = response.body()?.message ?: emptyList()
                    recyclerView.adapter = DogAdapter(breedsList)
                }
            }
            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                // Maneja el error
            }
        })
    }
}