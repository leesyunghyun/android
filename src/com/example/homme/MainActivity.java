package com.example.homme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnHealth, btnMakeup, btnHairstyle;
	private TextView tvname, tvage, tvheight, tvweight, tvfat, tvjob;
	private Homme_DB homme;
	private SQLiteDatabase sql;
	private Cursor c;
	private String strFat;
	private int profile;
	private ImageView ivmain;
	private Uri uri = Uri.parse("default");
	private Bitmap bm = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnHealth = (Button) findViewById(R.id.btnHealth);
		btnHairstyle = (Button) findViewById(R.id.btnHairStyle);
		btnMakeup = (Button) findViewById(R.id.btnMakeup);
		tvname = (TextView) findViewById(R.id.tvName);
		tvage = (TextView) findViewById(R.id.tvAge);
		tvheight = (TextView) findViewById(R.id.tvHeight);
		tvweight = (TextView) findViewById(R.id.tvWeight);
		tvfat = (TextView) findViewById(R.id.tvFat);
		tvjob = (TextView) findViewById(R.id.tvJob);
		ivmain = (ImageView) findViewById(R.id.ivmain);

		float fat;
		int weight, height;
		float fatheight;
		int job;

		homme = new Homme_DB(this);
		sql = homme.getReadableDatabase();

		Intent intent = getIntent();
		profile = intent.getIntExtra("profilename", 0);

		c = sql.rawQuery("select * from profile where id = '" + profile + "';",
				null);
		c.moveToFirst();

		tvname.setText(c.getString(1));
		tvage.setText(c.getString(2));
		tvheight.setText(c.getString(3));
		tvweight.setText(c.getString(4));
		String str = c.getString(10);

		uri = Uri.parse(str);

		if (!uri.toString().equals("default")) {

			try {				
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 4;
				options.inPurgeable = true;
				options.inDither = true;

				Cursor cur = getContentResolver().query(uri, null, null, null,
						null);
				cur.moveToNext();
				String path = cur.getString(cur.getColumnIndex("_data"));
				cur.close();

				bm = BitmapFactory.decodeFile(path, options);
				ivmain.setLayoutParams(new LinearLayout.LayoutParams(320,269));
				ivmain.setImageBitmap(bm);
				ivmain.setTag("outimage");
			} catch (Exception e) {

			}
		} else {
			ivmain.setImageResource(R.drawable.image13);
			ivmain.setLayoutParams(new LinearLayout.LayoutParams(150,126));
			ivmain.setScaleType(ScaleType.FIT_CENTER);
			ivmain.setTag("image13");
		}
		height = Integer.parseInt(c.getString(3));
		weight = Integer.parseInt(c.getString(4));

		fatheight = (float) (height / 100.0);
		fat = weight / (fatheight * fatheight);

		strFat = String.format("%.2f", fat);
		tvfat.setText(strFat);

		job = Integer.parseInt(c.getString(5));
		switch (job) {
		case 0:
			tvjob.setText("초등학생");
			break;
		case 1:
			tvjob.setText("중/고등학생");
			break;
		case 2:
			tvjob.setText("대학생");
			break;
		case 3:
			tvjob.setText("일반인");
			break;
		default:
			tvjob.setText("일반인");
		}

		ivmain.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				AlertDialog.Builder dlg = new AlertDialog.Builder(
						MainActivity.this);
				String str[] = { "변경", "삭제" };
				dlg.setItems(str, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						switch (which) {
						case 0:
							Intent intent = new Intent(Intent.ACTION_PICK);
							intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
							intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
							startActivityForResult(intent, 3);
							break;
						case 1:
							uri = Uri.parse("default");
							sql.execSQL("Update profile set image = '" + uri
									+ "' where id =" + c.getString(0));
							ivmain.setLayoutParams(new LinearLayout.LayoutParams(150,126));
							ivmain.setImageResource(R.drawable.image13);
							
							break;
						}
					}
				});
				dlg.setTitle("하실 작업을 선택해주세요");
				dlg.show();
			}
		});

		btnHealth.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						Homme_Health_Main.class);
				intent.putExtra("fat", strFat);
				startActivity(intent);
			}
		});

		btnHairstyle.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						Homme_Hair_Main.class);
				intent.putExtra("hairname", profile);
				startActivity(intent);
			}
		});

		btnMakeup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						Homme_Skin_Main.class);
				intent.putExtra("skinname", profile);
				startActivity(intent);

			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if (!ivmain.getTag().equals("image13")) {
			bm.recycle();
			bm = null;
		}
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Homme_Profile_Select.activity.finish();
		startActivity(new Intent(MainActivity.this,
				Homme_Profile_Select.class));
		finish();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 3) {
			if (resultCode == Activity.RESULT_OK) {
				uri = data.getData();
				sql.execSQL("Update profile set image = '" + uri
						+ "' where id =" + c.getString(0));

				try {				
					BitmapFactory.Options options = new BitmapFactory.Options();
					options.inSampleSize = 4;
					options.inPurgeable = true;
					options.inDither = true;

					Cursor cur = getContentResolver().query(uri, null, null, null,
							null);
					cur.moveToNext();
					String path = cur.getString(cur.getColumnIndex("_data"));
					cur.close();

					bm = BitmapFactory.decodeFile(path, options);
					ivmain.setLayoutParams(new LinearLayout.LayoutParams(320,269));
					ivmain.setImageBitmap(bm);
					ivmain.setTag("outimage");
				} catch (Exception e) {
					
				}
				Toast.makeText(MainActivity.this, "사진을 정상적으로 변경하였습니다.", 0)
						.show();
			} else {
				Toast.makeText(MainActivity.this, "사진 변경이 취소되었습니다.", 0).show();
			}
		}

	}

}
