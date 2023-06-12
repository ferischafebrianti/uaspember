package com.example.searchbar.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchbar.R

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var homeadapter: HomeAdapter
    private lateinit var homekelas: MutableList<HomeKelas>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerview)

        val context = context

        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager

        homekelas = mutableListOf()
        homekelas.add(HomeKelas("Realme GT","Rp, 8.500.000",  R.drawable.contoh))
        homekelas.add(HomeKelas("Realme 9Pro","Rp, 3.750.000",  R.drawable.realme9pro))
        homekelas.add(HomeKelas("Realme X50 Pro 5G","Rp, 6.899.000",  R.drawable.realmex50pro5g))
        homekelas.add(HomeKelas("Realme 8","Rp, 2.999.000",  R.drawable.realme8))
        homekelas.add(HomeKelas("Realme 5 Pro","Rp, 1.899.000",  R.drawable.realme5pro))
        homekelas.add(HomeKelas("Realme 7","Rp, 2.599.000",  R.drawable.realme7))
        homekelas.add(HomeKelas("Realme Narzo 50A","Rp, 3.579.000",  R.drawable.realmenarzo50a))
        homekelas.add(HomeKelas("Realme C35","Rp, 2.499.000",  R.drawable.realmec35))
        homekelas.add(HomeKelas("Realme GT Neo","Rp, 7.999.000",  R.drawable.realmegtneo))
        homekelas.add(HomeKelas("Realme GT Master Edition","Rp, 9.799.000",  R.drawable.realmegtmasteredition))

        homeadapter = HomeAdapter(homekelas)
        recyclerView.adapter = homeadapter

        return view

    }
//
//    private fun navigateToActivity() {
//        val intent = Intent(activity, MainActivity2::class.java)
//        startActivity(intent)
//    }

}