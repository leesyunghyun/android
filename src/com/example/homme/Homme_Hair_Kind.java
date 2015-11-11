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
	private String strkind1[] = {"�������̶� ?","������̶� ?","����Ʈ���̶� ?","����ĭ���̶� ?","���Ī���̶� ?","�������̶� ?","�����������̶� ?"};
	private String strkind2[] = {"��,�ոӸ��� ���Ӹ��� ������ �ٸ��� ĿƮ�� �� ���� ���� �������ִ� ����.","Ư���� � ������ ���� ��Ÿ���� �ƴ� '����� ��'�� ��Ÿ���� ����.","�׸����� ��� ĥ�ϰ� �ոӸ��� ���� �Ͽ� ���� ���� �ѱ�� ���Ӹ��� �ٿ��� �簨�� ��Ÿ�� �ϵ��� ������ �Ƿ翧�� Ư¡�� ����.","���Ӹ��� ����ϰų� ª�� �ڸ� �� ��� �κи��� �⸣�� ��Ÿ���� ����ĭ����.","�Ӹ� �¿��� ��Ī�� ������ �ʰ� ���Ī���� ĿƮ�� ��߶����� ��Ÿ���� �����ϴ� ���� ����.","�������̶� ���� ���� �ĳ��� ������ ������ �����ϴ� �Ϻ��� ��Ÿ����.","�����Ӹ��� �� �״�� �Ӹ��� ��� �淯 �Ӹ����� �̿��� ���� ��Ÿ���� ����."};
	

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
