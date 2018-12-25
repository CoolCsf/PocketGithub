package com.csf.pocketgithub

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.util.*

class MApplication : Application() {
    private val activities by lazy { Stack<Activity>() }
    private val activityLifecycleCallbacks = object : ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity?) {

        }

        override fun onActivityResumed(activity: Activity?) {
        }

        override fun onActivityStarted(activity: Activity?) {

        }

        override fun onActivityDestroyed(activity: Activity?) {
            removeActivity(activity)
        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        }

        override fun onActivityStopped(activity: Activity?) {
        }

        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            addActivities(activity)
        }

    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks)
    }

    //清楚栈中所有的activity
    private fun finishAll() {
        activities.forEach {
            it.finish()
        }
        activities.clear()
    }

    fun removeActivity(activity: Activity?) {
        activity?.let {
            activities.remove(it)
        }
    }

    fun getCurrentActivity() = activities.pop()
    fun addActivities(activity: Activity?) {
        activity?.let {
            activities.push(it)
        }
    }
}