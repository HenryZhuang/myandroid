package com.zhb.myandroid.framework.utils;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.content.Context;
import android.os.Environment;

/**
 * 文件操作工具类
 * @author zhb
 *
 */
public class FileUtils {
	private Context context;
	/** SD卡是否存在 **/
	private boolean hasSD = false;
	/** SD卡的路径 **/
	private String sdPath;
	/** 当前程序包的路径 **/
	private String filePath;

	public FileUtils(Context context) {
		this.context = context;
		hasSD = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
		sdPath = Environment.getExternalStorageDirectory().getPath();
		filePath = this.context.getFilesDir().getPath();
	}

	/**
	 * 获取SD卡是否存在
	 * @return
	 */
	public boolean hasSD() {
		return hasSD;
	}

	/**
	 * 获取SD卡路径
	 * @return
	 */
	public String getSdPath() {
		return sdPath;
	}
	
	/**
	 * 当前程序包的路径
	 * @return
	 */
	public String getFilePath() {
		return filePath;
	}
	
	/**
	 * 在SD卡上创建文件
	 * 
	 * @throws IOException
	 */
	public File createSDFile(String fileName) throws IOException {
		File file = new File(sdPath + "//" + fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}

	/**
	 * 删除SD卡上的文件
	 * @param fileName
	 * @return 文件不存在，或者是目录的情况都返回false
	 */
	public boolean deleteSDFile(String fileName) {
		File file = new File(sdPath + "//" + fileName);
		if (file == null || !file.exists() || file.isDirectory())
			return false;
		return file.delete();
	}

	/**
	 * 写入内容到SD卡中的txt文本中 str为内容
	 * @throws IOException 
	 */
	public void writeSDFile(String str, String fileName) throws IOException {
		FileWriter fw = new FileWriter(sdPath + "//" + fileName);
		try {
			fw.write(str);
//			File f = new File(sdPath + "//" + fileName);
//			FileOutputStream os = new FileOutputStream(f);
//			DataOutputStream out = new DataOutputStream(os);
//			out.writeShort(2);
//			out.writeUTF("");
			fw.flush();
			fw.close();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 写入内容到SD卡中的txt文本中 str为内容
	 * @throws IOException 
	 */
	public void writeSDFile2(String str, String fileName) throws IOException {
		File f = new File(sdPath + "//" + fileName);
		FileOutputStream os = new FileOutputStream(f);
		DataOutputStream out = new DataOutputStream(os);
		try {
			out.writeShort(2);
			out.writeUTF("");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 读取SD卡中文本文件
	 * 
	 * @param fileName
	 * @return
	 */
	public String readSDFile(String fileName) {
		StringBuffer sb = new StringBuffer();
		File file = new File(sdPath + "//" + fileName);
		try {
			FileInputStream fis = new FileInputStream(file);
			int c;
			while ((c = fis.read()) != -1) {
				sb.append((char) c);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}