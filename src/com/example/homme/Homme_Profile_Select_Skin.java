package com.example.homme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Homme_Profile_Select_Skin extends Activity {

	private Button btnselectskin;
	private TextView tvselectskin1, tvselectskin2, tvselectskin3;
	private RadioGroup rgselectskin;
	private RadioButton rbselectskin1, rbselectskin2, rbselectskin3;
	private String[] strskin = { "", "모공이 크지 않다", "모공이 매우 작다", "모공이 매우 크다",
			"모공의 크기가 적당하다", "모공의 크기가 부분적으로 다르다", "눈 입 주위에 잔주름이 많다",
			"겨울철은 당기고 여름철은 유분이 많다", "피부가 두껍고 피지분비가 많다", "윤기가 없고 피부도 칙칙하다",
			"얼굴이 자주 빨개진다", "피부톤이 밝고 고른 편이다", "환절기에 피부트러블이 생긴다",
			"피부톤이 전체적으로 어둡다", "세안 후 당기고 T존 부위는 유분이 많다", "얼굴이 많이 건조하다",
			"피부에 윤기가 없다", "나이에 비해 피부가 좋다", "화장이 잘 지워지고 유분이 많다",
			"T존 부위만 화장이 잘 지워진다", "피곤하면 트러블이 생긴다", "세안 후 얼굴이 전체적으로 당긴다",
			"화장이 오래 간다", "여드름성 트러블이 잘 일어난다", "얼굴이 부분적으로 번들거린다",
			"화장품이나 비누를 바꾸면 트러블이 생긴다" };
	private int frameflag = 1;
	private Intent result;
	private Intent intent;
	private int activityflag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profileselectskin1);
		
		intent = getIntent();
		activityflag = intent.getIntExtra("activityflag", 0);
		
		btnselectskin = (Button) findViewById(R.id.btnselectskin);
		tvselectskin1 = (TextView) findViewById(R.id.tvselectskin1);
		tvselectskin2 = (TextView) findViewById(R.id.tvselectskin2);
		tvselectskin3 = (TextView) findViewById(R.id.tvselectskin3);
		rgselectskin = (RadioGroup) findViewById(R.id.rgselectskin);
		rbselectskin1 = (RadioButton) findViewById(R.id.rbselectskin1);
		rbselectskin2 = (RadioButton) findViewById(R.id.rbselectskin2);
		rbselectskin3 = (RadioButton) findViewById(R.id.rbselectskin3);

		tvselectskin1
				.setText("자신에 맞는 걸 선택해주세요.\n한번 선택하면 되돌아 갈 수 없습니다.\n버튼을 길게 눌러 주세요!");
		tvselectskin2.setText("모공이 크지 않다");
		
		
		btnselectskin.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				switch (frameflag) {
				case 1:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 6;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 2;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 7;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 2:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 6;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 3;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 8;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 3:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 8;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 4;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 9;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 4:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 7;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 5;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 6;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 5:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 10;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 6;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 9;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 6:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 11;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 7;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 12;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 7:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 12;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 8;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 13;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 8:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 13;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 9;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 14;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 9:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 14;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 10;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 15;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 10:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 15;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 16;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 16;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 11:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 16;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 12;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 18;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 12:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 17;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 13;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 16;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 13:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 18;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 14;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 17;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 14:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 19;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin3.setVisibility(View.GONE);
						break;
					case R.id.rbselectskin2:
						frameflag = 15;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 18;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 15:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 20;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin3.setVisibility(View.GONE);
						break;
					case R.id.rbselectskin2:
						frameflag = 17;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 19;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin3.setVisibility(View.GONE);
						break;
					}
					break;
				case 16:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 21;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 17;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 22;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 17:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 22;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 18;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 24;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 18:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 23;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin2:
						frameflag = 19;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin3.setVisibility(View.GONE);
						break;
					case R.id.rbselectskin3:
						frameflag = 24;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					}
					break;
				case 19:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 24;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin3.setVisibility(View.VISIBLE);
						break;
					case R.id.rbselectskin2:
						frameflag = 20;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin3.setVisibility(View.GONE);
						break;
					}
					break;
				case 20:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 25;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.VISIBLE);
						break;
					case R.id.rbselectskin2:
						frameflag = 11;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin3.setVisibility(View.VISIBLE);
						break;
					}
					break;
				case 21:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 26;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("건성피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					case R.id.rbselectskin2:
						frameflag = 22;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 27;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("일반피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					}
					break;
				case 22:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 27;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("일반피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					case R.id.rbselectskin2:
						frameflag = 23;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 26;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("건성피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					}
					break;
				case 23:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 28;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("지성피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					case R.id.rbselectskin2:
						frameflag = 24;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						break;
					case R.id.rbselectskin3:
						frameflag = 29;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("복합성피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					}
					break;
				case 24:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 29;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("복합성피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					case R.id.rbselectskin2:
						frameflag = 25;
						tvselectskin2.setText(strskin[frameflag]);
						rbselectskin1.setChecked(true);
						rbselectskin2.setVisibility(View.GONE);
						break;
					case R.id.rbselectskin3:
						frameflag = 28;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("지성피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					}
					break;
				case 25:
					switch (rgselectskin.getCheckedRadioButtonId()) {
					case R.id.rbselectskin1:
						frameflag = 30;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("민감성피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					case R.id.rbselectskin3:
						frameflag = 29;
						tvselectskin1.setText("당신의 피부 타입은 ");
						tvselectskin2.setText("복합성피부");
						tvselectskin2.setTextColor(Color.rgb(255, 0, 255));
						tvselectskin3.setText("입니다.");
						rbselectskin1.setVisibility(View.GONE);
						rbselectskin2.setVisibility(View.GONE);
						rbselectskin3.setVisibility(View.GONE);
						btnselectskin.setText("완료");
						break;
					}
					break;
				case 26:
					switch(activityflag)
					{
					case 0:
						Toast.makeText(getApplicationContext(), "당신의 피부는 건성피부입니다.",
								0).show();
						result = new Intent();
						result.putExtra("skinflag", 1);
						setResult(0, result);
						finish();
						break;
					case 1:
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n진단한 결과를 프로필에 반영하시겠습니까?");
						
						AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Profile_Select_Skin.this);
						dlg.setView(abc);
						dlg.setPositiveButton("반영", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								result = new Intent();
								result.putExtra("skinflag2", 1);
								setResult(0,result);
								finish();
							}
						});
						
						dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								finish();
							}
						});
						dlg.show();
						break;
					}
					break;
				case 27:
					switch(activityflag)
					{
					case 0:
						Toast.makeText(getApplicationContext(), "당신의 피부는 일반피부입니다.",
								0).show();
						result = new Intent();
						result.putExtra("skinflag", 0);
						setResult(0, result);
						finish();
						break;
					case 1:
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n진단한 결과를 프로필에 반영하시겠습니까?");
						
						AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Profile_Select_Skin.this);
						dlg.setView(abc);
						dlg.setPositiveButton("반영", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								result = new Intent();
								result.putExtra("skinflag2", 0);
								setResult(0,result);
								finish();
							}
						});
						
						dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								finish();
							}
						});
						dlg.show();
						break;
					}
					break;
				case 28:
					switch(activityflag)
					{
					case 0:
						Toast.makeText(getApplicationContext(), "당신의 피부는 지성피부입니다.",
								0).show();
						result = new Intent();
						result.putExtra("skinflag", 4);
						setResult(0, result);
						finish();
						break;
					case 1:
						
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n진단한 결과를 프로필에 반영하시겠습니까?");
						
						AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Profile_Select_Skin.this);
						dlg.setView(abc);
						dlg.setPositiveButton("반영", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								result = new Intent();
								result.putExtra("skinflag2", 4);
								setResult(0,result);
								finish();
							}
						});
						
						dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								finish();
							}
						});
						dlg.show();
						break;
					}
					break;
				case 29:
					switch(activityflag)
					{
					case 0:
						Toast.makeText(getApplicationContext(),
								"당신의 피부는 복합성피부입니다.", 0).show();
						result = new Intent();
						result.putExtra("skinflag", 3);
						setResult(0, result);
						finish();
						break;
					case 1:
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n진단한 결과를 프로필에 반영하시겠습니까?");
						
						AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Profile_Select_Skin.this);
						dlg.setView(abc);
						dlg.setPositiveButton("반영", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								result = new Intent();
								result.putExtra("skinflag2", 3);
								setResult(0,result);
								finish();
							}
						});
						
						dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								finish();
							}
						});
						dlg.show();
						break;
					}
					break;
				case 30:
					switch(activityflag)
					{
					case 0:
						Toast.makeText(getApplicationContext(),
								"당신의 피부는 민감성피부입니다.", 0).show();
						result = new Intent();
						result.putExtra("skinflag", 2);
						setResult(0, result);
						finish();
						break;
					case 1:
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n진단한 결과를 프로필에 반영하시겠습니까?");
						
						AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Profile_Select_Skin.this);
						dlg.setView(abc);
						dlg.setPositiveButton("반영", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								result = new Intent();
								result.putExtra("skinflag2", 2);
								setResult(0,result);
								finish();
							}
						});
						
						dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								finish();
							}
						});
						dlg.show();
						break;
					}
					break;
				}
				return true;
			}

		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout abc = (LinearLayout) vi.inflate(
				R.layout.dlgback, null);
		TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
		tvdlg1.setText("\n종료하면 작성한 정보가 지워집니다.\n종료하시겠습니까?");
		
		AlertDialog.Builder dlg = new AlertDialog.Builder(
				Homme_Profile_Select_Skin.this);
		dlg.setTitle("경고!");
		dlg.setView(abc);
		dlg.setPositiveButton("확인", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

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
