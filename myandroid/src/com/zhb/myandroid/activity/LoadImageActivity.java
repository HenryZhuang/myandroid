package com.zhb.myandroid.activity;


import java.io.IOException;

import com.zhb.myandroid.framework.utils.FileUtils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 
 * 一张图片：1920*2560
 * 实际占用空间为：1920*2560个点，如果每个点采用RGB，1个点3个字节
1920*2560*3/1024/1024约等于14M
如果有透明度Alpha则每个点是4个字节
 *如果手机屏幕只有320*480 hdpi
 *宽度的倍数：1920/320  6
 *高度的倍数：2560/480  5.333333。。。
 *
 *应该按照啊倍数高的6进行缩放，会出现如果图片居中高度上下会空出一点
 */
public class LoadImageActivity extends Activity {
	ImageView imgView;
	private int windowHeight;
	private int windowWidth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhb_load_image_activity);
		//得到手机屏幕的高度
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		windowHeight = wm.getDefaultDisplay().getHeight();
		windowWidth = wm.getDefaultDisplay().getWidth();
		
		
		
		//下面是在Android3.0往上使用的获取方式
//		Point outSize = new Point();
//		wm.getDefaultDisplay().getSize(outSize);
//		outSize.x;
//		outSize.y;
		
		imgView = (ImageView) this.findViewById(R.id.imgView);
		Button btn = (Button) this.findViewById(R.id.testBtn);
		btn.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				load();
			}
			
		});
		
	}
	public void load(){
//		String imagePath = "/storage/sdcard0/Pictures/Screenshots/7c6c1b05dab14ec7b2cad7146d08cad5.jpg";
		String imagePath = "/storage/emulated/legacy/Pictures/1.jpeg";
//		System.out.println(new FileUtils(this).getSdPath());
		
		Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
		imgView.setImageBitmap(bitmap);
	}
	
	public void load2(){
		BitmapFactory.Options opts = new Options();
		opts.inJustDecodeBounds = true;
		//不去真的解析图片，只是获取图片的头部信息 宽高
		String imagePath = "/storage/sdcard0/Pictures/Screenshots/7c6c1b05dab14ec7b2cad7146d08cad5.jpg";
		BitmapFactory.decodeFile(imagePath, opts);
		int imageHeight = opts.outHeight;
		int imageWidth = opts.outWidth;
		System.out.println("图片宽："+imageWidth);
		System.out.println("图片高："+imageHeight);
		
		//计算缩放比例
		int scaleX = imageWidth/windowWidth;
		int scaleY = imageHeight/windowHeight;
		
		int scale = 1;
		if(scaleX>scaleY & scaleY>=1){
			scale = scaleX;
		}
		if(scaleY>scaleX & scaleX>=1){
			scale = scaleY;
		}		
		//真的解析图片
		opts.inJustDecodeBounds = false;
		opts.inSampleSize = scale;
		Bitmap bitmap = BitmapFactory.decodeFile(imagePath, opts);
		imgView.setImageBitmap(bitmap);
	}
	
	/**
	 * 读取图片的exif信息
	 */
	public void readImageExifInfo(){
		String filename = "";
		try {
			ExifInterface exif = new ExifInterface(filename);
			String time = exif.getAttribute(ExifInterface.TAG_DATETIME);
			String model = exif.getAttribute(ExifInterface.TAG_MODEL);
			System.out.println("time:"+time);
			System.out.println("model:"+model);
			
//			exif.setAttribute(tag, value);同样可以设置信息
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
