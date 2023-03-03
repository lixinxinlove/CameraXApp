package com.lixinxinlove.cameraxapp

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.lixinxinlove.cameraxapp", appContext.packageName)
    }


    //指定测试的目标Activity页面
    @Rule
    var mActivityTestRule = ActivityTestRule(WelcomeActivity::class.java, true, true)


    @Test
    fun testLogin() {
        //验证是否显示
//        onView(withId(R.id.login_btn)).check(matches(isDisplayed()))
//
//        //不输入任何内容，直接点击登录按钮
//        onView(withId(R.id.btn_login)).perform(click())
//        //onView(allOf(withId(R.id.btn_login), isDisplayed())).perform(click())
//
//        //只输入用户名
//        onView(withId(R.id.edit_name)).perform(typeText("admin"), closeSoftKeyboard())
//        onView(withId(R.id.btn_login)).perform(click())
//        onView(withId(R.id.edit_name)).perform(clearText())
//
//        //同时输入用户名和密码，但是密码格式不正确
//        onView(withId(R.id.edit_name)).perform(typeText("admin"))
//        onView(withId(R.id.edit_password)).perform(typeText("123"), closeSoftKeyboard())
//        onView(withId(R.id.btn_login)).perform(click())
//        onView(withId(R.id.edit_name)).perform(clearText())
//        onView(withId(R.id.edit_password)).perform(clearText())

        //输入正确的用户名和密码
        onView(withId(R.id.user_name_text)).perform(typeText("admin"))
        onView(withId(R.id.password_text)).perform(typeText("123456"))
        onView(withId(R.id.login_btn)).perform(click())

        //验证内容
        //  onView(withId(R.id.btn_login)).check(matches(withText("登录成功")))
        //  onView(withId(R.id.edit_name)).check(matches(withText("admin")))
        //  onView(withId(R.id.edit_password)).check(matches(withText("123456")))
    }


}


