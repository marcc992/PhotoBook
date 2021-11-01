package es.marcmauri.photobook.features.photoviewer.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.marcmauri.photobook.R
import es.marcmauri.photobook.app.PhotoBookApp
import es.marcmauri.photobook.databinding.FragmentPhotoDetailBinding
import es.marcmauri.photobook.features.photoviewer.PhotoViewerDetailMVP
import es.marcmauri.photobook.features.photoviewer.model.entities.UnsplashPhoto
import es.marcmauri.photobook.utils.loadByResource
import es.marcmauri.photobook.utils.loadByUrl
import es.marcmauri.photobook.utils.snackBar
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

private const val TAG = "D_PhotoDetailFragment"
private const val ARG_PHOTO = "photo"

class PhotoViewerDetailFragment : Fragment(), PhotoViewerDetailMVP.View {

    private var photo: UnsplashPhoto? = null
    private lateinit var binding: FragmentPhotoDetailBinding

    @Inject
    lateinit var presenter: PhotoViewerDetailMVP.Presenter


    companion object {
        @JvmStatic
        fun newInstance(photo: UnsplashPhoto) =
            PhotoViewerDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PHOTO, photo)
                }
            }
    }

    override fun onAttach(context: Context) {
        (activity?.application as PhotoBookApp).getComponent().inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            photo = it.getParcelable(ARG_PHOTO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView()")
        binding = FragmentPhotoDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated(...)")
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        photo?.let { photo ->
            Log.d(TAG, "onViewCreated() -> photo ID = ${photo.id}")
            presenter.onFragmentReady(photo)
        }
    }

    override fun configureUI() {
        Log.d(TAG, "configureUI()")
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
        setCloseBehavior()

        photo?.let {
            presenter.getPhotoDetails(it.id)
        }
    }

    private fun setCloseBehavior() {
        binding.ivCloseDetail.setOnClickListener {
            presenter.closeButtonClicked()
        }
    }

    override fun setImage(url: String) {
        Log.d(TAG, "setImage(url = $url)")
        binding.ivPhotoDetail.loadByUrl(url, true)
    }

    override fun setAuthorImage(url: String?) {
        Log.d(TAG, "setAuthorImage(url = $url)")

        if (url.isNullOrEmpty()) {
            binding.ivUserPhoto.loadByResource(R.drawable.ic_profile_photo)
        } else {
            binding.ivUserPhoto.loadByUrl(url)
        }
    }

    override fun setAuthorName(name: String) {
        Log.d(TAG, "setAuthor(author = $name)")
        binding.tvUserName.text = name
    }

    override fun setAuthorInstagram(instagram: String?) {
        Log.d(TAG, "setAuthorInstagram(instagram = $instagram)")

        if (instagram.isNullOrEmpty()) {
            binding.tvUserInstagram.visibility = View.GONE
        } else {
            val instaWithTag = "@$instagram"
            binding.tvUserInstagram.text = instaWithTag
            binding.tvUserInstagram.visibility = View.VISIBLE
        }
    }

    override fun setPhotoDate(date: Date) {
        Log.d(TAG, "setDate(date = $date)")
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE)
        val textDate = resources.getString(
            R.string.fragment_photoviewer_detail_photo_date,
            format.format(date)
        )
        binding.tvPhotoDetailDate.text = textDate
    }

    override fun setCameraMake(make: String) {
        //TODO
        binding.tvPhotoDetailInfoFirst.text = make
    }

    override fun setCameraModel(model: String) {
        // TODO
        binding.tvPhotoDetailInfoSecond.text = model
    }

    override fun setCameraName(name: String) {
        // todo
        showError("Aqui va el nombre: $name")
    }

    override fun closeFragment() {
        Log.d(TAG, "closeFragment()")
        activity?.onBackPressed()
    }

    override fun showLoading() {
        Log.d(TAG, "showLoading()")
        binding.progressLoadingPhotoDetail.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        Log.d(TAG, "hideLoading()")
        binding.progressLoadingPhotoDetail.visibility = View.GONE
    }

    override fun showError(message: String) {
        Log.d(TAG, "showError(message = $message)")
        snackBar(message = message, view = binding.rootView)
    }
}