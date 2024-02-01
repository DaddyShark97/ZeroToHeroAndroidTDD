package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as App).viewModel

        val adapter = Adapter()
        binding.recyclerView.adapter = adapter
        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            viewModel.add(text)
            binding.inputEditText.setText("")
        }

        viewModel.liveData().observe(this) {
            adapter.update(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.restore(BundleWrapper.Base(savedInstanceState))
    }
}

//interface NotNullSomething<T : Any> {
//    fun show(source:T)
//}
//
//interface NullableSomething<T> {
//    fun showNullable(source: T)
//}
//
//interface ShowNullableString : NullableSomething<String?>{
//
//    class Base : ShowNullableString {
//        override fun showNullable(source: String?) {
//            TODO("Not yet implemented")
//        }
//    }
//}
//
//interface ShowString: NotNullSomething<String> {
//
//    class Base : ShowString {
//
//        override fun show(source: String) {
//            TODO("Not yet implemented")
//        }
//    }
//}