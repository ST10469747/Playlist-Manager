package za.ac.iie.playlistmanager

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import android.widget.RatingBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtSongName = findViewById<EditText>(R.id.txtSongName)
        val txtArtist = findViewById<EditText>(R.id.txtArtist)
        val txtRate = findViewById<RatingBar>(R.id.txtRate)
        val txtComment = findViewById<EditText>(R.id.txtComment)
        val btnPlaylist = findViewById<Button>(R.id.btnPlaylist)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnPlaylist.setOnClickListener{
            txtSongName.visibility = View.VISIBLE
            txtArtist.visibility = View.VISIBLE
            txtRate.visibility = View.VISIBLE
            txtComment.visibility = View.VISIBLE
        }
        btnNext.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen2::class.java).apply {
                putExtra("song", txtSongName.text.toString())
                putExtra("artist", txtArtist.text.toString())
                putExtra("rating", txtRate.rating)
                putExtra("comment", txtComment.text.toString())
            }
            startActivity(intent)
        }

        val btnExit: Button = findViewById(R.id.btnExit)
        btnExit.setOnClickListener {
            finishAffinity()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}