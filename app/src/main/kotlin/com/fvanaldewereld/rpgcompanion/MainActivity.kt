package com.fvanaldewereld.rpgcompanion


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fvanaldewereld.rpgcompanion.gdocs.business.di.GDOCS_BUSINESS_MODULE
import com.fvanaldewereld.rpgcompanion.gdocs.business.domain.GetGdocsByUrlUseCase
import com.fvanaldewereld.rpgcompanion.ui.theme.RPGCompanionTheme
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(GDOCS_BUSINESS_MODULE)
        }

        val gdocsByUrlUseCase: GetGdocsByUrlUseCase by GlobalContext.get().inject()

        val gdocsUrl = "https://docs.google.com/document/d/1EAJa9JbA9tbGNbyv5AHIherdT34C4Ks6hKyIyDlZ7Os/edit?usp=sharing"

        MainScope().launch{
            val gdocs = gdocsByUrlUseCase.execute(gdocsUrl)

            //TODO Add loader
            setContent {
                RPGCompanionTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background,
                    ) {
                        Text(text= "GDocs Title : ${gdocs.title}")
                    }
                }
            }
        }

    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RPGCompanionTheme {
        Text(text= "Document Title : Example title")
    }
}
