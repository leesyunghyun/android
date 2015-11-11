package com.example.homme;

import com.example.homme.R.id;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Homme_Hair_Tip extends Activity {

	private TextView tvHairTip1, tvHairTip2;
	private VideoView videoHairTip1;
	private Uri uri;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.healthhealth);
		tvHairTip1 = (TextView) findViewById(R.id.videotv);
		tvHairTip2 = (TextView) findViewById(R.id.healthtv1);
		videoHairTip1 = (VideoView) findViewById(R.id.healthvideo);
		
		
		tvHairTip1.setText("�⺻���� ��Ÿ�ϸ�");
		tvHairTip2.setText("1.����̱��� ���� �̿��� ���Ӹ��� �����ݴϴ�.\n2.��Ÿ�ϸ� �� �κ��� ������ �����ݴϴ�.\n3.�������� ������ ���� ���� ����̱�� ���� �ݴϴ�.(���� �ְ� ������ ���ܰ��� �����ֽø� ���ƿ�!)\n5.�������� �� 4������ ������ ������ ��� ���� �ݴϴ�.\n6.������ �������ָ� �ٽ��ѹ� ���� �ָ� ����ݴϴ�.\n7.�޸Ӹ��� �ѸӸ��� ������ ��� ���� ����� �ݴϴ�.\n8.�ν��� ���緮 ���� ������ ��� ����� ����ݴϴ�.\n9.���� �ν��� ���Ӹ��� �����ְ� �޸Ӹ��� �е��� �߶��ݴϴ�.\n�ڿ������� ���� ���� ������ �� ��Ÿ�ϸ� �ϼ�!!");
		tvHairTip2.setTextColor(Color.BLUE);
		tvHairTip2.setTextSize(17);
		
		uri = Uri.parse("android.resource://com.example.homme/" + R.raw.hairtip);
		
		videoHairTip1.setVideoURI(uri);
		videoHairTip1.start();
		
		videoHairTip1.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					if (videoHairTip1.isPlaying()) {
						videoHairTip1.pause();
						Toast.makeText(getApplicationContext(), "������ �Ͻ�����", 0)
								.show();
					} else {
						videoHairTip1.start();
						Toast.makeText(getApplicationContext(), "������ ���", 0)
								.show();
					}
					return true;
				}
				return false;

			}
		});

		videoHairTip1.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				if (!videoHairTip1.isPlaying())
					videoHairTip1.start();
			}
		});
	}

}
