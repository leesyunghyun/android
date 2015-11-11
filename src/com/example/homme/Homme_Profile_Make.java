package com.example.homme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Homme_Profile_Make extends Activity {

	private Homme_DB homme;
	private SQLiteDatabase sql;
	private EditText etName, etAge, etHei, etWei, etskinage;
	private RadioGroup rgjob, rghairtype, rghairstyle, rgskintype;
	private RadioButton rbskinRadio0, rbskinRadio1, rbskinRadio2, rbskinRadio3,
			rbskinRadio4;
	private RadioButton rbhairRadio0, rbhairRadio1, rbhairRadio2, rbhairRadio3,
			rbhairRadio4;
	private Button btnMake, btnCancel, btnskintest, btnskinage, btnfaceselect,
			btnimage;
	private Cursor c;
	private Uri uri = Uri.parse("default");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profilemake);
		homme = new Homme_DB(this);
		sql = homme.getWritableDatabase();
		c = sql.rawQuery("select * from profile", null);
		etName = (EditText) findViewById(R.id.editName);
		etAge = (EditText) findViewById(R.id.editAge);
		etHei = (EditText) findViewById(R.id.editHeight);
		etWei = (EditText) findViewById(R.id.editWeight);
		etskinage = (EditText) findViewById(R.id.editskinage);
		rgjob = (RadioGroup) findViewById(R.id.rgJob);
		rghairtype = (RadioGroup) findViewById(R.id.rghairType);
		rghairstyle = (RadioGroup) findViewById(R.id.rghairStyle);
		rgskintype = (RadioGroup) findViewById(R.id.rgskinType);
		rbskinRadio0 = (RadioButton) findViewById(R.id.skinRadio0);
		rbskinRadio1 = (RadioButton) findViewById(R.id.skinRadio1);
		rbskinRadio2 = (RadioButton) findViewById(R.id.skinRadio2);
		rbskinRadio3 = (RadioButton) findViewById(R.id.skinRadio3);
		rbskinRadio4 = (RadioButton) findViewById(R.id.skinRadio4);
		rbhairRadio0 = (RadioButton) findViewById(R.id.hairface1);
		rbhairRadio1 = (RadioButton) findViewById(R.id.hairface2);
		rbhairRadio2 = (RadioButton) findViewById(R.id.hairface3);
		rbhairRadio3 = (RadioButton) findViewById(R.id.hairface4);
		rbhairRadio4 = (RadioButton) findViewById(R.id.hairface5);

		btnimage = (Button) findViewById(R.id.btnImage);
		btnskinage = (Button) findViewById(R.id.btnskinage);
		btnskintest = (Button) findViewById(R.id.btnskintest);
		btnfaceselect = (Button) findViewById(R.id.btnfaceselect);
		btnMake = (Button) findViewById(R.id.btnMake);
		btnCancel = (Button) findViewById(R.id.btnCancel);

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

		btnfaceselect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Profile_Make.this,
						Homme_Profile_Hair.class);
				startActivityForResult(intent, 2);
			}
		});

		btnskinage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Profile_Make.this,
						Homme_Profile_Select_Skin2.class);
				startActivityForResult(intent, 1);
			}
		});

		btnskintest.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Homme_Profile_Make.this,
						Homme_Profile_Select_Skin.class);
				startActivityForResult(intent, 0);
			}
		});

		btnMake.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
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
					}

					age = Integer.parseInt(etAge.getText().toString());
					hei = Integer.parseInt(etHei.getText().toString());
					wei = Integer.parseInt(etWei.getText().toString());
					name = etName.getText().toString();

					if (etskinage.getText().toString().equals("동안피부")) {
						skinage = 0;
					} else if (etskinage.getText().toString().equals("30대피부")) {
						skinage = 1;
					} else {
						skinage = 2;
					}

					sql.execSQL("INSERT INTO profile(name, age, height, weight, job, hairtype, hairstyle, skintype, skinage, image) VALUES('"
							+ name
							+ "', '"
							+ age
							+ "', '"
							+ hei
							+ "', '"
							+ wei
							+ "', '"
							+ job
							+ "', '"
							+ hairtype
							+ "', '"
							+ hairstyle
							+ "', '"
							+ skintype
							+ "', '"
							+ skinage
							+ "', '" + uri + "');");
					sql.close();
					Homme_Profile_Select.activity.finish();
					startActivity(new Intent(Homme_Profile_Make.this,
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
				if (c.moveToFirst()) {
					LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					LinearLayout abc = (LinearLayout) vi.inflate(
							R.layout.dlgback, null);
					TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
					tvdlg1.setText("\n프로필 생성을 취소하시겠습니까?");

					AlertDialog.Builder dlg = new AlertDialog.Builder(
							Homme_Profile_Make.this);
					dlg.setTitle("경고!");
					dlg.setView(abc);
					dlg.setPositiveButton("확인", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Homme_Profile_Select.activity.finish();
							startActivity(new Intent(Homme_Profile_Make.this,
									Homme_Profile_Select.class));
							finish();
						}
					});
					dlg.setNegativeButton("취소", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.cancel();
						}
					});
					dlg.setCancelable(false);
					dlg.show();
				} else {
					LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					LinearLayout abc = (LinearLayout) vi.inflate(
							R.layout.dlgback, null);
					TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
					tvdlg1.setText("\n프로필을 생성하지 않고 종료하면 \n 프로그램을 진행할 수 없습니다. 계속하시겠습니까?");

					AlertDialog.Builder dlg = new AlertDialog.Builder(
							Homme_Profile_Make.this);
					dlg.setTitle("경고!");
					dlg.setView(abc);
					dlg.setPositiveButton("확인", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub

							Homme_Profile_Select.activity.finish();
							startActivity(new Intent(Homme_Profile_Make.this,
									Homme_Profile_Select.class));
							finish();
						}
					});
					dlg.setNegativeButton("취소", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.cancel();
						}
					});
					dlg.setCancelable(false);
					dlg.show();
				}
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
					Toast.makeText(Homme_Profile_Make.this,
							"측정된 피부나이는 동안피부입니다.", 0).show();
				} else if (skinagepoint > 10 && skinagepoint <= 20) {
					etskinage.setText("30대피부");
					Toast.makeText(Homme_Profile_Make.this,
							"측정된 피부나이는 30대피부입니다.", 0).show();
				} else {
					etskinage.setText("40~50대피부");
					Toast.makeText(Homme_Profile_Make.this,
							"측정된 피부나이는 40~50대피부입니다.", 0).show();
				}
			}
		} else if (resultCode == 2) {
			if (data != null) {
				int facetype = data.getIntExtra("facetype", 0);
				switch (facetype) {
				case 0:
					rbhairRadio0.setChecked(true);
					Toast.makeText(Homme_Profile_Make.this,
							"선택하신 얼굴형은 긴 얼굴형 입니다.", 0).show();
					break;
				case 1:
					rbhairRadio1.setChecked(true);
					Toast.makeText(Homme_Profile_Make.this,
							"선택하신 얼굴형은 타원의 얼굴형 입니다.", 0).show();
					break;
				case 2:
					rbhairRadio2.setChecked(true);
					Toast.makeText(Homme_Profile_Make.this,
							"선택하신 얼굴형은 사각의 얼굴형 입니다.", 0).show();
					break;
				case 3:
					rbhairRadio3.setChecked(true);
					Toast.makeText(Homme_Profile_Make.this,
							"선택하신 얼굴형은 둥근 얼굴형 입니다.", 0).show();
					break;
				case 4:
					rbhairRadio4.setChecked(true);
					Toast.makeText(Homme_Profile_Make.this,
							"선택하신 얼굴형은 다이아몬드의 얼굴형 입니다.", 0).show();
					break;
				}
			}
		} else if (requestCode == 3) {
			if (resultCode == Activity.RESULT_OK) {
				uri = data.getData();
				Toast.makeText(Homme_Profile_Make.this, "사진을 정상적으로 불러왔습니다.", 0)
						.show();
			} else {
				Toast.makeText(Homme_Profile_Make.this, "사진을 불러오는데 실패했습니다.", 0)
						.show();
			}
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (c.moveToFirst()) {
			LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			LinearLayout abc = (LinearLayout) vi
					.inflate(R.layout.dlgback, null);
			TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
			tvdlg1.setText("\n프로필 생성을 취소하시겠습니까?");

			AlertDialog.Builder dlg = new AlertDialog.Builder(
					Homme_Profile_Make.this);
			dlg.setTitle("경고!");
			dlg.setView(abc);
			dlg.setPositiveButton("확인", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Homme_Profile_Select.activity.finish();
					startActivity(new Intent(Homme_Profile_Make.this,
							Homme_Profile_Select.class));
					finish();
				}
			});
			dlg.setNegativeButton("취소", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			dlg.setCancelable(false);
			dlg.show();

		} else {
			LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			LinearLayout abc = (LinearLayout) vi
					.inflate(R.layout.dlgback, null);
			TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
			tvdlg1.setText("\n프로필을 생성하지 않고 종료하면 \n 프로그램을 진행할 수 없습니다. 계속하시겠습니까?");

			AlertDialog.Builder dlg = new AlertDialog.Builder(
					Homme_Profile_Make.this);
			dlg.setTitle("경고!");
			dlg.setView(abc);
			dlg.setPositiveButton("확인", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

					Homme_Profile_Select.activity.finish();
					startActivity(new Intent(Homme_Profile_Make.this,
							Homme_Profile_Select.class));
					finish();
				}
			});
			dlg.setNegativeButton("취소", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			dlg.setCancelable(false);
			dlg.show();
		}
	}

}
