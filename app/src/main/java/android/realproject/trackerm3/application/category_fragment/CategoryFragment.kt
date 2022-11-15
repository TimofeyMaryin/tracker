package android.realproject.trackerm3.application.category_fragment

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.model.navigation.Screen
import android.realproject.trackerm3.ui.elements.app_el.CategoryItem
import android.realproject.trackerm3.ui.elements.app_el.topbar.CustomTopBar
import android.realproject.trackerm3.ui.elements.app_el.topbar.ForMainDisplay
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CategoryFragment(
    mViewModel: MainViewModel,
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopBar(height = 80.dp) { ForMainDisplay(mViewModel) }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            LazyContent(mViewModel = mViewModel, navController = navController)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.background,
                                Color.Transparent
                            )
                        )
                    )
            )
        }

    }


}



@Composable
private fun LazyContent(
    mViewModel: MainViewModel,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(mViewModel.categoryItemData.size) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                CategoryItem(
                    content = mViewModel.categoryItemData[it],
                    modifier = Modifier.clickable {
                        navController.navigate("${Screen.OnBoardingFragment.route}/$it")
                    }
                )
            }

        }
    }
}


