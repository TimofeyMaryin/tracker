package android.realproject.trackerm3.application.additcionaly

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.model.CategoryItemData
import android.realproject.trackerm3.ui.elements.app_el.topbar.CustomTopBar
import android.realproject.trackerm3.ui.elements.app_el.topbar.ForAddictionFragment
import android.realproject.trackerm3.ui.elements.app_el.topbar.TopBarAdditional
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdditionallyFragment(
    content: CategoryItemData,
    viewModel: MainViewModel,
    addViewModel: AdditionallyViewModel
) {
    Scaffold(
        topBar = {
            TopBarAdditional(
                content = content,
                contentUi = {
                    CustomTopBar(
                        height = 50.dp,
                        content = {
                             ForAddictionFragment(viewModel, content = content)
                        }
                    )
                }
            )
        },
        content = {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        if (content.quote != null) {
                            Text(
                                text = stringResource(id = content.quote),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 45.dp, vertical = 20.dp),
                                fontSize = viewModel.fontSizeForQuote.sp,
                                fontStyle = FontStyle.Italic,
                                color = Color.Gray,
                                textAlign = TextAlign.Center,
                                lineHeight = 1.3.em
                            )
                        }
                    }
                    item {
                        Text(
                            text = stringResource(id = content.descToAddiction),
                            lineHeight = 1.7.em,
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                            fontSize = viewModel.fontSizeForTitle.sp
                        )
                    }
                    item {
                        ReactionFragment(addViewModel, index = content.id, mViewModel = viewModel)
                    }
                }

            }
        }
    )
}