package com.pay.utils.factory.alipay

import android.app.Activity
import com.pay.utils.listener.OnPayListener

interface AliPayment {

    fun startAliPayment(activity: Activity, orderInfo: String, listener: OnPayListener)
}