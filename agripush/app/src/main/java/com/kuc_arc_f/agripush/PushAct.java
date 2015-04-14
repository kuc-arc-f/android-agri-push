package com.kuc_arc_f.agripush;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.RefreshCallback;
import com.parse.SaveCallback;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class PushAct extends ListActivity {
    final String TAG ="PushAct";

    private static AdapterSen             mAdapter;
	//private RadioButton genderFemaleButton;
	//private RadioButton genderMaleButton;
	//private EditText ageEditText;
	//private RadioGroup genderRadioGroup;
    private TextView mLblText_01;

	//public static final String GENDER_MALE = "male";
	//public static final String GENDER_FEMALE = "female";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.push );

		// Track app
		ParseAnalytics.trackAppOpened(getIntent());
        this.mLblText_01 = (TextView) findViewById(R.id.lbl_txt_01);
        init_proc();
	}

    private void init_proc(){
        try
        {
            final ParseQuery<ParseObject> query = ParseQuery.getQuery("SenObject1");
            query.orderByDescending("dtnum");
            query.setLimit( 1 );
            query.findInBackground(new FindCallback<ParseObject>() {
                public void done(List<ParseObject> senList, ParseException e) {
                    if (e == null) {
                        ArrayList lst =  new ArrayList<ItemSensor>();
                        Log.d("score", "Retrieved :  " + senList.size() + " scores");
                        if(senList.size() > 0){
                            ParseObject item = senList.get(0);
                            ItemSensor itm1= new ItemSensor();
                            int iSnum1 = item.getInt("snum1");
                            itm1.setSnum1( String.valueOf(iSnum1) );
                            lst.add(itm1);
                            ItemSensor itm2= new ItemSensor();
                            int iSnum2 = item.getInt("snum2");
                            itm2.setSnum1( String.valueOf(iSnum2) );
                            lst.add(itm2);
                            ItemSensor itm3= new ItemSensor();
                            int iSnum3 = item.getInt("snum3");
                            itm3.setSnum1( String.valueOf(iSnum3) );
                            lst.add(itm3);
                            ItemSensor itm4= new ItemSensor();
                            int iSnum4 = item.getInt("snum4");
                            itm4.setSnum1( String.valueOf(iSnum4) );
                            lst.add(itm4);
                            Long iDnum = item.getLong("dtnum");
                            String s2 =String.valueOf(iSnum1)+ ":" + String.valueOf(iSnum2) + ":"+ String.valueOf(iSnum3) +":" + String.valueOf(iSnum4);
Log.d(TAG, "s=" + s2 + ":dt="+ String.valueOf(iDnum) );
                            String sDate = get_dateString(String.valueOf(iDnum));
                            try
                            {
                                disp_proc(lst);
                            }catch(Exception ex){
                                ex.printStackTrace();
                            }
                            mLblText_01.setText( sDate );
                        }
                    } else {
                        Log.d("score", "Error: " + e.getMessage());
                    }
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    void disp_proc(ArrayList lst) throws Exception{
        try
        {
            mAdapter = new AdapterSen( this, lst );
            setListAdapter(mAdapter);
        }catch(Exception e){  throw e; }
    }
    String get_dateString(String src){
        String ret="";
        if(src.length() >=14){
            //String sYY = src.substring(0, 4);
            String sMM = src.substring(4, 6);
            String sDD = src.substring(6, 8);
            String sHH = src.substring(8, 10);
            String sMI = src.substring(10, 12);
            //String sSS = src.substring(12, 14);

            ret=sMM + "-"+ sDD+ " "+ sHH + ":"+ sMI;
Log.d(TAG, "date.ret="+ ret);
        }

        return ret;
    }

}
