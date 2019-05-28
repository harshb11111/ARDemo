package com.online.vegas.demo.custom;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.online.vegas.demo.GlideApp;
import com.online.vegas.demo.R;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by Harshil.
 */

public class Binding {

    @BindingAdapter("bind:imgRes")
    public static void setImage(ImageView view, String imageUrl) {
        if (imageUrl == null) {
            return;
        }

        GlideApp.with(view)
                .load(imageUrl)
//                .transform(new RoundedCornersTransformation(30, 10))
                .placeholder(R.drawable.noimg)
                .error(R.drawable.noimg)
                .into(view);
    }

//    @BindingAdapter("bind:imgRes")
//    public static void setImage(ImageView view, @DrawableRes int res) {
//       /* if (res == 0) {
//            return;
//        }
//        Glide.with(view).load("android.resource://" + view.getContext().getPackageName() + "/" + res);*/
//        view.setImageResource(res);
//    }

//    @BindingAdapter("bind:imgRes")
//    public static void setImage(ImageView view, String imageUrl) {
//        if (imageUrl == null) {
//            return;
//        }
//        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.drawable.ic_launcher)
//                .error(R.drawable.ic_launcher);
//        Glide.with(view).load(imageUrl).apply(requestOptions).into(view);
//
//    }

//    @BindingAdapter({"bind:text", "bind:prefix"})
//    public static void setData(TextView view, String value, String prefix) {
//        view.setText(String.format("%s %s", value, prefix));
//    }

//    @BindingAdapter("bind:imgRes")
//    public static void setImage(ImageView view, Uri res) {
//        if (res == null) {
//            return;
//        }
//        Glide.with(view).load(res).into(view);
//    }


}
