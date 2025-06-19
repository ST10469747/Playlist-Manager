package za.ac.iie.playlistmanager

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView


class DetailedViewScreen2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen2)

        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        val btnAver = findViewById<Button>(R.id.btnAver)
        val txtAverage = findViewById<TextView>(R.id.txtAverage)

        val txtSongName = intent.getStringExtra("song")
        val txtArtist = intent.getStringExtra("artist")
        val txtRating = intent.getFloatExtra("rating", 0f)
        val txtComment = intent.getStringExtra("comment")

        btnSearch.setOnClickListener{
            val display = """
                SongName: $txtSongName
                Artist: $txtArtist
                rating: $txtRating
                Comment: $txtComment\
                """.trimIndent()
            txtResults.text = display

            val ratings = intent.getFloatArrayExtra("ratings")?: floatArrayOf()
           btnAver.setOnClickListener{
               var sum = 0f
               for (rate in ratings) {
                   sum += rate
               }
               val average = if (ratings.isNotEmpty()) sum / ratings.size else 0f
               txtAverage.text = "Average Rating: $average"

           }



        }






        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}