package com.zhb.myandroid.framework.test;


import java.io.File;

import com.zhb.myandroid.framework.utils.FileUtils;
import com.zhb.myandroid.framework.utils.LogUtils;

import junit.framework.Assert;


import android.test.AndroidTestCase;

public class FileUtilsTest extends AndroidTestCase {
	private static final String TAG = "MyTest";
	
	public void testHasSD() throws Throwable{
		FileUtils fileUtils = new FileUtils(getContext());
		boolean hasSD = fileUtils.hasSD();
		LogUtils.print(TAG, hasSD+"");
		
		Assert.assertEquals(true, hasSD);
	}
	
	public void testGetSdPath() throws Throwable{
		FileUtils fileUtils = new FileUtils(getContext());
		String sdPath = fileUtils.getSdPath();
		LogUtils.print(TAG, sdPath);
	}
	
	public void testGetFilePath() throws Throwable{
		FileUtils fileUtils = new FileUtils(getContext());
		String filePath = fileUtils.getFilePath();
		LogUtils.print(TAG, filePath);
	}
	
	public void testCreateSDFile() throws Throwable{
		FileUtils fileUtils = new FileUtils(getContext());
		File f = fileUtils.createSDFile("2.txt");
		LogUtils.print(TAG, f.getAbsolutePath());
	}
	
	public void testDeleteSDFile() throws Throwable{
		FileUtils fileUtils = new FileUtils(getContext());
		boolean f = fileUtils.deleteSDFile("1.txt");
		LogUtils.print(TAG, "删除成功与否："+f+"");
	}
	
	public void testWriteSDFile() throws Throwable{
		FileUtils fileUtils = new FileUtils(getContext());
		fileUtils.writeSDFile("123", "2.txt");
		LogUtils.print(TAG, "写完");
	}
	
}
