package es.marcmauri.photobook.features.photogrid.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.marcmauri.photobook.R
import es.marcmauri.photobook.features.photogrid.listeners.RecyclerPhotoGridListener
import es.marcmauri.photobook.utils.inflate
import es.marcmauri.photobook.utils.loadByUrl

class PhotoGridAdapter(
    private val photos: List<String>,
    private val listener: RecyclerPhotoGridListener
) : RecyclerView.Adapter<PhotoGridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.recycler_photo_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvPhotoTitle.text = photos[position]
        holder.ivPhotoPoster.loadByUrl(photos[position])
        holder.itemView.setOnClickListener {
            listener.onPhotoItemClick(photos[position], position)
        }
    }

    override fun getItemCount() = photos.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPhotoTitle: TextView
        val ivPhotoPoster: ImageView

        init {
            tvPhotoTitle = itemView.findViewById(R.id.tv_photoTitle)
            ivPhotoPoster = itemView.findViewById(R.id.iv_photoPoster)
        }
    }
}