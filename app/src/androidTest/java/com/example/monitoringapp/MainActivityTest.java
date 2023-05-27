package com.example.monitoringapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {

    }

    @Test
    public void onCreate_loginButtonClicked_responseSuccess() {
        onView(withId(R.id.email_edit_text)).perform(typeText("test@example.com"));
        onView(withId(R.id.password_edit_text)).perform(typeText("password"));
        onView(withId(R.id.login_button)).perform(click());
    }

    @Test
    public void onCreate_loginButtonClicked_responseWorker() {
        onView(withId(R.id.email_edit_text)).perform(typeText("test@example.com"));
        onView(withId(R.id.password_edit_text)).perform(typeText("password"));
        onView(withId(R.id.login_button)).perform(click());
    }
}
