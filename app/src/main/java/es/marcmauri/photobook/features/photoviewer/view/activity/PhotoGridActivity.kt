package es.marcmauri.photobook.features.photoviewer.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import es.marcmauri.photobook.R
import es.marcmauri.photobook.app.PhotoBookApp
import es.marcmauri.photobook.databinding.ActivityPhotoGridBinding
import es.marcmauri.photobook.features.photoviewer.view.fragment.PhotoViewerGridFragment

private const val TAG = "D_PhotoGridActivity"

class PhotoGridActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoGridBinding
    private val photoGridFragment by lazy { PhotoViewerGridFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate()")
        binding = ActivityPhotoGridBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as PhotoBookApp).getComponent().inject(this)

        loadFragment(photoGridFragment)
    }

    fun loadFragment(fragment: Fragment) {
        if (!fragment.isAdded) {
            val transaction = supportFragmentManager.beginTransaction()

            if (fragment is PhotoViewerGridFragment) {
                transaction
                    .add(R.id.fragment_container, fragment)
            } else {
                supportActionBar?.hide()
                transaction
                    .addToBackStack(null)
                    .hide(photoGridFragment)
                    .add(R.id.fragment_container, fragment)
            }
            transaction.setTransition(TRANSIT_FRAGMENT_OPEN)
            transaction.commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportActionBar?.show()
    }
}