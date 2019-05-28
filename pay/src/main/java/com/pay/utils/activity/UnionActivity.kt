package com.pay.utils.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pay.utils.listener.OnPayListener
import com.pay.utils.utils.Common
import com.unionpay.UPPayAssistEx

class UnionActivity : AppCompatActivity() {

    private val tn: String by lazy {
        intent.extras.getString("tn")
    }

    private val isDebug: Boolean by lazy {
        intent.extras.getBoolean("isDebug")
    }

    companion object {

        private lateinit var mListener: OnPayListener

        fun startA(context: Context, tn: String, isDebug: Boolean, listener: OnPayListener) {
            this.mListener = listener
            var intent = Intent(context, UnionActivity::class.java)
            intent.putExtra("tn", tn)
            intent.putExtra("isDebug", isDebug)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UPPayAssistEx.startPay(this, null, null, tn, if (isDebug) "01" else "00")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            mListener?.onFailure("", "支付失败")
        }
        when (data!!.getStringExtra("pay_result")) {

            "success" -> {
                mListener.onSuccess()
                mListener.onComplete()
            }

            "fail" -> {
                mListener.onFailure(Common.PayResult.FAILURE, "支付失败")
                mListener.onComplete()
            }

            "cancel" -> {
                mListener.onFailure(Common.PayResult.CANCEL, "支付取消")
                mListener.onComplete()
            }

        }
        finish()
    }
}