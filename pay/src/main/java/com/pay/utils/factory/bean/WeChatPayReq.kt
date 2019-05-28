package com.pay.utils.factory.bean


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pay.utils.listener.OnPayListener
import com.pay.utils.utils.Common

class WeChatPayReq private constructor(builder: Builder) {

     var appId: String?
     var partnerId: String?
     var prepayId: String?
     var packageValue: String?
     var nonceStr: String?
     var timeStamp: String?
     var sign: String?
    var context: Context? = null
    companion object {
        private var listener: OnPayListener? = null
    }

    init {
        appId = builder.appId
        partnerId = builder.partnerId
        prepayId = builder.prepayId
        packageValue = builder.packageValue
        nonceStr = builder.nonceStr
        timeStamp = builder.timeStamp
        sign = builder.sign
        listener = builder.listener
        context = builder.context
    }

    class Builder constructor(var context: Context) {
        internal var appId: String? = null
        internal var partnerId: String? = null
        internal var prepayId: String? = null
        internal var packageValue: String? = null
        internal var nonceStr: String? = null
        internal var timeStamp: String? = null
        internal var sign: String? = null
        internal var listener: OnPayListener? = null

        fun setAppId(appId: String): Builder = apply {
            this@Builder.appId = appId
        }

        fun setPartnerId(partnerId: String): Builder = apply {
            this@Builder.partnerId = partnerId
        }

        fun setPrepayId(prepayId: String): Builder = apply {
            this@Builder.prepayId = prepayId
        }

        fun setPackageValue(packageValue: String): Builder = apply {
            this@Builder.packageValue = packageValue
        }

        fun setTimeStampr(timeStamp: String): Builder = apply {
            this@Builder.timeStamp = timeStamp
        }

        fun setNonceStr(nonceStr: String): Builder = apply {
            this@Builder.nonceStr = nonceStr
        }

        fun setSign(sign: String): Builder = apply {
            this@Builder.sign = sign
        }

        fun setListener(listener: OnPayListener): Builder = apply {
            this@Builder.listener = listener
        }

        fun create(): WeChatPayReq {
            return WeChatPayReq(this)
        }
    }

    class Receiver : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent == null) {
                return
            }
            var result = intent.extras!!.getInt(Common.WX_PAY_RESULT)
            when (result) {
                0 -> {//支付成功
                    listener?.onSuccess()
                }

                -1 -> {//支付失败
                    listener?.onFailure(Common.PayResult.FAILURE, "支付失败")
                }

                -2 -> {//支付取消
                    listener?.onFailure(Common.PayResult.CANCEL, "支付取消")
                }
            }

        }

    }

}