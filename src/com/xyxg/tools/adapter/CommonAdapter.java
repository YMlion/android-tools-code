/**
 * @项目名称：CommonAdapterTest
 * @文件名：CommonAdapter.java
 * @版本信息：1.0
 * @日期：2015年3月9日
 */
package com.xyxg.tools.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @项目名称：CommonAdapterTest
 * @类名称：CommonAdapter
 * @类描述：
 * @创建人：YMlion
 * @创建时间：2015年3月9日 上午8:31:59
 * @修改人：YMlion
 * @修改时间：2015年3月9日 上午8:31:59
 * @修改备注：
 * @version 1.0
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    
    protected List<T> mDataList;
    
    protected Context mContext;
    
    protected int mLayoutId;
    
    /**
     * 创建一个新的实例 CommonAdapter.
     * 
     * @param context
     *            Interface to global information about an application
     *            environment.
     * @param datas
     *            The datas that the ListView will show.
     * @param layoutId
     *            The layout that the ListView item will show.
     */
    protected CommonAdapter(Context context, List<T> datas, int layoutId) {
        mContext = context;
        mDataList = datas;
        mLayoutId = layoutId;
    }
    
    @Override
    public int getCount() {
        return mDataList.size();
    }
    
    /**
     * mDataList
     * 
     * @return the mDataList
     * @since CodingExample Ver(编码范例查看) 1.0
     */
    
    protected List<T> getDataList() {
        return mDataList;
    }
    
    /**
     * @param mDatas
     *            the mDataList to set
     */
    public void setDatas(T[] mDatas) {
        mDataList = new ArrayList<>();
        for (T t : mDatas) {
            mDataList.add(t);
        }
    }
    
    @Override
    public T getItem(int position) {
        return mDataList.get(position);
    }
    
    @Override
    public long getItemId(int position) {
        return position;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mLayoutId);
        getItemView(holder, getItem(position));
        return holder.getConvertView();
    }
    
    public abstract void getItemView(ViewHolder holder, T t);
}
