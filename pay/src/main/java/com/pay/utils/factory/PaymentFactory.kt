package com.pay.utils.factory

import com.pay.utils.factory.alipay.AliPayment
import com.pay.utils.factory.union.UnionPayment
import com.pay.utils.factory.wechat.WeChatPayment

interface PaymentFactory {

    fun createAliPayment() : AliPayment

    fun createUnionPayment() : UnionPayment

    fun createWxPayment() : WeChatPayment

}