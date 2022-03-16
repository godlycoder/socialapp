package id.banidevv.socialapp.presenter.detailpost

import id.banidevv.socialapp.common.core.BaseRecyclerAdapter
import id.banidevv.socialapp.databinding.ItemCommentBinding
import id.banidevv.socialapp.domain.model.CommentModel


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


class CommentAdapter : BaseRecyclerAdapter<CommentModel, ItemCommentBinding>() {
    override fun ItemCommentBinding.bind(item: CommentModel, position: Int) {
        tvName.text = item.authorName
        tvBody.text = item.body

        tvName.setOnClickListener {

        }
    }
}