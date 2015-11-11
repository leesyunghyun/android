package com.example.homme;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Homme_Hair_Main extends Activity {

	private TextView tvhairmain1, tvhairmain2, tvhairmain3, tvhairmain4;
	private Button btnhairmain1, btnhairmain2, btnhairmain3;
	private Intent intent;
	private int hairstyle = 0;
	private int hairface = 0;
	private Homme_DB homme;
	private Cursor c;
	private SQLiteDatabase sql;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hairmain);
		tvhairmain1 =(TextView)findViewById(R.id.tvhairmain1);
		tvhairmain2 =(TextView)findViewById(R.id.tvhairmain2);
		tvhairmain3 =(TextView)findViewById(R.id.tvhairmain3);
		tvhairmain4 =(TextView)findViewById(R.id.tvhairmain4);
		btnhairmain1 = (Button)findViewById(R.id.btnhairmain1);
		btnhairmain2 = (Button)findViewById(R.id.btnhairmain2);
		btnhairmain3 = (Button)findViewById(R.id.btnhairmain3);
		
		homme = new Homme_DB(this);
		sql = homme.getReadableDatabase();
		
		
		intent = getIntent();
		c = sql.rawQuery("select * from profile where id='" + intent.getIntExtra("hairname", 0) + "'" , null);
		
		c.moveToFirst();
		
		hairface = Integer.parseInt(c.getString(6));
		hairstyle = Integer.parseInt(c.getString(7));
		
		switch(hairface)
		{
		case 0:
			tvhairmain2.setText("긴 얼굴형");
			tvhairmain2.setTextColor(Color.BLUE);
			break;
		case 1:
			tvhairmain2.setText("타원의 얼굴형");
			tvhairmain2.setTextColor(Color.BLUE);
			break;
		case 2:
			tvhairmain2.setText("사각의 얼굴형");
			tvhairmain2.setTextColor(Color.BLUE);
			break;
		case 3:
			tvhairmain2.setText("둥근 얼굴형");
			tvhairmain2.setTextColor(Color.BLUE);
			break;
		case 4:
			tvhairmain2.setText("다이아몬드의 얼굴형");
			tvhairmain2.setTextColor(Color.BLUE);
			break;
		}
	
		switch(hairstyle)
		{
		case 0:
			tvhairmain4.setText("짧은 길이의 머리");
			tvhairmain4.setTextColor(Color.rgb(255,150,220));
			break;
		case 1:
			tvhairmain4.setText("중간 길이의 머리");
			tvhairmain4.setTextColor(Color.rgb(255,150,220));
			break;
		case 2:
			tvhairmain4.setText("긴 길이의 머리");
			tvhairmain4.setTextColor(Color.rgb(255,150,220));
			break;
		}
		
		
		btnhairmain1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Hair_Main.this, Homme_Hair_Style.class);
				intent.putExtra("hairstyle", hairface);
				startActivity(intent);
			}
		});
		
		btnhairmain2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Hair_Main.this, Homme_Hair_Tip.class);
				startActivity(intent);
			}
		});
		
		btnhairmain3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Hair_Main.this, Homme_Hair_Kind.class);
				startActivity(intent);
			}
		});
	}

}
