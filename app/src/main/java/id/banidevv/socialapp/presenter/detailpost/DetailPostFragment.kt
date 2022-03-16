package id.banidevv.socialapp.presenter.detailpost

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import id.banidevv.socialapp.R
import id.banidevv.socialapp.common.core.BaseFragment
import id.banidevv.socialapp.databinding.FragmentDetailPostBinding
import id.banidevv.socialapp.domain.model.PostModel
import id.banidevv.socialapp.domain.Status


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


@AndroidEntryPoint
class DetailPostFragment : BaseFragment<FragmentDetailPostBinding>() {

    private val viewModel by viewModels<DetailPostViewModel>()
    private val commentAdapter = CommentAdapter()
    private var post : PostModel? = null

    override fun FragmentDetailPostBinding.initialBinding() {
        val argsPost = arguments?.getString("post")
        post = Gson().fromJson(argsPost, PostModel::class.java)

        if (post != null) {
            tvTitle.text = post?.title
            tvUser.text = post?.userName
            tvBody.text = post?.body

            tvTitle.setOnClickListener {
                val data = bundleOf("userId" to post?.userId)
                it.findNavController().navigate(R.id.userFragment, data)
            }

            displayComment()
        }

        rvComment.adapter = commentAdapter
    }

    private fun displayComment() {
        post?.id?.let { id ->
            viewModel.getComment(id).observe(this) {
                when(it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { it1 -> commentAdapter.setItems(it1) }
                    }
                    else -> {}
                }
            }
        }
    }
}