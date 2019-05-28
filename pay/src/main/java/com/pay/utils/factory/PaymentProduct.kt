package com.pay.utils.factory

import com.pay.utils.factory.alipay.AliPayment
import com.pay.utils.factory.alipay.AliPaymentProduct
import com.pay.utils.factory.union.UnionPayment
import com.pay.utils.factory.union.UnionPaymentProduct
import com.pay.utils.factory.wechat.WeChatPayment
import com.pay.utils.factory.wechat.WeChatPaymentProduct

class PaymentProduct : PaymentFactory {
    override fun createWxPayment(): WeChatPayment {
        return WeChatPaymentProduct()
    }

    override fun createAliPayment(): AliPayment {
        return AliPaymentProduct()
    }

    override fun createUnionPayment(): UnionPayment {
        return UnionPaymentProduct()
    }


}