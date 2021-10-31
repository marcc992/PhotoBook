package es.marcmauri.photobook.features.photoviewer.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import es.marcmauri.photobook.app.PhotoBookApp
import es.marcmauri.photobook.databinding.FragmentPhotoDetailBinding
import es.marcmauri.photobook.features.photoviewer.PhotoViewerDetailMVP
import es.marcmauri.photobook.features.photoviewer.model.UnsplashPhoto
import es.marcmauri.photobook.utils.loadByUrl
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val TAG = "D_PhotoDetailFragment"
private const val ARG_PARAM1 = "photo"

class PhotoDetailFragment : Fragment(), PhotoViewerDetailMVP.View {
    // TODO: Rename and change types of parameters
    private var photo: UnsplashPhoto? = null

    private lateinit var binding: FragmentPhotoDetailBinding

    @Inject
    lateinit var presenter: PhotoViewerDetailMVP.Presenter


    override fun onAttach(context: Context) {
        (activity?.application as PhotoBookApp).getComponent().inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            photo = it.getParcelable(ARG_PARAM1)
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment PhotoDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(photo: UnsplashPhoto) =
            PhotoDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, photo)
                }
            }
    }

    override fun configureUI() {
        Log.d(TAG, "configureUI()")
        binding.ivCloseDetail.setOnClickListener {
            presenter.onCloseButtonClick()
        }
    }

    override fun setImage(url: String) {
        Log.d(TAG, "setImage(url = $url)")
        binding.ivPhotoDetail.loadByUrl(url)
    }

    override fun setTitle(title: String) {
        Log.d(TAG, "setTitle(title = $title)")
        binding.tvPhotoDetailTitle.text = title
    }

    override fun setAuthor(author: String) {
        Log.d(TAG, "setAuthor(author = $author)")
        binding.tvPhotoDetailAuthor.text = author
    }

    override fun setDate(date: String) {
        Log.d(TAG, "setDate(date = $date)")
        binding.tvPhotoDetailDate.text = date
    }

    override fun setAdditionalInfoFirst(text: String) {
        Log.d(TAG, "setAdditionalInfoFirst(text = $text)")
        binding.tvPhotoDetailInfoFirst.text = text
    }

    override fun setAdditionalInfoSecond(text: String) {
        Log.d(TAG, "setAdditionalInfoSecond(text = $text)")
        binding.tvPhotoDetailInfoSecond.text = text
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

    override fun showError() {
        TODO("Not yet implemented")
    }
}