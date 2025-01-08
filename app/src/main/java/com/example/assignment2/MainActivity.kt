package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var locations: List<Location>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize location data
        setupLocations()

        // Set up click listeners and initial ratings
        setupViews()
    }

    private fun setupLocations() {
        locations = listOf(
            Location(
                getString(R.string.shrine_remembrance),
                getString(R.string.melbourne_region),
                R.drawable.location1,
                4.5f,
                "2024-01-15"
            ),
            Location(
                getString(R.string.opera_house),
                getString(R.string.sydney_region),
                R.drawable.location2,
                5.0f,
                "2024-02-01"
            ),
            Location(
                getString(R.string.brisbane_beach),
                getString(R.string.brisbane_region),
                R.drawable.location3,
                4.0f,
                "2024-01-20"
            ),
            Location(
                getString(R.string.bali_temple),
                getString(R.string.bali_region),
                R.drawable.location4,
                4.5f,
                "2024-03-01"
            )
        )
    }

    private fun setupViews() {
        // Set up location 1
        findViewById<LinearLayout>(R.id.location1Container).setOnClickListener {
            openDetailActivity(locations[0])
        }
        findViewById<RatingBar>(R.id.location1Rating).rating = locations[0].rating

        // Set up location 2
        findViewById<LinearLayout>(R.id.location2Container).setOnClickListener {
            openDetailActivity(locations[1])
        }
        findViewById<RatingBar>(R.id.location2Rating).rating = locations[1].rating

        // Set up location 3
        findViewById<LinearLayout>(R.id.location3Container).setOnClickListener {
            openDetailActivity(locations[2])
        }
        findViewById<RatingBar>(R.id.location3Rating).rating = locations[2].rating

        // Set up location 4
        findViewById<LinearLayout>(R.id.location4Container).setOnClickListener {
            openDetailActivity(locations[3])
        }
        findViewById<RatingBar>(R.id.location4Rating).rating = locations[3].rating
    }

    private fun openDetailActivity(location: Location) {
        try {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("location", location)
            }
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            // You could also show a Toast here
        }
    }
}