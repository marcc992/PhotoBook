package es.marcmauri.photobook.features.photodetail

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import es.marcmauri.photobook.R
import es.marcmauri.photobook.utils.loadByUrl

class PhotoDetailFragment(val photoUrl: String) : DialogFragment() {
    private val TAG = "PhotoGridDetailFragment"

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            val photoView = inflater.inflate(R.layout.dialog_photo_detail, null)
            photoView.findViewById<ImageView>(R.id.iv_photoPoster).loadByUrl(photoUrl)
            builder.setView(photoView)
            // Create the AlertDialgo object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}