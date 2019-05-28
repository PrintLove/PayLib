# PayLib
PayLib 创建

[![](https://jitpack.io/v/PrintLove/PayLib.svg)](https://jitpack.io/#PrintLove/PayLib)

支持支付宝、微信、银联支付


使用方式：
在project gradle 下加入:

	   maven { url 'https://jitpack.io' }

在App module 下加入:

 	implementation 'com.github.PrintLove:PayLib:$version'


调起支付宝支付：
第一个参数是  activity
第二个参数是  从后台获取的支付宝返回的值
地三个参数是  回调

          PaymentManager.startAliPay(this, ali, object : OnPayListener {
                override fun onComplete() {
                }

                override fun onFailure(errorCode: String, errorMsg: String) {
                    Toast.makeText(this@MainActivity, errorMsg, Toast.LENGTH_SHORT).show()
                }

                override fun onSuccess() {
                }
            })
调起银联支付
第一个参数是上下文   
第二个参数是从后台获取的银联的tn号   
第三个参数是 是否是测试还是正式   
第四个参数是  支付的回调   
	
	PaymentManager.startUnionPay(this@MainActivity,"727507215548738090001",true,object : OnPayListener{
                override fun onComplete() {

                }

                override fun onFailure(errorCode: String, errorMsg: String) {
                    Toast.makeText(this@MainActivity, errorMsg, Toast.LENGTH_SHORT).show()
                }

                override fun onSuccess() {
                }

            })
	    
调起微信支付

参数是 从后台获取微信支付预下单的值

		var wx = WeChatPayReq.Builder(this@MainActivity)
                .setAppId("")
                .setNonceStr("")
                .setPackageValue("")
                .setPartnerId("")
                .setPrepayId("")
                .setSign("")
                .setTimeStampr("")
                .setListener(object : OnPayListener{
                    override fun onComplete() {

                    }

                    override fun onFailure(errorCode: String, errorMsg: String) {
                    }

                    override fun onSuccess() {
                    }

                })
                .create()
            PaymentManager.startWxPay(wx)
	

