package com.pay.utils.factory.alipay

import android.annotation.SuppressLint
import android.app.Activity
import com.alipay.sdk.app.PayTask
import com.pay.utils.factory.bean.AliPayResult
import com.pay.utils.factory.bean.ServerException
import com.pay.utils.listener.OnPayListener
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AliPaymentProduct : AliPayment {
    //支付
    @SuppressLint("CheckResult")
    override fun startAliPayment(activity: Activity, orderInfo: String, listener: OnPayListener) {
        Observable.create<Map<String, String>> {
            val payTask = PayTask(activity)
            val result = payTask.payV2(orderInfo, true)
            it.onNext(result)
            it.onComplete()
        }.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                return@map AliPayResult(it)
            }
            .subscribe(object : Observer<AliPayResult> {
                override fun onComplete() {
                    listener?.onComplete()
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: AliPayResult) {
                    when (t.resultStatus) {
                        "9000" ->
                            //成功
                            listener?.onSuccess()
                        else -> {
                            onError(ServerException(t.resultStatus, t.memo))
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    if (e is ServerException) {
                        listener?.onFailure(e.errorCode, e.errorMessage)
                    }
                }

            })
    }
}