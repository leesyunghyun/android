package com.example.homme;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoadingSplash extends Activity {
	private ProgressDialog progressDialog = null;
	private Homme_DB homme;
	private SQLiteDatabase sql;
	private Cursor c = null;
	public static int splashflag = 0;
	private int toastflag = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loding_splash);
		homme = new Homme_DB(this);

		sql = homme.getReadableDatabase();
		sql.execSQL("create table if not exists profile(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, height INTEGER, weight INTEGER, job INTEGER, hairtype INTEGER, hairstyle INTEGER, skintype INTEGER, skinage INTEGER, image TEXT);");
		progressDialog = new ProgressDialog(this);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setMessage(Html
				.fromHtml("<FONT Color='Black'>프로필 조회중입니다. . .</FONT>"));
		progressDialog.setIcon(0);
		progressDialog.setCancelable(false);

		Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				c = sql.rawQuery("select * from profile", null);

				if (c.moveToFirst()) {
					LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					LinearLayout abc = (LinearLayout) vi.inflate(
							R.layout.dlgback, null);
					TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
					tvdlg1.setText("\n프로필 선택창으로 이동합니다!");
					
					AlertDialog.Builder dlg = new AlertDialog.Builder(
							LoadingSplash.this);
					dlg.setView(abc);
					dlg.setNeutralButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									c.close();
									sql.close();
									finish();
								}
							});
					toastflag = 0;
					dlg.setCancelable(false);
					dlg.show();

				} else {
					toastflag = 1;
					LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					LinearLayout abc = (LinearLayout) vi.inflate(
							R.layout.dlgback, null);
					TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
					tvdlg1.setText("\n프로필이 존재하지 않습니다!\n프로필을 먼저 생성해주세요!");

					AlertDialog.Builder dlg = new AlertDialog.Builder(
							LoadingSplash.this);
					dlg.setView(abc);
					dlg.setNeutralButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									startActivity(new Intent(LoadingSplash.this,
											Homme_Profile_Make.class));
									
									c.close();
									sql.close();
									finish();
								}
							});
					dlg.setCancelable(false);
					dlg.show();
				}
			}
		};

		handler.sendEmptyMessageDelayed(0, 2000);
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				progressDialog.show();
			}
		}, 800);

		progressDialog.setOnDismissListener(new OnDismissListener() {

			@Override
			public void onDismiss(DialogInterface dialog) {
				// TODO Auto-generated method stub
				switch (toastflag) {
				case 0:
					Toast.makeText(getApplicationContext(),
							"Homme 오늘도 완벽한 남자가 되어봐요!", Toast.LENGTH_LONG)
							.show();
					break;
				case 1:
					Toast.makeText(getApplicationContext(),
							"Homme 프로필을 먼저 생성해주세요!", Toast.LENGTH_LONG).show();
					break;
				}
			}
		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		progressDialog.dismiss();
	}

}
