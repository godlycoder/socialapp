package id.banidevv.socialapp.common.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    lateinit var binding : T

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingClass = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)
        val invokeLayout = inflateMethod.invoke(null, layoutInflater) as T
        setContentView(invokeLayout.root)

        invokeLayout.also {
            binding = it
        }
    }

    override fun onStart() {
        super.onStart()
        binding.initialBinding()
    }

    open fun T.initialBinding() {}
}