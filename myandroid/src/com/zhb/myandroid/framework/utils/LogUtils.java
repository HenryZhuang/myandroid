package com.zhb.myandroid.framework.utils;


/**
 * 日志打印工具类
 * 
 * 功能：日志打印，当打生产版本时可将debugVer改为false
 * 
 * 作者：
 * 
 * 日期：2012 年 12 月 27 日
 * 
 * 引用JAR包：
 * 
 * 说明文档名字及位置：
 * 
 */
import android.util.Log;

public class LogUtils 
{
	private static boolean debugVer = true;
	
	/**
	 * @param tag 日志标记
	 * @param msg 日志信息
	 */
	public static void print(String tag, String msg)
	{
	
		if ((false == debugVer) || (null == msg))
		{
			return;
		}
		
		Log.i(tag, msg);
	}
}
