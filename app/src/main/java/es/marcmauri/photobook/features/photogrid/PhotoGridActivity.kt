package es.marcmauri.photobook.features.photogrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.marcmauri.photobook.R
import es.marcmauri.photobook.app.PhotoBookApp
import es.marcmauri.photobook.databinding.ActivityPhotoGridBinding
import es.marcmauri.photobook.features.photodetail.PhotoDetailFragment
import es.marcmauri.photobook.features.photogrid.adapters.PhotoGridAdapter
import es.marcmauri.photobook.features.photogrid.listeners.RecyclerPhotoGridListener
import es.marcmauri.photobook.utils.Utilities
import es.marcmauri.photobook.utils.snackBar
import javax.inject.Inject

class PhotoGridActivity : AppCompatActivity(), PhotoGridMVP.View {
    private val TAG = "PhotoGridActivity"
    private lateinit var binding: ActivityPhotoGridBinding
    private lateinit var adapter: PhotoGridAdapter
    private var photoList: ArrayList<String> = ArrayList(0)
    private val layoutManager by lazy {
        GridLayoutManager(this, Utilities().getGridSpanCount(resources,  680))
    }
    private var photoDetailFragment: PhotoDetailFragment? = null

    var totalPages = 1 // todo: actualizar este parametro si existe en api
    var currentPage = 0

    private var loading = false
    private var pastVisibleItems = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0

    @Inject
    lateinit var presenter: PhotoGridMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate()")
        binding = ActivityPhotoGridBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as PhotoBookApp).getComponent().inject(this)

        presenter.setView(this)
        presenter.onActivityReady(savedInstanceState)
    }

    override fun configureUI() {
        Log.d(TAG, "configureUI()")
        title = getString(R.string.app_name)
        setAdapter()
        setRecylcerView()
        presenter.getPhotos(0)
    }

    private fun setAdapter() {
        Log.d(TAG, "setAdapter()")
        adapter = PhotoGridAdapter(photoList, object : RecyclerPhotoGridListener {
            override fun onPhotoItemClick(photo: String, position: Int) {
                showSnack("Photo clicked! Position: $position")

                //presenter.onPhotoItemClick(position)
            }

            override fun onPhotoItemLongClick(photo: String, position: Int) {
                photoDetailFragment = PhotoDetailFragment(photo)
                photoDetailFragment!!.show(supportFragmentManager, "PhotoDetailFragment")
            }

            override fun onPhotoItemLongClickReleased() {
                photoDetailFragment?.dismiss()
            }
        })
    }

    private fun setRecylcerView() {
        Log.d(TAG, "setRecylcerView()")
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.itemAnimator = DefaultItemAnimator()
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                visibleItemCount = layoutManager.childCount
                totalItemCount = layoutManager.itemCount
                pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

                if (dy > 0) {
                    if (!loading && ((totalItemCount - visibleItemCount) <= pastVisibleItems)) {

                        if (++currentPage <= totalPages)
                            presenter.getPhotos(currentPage)
                        else {
                            showSnack("T: No hay mas fotos para mostrar")
                            //hideLoading()
                            loading = true // Flag loading as true to avoid this step again
                        }
                    }
                }
            }
        })
        binding.recyclerview.adapter = adapter
    }

    override fun addPhotos(newPhotos: List<String>) {
        Log.d(TAG, "addPhotos(newPhotos.size=${newPhotos.size})")
        newPhotos.forEach { photo ->
            photoList.add(photo)
            binding.recyclerview.post {
                adapter.notifyItemInserted(photoList.size - 1)
            }
        }
    }

    override fun openPhotoInfo(photo: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        Log.d(TAG, "showLoading()")
        binding.progressBarLoadingPhotos.visibility = View.VISIBLE
        loading = true
    }

    override fun hideLoading() {
        Log.d(TAG, "hideLoading()")
        binding.progressBarLoadingPhotos.visibility = View.GONE
        loading = false
    }

    override fun showSnack(text: String) {
        snackBar(text)
    }
}