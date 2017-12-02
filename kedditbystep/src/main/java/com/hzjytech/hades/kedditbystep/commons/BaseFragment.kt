package com.hzjytech.hades.kedditbystep.commons

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by Hades on 2017/12/2.
 */
open class BaseFragment:Fragment(){
    protected var subscriptions=CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions= CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }
}