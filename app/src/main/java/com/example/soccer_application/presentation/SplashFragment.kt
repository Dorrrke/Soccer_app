package com.example.soccer_application.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.soccer_application.MainActivity
import com.example.soccer_application.R
import com.example.soccer_application.app
import com.example.soccer_application.domain.models.DataItem
import com.example.soccer_application.domain.viewModels.SplashViewModel
import com.example.soccer_application.domain.viewModels.splashViewModelFactory
import com.example.soccer_application.ui.theme.Soccer_applicationTheme

class SplashFragment : Fragment(R.layout.splash_fragment) {


    lateinit var mainActivity: MainActivity
    lateinit var viewModel: SplashViewModel
    private var matchList: List<DataItem?>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, splashViewModelFactory(activity?.application as app))[SplashViewModel::class.java]
        mainActivity = activity as MainActivity
    }



    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.matchList.observe(viewLifecycleOwner, Observer { initMatchList(it) })
        val navController = findNavController()
        viewModel.getAllMatches()
        return ComposeView(requireContext()).apply {

            setContent {
                Soccer_applicationTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Greeting(viewModel, matchList, navController)
                    }
                    }
                }
            }
        }

    private fun initMatchList(dataItems: List<DataItem?>?) {
        matchList = dataItems
    }


    }



@Composable
fun Greeting(viewModel: SplashViewModel, matchList: List<DataItem?>?, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.pngimg_com___football_png1080), contentDescription = "Ball")
        Text(text = "Soccer application")
        Spacer(modifier = Modifier.height(20.dp))

        while (matchList?.isNullOrEmpty() == true) {
            CircularProgressIndicator( modifier = Modifier.size(32.dp))
        }
        navController.navigate(R.id.action_splashFragment_to_mainFragment)

    }
}
