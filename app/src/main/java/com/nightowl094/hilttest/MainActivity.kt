package com.nightowl094.hilttest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nightowl094.hilttest.data.entities.Member
import com.nightowl094.hilttest.utils.Logger
import com.nightowl094.hilttest.view_models.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "nightOwl094-Test"
    }

    @Inject
    lateinit var logger: Logger

    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.insert(
            Member(
                memberIdx = 1,
                memberName = "NightOwl094"
            )
        )

        logger.log("logger test 123")

        viewModel.loadAll().observe(this, { members ->
            Log.d(TAG, "onCreate: members : $members")
        })

    }

}