package id.banidevv.socialapp.presenter.user

import com.bumptech.glide.Glide
import id.banidevv.socialapp.R
import id.banidevv.socialapp.common.core.BaseRecyclerAdapter
import id.banidevv.socialapp.databinding.ItemPhotoBinding
import id.banidevv.socialapp.domain.model.PhotoModel

class PhotoAdapter : BaseRecyclerAdapter<PhotoModel, ItemPhotoBinding>() {
    override fun ItemPhotoBinding.bind(item: PhotoModel, position: Int) {
        Glide.with(root.context)
            .load(item.link)
            .placeholder(R.color.grey)
            .into(root)
    }

}
