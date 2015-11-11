package com.example.homme;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Homme_Skin_Main extends Activity {

	private TextView tvskinmain1, tvskinmain2;
	private Button btnskinmain1, btnskinmain2;
	private Homme_DB homme;
	private SQLiteDatabase sql;
	private Cursor c;
	private Intent intent;
	private Intent intent2;
	private int profilename;
	private int skintype, skinage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.skinmain);
		tvskinmain1 = (TextView)findViewById(R.id.tvskinmain1);
		tvskinmain2 = (TextView)findViewById(R.id.tvskinmain2);
		btnskinmain1 = (Button)findViewById(R.id.btnskinmain1);
		btnskinmain2 = (Button)findViewById(R.id.btnskinmain2);
		
		intent = getIntent();
		profilename = intent.getIntExtra("skinname", 0);
		
		homme = new Homme_DB(this);
		sql = homme.getReadableDatabase();
		c = sql.rawQuery("select * from profile where id ='" + profilename + "'", null);
		c.moveToFirst();
		
		skintype = Integer.parseInt(c.getString(8));
		skinage = Integer.parseInt(c.getString(9));
		tvskinmain1.setTextColor(Color.BLUE);
		tvskinmain2.setTextColor(Color.rgb(255, 0, 255));
		
		switch(skinage)
		{
		case 0:
			tvskinmain1.setText("동안피부");
			break;
		case 1:
			tvskinmain1.setText("30대피부");
			break;
		case 2:
			tvskinmain1.setText("40~50대피부");
			break;
		}
		
		switch(skintype)
		{
		case 0:
			tvskinmain2.setText("일반피부");
			break;
		case 1:
			tvskinmain2.setText("건성피부");
			break;
		case 2:
			tvskinmain2.setText("민감성피부");
			break;
		case 3:
			tvskinmain2.setText("복합성피부");
			break;
		case 4:
			tvskinmain2.setText("지성피부");
			break;
		}
		
		btnskinmain1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Skin_Main.this, Homme_Skin_Kind.class);
				intent.putExtra("skintypes", skintype);
				startActivity(intent);
			}
		});
		
		btnskinmain2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str[] = {"피부타입진단","피부나이진단"};
				
				AlertDialog.Builder dlg = new AlertDialog.Builder(
						Homme_Skin_Main.this);		
				dlg.setTitle("피부진단");
				dlg.setItems(str,new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						switch(which)
						{
						case 0:
							intent2 = new Intent(Homme_Skin_Main.this, Homme_Profile_Select_Skin.class);
							intent2.putExtra("activityflag", 1);
							startActivityForResult(intent2, 0);
							break;
						case 1:
							intent2 = new Intent(Homme_Skin_Main.this, Homme_Profile_Select_Skin2.class);
							intent2.putExtra("activityflag", 1);
							startActivityForResult(intent2, 1);
							break;
						}
					}
				});
				dlg.show();

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 0) {
			if (data != null) {
				int skinflag = data.getIntExtra("skinflag2", 0);
				switch(skinflag)
				{
				case 0:
					tvskinmain2.setText("일반피부");
					Toast.makeText(Homme_Skin_Main.this, "당신의 피부는 일반피부입니다.", 0).show();
					break;
				case 1:
					tvskinmain2.setText("건성피부");
					Toast.makeText(Homme_Skin_Main.this, "당신의 피부는 건성피부입니다.", 0).show();
					break;
				case 2:
					tvskinmain2.setText("민감성피부");
					Toast.makeText(Homme_Skin_Main.this, "당신의 피부는 민감성피부입니다.", 0).show();
					break;
				case 3:
					tvskinmain2.setText("복합성피부");
					Toast.makeText(Homme_Skin_Main.this, "당신의 피부는 복합성피부입니다.", 0).show();
					break;
				case 4:
					tvskinmain2.setText("지성피부");
					Toast.makeText(Homme_Skin_Main.this, "당신의 피부는 지성피부입니다.", 0).show();
					break;
				}
				sql.execSQL("update profile set skintype ='" + skinflag + "' where id = '" + profilename + "'");
				skintype = skinflag;
			}
		}
		else if(resultCode == 1)
		{
			int skinage = 0;
			if(data != null)
			{
				int skinagepoint = data.getIntExtra("skinageflag2",0);
				if(skinagepoint<=10)
				{
					tvskinmain1.setText("동안피부");
					skinage = 0;
					Toast.makeText(Homme_Skin_Main.this, "측정된 피부나이는 동안피부입니다.", 0).show();
				}
				else if(skinagepoint>10 && skinagepoint<=20)
				{
					tvskinmain1.setText("30대피부");
					skinage = 1;
					Toast.makeText(Homme_Skin_Main.this, "측정된 피부나이는 30대피부입니다.", 0).show();
				}
				else
				{
					tvskinmain1.setText("40~50대피부");
					skinage = 2;
					Toast.makeText(Homme_Skin_Main.this, "측정된 피부나이는 40~50대피부입니다.", 0).show();
				}
				sql.execSQL("update profile set skinage ='" + skinage + "' where id = '" + profilename + "'");
			}
		}
		
	}

}
