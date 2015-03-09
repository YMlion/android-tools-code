/**
 * @项目名称：CommonAdapterTest
 * @文件名：ViewHolder.java
 * @版本信息：1.0
 * @日期：2015年3月9日
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
 * @项目名称：CommonAdapterTest
 * @类名称：ViewHolder
 * @类描述：
 * @创建人：YMlion
 * @创建时间：2015年3月9日 上午8:58:56
 * @修改人：YMlion
 * @修改时间：2015年3月9日 上午8:58:56
 * @修改备注：
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
     * 拿到一个ViewHolder对象
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
     * 通过控件的Id获取对于的控件，如果没有则加入views
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
     * 为TextView设置字符串
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
     * 为ImageView设置图片
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
     * 为ImageView设置图片
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
