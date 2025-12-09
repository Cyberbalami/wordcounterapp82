package com.example.wordcounterapp82;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWordCountingUi() {
        onView(withId(R.id.editTextInput)).perform(typeText("Hello world test"), closeSoftKeyboard());
        onView(withId(R.id.spinnerMetric)).perform(click());
        onView(withText("Words")).perform(click());
        onView(withId(R.id.buttonCount)).perform(click());
        onView(withId(R.id.textViewResult)).check(matches(withText("Words:3")));
    }

    @Test
    public void testSentenceCountingUi() {
        onView(withId(R.id.editTextInput)).perform(typeText("Hello world. This is a test."), closeSoftKeyboard());
        onView(withId(R.id.spinnerMetric)).perform(click());
        onView(withText("Sentences")).perform(click());
        onView(withId(R.id.buttonCount)).perform(click());
        onView(withId(R.id.textViewResult)).check(matches(withText("Sentences:2")));
    }

    @Test
    public void testCharacterCountingUi() {
        onView(withId(R.id.editTextInput)).perform(typeText("ABC"), closeSoftKeyboard());
        onView(withId(R.id.spinnerMetric)).perform(click());
        onView(withText("Chars")).perform(click());
        onView(withId(R.id.buttonCount)).perform(click());
        onView(withId(R.id.textViewResult)).check(matches(withText("Chars:3")));
    }

    @Test
    public void testNumberCountingUi() {
        onView(withId(R.id.editTextInput)).perform(typeText("A1B2C3"), closeSoftKeyboard());
        onView(withId(R.id.spinnerMetric)).perform(click());
        onView(withText("Numbers")).perform(click());
        onView(withId(R.id.buttonCount)).perform(click());
        onView(withId(R.id.textViewResult)).check(matches(withText("Numbers:3")));
    }
}
