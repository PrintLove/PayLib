package com.pay.utils.factory.union

import android.content.Context
import com.pay.utils.activity.UnionActivity
import com.pay.utils.listener.OnPayListener

class UnionPaymentProduct : UnionPayment {

    override fun startUnionPayment(context: Context,tn: String, isDebug: Boolean, listener: OnPayListener) {
        UnionActivity.startA(context, tn, isDebug, listener)
    }
}