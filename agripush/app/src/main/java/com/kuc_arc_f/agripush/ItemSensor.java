package com.kuc_arc_f.agripush;

import android.content.Context;
import android.util.Log;

//Item.java
public class ItemSensor {
	private static final  String TAG ="ItemSensor";
	
	private String mSnum1="";
	private String mDtnum="";
	
	public ItemSensor() {
	}

	public String getSnum1() { return mSnum1; }
	public void setSnum1(String src){mSnum1 = src; }

	public String getDtnum() { return mDtnum; }
	public void setDtnum(String src){mDtnum = src; }
}