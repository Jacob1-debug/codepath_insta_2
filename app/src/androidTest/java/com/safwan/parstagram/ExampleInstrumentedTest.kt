package com.safwan.parstagram

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.safwan.parstagram", appContext.packageName)
    }
}

"""
This is an Android instrumented test.
The test runs on an Android device and uses the InstrumentationRegistry 
class to get the context of the app under test. It then asserts that the 
package name of the context is "com.safwan.parstagram". The @RunWith(AndroidJUnit4::class)
annotation tells JUnit to run the test using the AndroidJUnit4 class, which provides additional 
functionalities for running Android tests. The @Test annotation indicates that the useAppContext()
method is a test method that should be executed by JUnit.

"""
