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
		
		
		tvHairTip1.setText("기본적인 스타일링");
		tvHairTip2.setText("1.드라이기의 열을 이용해 옆머리를 눌러줍니다.\n2.스타일링 할 부분의 섹션을 나눠줍니다.\n3.구간별로 손으로 세게 쥐어가며 드라이기로 열을 줍니다.(열을 주고 손으로 구겨가며 식혀주시면 좋아요!)\n5.구간별로 총 4번으로 나누어 손으로 쥐어 컬을 줍니다.\n6.손으로 정리해주며 다시한번 열을 주며 쥐어줍니다.\n7.뒷머리는 겉머리만 손으로 쥐며 컬을 만들어 줍니다.\n8.왁스를 적당량 덜어 손으로 쥐며 모양을 잡아줍니다.\n9.남은 왁스로 옆머리는 눌러주고 뒷머리는 털듯이 발라줍니다.\n자연스럽게 고데기 없이 쉐도우 펌 스타일링 완성!!");
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
						Toast.makeText(getApplicationContext(), "동영상 일시정지", 0)
								.show();
					} else {
						videoHairTip1.start();
						Toast.makeText(getApplicationContext(), "동영상 재생", 0)
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
