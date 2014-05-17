package com.zhb.myandroid.framework.utils;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;

public class MyUtils {
	
	
	/**
	 * 拨打电话
	 * 需要在清单文件配置权限 <uses-permission android:name="android.permission.CALL_PHONE"/>
	 * @param context 上下文
	 * @param phoneNum 电话号码
	 */
	public static void callPhone(Context context, String phoneNum){
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));  
		context.startActivity(intent); 
	}
	
	/**
	 * 获取手机IMEI
	 * @param context
	 * @return
	 */
	public static String getIMEI(Context context){
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
	    String imei = tm.getDeviceId();       //取出IMEI，IMEI(International Mobile Equipment Identity)是国际移动设备身份码的缩写，国际移动装备辨识码，是由15位数字组成的"电子串号"，它与每台手机一一对应，而且该码是全世界唯一的。
	    String tel = tm.getLine1Number();     //取出MSISDN，很可能为空，通常指的手机号，是指主叫用户为呼叫GSM PLMN中的一个移动用户所需拨的号码，作用同于固定网PSTN号码；是在公共电话网交换网络编号计划中，唯一能识别移动用户的号码。
	    String iccid = tm.getSimSerialNumber();  //取出ICCID，集成电路卡识别码（固化在手机SIM卡中） ICCID为IC卡的唯一识别号码，共有20位数字组成
	    String imsi = tm.getSubscriberId();     //取出IMSI，国际移动用户识别码（IMSI：International Mobile Subscriber Identification Number）是区别移动用户的标志
	    return imei;
	}


	
	
}
