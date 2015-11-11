package com.example.homme;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Homme_Profile_Select extends Activity {

	private Button btnadd, btnnotice;
	private Homme_DB homme;
	private SQLiteDatabase sql;
	private Cursor c;
	private int listCount;
	private String list[] = { "변경", "삭제" };
	private String str[];
	private ArrayList<String> arrayList;
	private ArrayAdapter<String> arrayAdapter;
	private ListView listprofile;
	public static Activity activity;
	private Bitmap bm = null;
	private Uri uri;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profileselect);
		if (LoadingSplash.splashflag == 0) {
			homme = new Homme_DB(this);
			sql = homme.getReadableDatabase();
			sql.execSQL("create table if not exists profile(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, height INTEGER, weight INTEGER, job INTEGER, hairtype INTEGER, hairstyle INTEGER, skintype INTEGER, skinage INTEGER, image TEXT);");

			startActivity(new Intent(Homme_Profile_Select.this,
					LoadingSplash.class));
			LoadingSplash.splashflag = 1;
		}

		listprofile = (ListView) findViewById(R.id.listprofile);
		btnadd = (Button) findViewById(R.id.btnAdd);
		btnnotice = (Button) findViewById(R.id.btnNotice);
		activity = this;

		homme = new Homme_DB(this);
		sql = homme.getReadableDatabase();

		c = sql.rawQuery("select * from profile", null);
		listCount = c.getCount();
		c.moveToFirst();
		arrayList = new ArrayList<String>();
		for (int i = 0; i < listCount; i++) {
			arrayList.add("이름 : " + c.getString(1));
			c.moveToNext();
		}

		arrayAdapter = new MyAdapter(this, android.R.layout.simple_list_item_1,
				arrayList);
		listprofile.setAdapter(arrayAdapter);

		listprofile
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub

						Intent intent = new Intent(Homme_Profile_Select.this,
								MainActivity.class);
						c = sql.rawQuery("select id from profile;", null);
						c.moveToPosition(position);
						intent.putExtra("profilename",
								Integer.parseInt(c.getString(0)));
						startActivity(intent);

					}
				});

		listprofile
				.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub

						c = sql.rawQuery("select * from profile", null);
						c.moveToFirst();

						for (int i = 0; i < position; i++) {
							c.moveToNext();
						}

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Profile_Select.this);
						dlg.setTitle("하실 작업을 선택해 주세요");
						dlg.setItems(list,
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										switch (which) {
										case 0:
											Intent intent = new Intent(
													Homme_Profile_Select.this,
													Homme_Profile_Modify.class);
											intent.putExtra("selectID",
													c.getString(0));
											startActivity(intent);
											break;
										case 1:
											AlertDialog.Builder dlg2 = new AlertDialog.Builder(
													Homme_Profile_Select.this);
											dlg2.setPositiveButton(
													"삭제",
													new DialogInterface.OnClickListener() {

														@Override
														public void onClick(
																DialogInterface dialog2,
																int which) {
															// TODO
															// Auto-generated
															// method stub
															sql.execSQL("delete from profile where id="
																	+ Integer
																			.parseInt(c
																					.getString(0)));
															arrayList.remove(c
																	.getPosition());
															arrayAdapter
																	.notifyDataSetChanged();
														}
													});
											dlg2.setNegativeButton(
													"취소",
													new DialogInterface.OnClickListener() {

														@Override
														public void onClick(
																DialogInterface dialog2,
																int which) {
															// TODO
															// Auto-generated
															// method stub
															dialog2.cancel();
														}
													});
											dlg2.setTitle("정말 삭제하시겠습니까?\n삭제된 자료는 복구가 불가능합니다.");
											dlg2.show();
											break;
										default:
											break;
										}

									}
								});
						dlg.show();
						return true;
					}
				});

		btnadd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Homme_Profile_Select.this,
						Homme_Profile_Make.class));
			}
		});

		btnnotice.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				LinearLayout abc = (LinearLayout) vi.inflate(R.layout.dlgback,
						null);
				AlertDialog.Builder dlg = new AlertDialog.Builder(
						Homme_Profile_Select.this);

				TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
				tvdlg1.setText("\n프로필 한번 누르기 = HOMME 시작 \n프로필 길게 누르기 = 프로필 변경/삭제");

				dlg.setView(abc);
				dlg.setTitle("안내사항");
				dlg.show();
			}
		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout abc = (LinearLayout) vi.inflate(R.layout.dlgback, null);

		TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
		tvdlg1.setText("\n종료하시겠습니까?");

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setView(abc);
		builder.setCancelable(false);
		builder.setPositiveButton("종료", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		builder.show();
	}

	public class MyAdapter extends ArrayAdapter {

		private Activity m_context;
		private ArrayList<String> m_arrayList;
		private ArrayList<LinearLayout> abc;
		public MyAdapter(Activity context, int textViewResourceId,
				ArrayList<String> objects) {
			super(context, textViewResourceId, objects);
			// TODO Auto-generated constructor stub
			m_context = context;
			m_arrayList = objects;
			//
			setCheckBoxList();
		}

		private void setCheckBoxList() {
			abc = new ArrayList<LinearLayout>();
			if (c.moveToFirst()) {
				for (int i = 0; i < m_arrayList.size(); i++) {
					LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					LinearLayout a1 = (LinearLayout) vi.inflate(
							R.layout.profileselectlist, null);
				
					ImageView imv = new ImageView(m_context);
					TextView tv = new TextView(m_context);
					
					tv.setFocusable(false);
					tv.setClickable(false);
					imv.setFocusable(false);
					imv.setClickable(false);
					uri = Uri.parse(c.getString(10));

					if (uri.toString().equals("default")) {
						imv.setImageResource(R.drawable.image13);
					} else {
						BitmapFactory.Options options = new BitmapFactory.Options();
						options.inSampleSize = 16;
						options.inPurgeable = true;
						options.inDither = true;

						Cursor cur = getContentResolver().query(uri, null,
								null, null, null);
						cur.moveToNext();
						String path = cur
								.getString(cur.getColumnIndex("_data"));
						cur.close();

						bm = BitmapFactory.decodeFile(path, options);
						imv.setImageBitmap(bm);
					}
					c.moveToNext();
					tv.setText(m_arrayList.get(i));
					tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
					imv.setLayoutParams(new LinearLayout.LayoutParams(120,101));
					a1.addView(imv);
					a1.addView(tv);
					abc.add(a1);
				}
			}
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			// return m_imagelist.get(position);
			return abc.get(position);
		}

	}
}
