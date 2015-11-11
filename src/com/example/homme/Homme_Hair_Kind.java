package com.example.homme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Homme_Hair_Kind extends Activity {

	private Button btnhairkind, btnhairkind2;
	private TextView tvhairkind1, tvhairkind2;
	private RadioGroup rghairkind;
	private WebView wbhairkind;
	private RadioButton rbhairkind0, rbhairkind1, rbhairkind2, rbhairkind3,
			rbhairkind4, rbhairkind5, rbhairkind6;
	private int select_rb_flag = 0;
	private String strkind1[] = {"투블럭컷이란 ?","댄디컷이란 ?","리젠트컷이란 ?","모히칸컷이란 ?","비대칭컷이란 ?","샤기컷이란 ?","꽁지묶음컷이란 ?"};
	private String strkind2[] = {"윗,앞머리와 옆머리의 기장을 다르게 커트해 두 개의 블럭을 형성해주는 컷임.","특정한 어떤 모양새를 가진 헤어스타일이 아닌 '댄디한 컷'의 헤어스타일을 말함.","그리스를 듬뿍 칠하고 앞머리를 높게 하여 위로 빗어 넘기고 옆머리를 붙여서 양감을 나타낸 하드한 감각의 실루엣이 특징인 컷임.","옆머리를 삭발하거나 짧게 자른 뒤 가운데 부분만을 기르는 스타일이 모히칸컷임.","머리 좌우의 대칭을 맞추지 않고 비대칭으로 커트해 언발란스한 스타일을 연출하는 컷을 말함.","샤기컷이란 숱을 많이 쳐내어 가벼운 질감을 연출하는 일본식 스타일임.","묶음머리는 말 그대로 머리를 길게 길러 머리끈을 이용해 묶는 헤어스타일을 말함."};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hairkind);
		btnhairkind = (Button) findViewById(R.id.btnhairkind);
		btnhairkind2 = (Button) findViewById(R.id.btnhairkind2);
		tvhairkind1 = (TextView) findViewById(R.id.tvhairkind1);
		tvhairkind2 = (TextView) findViewById(R.id.tvhairkind2);
		rghairkind = (RadioGroup) findViewById(R.id.rghairkind);
		wbhairkind = (WebView) findViewById(R.id.webViewhairkind);
		rbhairkind0 = (RadioButton) findViewById(R.id.rbhairkind0);
		rbhairkind1 = (RadioButton) findViewById(R.id.rbhairkind1);
		rbhairkind2 = (RadioButton) findViewById(R.id.rbhairkind2);
		rbhairkind3 = (RadioButton) findViewById(R.id.rbhairkind3);
		rbhairkind4 = (RadioButton) findViewById(R.id.rbhairkind4);
		rbhairkind5 = (RadioButton) findViewById(R.id.rbhairkind5);
		rbhairkind6 = (RadioButton) findViewById(R.id.rbhairkind6);

		wbhairkind.setWebViewClient(new MyWeb());
		WebSettings webSet = wbhairkind.getSettings();
		webSet.setBuiltInZoomControls(true);

		wbhairkind.setVisibility(View.INVISIBLE);
		btnhairkind2.setVisibility(View.INVISIBLE);
		tvhairkind1.setVisibility(View.GONE);
		tvhairkind2.setVisibility(View.GONE);
		
		btnhairkind2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (rghairkind.getCheckedRadioButtonId()) {
				case R.id.rbhairkind0:
					wbhairkind.loadUrl("http://blog.daum.net/zidane8022/421");
					break;
				case R.id.rbhairkind1:
					wbhairkind.loadUrl("http://blog.daum.net/zidane8022/422");
					break;
				case R.id.rbhairkind2:
					wbhairkind.loadUrl("http://blog.daum.net/zidane8022/438");
					break;
				case R.id.rbhairkind3:
					wbhairkind.loadUrl("http://blog.daum.net/zidane8022/447");
					break;
				case R.id.rbhairkind4:
					wbhairkind.loadUrl("http://blog.daum.net/zidane8022/450");
					break;
				case R.id.rbhairkind5:
					wbhairkind.loadUrl("http://blog.daum.net/zidane8022/457");
					break;
				case R.id.rbhairkind6:
					wbhairkind.loadUrl("http://blog.daum.net/zidane8022/475");
					break;
				}

				wbhairkind.setVisibility(View.VISIBLE);
				btnhairkind2.setVisibility(View.GONE);
				tvhairkind1.setVisibility(View.GONE);
				tvhairkind2.setVisibility(View.GONE);
			}
		});

		btnhairkind.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(select_rb_flag == rghairkind.getCheckedRadioButtonId())
				{
					return ;
				}
				else
				{
					switch (rghairkind.getCheckedRadioButtonId()) {
					case R.id.rbhairkind0:
						tvhairkind1.setText(strkind1[0]);
						tvhairkind2.setText(strkind2[0]);
						select_rb_flag = R.id.rbhairkind0;
						break;
					case R.id.rbhairkind1:
						tvhairkind1.setText(strkind1[1]);
						tvhairkind2.setText(strkind2[1]);
						select_rb_flag = R.id.rbhairkind1;
						break;
					case R.id.rbhairkind2:
						tvhairkind1.setText(strkind1[2]);
						tvhairkind2.setText(strkind2[2]);
						select_rb_flag = R.id.rbhairkind2;
						break;
					case R.id.rbhairkind3:
						tvhairkind1.setText(strkind1[3]);
						tvhairkind2.setText(strkind2[3]);
						select_rb_flag = R.id.rbhairkind3;
						break;
					case R.id.rbhairkind4:
						tvhairkind1.setText(strkind1[4]);
						tvhairkind2.setText(strkind2[4]);
						select_rb_flag = R.id.rbhairkind4;
						break;
					case R.id.rbhairkind5:
						tvhairkind1.setText(strkind1[5]);
						tvhairkind2.setText(strkind2[5]);
						select_rb_flag = R.id.rbhairkind5;
						break;
					case R.id.rbhairkind6:
						tvhairkind1.setText(strkind1[6]);
						tvhairkind2.setText(strkind2[6]);
						select_rb_flag = R.id.rbhairkind6;
						break;
					}
					wbhairkind.setVisibility(View.INVISIBLE);
					btnhairkind2.setVisibility(View.VISIBLE);
					tvhairkind1.setVisibility(View.VISIBLE);
					tvhairkind2.setVisibility(View.VISIBLE);
				}
			}
		});

	}

	class MyWeb extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			return super.shouldOverrideUrlLoading(view, url);
		}

	}
}
