package es.marcmauri.photobook.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import es.marcmauri.photobook.R

fun Activity.snackBar(
    message: CharSequence,
    view: View? = findViewById(R.id.root_view),
    duration: Int = Snackbar.LENGTH_SHORT,
    action: String? = null,
    actionEvt: (v: View) -> Unit = {}
) {
    if (view != null) {
        val snackBar = Snackbar.make(view, message, duration)
        if (!action.isNullOrEmpty()) {
            snackBar.setAction(action, actionEvt)
        }
        snackBar.show()
    }
}

fun Fragment.snackBar(
    message: CharSequence,
    view: View,
    duration: Int = Snackbar.LENGTH_SHORT,
    action: String? = null,
    actionEvt: (v: View) -> Unit = {}
) {
    val snackBar = Snackbar.make(view, message, duration)
    if (!action.isNullOrEmpty()) {
        snackBar.setAction(action, actionEvt)
    }
    snackBar.show()
}

fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId, this, false)!!

fun ImageView.loadByUrl(url: String, centerInside: Boolean? = false) {
    if (centerInside!!) {
        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_foreground).fit().centerInside()
            .into(this)
    } else {
        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_foreground).fit().centerCrop()
            .into(this)
    }
}


fun ImageView.loadByResource(resource: Int) = Picasso.get().load(resource).into(this)
