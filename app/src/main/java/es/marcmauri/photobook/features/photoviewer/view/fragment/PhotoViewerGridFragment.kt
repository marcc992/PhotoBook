package es.marcmauri.photobook.features.photoviewer.view.fragment

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.marcmauri.photobook.app.PhotoBookApp
import es.marcmauri.photobook.databinding.FragmentPhotoGridBinding
import es.marcmauri.photobook.features.photopreview.view.fragment.PhotoPreviewFragment
import es.marcmauri.photobook.features.photoviewer.PhotoViewerGridMVP
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto
import es.marcmauri.photobook.features.photoviewer.view.activity.PhotoGridActivity
import es.marcmauri.photobook.features.photoviewer.view.adapter.PhotoGridAdapter
import es.marcmauri.photobook.features.photoviewer.view.listeners.RecyclerPhotoGridListener
import es.marcmauri.photobook.http.unsplash.UnsplashAPI
import es.marcmauri.photobook.utils.Utilities
import es.marcmauri.photobook.utils.snackBar
import javax.inject.Inject

private const val TAG = "D_PhotoGridFragment"

class PhotoViewerGridFragment : Fragment(), PhotoViewerGridMVP.View {

    @Inject
    lateinit var presenter: PhotoViewerGridMVP.Presenter

    @Inject
    lateinit var unsplashApi: UnsplashAPI

    private lateinit var binding: FragmentPhotoGridBinding
    private lateinit var adapter: PhotoGridAdapter
    private var photoList: ArrayList<UnsplashPhoto> = ArrayList(0)
    private val layoutManager by lazy {
        GridLayoutManager(context, Utilities().getGridSpanCount(resources, 680))
    }
    private var photoPreviewFragment: PhotoPreviewFragment? = null

    var currentPage = 0

    private var loading = false
    private var hasMorePhotos = true
    private var pastVisibleItems = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0


    override fun onAttach(context: Context) {
        (activity?.application as PhotoBookApp).getComponent().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView()")
        binding = FragmentPhotoGridBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        presenter.onFragmentReady()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        layoutManager.spanCount = Utilities().getGridSpanCount(resources, 680)

    }

    override fun configureUI() {
        Log.d(TAG, "configureUI()")
        setAdapter()
        setRecylcerView()
        presenter.getPhotos(++currentPage)  // API pagination starts on page 1
    }

    private fun setAdapter() {
        Log.d(TAG, "setAdapter()")
        adapter = PhotoGridAdapter(photoList, object : RecyclerPhotoGridListener {
            override fun onPhotoItemClick(photo: UnsplashPhoto, position: Int) {
                presenter.onPhotoItemClick(photo)
            }

            override fun onPhotoItemLongClick(photo: UnsplashPhoto, position: Int) {
                photoPreviewFragment = PhotoPreviewFragment(photo.smallUrl)
                photoPreviewFragment!!.show(
                    activity!!.supportFragmentManager,
                    "PhotoPreviewFragment"
                )
            }

            override fun onPhotoItemLongClickReleased() {
                photoPreviewFragment?.dismiss()
            }
        })
    }

    private fun setRecylcerView() {
        Log.d(TAG, "setRecylcerView()")
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.itemAnimator = DefaultItemAnimator()
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                visibleItemCount = layoutManager.childCount
                totalItemCount = layoutManager.itemCount
                pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

                if (!loading && hasMorePhotos
                    && dy > 0 && ((totalItemCount - visibleItemCount) <= pastVisibleItems)
                ) {
                    presenter.getPhotos(++currentPage)
                }
            }
        })
        binding.recyclerview.adapter = adapter
    }

    override fun addPhotos(newPhotos: List<UnsplashPhoto>) {
        Log.d(TAG, "addPhotos(newPhotos.size=${newPhotos.size})")
        newPhotos.forEach { photo ->
            photoList.add(photo)
            binding.recyclerview.post {
                adapter.notifyItemInserted(photoList.size - 1)
            }
        }
    }

    override fun openPhotoInfo(photo: UnsplashPhoto) {
        Log.d(TAG, "openPhotoInfo(photo = ${photo.id})")
        (activity as PhotoGridActivity).loadFragment(PhotoViewerDetailFragment.newInstance(photo))
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

    override fun showNoMorePhotos() {
        hasMorePhotos = false
        snackBar(
            message = "T: No se han encontrado (mas) fotos",
            view = binding.rootView
        );
    }

    override fun showError(message: String) {
        --currentPage
        snackBar(
            message = message,
            view = binding.rootView
        );
    }
}