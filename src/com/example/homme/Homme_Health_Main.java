package com.example.homme;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Homme_Health_Main extends Activity {

	private TextView tvhealthfat1, tvhealthfat2;
	private Button btnhealthmain, btnhealthweight;
	private String strfat;
	private float fat;
	private int fatflag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.healthmain);
		tvhealthfat1 = (TextView) findViewById(R.id.healthfat1);
		tvhealthfat2 = (TextView) findViewById(R.id.healthfat2);
		btnhealthmain = (Button) findViewById(R.id.btnHealthmain);
		btnhealthweight = (Button) findViewById(R.id.btnHealthWeight);

		Intent intent = getIntent();
		strfat = intent.getStringExtra("fat");
		fat = Float.parseFloat(strfat);
		if (fat < 18.5) {
			tvhealthfat1.setText(strfat);
			tvhealthfat1.setTextColor(Color.YELLOW);
			tvhealthfat2.setText(" 이므로 저체중에 해당합니다.");
			fatflag = 0;
		} else if (fat > 18.5 && fat < 22.9) {
			tvhealthfat1.setText(strfat);
			tvhealthfat1.setTextColor(Color.BLUE);
			tvhealthfat2.setText(" 이므로 정상체중에 해당합니다.");
			fatflag = 1;
		} else if (fat > 23.0 && fat < 29.0) {
			tvhealthfat1.setText(strfat);
			tvhealthfat1.setTextColor(Color.YELLOW);
			tvhealthfat2.setText(" 이므로 경도비만에 해당합니다.");
			fatflag = 1;
		} else {
			tvhealthfat1.setText(strfat);
			tvhealthfat1.setTextColor(Color.RED);
			tvhealthfat2.setText(" 이므로 고도비만에 해당합니다.");
			fatflag = 2;
		}

		btnhealthmain.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 헬스운동방법
				startActivity(new Intent(Homme_Health_Main.this,
						Homme_Health_Kind.class));
			}
		});

		btnhealthweight.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Health_Main.this,
						Homme_Health_Weight.class);
				switch (fatflag) {
				case 0:
					intent.putExtra("flag", 0);
					break;
				case 1:
					intent.putExtra("flag", 1);
					break;
				case 2:
					intent.putExtra("flag", 2);
					break;
				default:
					intent.putExtra("flag", 0);
					break;
				}
				startActivity(intent);
			}
		});
	}
}
