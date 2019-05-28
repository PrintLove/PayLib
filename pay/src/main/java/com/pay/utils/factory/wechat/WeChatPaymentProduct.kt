package com.pay.utils.factory.wechat

import com.pay.utils.factory.bean.WeChatPayReq
import com.tencent.mm.opensdk.modelpay.PayReq
import com.tencent.mm.opensdk.openapi.WXAPIFactory

class WeChatPaymentProduct : WeChatPayment {

    override fun startWxPayment(wx: WeChatPayReq) {

        val msgApi = WXAPIFactory.createWXAPI(wx.context, null)
        // 将该app注册到微信
        msgApi.registerApp(wx.appId)
        val request = PayReq()
        request.appId = wx.appId
        request.partnerId = wx.partnerId
        request.prepayId = wx.prepayId
        request.packageValue = wx.packageValue
        request.nonceStr = wx.nonceStr
        request.timeStamp = wx.timeStamp
        request.sign = wx.sign
        msgApi.sendReq(request)
    }
}