package com.example.homme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Homme_Profile_Modify extends Activity {

	private Homme_DB homme;
	private SQLiteDatabase sql;
	private TextView tvnotice;
	private EditText etName, etAge, etHei, etWei, etskinage;
	private RadioGroup rgjob, rghairtype, rghairstyle, rgskintype;
	private RadioButton rbelmntStd, rbmhStd, rbunivStd, rbhuman;
	private RadioButton rbhairface1, rbhairface2, rbhairface3, rbhairface4,
			rbhairface5;
	private RadioButton rbhairShort, rbhairMiddle, rbhairLong;
	private RadioButton rbskinRadio0, rbskinRadio1, rbskinRadio2, rbskinRadio3,
			rbskinRadio4;
	private Button btnModify, btnCancel, btnskinTest, btnskinage, btnfacetype,
			btnimage;
	private Cursor c;
	private Uri uri = Uri.parse("default");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profilemake);
		homme = new Homme_DB(this);
		sql = homme.getReadableDatabase();
		Intent intent = getIntent();

		c = sql.rawQuery(
				"select * from profile where id = "
						+ Integer.parseInt(intent.getStringExtra("selectID")),
				null);
		c.moveToFirst();

		tvnotice = (TextView) findViewById(R.id.tvnotice);
		etName = (EditText) findViewById(R.id.editName);
		etAge = (EditText) findViewById(R.id.editAge);
		etHei = (EditText) findViewById(R.id.editHeight);
		etWei = (EditText) findViewById(R.id.editWeight);
		etskinage = (EditText) findViewById(R.id.editskinage);

		rgjob = (RadioGroup) findViewById(R.id.rgJob);
		rghairtype = (RadioGroup) findViewById(R.id.rghairType);
		rghairstyle = (RadioGroup) findViewById(R.id.rghairStyle);
		rgskintype = (RadioGroup) findViewById(R.id.rgskinType);

		rbelmntStd = (RadioButton) findViewById(R.id.elmntStd);
		rbmhStd = (RadioButton) findViewById(R.id.mhStd);
		rbunivStd = (RadioButton) findViewById(R.id.UnivStd);
		rbhuman = (RadioButton) findViewById(R.id.human);
		rbhairface1 = (RadioButton) findViewById(R.id.hairface1);
		rbhairface2 = (RadioButton) findViewById(R.id.hairface2);
		rbhairface3 = (RadioButton) findViewById(R.id.hairface3);
		rbhairface4 = (RadioButton) findViewById(R.id.hairface4);
		rbhairface5 = (RadioButton) findViewById(R.id.hairface5);

		rbhairShort = (RadioButton) findViewById(R.id.hairShort);
		rbhairMiddle = (RadioButton) findViewById(R.id.hairMiddle);
		rbhairLong = (RadioButton) findViewById(R.id.hairLong);
		rbskinRadio0 = (RadioButton) findViewById(R.id.skinRadio0);
		rbskinRadio1 = (RadioButton) findViewById(R.id.skinRadio1);
		rbskinRadio2 = (RadioButton) findViewById(R.id.skinRadio2);
		rbskinRadio3 = (RadioButton) findViewById(R.id.skinRadio3);
		rbskinRadio4 = (RadioButton) findViewById(R.id.skinRadio4);

		btnModify = (Button) findViewById(R.id.btnMake);
		btnCancel = (Button) findViewById(R.id.btnCancel);
		btnskinTest = (Button) findViewById(R.id.btnskintest);
		btnskinage = (Button) findViewById(R.id.btnskinage);
		btnfacetype = (Button) findViewById(R.id.btnfaceselect);
		btnimage = (Button) findViewById(R.id.btnImage);

		tvnotice.setText("프로필을 수정해주세요");
		btnModify.setText("수정");
		etName.setText(c.getString(1));
		etAge.setText(c.getString(2));
		etHei.setText(c.getString(3));
		etWei.setText(c.getString(4));
		uri = Uri.parse(c.getString(10));
		switch (Integer.parseInt(c.getString(5))) {
		case 0:
			rbelmntStd.setChecked(true);
			break;
		case 1:
			rbmhStd.setChecked(true);
			break;
		case 2:
			rbunivStd.setChecked(true);
			break;
		case 3:
			rbhuman.setChecked(true);
			break;
		}

		switch (Integer.parseInt(c.getString(6))) {
		case 0:
			rbhairface1.setChecked(true);
			break;
		case 1:
			rbhairface2.setChecked(true);
			break;
		case 2:
			rbhairface3.setChecked(true);
			break;
		case 3:
			rbhairface4.setChecked(true);
			break;
		case 4:
			rbhairface5.setChecked(true);
			break;
		}

		switch (Integer.parseInt(c.getString(7))) {
		case 0:
			rbhairShort.setChecked(true);
			break;
		case 1:
			rbhairMiddle.setChecked(true);
			break;
		case 2:
			rbhairLong.setChecked(true);
			break;
		}

		switch (Integer.parseInt(c.getString(8))) {
		case 0:
			rbskinRadio0.setChecked(true);
			break;
		case 1:
			rbskinRadio1.setChecked(true);
			break;
		case 2:
			rbskinRadio2.setChecked(true);
			break;
		case 3:
			rbskinRadio3.setChecked(true);
			break;
		case 4:
			rbskinRadio4.setChecked(true);
			break;
		}

		switch (Integer.parseInt(c.getString(9))) {
		case 0:
			etskinage.setText("동안피부");
			break;
		case 1:
			etskinage.setText("30대피부");
			break;
		case 2:
			etskinage.setText("40~50대피부");
			break;
		default:
			break;
		}

		btnimage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_PICK);
				intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
				intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, 3);
			}
		});

		btnfacetype.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Profile_Modify.this,
						Homme_Profile_Hair.class);
				startActivityForResult(intent, 2);
			}
		});

		btnskinage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Profile_Modify.this,
						Homme_Profile_Select_Skin2.class);
				startActivityForResult(intent, 1);
			}
		});

		btnskinTest.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Profile_Modify.this,
						Homme_Profile_Select_Skin.class);
				startActivityForResult(intent, 0);
			}
		});

		btnModify.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!etName.getText().toString().isEmpty()
						&& !etAge.getText().toString().isEmpty()
						&& !etHei.getText().toString().isEmpty()
						&& !etWei.getText().toString().isEmpty()
						&& !etskinage.getText().toString().isEmpty()) {
					int age, hei, wei;
					String name;
					int job, hairtype, hairstyle, skintype, skinage;

					switch (rgjob.getCheckedRadioButtonId()) {
					case R.id.elmntStd:
						job = 0;
						break;
					case R.id.mhStd:
						job = 1;
						break;
					case R.id.UnivStd:
						job = 2;
						break;
					case R.id.human:
						job = 3;
						break;
					default:
						job = 0;
					}

					switch (rghairtype.getCheckedRadioButtonId()) {
					case R.id.hairface1:
						hairtype = 0;
						break;
					case R.id.hairface2:
						hairtype = 1;
						break;
					case R.id.hairface3:
						hairtype = 2;
						break;
					case R.id.hairface4:
						hairtype = 3;
						break;
					case R.id.hairface5:
						hairtype = 4;
						break;
					default:
						hairtype = 0;
						break;
					}

					switch (rghairstyle.getCheckedRadioButtonId()) {
					case R.id.hairShort:
						hairstyle = 0;
						break;
					case R.id.hairMiddle:
						hairstyle = 1;
						break;
					case R.id.hairLong:
						hairstyle = 2;
						break;
					default:
						hairstyle = 0;
						break;
					}

					switch (rgskintype.getCheckedRadioButtonId()) {
					case R.id.skinRadio0:
						skintype = 0;
						break;
					case R.id.skinRadio1:
						skintype = 1;
						break;
					case R.id.skinRadio2:
						skintype = 2;
						break;
					case R.id.skinRadio3:
						skintype = 3;
						break;
					case R.id.skinRadio4:
						skintype = 4;
						break;
					default:
						skintype = 0;
						break;
					}

					if (etskinage.getText().toString().equals("동안피부")) {
						skinage = 0;
					} else if (etskinage.getText().toString().equals("30대피부")) {
						skinage = 1;
					} else {
						skinage = 2;
					}

					age = Integer.parseInt(etAge.getText().toString());
					hei = Integer.parseInt(etHei.getText().toString());
					wei = Integer.parseInt(etWei.getText().toString());
					name = etName.getText().toString();

					// TODO Auto-generated method stub
					sql.execSQL("Update profile set name = '" + name
							+ "', age = '" + age + "', height = '" + hei
							+ "', weight ='" + wei + "', job ='" + job
							+ "', hairtype ='" + hairtype + "', hairstyle = '"
							+ hairstyle + "', skintype = '" + skintype
							+ "', skinage = '" + skinage + "', image = '" + uri
							+ "' where id =" + c.getString(0));
					// 변경작업
					sql.close();
					Homme_Profile_Select.activity.finish();
					startActivity(new Intent(Homme_Profile_Modify.this,
							Homme_Profile_Select.class));
					finish();
				} else {
					Toast.makeText(getApplicationContext(), "전부 입력해 주세요!",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		btnCancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder dlg = new AlertDialog.Builder(
						Homme_Profile_Modify.this);
				dlg.setTitle("변경작업을 취소하시겠습니까?");
				dlg.setPositiveButton("확인",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								finish();
							}
						});
				dlg.setNegativeButton("취소",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								dialog.cancel();
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
				int skinflag = data.getIntExtra("skinflag", 0);
				switch (skinflag) {
				case 0:
					rbskinRadio0.setChecked(true);
					break;
				case 1:
					rbskinRadio1.setChecked(true);
					break;
				case 2:
					rbskinRadio2.setChecked(true);
					break;
				case 3:
					rbskinRadio3.setChecked(true);
					break;
				case 4:
					rbskinRadio4.setChecked(true);
					break;
				}
			}
		} else if (resultCode == 1) {
			if (data != null) {
				int skinagepoint = data.getIntExtra("skinageflag", 0);
				if (skinagepoint <= 10) {
					etskinage.setText("동안피부");
					Toast.makeText(Homme_Profile_Modify.this,
							"측정된 피부나이는 동안피부입니다.", 0).show();
				} else if (skinagepoint > 10 && skinagepoint <= 20) {
					etskinage.setText("30대피부");
					Toast.makeText(Homme_Profile_Modify.this,
							"측정된 피부나이는 30대피부입니다.", 0).show();
				} else {
					etskinage.setText("40~50대피부");
					Toast.makeText(Homme_Profile_Modify.this,
							"측정된 피부나이는 40~50대피부입니다.", 0).show();
				}
			}
		} else if (resultCode == 2) {
			if (data != null) {
				int facetype = data.getIntExtra("facetype", 0);
				switch (facetype) {
				case 0:
					rbhairface1.setChecked(true);
					Toast.makeText(Homme_Profile_Modify.this,
							"선택하신 얼굴형은 긴 얼굴형 입니다.", 0).show();
					break;
				case 1:
					rbhairface2.setChecked(true);
					Toast.makeText(Homme_Profile_Modify.this,
							"선택하신 얼굴형은 타원의 얼굴형 입니다.", 0).show();
					break;
				case 2:
					rbhairface3.setChecked(true);
					Toast.makeText(Homme_Profile_Modify.this,
							"선택하신 얼굴형은 사각의 얼굴형 입니다.", 0).show();
					break;
				case 3:
					rbhairface4.setChecked(true);
					Toast.makeText(Homme_Profile_Modify.this,
							"선택하신 얼굴형은 둥근 얼굴형 입니다.", 0).show();
					break;
				case 4:
					rbhairface5.setChecked(true);
					Toast.makeText(Homme_Profile_Modify.this,
							"선택하신 얼굴형은 다이아몬드의 얼굴형 입니다.", 0).show();
					break;
				}
			}
		}
		else if(requestCode == 3)
		{
			if(resultCode == Activity.RESULT_OK)
			{
				uri = data.getData();
				Toast.makeText(Homme_Profile_Modify.this, "사진을 정상적으로 불러왔습니다.", 0).show();
			}
			else
			{
				Toast.makeText(Homme_Profile_Modify.this, "사진을 불러오는데 실패했습니다.", 0).show();
			}
		}
		
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		AlertDialog.Builder dlg = new AlertDialog.Builder(
				Homme_Profile_Modify.this);
		dlg.setTitle("변경작업을 취소하시겠습니까?");
		dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		dlg.show();
	}

}
