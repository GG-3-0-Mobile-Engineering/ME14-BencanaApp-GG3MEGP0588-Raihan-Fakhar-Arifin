package com.r2.disastertracker

import android.view.KeyEvent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressKey
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import kotlinx.coroutines.delay
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun testDialog(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val start_date = "2020-10-20"
        val end_date = "2020-10-30"

//        show dialog
        onView(withId(R.id.btn1)).perform(click())

//        Cancel input
        onView(withText(R.string.text_cancel)).perform(click())

//        show dialog
        onView(withId(R.id.btn1)).perform(click())

//        Give input
        onView(withId(R.id.startDate)).perform(typeText(start_date))
        onView(withId(R.id.endDate)).perform(typeText(end_date))

//        enter input
        onView(withText(R.string.text_ok)).perform(click())

// Kurang checking

    }

    @Test
    fun testSearchView(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

//        Give input disaster
        onView(withId(R.id.sVMain)).perform(typeText("flood"))
        clearTextSearchView("flood")
        onView(withId(R.id.sVMain)).perform(typeText("wind"))
        clearTextSearchView("wind")
        onView(withId(R.id.sVMain)).perform(typeText("earthquake"))
        clearTextSearchView("earthquake")
        onView(withId(R.id.sVMain)).perform(typeText("mist"))
        clearTextSearchView("mist")
        onView(withId(R.id.sVMain)).perform(typeText("fire"))
        clearTextSearchView("fire")

//        Give input disaster
        onView(withId(R.id.sVMain)).perform(typeText("ID-BT"))
        clearTextSearchView("ID-BT")
        onView(withId(R.id.sVMain)).perform(typeText("ID-BE"))
        clearTextSearchView("ID-BE")
        onView(withId(R.id.sVMain)).perform(typeText("ID-JT"))
        clearTextSearchView("ID-JT")
    }

    fun clearTextSearchView(query: String){
        for(i in query) {
            onView(withId(R.id.sVMain)).perform(pressKey(KeyEvent.KEYCODE_DEL))
        }
    }
}