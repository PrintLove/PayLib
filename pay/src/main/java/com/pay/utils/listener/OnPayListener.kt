package com.pay.utils.listener

interface OnPayListener {

    fun onSuccess()

    fun onFailure(errorCode : String,errorMsg : String)

    fun onComplete()
}