package com.example.homme;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Homme_Health_Weight extends TabActivity{

	private PointF mLastPoint = null;
	private TabHost tabHost;
	ImageView iv1, iv2, iv3;
	TextView tv1, tv2, tv3, tv4;
	TextView tv5;
	int flag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.healthweight);
		mLastPoint = new PointF();

		iv1 = (ImageView) findViewById(R.id.tabiv1);
		iv2 = (ImageView) findViewById(R.id.tabiv2);
		iv3 = (ImageView) findViewById(R.id.tabiv4);
		tv1 = (TextView) findViewById(R.id.tabtv1);
		tv2 = (TextView) findViewById(R.id.tabtv2);
		tv3 = (TextView) findViewById(R.id.tabtv3);
		tv4 = (TextView) findViewById(R.id.tabtv4);
		tv5 = (TextView) findViewById(R.id.tvhealthweightfat);

		Intent intent = getIntent();
		flag = intent.getIntExtra("flag", 0);
		tabHost = (TabHost) findViewById(android.R.id.tabhost);

		TabSpec spec1 = tabHost.newTabSpec("spec1").setIndicator("원인");
		spec1.setContent(R.id.tab1);
		tabHost.addTab(spec1);

		TabSpec spec2 = tabHost.newTabSpec("spec2").setIndicator("문제점");
		spec2.setContent(R.id.tab2);
		tabHost.addTab(spec2);

		TabSpec spec3 = tabHost.newTabSpec("spec3").setIndicator("식단");
		spec3.setContent(R.id.tab3);
		tabHost.addTab(spec3);

		TabSpec spec4 = tabHost.newTabSpec("spec4").setIndicator("운동법");
		spec4.setContent(R.id.tab4);
		tabHost.addTab(spec4);

		tabHost.setCurrentTab(0);

		switch (flag) {
		case 0:
			tv5.setText("당신은 저체중 이므로 아래와 같은 운동 및 관리를 요구합니다");
			iv1.setBackgroundResource(R.drawable.tabimage11);
			iv2.setBackgroundResource(R.drawable.tabimage12);
			iv3.setBackgroundResource(R.drawable.tabimage13);
			tv1.setText("1.활동량에 비해 음식물을 먹는 양이 부족\n2.먹은 음식물이 제대로 소화, 흡수되지 못함\n3.편식이 심함\n4.결핵이나 갑상선기능 항진 등과 같은 소모성 질환\n5.심리적 스트레스, 불안, 걱정 등으로 인한 식욕부진");
			tv2.setText("1.식욕부진, 소화장애 등에 의한 빈혈, 골다공증\n2.신체 면역력 저하, 감염성질환 위험\n3.쉽게 피로감을 느끼며 피부가 건조해지고 탄력성 감소");
			tv3.setText("1.반드시 1일 3회의 식사를 규칙적으로 한다.\n2.식사와 식사 사이에 적당량의 간식을 섭취한다.\n3.너무 많은 양의 음식을 한꺼번에 먹기보단, 열량이 농축되어 있는 식품을 섭취한다.\n4.지나친 흡연과 과음, 커피 등의 카페인 음료는 영양소 흡수를 방해하므로 삼간다.");
			tv4.setText("1.운동시간은 하루 1시간 이내로 짧게 한다.\n2.무거운 무게로 낮은 반복, 세트 사이의 휴식은 3분 정도로 한다.\n3.한 부위에 2~3가지 이상의 운동을 하지 않는다.\n4.짧게 운동하고 자주 운동하지 않는다.");
			break;
		case 1:
			tv5.setText("당신은 정상체중/마른비만 이므로 아래와 같은 운동 및 관리를 요구합니다");
			iv1.setBackgroundResource(R.drawable.tabimage21);
			iv2.setBackgroundResource(R.drawable.tabimage22);
			iv3.setBackgroundResource(R.drawable.tabimage23);
			tv1.setText("1.불규칙한 식습관\n2.과식 또는 폭식\n3.소화장애가 있어서 영양소 흡수율이 낮음\n4.내장지방의 축적");
			tv2.setText("1.복부의 팽창으로 인한 허리둘레 증가\n2.당뇨합병증, 심장병 위험 증가\n3.내장지방으로 인한 성인병 위험 증가");
			tv3.setText("1.야채와 해조류를 위주로 한 저지방 식사와 규칙적인 식사습관\n2.과식,폭식을 하지 않고 하루 권장 칼로리에 맞추어서 식사");
			tv4.setText("1.요가, 조깅, 에어로빅, 수영 등 유산소운동을 규칙적으로 한다.\n2.근육 운동과 병행하여 근육량을 늘려 기초대사량을 증가시킨다.\n3.근육운동 후에 유산소운동을 30~40분 정도 한다.");
			break;
		case 2:
			tv5.setText("당신은 과체중(비만) 이므로 아래와 같은 운동 및 관리를 요구합니다");
			iv1.setBackgroundResource(R.drawable.tabimage31);
			iv2.setBackgroundResource(R.drawable.tabimage32);
			iv3.setBackgroundResource(R.drawable.tabimage33);
			tv1.setText("1.유전적요인\n2.불규칙한 식사와 늦은 시간의 식사\n3.운동을 하지 않는 생활 습관\n4.과식과 과도한 탄수화물, 지방 섭취");
			tv2.setText("1.고지혈증과 당뇨병 발병률 증가\n2.담석증과 일부의 경우 암 발병가능\n3.당뇨로 인한 합병증 발병 가능\n4.고혈압으로 인한 합병증 발병 가능");
			tv3.setText("1.규칙적인 식생활 1일 3끼를 먹으나, 1일 권장량보다 2~300kcal정도 낮추어서 식사한다.\n2.과도한 단식은 역효과를 일으키므로 적당량을 섭취한다.\n3.기름진 음식, 고칼로리 음식, 맵거나 짜고 자극적인 음식은 자제한다.\n4.저녁 7시 이후로는 음식을 먹지 않는다.");
			tv4.setText("1.근육위주의 운동 보다는 런닝,라이딩,수영,요가,에어로빅 등 유산소운동을 주 5시간 이상 실시한다.\n2.특정 부위의 운동을 하기 보다는 전신 운동을 한다.\n3.운동에 있어서 가장 중요한 것은 식사량 조절이다. 자신이 선택한 식단을 유지하면서 규칙적으로 운동을 하는 습관을 들인다.");
			break;
		default:
			tv5.setText("오류");
			break;
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		float distance = 0;
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mLastPoint.x = event.getX();
			break;
		case MotionEvent.ACTION_UP:
			distance = mLastPoint.x - event.getX();
			break;
		}
		
		if(Math.abs(distance)<100)
		{
			return false;
		}
		if(distance > 0)
		{
			int index = tabHost.getCurrentTab()+1;
			if(index == 4)
				index = 0;
			tabHost.setCurrentTab(index);
		}
		else
		{
			int index = tabHost.getCurrentTab()-1;
			if(index == -1)
				index = 3;
			tabHost.setCurrentTab(index);
		}
		return true;
	}
}
