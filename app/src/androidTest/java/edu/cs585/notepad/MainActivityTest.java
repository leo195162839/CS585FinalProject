package edu.cs585.notepad;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("New Note"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.text_editor));
        appCompatEditText.perform(scrollTo(), replaceText("Testing"), closeSoftKeyboard());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.title), withText("Save"), isDisplayed()));
        appCompatTextView2.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.title), withText("New Note"), isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.text_editor));
        appCompatEditText2.perform(scrollTo(), replaceText("Testing2"), closeSoftKeyboard());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(R.id.title), withText("Save"), isDisplayed()));
        appCompatTextView4.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView5 = onView(
                allOf(withId(R.id.title), withText("New Note"), isDisplayed()));
        appCompatTextView5.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                withId(R.id.text_editor));
        appCompatEditText3.perform(scrollTo(), replaceText("Testing3"), closeSoftKeyboard());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView6 = onView(
                allOf(withId(R.id.title), withText("Save"), isDisplayed()));
        appCompatTextView6.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView7 = onView(
                allOf(withId(R.id.title), withText("New Note"), isDisplayed()));
        appCompatTextView7.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                withId(R.id.text_editor));
        appCompatEditText4.perform(scrollTo(), replaceText("1234"), closeSoftKeyboard());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView8 = onView(
                allOf(withId(R.id.title), withText("Save"), isDisplayed()));
        appCompatTextView8.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.listView),
                                withParent(withId(android.R.id.content))),
                        1),
                        isDisplayed()));
        linearLayout.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView9 = onView(
                allOf(withId(R.id.title), withText("Discard"), isDisplayed()));
        appCompatTextView9.perform(click());

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.listView),
                                withParent(withId(android.R.id.content))),
                        0),
                        isDisplayed()));
        linearLayout2.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView10 = onView(
                allOf(withId(R.id.title), withText("Discard"), isDisplayed()));
        appCompatTextView10.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView11 = onView(
                allOf(withId(R.id.title), withText("New Note"), isDisplayed()));
        appCompatTextView11.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                withId(R.id.text_editor));
        appCompatEditText5.perform(scrollTo(), replaceText("End test"), closeSoftKeyboard());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView12 = onView(
                allOf(withId(R.id.title), withText("Save"), isDisplayed()));
        appCompatTextView12.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
