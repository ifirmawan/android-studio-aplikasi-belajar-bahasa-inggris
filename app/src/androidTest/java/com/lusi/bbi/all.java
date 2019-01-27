package com.lusi.bbi;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class all {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void all() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction editText = onView(
                allOf(withId(R.id.etUname),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                1)));
        editText.perform(scrollTo(), replaceText("imam"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.etPassword),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        editText2.perform(scrollTo(), replaceText("imam"), closeSoftKeyboard());

        ViewInteraction button = onView(
                allOf(withId(R.id.btnHelp), withText("Help"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                7)));
        button.perform(scrollTo(), click());

        ViewInteraction checkBox = onView(
                allOf(withId(R.id.cbShow), withText("Show Password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0)));
        checkBox.perform(scrollTo(), click());

        pressBack();

        ViewInteraction button2 = onView(
                allOf(withId(R.id.btnLogin), withText("Log In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        button2.perform(scrollTo(), click());

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.bottom_navigation_container),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.myBottomNavigation_ID),
                                        1),
                                0),
                        isDisplayed()));
        frameLayout.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.imgVi),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.imgVi2),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                1)));
        appCompatImageButton.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.imgVi3),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                3)));
        appCompatImageButton2.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.imgVi4),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                5)));
        appCompatImageButton3.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.imgVi),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.imgVi2),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                1)));
        appCompatImageButton4.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withId(R.id.imgVi3),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                5)));
        appCompatImageButton5.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withId(R.id.imgVi5),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                9)));
        appCompatImageButton6.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.imgVi),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withId(R.id.imgVi2),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                1)));
        appCompatImageButton7.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withId(R.id.imgVi3),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                4)));
        appCompatImageButton8.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton9 = onView(
                allOf(withId(R.id.imgVi5),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                7)));
        appCompatImageButton9.perform(scrollTo(), click());

        pressBack();

        ViewInteraction frameLayout2 = onView(
                allOf(withId(R.id.bottom_navigation_container),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.myBottomNavigation_ID),
                                        1),
                                1),
                        isDisplayed()));
        frameLayout2.perform(click());

        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.imgVi),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView4.perform(click());

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.radio_button4), withText("D. My"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                3)));
        appCompatRadioButton.perform(scrollTo(), click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.radio_button1), withText("A. This"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                0)));
        appCompatRadioButton2.perform(scrollTo(), click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton3 = onView(
                allOf(withId(R.id.radio_button1), withText("A. More exciting"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                0)));
        appCompatRadioButton3.perform(scrollTo(), click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton6.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton4 = onView(
                allOf(withId(R.id.radio_button2), withText("B. Which"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                1)));
        appCompatRadioButton4.perform(scrollTo(), click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton7.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton5 = onView(
                allOf(withId(R.id.radio_button3), withText("C. Whom"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                2)));
        appCompatRadioButton5.perform(scrollTo(), click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton8.perform(scrollTo(), click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton9.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton6 = onView(
                allOf(withId(R.id.radio_button1), withText("A. when"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                0)));
        appCompatRadioButton6.perform(scrollTo(), click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton10.perform(scrollTo(), click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton11.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton7 = onView(
                allOf(withId(R.id.radio_button2), withText("B. Your"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                1)));
        appCompatRadioButton7.perform(scrollTo(), click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton12.perform(scrollTo(), click());

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton13.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton8 = onView(
                allOf(withId(R.id.radio_button3), withText("C. Smaller"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                2)));
        appCompatRadioButton8.perform(scrollTo(), click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton14.perform(scrollTo(), click());

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton15.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton9 = onView(
                allOf(withId(R.id.radio_button2), withText("B. He"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                1)));
        appCompatRadioButton9.perform(scrollTo(), click());

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton16.perform(scrollTo(), click());

        ViewInteraction appCompatButton17 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton17.perform(scrollTo(), click());

        ViewInteraction appCompatRadioButton10 = onView(
                allOf(withId(R.id.radio_button3), withText("C. The"),
                        childAtPosition(
                                allOf(withId(R.id.radio_group),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                4)),
                                2)));
        appCompatRadioButton10.perform(scrollTo(), click());

        ViewInteraction appCompatButton18 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton18.perform(scrollTo(), click());

        ViewInteraction appCompatButton19 = onView(
                allOf(withId(R.id.btnconfirm_next), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.quizLayout),
                                        0),
                                5)));
        appCompatButton19.perform(scrollTo(), click());

        ViewInteraction appCompatButton20 = onView(
                allOf(withId(R.id.btnUpload), withText("Send My Score"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        appCompatButton20.perform(scrollTo(), click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tvPenjelasan), withText("Explanation "),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                7)));
        appCompatTextView.perform(scrollTo(), click());

        ViewInteraction appCompatButton21 = onView(
                allOf(withId(R.id.easyShow), withText("Show Explanation Quiz Easy"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton21.perform(click());

        pressBack();

        ViewInteraction frameLayout3 = onView(
                allOf(withId(R.id.bottom_navigation_container),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.myBottomNavigation_ID),
                                        1),
                                2),
                        isDisplayed()));
        frameLayout3.perform(click());

        ViewInteraction appCompatImageView5 = onView(
                allOf(withId(R.id.imgVi),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView5.perform(click());

        pressBack();

        ViewInteraction frameLayout4 = onView(
                allOf(withId(R.id.bottom_navigation_container),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.myBottomNavigation_ID),
                                        1),
                                2),
                        isDisplayed()));
        frameLayout4.perform(click());

        ViewInteraction appCompatImageView6 = onView(
                allOf(withId(R.id.imgVi),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView6.perform(click());

        pressBack();

        ViewInteraction frameLayout5 = onView(
                allOf(withId(R.id.bottom_navigation_container),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.myBottomNavigation_ID),
                                        1),
                                2),
                        isDisplayed()));
        frameLayout5.perform(click());

        ViewInteraction appCompatImageView7 = onView(
                allOf(withId(R.id.imgVi),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v7.widget.CardView")),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageView7.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton22 = onView(
                allOf(withId(android.R.id.button1), withText("yes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton22.perform(scrollTo(), click());
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
