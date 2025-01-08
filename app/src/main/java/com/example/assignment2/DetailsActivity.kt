package com.example.assignment2

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private var currentLocation: Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Get the location data from the intent
        currentLocation = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("location", Location::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("location")
        }

        // Populate the views with location data
        currentLocation?.let { setupViews(it) }
    }

    private fun setupViews(location: Location) {
        // Set up image and title
        findViewById<ImageView>(R.id.detailImage).apply {
            setImageResource(location.imageResourceId)
            contentDescription = location.name
        }

        // Set up text views
        findViewById<TextView>(R.id.detailTitle).text = location.name
        findViewById<TextView>(R.id.detailRegion).text = location.region
        findViewById<TextView>(R.id.lastVisited).text =
            getString(R.string.last_visited, location.lastVisited)

        // Set up rating bar
        findViewById<RatingBar>(R.id.detailRating).apply {
            rating = location.rating
            setOnRatingBarChangeListener { _, newRating, _ ->
                location.rating = newRating

            }
        }
    }
}