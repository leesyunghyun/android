package com.example.homme;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Homme_Hair_Style extends Activity {

	private ImageView imagehairstyle1, imagehairstyle2, imagehairstyle3,
			imagehairstyle4, imagehairstyle5, imagehairstyle6;
	private TextView tvhairstyle1, tvhairstyle2;
	private LinearLayout.LayoutParams params;
	private Intent intent;
	private int facetypeflag;
	private int[] hairstyle1 = { R.drawable.hair11, R.drawable.hair12,
			R.drawable.hair13, R.drawable.hair14, R.drawable.hair15 };
	private int[] hairstyle2 = { R.drawable.hair21, R.drawable.hair22,
			R.drawable.hair23 };
	private int[] hairstyle3 = { R.drawable.hair31, R.drawable.hair32,
			R.drawable.hair33, R.drawable.hair34, R.drawable.hair35 };
	private int[] hairstyle4 = { R.drawable.hair41, R.drawable.hair42,
			R.drawable.hair43, R.drawable.hair44 };
	private int[] hairstyle5 = { R.drawable.hair51, R.drawable.hair52,
			R.drawable.hair53 };
	private int[] hairstyle6 = { R.drawable.hair61, R.drawable.hair62,
			R.drawable.hair63, R.drawable.hair64 };
	private String[] hairstyle7 = {
			"���̴� ���� ���÷����� ������ ��.\n�ձ� ������ �ݴ�� ���κ��ٴ� ���ο� ����Ʈ�� ����Ѵ�.�ĸ��� �ڿ������� ���κκ��� ǳ���ϰ� ����� �ִ� ���� ����Ʈ�̴�.",
			"Ÿ������ ��� ������� ���ϴ� ����.\n� ��Ÿ���̵��� ���ְ� ��ȭ�س� ���� �ִ�. Ʈ������ ��Ÿ���� ��� ������ ���� �־ �پ��� �����ư� ����Ʈ�� �� �����ε��� ���̵� �ϴ� ��Ÿ���� ��õ�Ѵ�.",
			"��ü������ ���� ���� �λ��� ������.\n�������� ����ó�� ���̴� �ݸ� ��ĩ ���������� �ٰ����� ���� �λ��̴�. ��������� ���� ���� �ִ��� ������ �ϰ��� ���� ���� �ʵ��� ������ �⸣�� �͵� ���̴�.",
			"�Ϳ��� �λ��� �ձ���\n�ʹ� ������̰ų� ���Ǻ��̱� ���� ���̸�, �̷� �ձ����� ���̶�� ���� ��â �����ϴ� ���� ��Ÿ�Ϸ� ���κκ��� Ȯ �о������ �ִ��� ��� ���̵��� �ϴ� ��Ÿ���� ��õ�Ѵ�.",
			"���� ������ ������ ���̾Ƹ����.\n�����غ��̴� �̹����� ������ �׺��� �Ű������� �λ��� �ִ� ������ �Ž����� �λ��̴�. �̷� ������ �Ӹ��� ������� �淯�� ������ Ŀ���ϰ� �ڿ������� �ĸ��� ���� �ε巯�� �λ��� �ֵ��� �ϴ� ���� ����Ʈ�̴�."};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hairstyle);
		params = new LinearLayout.LayoutParams(300,450,1);
		
		tvhairstyle1 = (TextView) findViewById(R.id.tvhairstyle1);
		tvhairstyle2 = (TextView) findViewById(R.id.tvhairstyle2);
		imagehairstyle1 = (ImageView) findViewById(R.id.imagehairstyle1);
		imagehairstyle2 = (ImageView) findViewById(R.id.imagehairstyle2);
		imagehairstyle3 = (ImageView) findViewById(R.id.imagehairstyle3);
		imagehairstyle4 = (ImageView) findViewById(R.id.imagehairstyle4);
		imagehairstyle5 = (ImageView) findViewById(R.id.imagehairstyle5);
		imagehairstyle6 = (ImageView) findViewById(R.id.imagehairstyle6);

		intent = getIntent();
		facetypeflag = intent.getIntExtra("hairstyle", 0);

		switch (facetypeflag) {
		case 0:
			imagehairstyle1.setBackgroundResource(hairstyle1[0]);
			imagehairstyle2.setBackgroundResource(hairstyle2[0]);
			imagehairstyle3.setBackgroundResource(hairstyle2[1]);
			imagehairstyle4.setBackgroundResource(hairstyle2[2]);
			imagehairstyle2.setLayoutParams(params);
			imagehairstyle3.setLayoutParams(params);
			imagehairstyle5.setVisibility(View.GONE);
			imagehairstyle6.setVisibility(View.GONE);
			tvhairstyle1.setText("�� ����");
			tvhairstyle1.setTextColor(Color.BLUE);
			tvhairstyle2.setText(hairstyle7[0]);
			break;
		case 1:
			imagehairstyle1.setBackgroundResource(hairstyle1[1]);
			imagehairstyle2.setBackgroundResource(hairstyle3[0]);
			imagehairstyle3.setBackgroundResource(hairstyle3[1]);
			imagehairstyle4.setBackgroundResource(hairstyle3[2]);
			imagehairstyle5.setBackgroundResource(hairstyle3[3]);
			imagehairstyle6.setBackgroundResource(hairstyle3[4]);
			imagehairstyle2.setLayoutParams(params);
			imagehairstyle3.setLayoutParams(params);
			imagehairstyle4.setLayoutParams(params);
			imagehairstyle5.setLayoutParams(params);
			tvhairstyle1.setText("Ÿ���� ����");
			tvhairstyle1.setTextColor(Color.BLUE);
			tvhairstyle2.setText(hairstyle7[1]);
			break;
		case 2:
			imagehairstyle1.setBackgroundResource(hairstyle1[2]);
			imagehairstyle2.setBackgroundResource(hairstyle4[0]);
			imagehairstyle3.setBackgroundResource(hairstyle4[1]);
			imagehairstyle4.setBackgroundResource(hairstyle4[2]);
			imagehairstyle5.setBackgroundResource(hairstyle4[3]);
			imagehairstyle2.setLayoutParams(params);
			imagehairstyle3.setLayoutParams(params);
			imagehairstyle4.setLayoutParams(params);
			imagehairstyle5.setLayoutParams(params);
			imagehairstyle6.setVisibility(View.GONE);
			tvhairstyle1.setText("�簢�� ����");
			tvhairstyle1.setTextColor(Color.BLUE);
			tvhairstyle2.setText(hairstyle7[2]);
			break;
		case 3:
			imagehairstyle1.setBackgroundResource(hairstyle1[3]);
			imagehairstyle2.setBackgroundResource(hairstyle5[0]);
			imagehairstyle3.setBackgroundResource(hairstyle5[1]);
			imagehairstyle4.setBackgroundResource(hairstyle5[2]);
			imagehairstyle2.setLayoutParams(params);
			imagehairstyle3.setLayoutParams(params);
			imagehairstyle5.setVisibility(View.GONE);
			imagehairstyle6.setVisibility(View.GONE);
			tvhairstyle1.setText("�ձ� ����");
			tvhairstyle1.setTextColor(Color.BLUE);
			tvhairstyle2.setText(hairstyle7[3]);
			break;
		case 4:
			imagehairstyle1.setBackgroundResource(hairstyle1[4]);
			imagehairstyle2.setBackgroundResource(hairstyle6[0]);
			imagehairstyle3.setBackgroundResource(hairstyle6[1]);
			imagehairstyle4.setBackgroundResource(hairstyle6[2]);
			imagehairstyle5.setBackgroundResource(hairstyle6[3]);
			imagehairstyle2.setLayoutParams(params);
			imagehairstyle3.setLayoutParams(params);
			imagehairstyle4.setLayoutParams(params);
			imagehairstyle5.setLayoutParams(params);
			imagehairstyle6.setVisibility(View.GONE);
			tvhairstyle1.setText("���̾Ƹ���� ����");
			tvhairstyle1.setTextColor(Color.BLUE);
			tvhairstyle2.setText(hairstyle7[4]);
			break;
		}

	}

}
