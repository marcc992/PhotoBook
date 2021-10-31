package es.marcmauri.photobook.features.photogrid.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import es.marcmauri.photobook.R
import es.marcmauri.photobook.app.PhotoBookApp
import es.marcmauri.photobook.databinding.ActivityPhotoGridBinding
import es.marcmauri.photobook.features.photogrid.view.fragment.PhotoGridFragment

class PhotoGridActivity : AppCompatActivity() {

    private val TAG = "PhotoGridActivity"
    private lateinit var binding: ActivityPhotoGridBinding
    private val photoGridFragment by lazy { PhotoGridFragment() }

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

            if (fragment is PhotoGridFragment) {
                transaction
                    .add(R.id.fragment_container, fragment)
            } else {
                transaction
                    .addToBackStack(null)
                    .hide(photoGridFragment)
                    .add(R.id.fragment_container, fragment)
            }
            transaction.setTransition(TRANSIT_FRAGMENT_OPEN)
            transaction.commit()
        }
    }

//    private val TAG = "PhotoGridActivity"
//    private lateinit var binding: ActivityPhotoGridBinding
//    private lateinit var adapter: PhotoGridAdapter
//    private var photoList: ArrayList<String> = ArrayList(0)
//    private val layoutManager by lazy {
//        GridLayoutManager(this, Utilities().getGridSpanCount(resources, 680))
//    }
//    private var photoPreviewFragment: PhotoPreviewFragment? = null
//
//    var totalPages = 1 // todo: actualizar este parametro si existe en api
//    var currentPage = 0
//
//    private var loading = false
//    private var pastVisibleItems = 0
//    private var visibleItemCount = 0
//    private var totalItemCount = 0
//
//    @Inject
//    lateinit var presenter: PhotoGridMVP.Presenter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d(TAG, "onCreate()")
//        binding = ActivityPhotoGridBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        (application as PhotoBookApp).getComponent().inject(this)
//
//        presenter.setView(this)
//        presenter.onActivityReady(savedInstanceState)
//    }
//
//    override fun configureUI() {
//        Log.d(TAG, "configureUI()")
//        title = getString(R.string.app_name)
//        setAdapter()
//        setRecylcerView()
//        presenter.getPhotos(0)
//    }
//
//    private fun setAdapter() {
//        Log.d(TAG, "setAdapter()")
//        adapter = PhotoGridAdapter(photoList, object : RecyclerPhotoGridListener {
//            override fun onPhotoItemClick(photo: String, position: Int) {
//                showSnack("Photo clicked! Position: $position")
//
//                //presenter.onPhotoItemClick(position)
//            }
//
//            override fun onPhotoItemLongClick(photo: String, position: Int) {
//                photoPreviewFragment = PhotoPreviewFragment(photo)
//                photoPreviewFragment!!.show(supportFragmentManager, "PhotoPreviewFragment")
//            }
//
//            override fun onPhotoItemLongClickReleased() {
//                photoPreviewFragment?.dismiss()
//            }
//        })
//    }
//
//    private fun setRecylcerView() {
//        Log.d(TAG, "setRecylcerView()")
//        binding.recyclerview.setHasFixedSize(true)
//        binding.recyclerview.itemAnimator = DefaultItemAnimator()
//        binding.recyclerview.layoutManager = layoutManager
//        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                visibleItemCount = layoutManager.childCount
//                totalItemCount = layoutManager.itemCount
//                pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
//
//                if (dy > 0) {
//                    if (!loading && ((totalItemCount - visibleItemCount) <= pastVisibleItems)) {
//
//                        if (++currentPage <= totalPages)
//                            presenter.getPhotos(currentPage)
//                        else {
//                            showSnack("T: No hay mas fotos para mostrar")
//                            //hideLoading()
//                            loading = true // Flag loading as true to avoid this step again
//                        }
//                    }
//                }
//            }
//        })
//        binding.recyclerview.adapter = adapter
//    }
//
//    override fun addPhotos(newPhotos: List<String>) {
//        Log.d(TAG, "addPhotos(newPhotos.size=${newPhotos.size})")
//        newPhotos.forEach { photo ->
//            photoList.add(photo)
//            binding.recyclerview.post {
//                adapter.notifyItemInserted(photoList.size - 1)
//            }
//        }
//    }
//
//    override fun openPhotoInfo(photo: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun showLoading() {
//        Log.d(TAG, "showLoading()")
//        binding.progressBarLoadingPhotos.visibility = View.VISIBLE
//        loading = true
//    }
//
//    override fun hideLoading() {
//        Log.d(TAG, "hideLoading()")
//        binding.progressBarLoadingPhotos.visibility = View.GONE
//        loading = false
//    }
//
//    override fun showSnack(text: String) {
//        snackBar(text)
//    }
}