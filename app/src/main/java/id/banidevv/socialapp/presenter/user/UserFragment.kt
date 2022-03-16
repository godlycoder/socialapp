package id.banidevv.socialapp.presenter.user

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.banidevv.socialapp.common.core.BaseFragment
import id.banidevv.socialapp.databinding.FragmentUserBinding
import id.banidevv.socialapp.domain.Status


/**
 * Created by Muhamad Ribani on 16/03/22.
 * banidevv@gmail.com
 */


@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding>() {

    private val viewModel by viewModels<UserViewModel>()

    private var userId: Int? = null

    override fun FragmentUserBinding.initialBinding() {
        userId = arguments?.getInt("userId")

        displayUserDetail()
        displayPhoto()
    }

    private fun displayUserDetail() {
        userId?.let { id ->
            viewModel.getUser(id).observe(this) {
                when(it.status) {
                    Status.SUCCESS -> {
                        binding.apply {
                            tvName.text = it.data?.name
                            tvEmail.text = it.data?.email
                            tvAddress.text = it.data?.address
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    private fun displayPhoto() {
        val adapter = PhotoAdapter()
        binding.rvPhoto.adapter = adapter
        userId?.let { id ->
            viewModel.getPhoto(id).observe(this) {
                when(it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { it1 -> adapter.setItems(it1) }
                    }
                    else -> {}
                }
            }
        }
    }
}