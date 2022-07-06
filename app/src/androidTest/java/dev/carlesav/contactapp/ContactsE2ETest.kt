package dev.carlesav.contactapp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dev.carlesav.contactapp.presentation.MainActivity
import dev.carlesav.contactapp.presentation.NavGraphs
import dev.carlesav.contactapp.presentation.ui.theme.ContactAppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@HiltAndroidTest
class NewsEndToEndTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalAnimationApi
    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            ContactAppTheme {

                DestinationsNavHost(navGraph = NavGraphs.root)

            }
        }
    }

    @Test
    fun navigateToArticle() = runTest {
        composeRule
            .onNodeWithTag("card-Contact 1")
            .performClick()

        composeRule
            .onNodeWithTag("detail-Contact 1")
            .assertExists()
    }
}
