package es.marcmauri.photobook.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
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

fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId, this, false)!!

fun ImageView.loadByUrl(url: String) =
    Picasso.get().load(url).placeholder(R.drawable.ic_launcher_foreground).fit().centerCrop().into(this)

fun ImageView.loadByResource(resource: Int) = Picasso.get().load(resource).into(this)
