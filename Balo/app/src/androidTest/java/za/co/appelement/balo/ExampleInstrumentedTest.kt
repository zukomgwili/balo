package za.co.appelement.balo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import za.co.appelement.balo.ui.theme.BaloTheme

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule val componentTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("za.co.appelement.balo", appContext.packageName)
    }

    @Test
    fun shouldStartGameWhenTheStartButtonIsTapped(){
        componentTestRule.setContent {
            BaloTheme {
                App()
            }
        }

        componentTestRule.onNodeWithText("start").performClick()

        componentTestRule.onNodeWithText("factor").assertIsDisplayed()
    }
}