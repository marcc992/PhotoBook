package es.marcmauri.photobook.features.photoviewer.view.adapter

import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.marcmauri.photobook.R
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto
import es.marcmauri.photobook.features.photoviewer.view.listeners.RecyclerPhotoGridListener
import es.marcmauri.photobook.utils.inflate
import es.marcmauri.photobook.utils.loadByUrl

private const val TAG = "D_PhotoGridAdapter"

class PhotoGridAdapter(
    private val photos: List<UnsplashPhoto>,
    private val listener: RecyclerPhotoGridListener
) : RecyclerView.Adapter<PhotoGridAdapter.ViewHolder>() {

    private var isLongClickPressed = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.recycler_photo_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivPhotoPoster.loadByUrl(photos[position].thumbUrl)
        holder.itemView.setOnClickListener {
            listener.onPhotoItemClick(photos[position], position)
        }
        holder.itemView.setOnLongClickListener {
            isLongClickPressed = true
            listener.onPhotoItemLongClick(photos[position], position)
            false
        }
        holder.itemView.setOnTouchListener { view, motionEvent ->
            view.onTouchEvent(motionEvent)
            if (isLongClickPressed && !motionEvent.action.equals(MotionEvent.AXIS_PRESSURE)) {
                isLongClickPressed = false
                listener.onPhotoItemLongClickReleased()
            }
            true
        }

    }

    override fun getItemCount() = photos.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPhotoPoster: ImageView

        init {
            ivPhotoPoster = itemView.findViewById(R.id.iv_photoPoster)
        }
    }
}