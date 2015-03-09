/**
 * @��Ŀ���ƣ�CommonAdapterTest
 * @�ļ�����ViewHolder.java
 * @�汾��Ϣ��1.0
 * @���ڣ�2015��3��9��
 */
package com.xyxg.tools.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @��Ŀ���ƣ�CommonAdapterTest
 * @�����ƣ�ViewHolder
 * @��������
 * @�����ˣ�YMlion
 * @����ʱ�䣺2015��3��9�� ����8:58:56
 * @�޸��ˣ�YMlion
 * @�޸�ʱ�䣺2015��3��9�� ����8:58:56
 * @�޸ı�ע��
 * @version 1.0
 */
public class ViewHolder {
    
    private final SparseArray<View> mViews;
    
    private View mConvertView;
    
    private ViewHolder(Context context, ViewGroup parent, int layoutId) {
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        // setTag
        mConvertView.setTag(this);
    }
    
    /**
     * �õ�һ��ViewHolder����
     * 
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId);
        }
        return (ViewHolder) convertView.getTag();
    }
    
    public View getConvertView() {
        return mConvertView;
    }
    
    /**
     * ͨ���ؼ���Id��ȡ���ڵĿؼ������û�������views
     * 
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    
    /**
     * ΪTextView�����ַ���
     * 
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    
    /**
     * ΪImageView����ͼƬ
     * 
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        
        return this;
    }
    
    /**
     * ΪImageView����ͼƬ
     * 
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }
}
