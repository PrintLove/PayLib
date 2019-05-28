package com.pay.utils.factory.wechat

import com.pay.utils.factory.bean.WeChatPayReq

interface WeChatPayment {

    fun startWxPayment(wx : WeChatPayReq)

}