package com.zcl;

import com.example.logcollec.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

@SuppressWarnings("deprecation")
public class ImageGalleryAdapter extends BaseAdapter {

	private Context context;
	private int[] image = new int[] { R.drawable.a, R.drawable.b,
	R.drawable.c, R.drawable.d, R.drawable.e };

	public ImageGalleryAdapter(Context context) {
	this.context = context;
	}

	@Override
	public int getCount() { // ȡ��Ҫ��ʾ���ݵ�����
	return image.length;
	}

	@Override
	public Object getItem(int position) { // ÿ����Դ��λ��
	return image[position];
	}

	@Override
	public long getItemId(int position) { // ȡ��ÿ�����ID
	return image[position];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView iv = new ImageView(context);
		iv.setBackgroundColor(0xFFFFFFFF);
		iv.setImageResource(image[position]);
		iv.setScaleType(ImageView.ScaleType.CENTER);
		iv.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,
		LayoutParams.WRAP_CONTENT));
		return iv;
	}

}
