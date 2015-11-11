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
			"길어보이는 얼굴이 콤플렉스인 길쭉한 형.\n둥근 형과는 반대로 세로보다는 가로에 포인트를 줘야한다.파마로 자연스럽게 가로부분을 풍성하게 만들어 주는 것이 포인트이다.",
			"타원형은 모든 사람들이 원하는 얼굴형.\n어떤 스타일이든지 멋있게 소화해낼 수가 있다. 트렌디한 헤어스타일을 모두 섭렵할 수가 있어서 다양한 투블럭컷과 리젠트컷 등 연예인들이 많이들 하는 스타일을 추천한다.",
			"전체적으로 선이 굵은 인상의 각진형.\n마초적인 남자처럼 보이는 반면 자칫 무서워보여 다가가기 힘든 인상이다. 구렛나루로 각진 얼굴을 최대한 가리고 하관이 눈에 띄지 않도록 수염을 기르는 것도 팁이다.",
			"귀여운 인상의 둥근형\n너무 어려보이거나 살쪄보이기 쉬운 형이며, 이런 둥근형의 얼굴이라면 요즘 한창 유행하는 투블럭 헤어스타일로 가로부분을 확 밀어버리고 최대한 얇게 보이도록 하는 스타일을 추천한다.",
			"턱의 라인이 날렵한 다이아몬드형.\n섬세해보이는 이미지가 있지만 그보다 신경질적인 인상을 주는 경향이 거슬리는 인상이다. 이런 얼굴형은 머리를 어느정도 길러서 얼굴형을 커버하고 자연스러운 파마를 통해 부드러운 인상을 주도록 하는 것이 포인트이다."};

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
			tvhairstyle1.setText("긴 얼굴형");
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
			tvhairstyle1.setText("타원의 얼굴형");
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
			tvhairstyle1.setText("사각의 얼굴형");
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
			tvhairstyle1.setText("둥근 얼굴형");
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
			tvhairstyle1.setText("다이아몬드의 얼굴형");
			tvhairstyle1.setTextColor(Color.BLUE);
			tvhairstyle2.setText(hairstyle7[4]);
			break;
		}

	}

}
