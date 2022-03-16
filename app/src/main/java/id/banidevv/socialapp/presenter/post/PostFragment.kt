package id.banidevv.socialapp.presenter.post

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import id.banidevv.socialapp.R
import id.banidevv.socialapp.common.core.BaseFragment
import id.banidevv.socialapp.databinding.FragmentPostBinding
import id.banidevv.socialapp.domain.Status


/**
 * Created by Muhamad Ribani on 15/03/22.
 * banidevv@gmail.com
 */


@AndroidEntryPoint
class PostFragment : BaseFragment<FragmentPostBinding>() {

    private val postAdapter = PostAdapter().apply {
        setOnItemClickListener { postModel, _ ->
            val data = Gson().toJson(postModel)
            val bundle = bundleOf("post" to data)
            findNavController().navigate(R.id.detailPostFragment, bundle)
        }
    }
    private val viewModel by viewModels<PostViewModel>()

    override fun FragmentPostBinding.initialBinding() {
        rvPost.adapter = postAdapter

        displayPost()
    }

    private fun displayPost() {
        viewModel.getAllPost().observe(this) {
            when(it.status) {
                Status.SUCCESS -> {
                    it.data?.let { data -> postAdapter.setItems(data) }
                }
                Status.ERROR -> {}
                Status.LOADING -> {}
                Status.FINISH -> {}
            }
        }
    }

}