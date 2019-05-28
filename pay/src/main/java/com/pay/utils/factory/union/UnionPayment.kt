package com.pay.utils.factory.union

import android.content.Context
import com.pay.utils.listener.OnPayListener

interface UnionPayment {

    fun startUnionPayment(context: Context, tn: String, isDebug: Boolean, listener: OnPayListener)
}