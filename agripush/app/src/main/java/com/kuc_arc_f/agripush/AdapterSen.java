package com.kuc_arc_f.agripush;
import java.util.List;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdapterSen extends ArrayAdapter<ItemSensor> {
	static String TAG ="AdapterSen";
	
	private LayoutInflater mInflater;
	//private String m_TYP_PORT_600 ="";
	Context mContext;
	
	public AdapterSen(Context context, List<ItemSensor> objects) {
		super(context, 0, objects);
		mContext = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;

		if (convertView == null) {
            view = mInflater.inflate(R.layout.push_row   , null);
		}
		ItemSensor item = this.getItem(position);
		if (item != null) {
			try
			{
                String s_num="";
                TextView t_txt = (TextView) view.findViewById(R.id.lbl_tit );
                TextView t_val = (TextView) view.findViewById(R.id.lbl_value);
                if(position==0){
                    t_txt.setText("Sensor-1");
                }
                else if(position==1){
                    t_txt.setText("Sensor-2");
                }
                else if(position==2){
                    t_txt.setText("Sensor-3");
                }
                else if(position==3){
                    t_txt.setText("Sensor-4");
                }
                s_num  = item.getSnum1();
                t_val.setText(s_num);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return view;
	}
	
}