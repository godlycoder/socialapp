package id.banidevv.socialapp.presenter.post

import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import id.banidevv.socialapp.R
import id.banidevv.socialapp.common.core.BaseRecyclerAdapter
import id.banidevv.socialapp.databinding.ItemPostBinding
import id.banidevv.socialapp.domain.model.PostModel


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


class PostAdapter : BaseRecyclerAdapter<PostModel, ItemPostBinding>() {
    override fun ItemPostBinding.bind(item: PostModel, position: Int) {
        tvTitle.text = item.title
        tvUser.text = item.userName
        tvUserCompany.text = item.companyName
        tvBody.text = item.body

        tvTitle.setOnClickListener {
            val data = bundleOf("userId" to item.userId)
            it.findNavController().navigate(R.id.userFragment, data)
        }
    }
}