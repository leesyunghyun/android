package com.example.homme;

import android.app.Activity;
import android.content.Intent;
import android.drm.DrmStore.Action;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Homme_Health_Health extends Activity {

	private VideoView video;
	private Uri uri;
	private TextView tv1,tv2,tv3,tv4,tv5;
	private ImageView iv1,iv2,iv3,iv4;
	private int flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.healthhealth);
		tv1 = (TextView)findViewById(R.id.healthtv1);
		tv2 = (TextView)findViewById(R.id.healthtv2);
		tv3 = (TextView)findViewById(R.id.healthtv3);
		tv4 = (TextView)findViewById(R.id.healthtv4);
		tv5 = (TextView)findViewById(R.id.videotv);
		iv1 = (ImageView)findViewById(R.id.healthiv1);
		iv2 = (ImageView)findViewById(R.id.healthiv2);
		iv3 = (ImageView)findViewById(R.id.healthiv3);
		iv4 = (ImageView)findViewById(R.id.healthiv4);
		video = (VideoView)findViewById(R.id.healthvideo);
		Toast.makeText(getApplicationContext(), "동영상 터치 : 재생/일시정지", 0).show();
		
		Intent intent = getIntent();
		flag = intent.getIntExtra("kind", 0);
		
		video.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction())
				{
				case MotionEvent.ACTION_DOWN:
					if(video.isPlaying())
					{
						video.pause();
						Toast.makeText(getApplicationContext(), "동영상 일시정지", 0).show();
					}
					else
					{
						video.start();
						Toast.makeText(getApplicationContext(), "동영상 재생", 0).show();
					}
					return true;
				}
				return false;
				
				
			}
		});
		
		video.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				if(!video.isPlaying())
					video.start();
			}
		});
		
		
		switch(flag)
		{
		case 11:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind110);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind111);
			tv1.setText("1.어깨너비보다 약간 넓게 다리를 벌리고 서서 어깨너비로 바벨을 잡는다.\n허리를 똑바로 세워 차렷 자세를 취하듯 가슴을 내밀고 엉덩이를 뒤로 치켜든다.");
			iv2.setBackgroundResource(R.drawable.kind112);
			tv2.setText("2.무릎을 살짝 구부리면서 바벨을 정강이까지 내린 다음 앞으로 숙이면서 복부와 등을 긴장시킨다.");
			iv3.setBackgroundResource(R.drawable.kind113);
			tv3.setText("3.다시 등으로 끌어당기는 느낌으로 바벨을 들어올리면서 원위치해서 일어선다.");
			tv5.setText("데드리프트\n주요 운동 부위 : 척추 기립근, 둔근, 슬굴곡근");
			break;
		case 12:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind120);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind121);
			tv1.setText("1.벤치에 누워 엉덩이와 견갑골을 등받이에 붙이고, 허리는 10cm가량 아치형을 만들어준다.\n어깨너비 두 배로 바를 잡고 눈이 바벨과 수직이 되도록 위치시킨다.");
			iv2.setBackgroundResource(R.drawable.kind122);
			tv2.setText("2.바를 들어 가슴 중앙과 바가 수직이 되도록 위치시킨 후 팔꿈치를 살짝 구부려 고정한다.");
			iv3.setBackgroundResource(R.drawable.kind123);
			tv3.setText("3.가슴과 바가 자석처럼 서로 만나는 느낌으로 가슴 위쪽 5~10cm까지 저항을 느끼며 바벨을 천천히 당긴다");
			iv4.setBackgroundResource(R.drawable.kind124);
			tv4.setText("4.겨드랑이에 힘을 준다는 느낌으로 바벨을 밀어 올린다.");
			tv5.setText("벤치프레스\n주요 운동 부위 : 대흉근,상완삼두근,삼각근");
			break;
		case 13:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind130);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind131);
			tv1.setText("1.선 자세에서 어깨너비보다 넓게 바벨을 잡는다.");
			iv2.setBackgroundResource(R.drawable.kind132);
			tv2.setText("2.바벨을 들어 머리 뒤의 승모근에 위치시킨다.\n시선은 정면을 향하고 복부에 힘을 주어 허리를 단단히 조여준다.");
			iv3.setBackgroundResource(R.drawable.kind133);
			tv3.setText("3.무릎이 발끝보다 앞으로 나오지 않도록 하면서 허벅지와 수평이 될 때까지 앉는다.");
			iv4.setBackgroundResource(R.drawable.kind134);
			tv4.setText("4.발뒤꿈치로 민다는 느낌으로 허벅지에 힘을 주면서 일어선다.");
			tv5.setText("스쿼트\n주요 운동 부위 : 대퇴사두근,대둔근,슬굴곡근");
			break;
		case 21:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind210);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind211);
			tv1.setText("1.바닥에 누워 무릎을 구부리고 발이 바닥과 떨어지지 않도록 한다.");
			iv2.setBackgroundResource(R.drawable.kind212);
			tv2.setText("2.양손을 귀에 대고 복부에 힘을 주면서 고개를 살짝 든다.");
			iv3.setBackgroundResource(R.drawable.kind213);
			tv3.setText("3.어깨가 바닥에서 약 10cm 떨어지도록 등을 둥글게 구부리면서 상복부를 수축한다");
			iv4.setBackgroundResource(R.drawable.kind214);
			tv4.setText("4.상복부의 긴장을 느끼면서 천천히 몸통을 바닥으로 눕힌다.\n이때 머리가 완전히 바닥에 닿지 않도록 한다.");
			tv5.setText("크런치\n주요 운동 부위 : 복직근 상부");
			break;
		case 22:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind220);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind221);
			tv1.setText("1.벤치에 누워 벤치 윗부분을 두 손으로 잡는다.");
			iv2.setBackgroundResource(R.drawable.kind222);
			tv2.setText("2.다리를 들어올린 후 무릎을 살짝 구부린다. 골반을 가슴 쪽으로 말아 올린다.");
			iv3.setBackgroundResource(R.drawable.kind223);
			tv3.setText("3.저항을 느끼며 다시 원위치한다.");
			tv5.setText("레그 레이즈\n주요 운동 부위 : 복직근 하부");
			break;
		case 31:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind310);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind311);
			tv1.setText("1.두 손으로 바벨을 어깨너비로 잡고 다리도 어깨너비만큼 벌리고 선다.");
			iv2.setBackgroundResource(R.drawable.kind312);
			tv2.setText("2.팔꿈치를 옆구리에 고정시키고, 이두근의 힘을 이용해 바벨을 들어올린다.\n손의 방향은 삼각근 전면을 향하도록 한다.");
			iv3.setBackgroundResource(R.drawable.kind313);
			tv3.setText("3.천천히 이두근의 저항을 느끼면서 바벨을 내린다.");
			tv5.setText("컬-바벨\n주요 운동 부위 : 상완이두근,전완,굴곡근");
			break;
		case 32:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind320);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind321);
			tv1.setText("1.어깨너비로 서서 덤벨을 양손으로 잡고 손바닥이 앞쪽으로 향하게 한 후 몸통 옆에 위치시킨다.");
			iv2.setBackgroundResource(R.drawable.kind322);
			tv2.setText("2.덤벨을 이두근의 힘으로 들어올려 최대 수축을 경험하고 연속하여 손목을 바깥쪽으로 비틀어준다.");
			iv3.setBackgroundResource(R.drawable.kind323);
			tv3.setText("3.덤벨을 머리 위로 들어올린다.");
			iv4.setBackgroundResource(R.drawable.kind324);
			tv4.setText("4.손바닥이 몸쪽을 향하게 해서 덤벨을 천천히 내린다.");
			tv5.setText("컬 프레스-덤벨\n주요 운동 부위 : 상완이두근,삼각근");
			break;
		case 41:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind410);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind411);
			tv1.setText("1.머신에 앉아 엉덩이와 어깨를 밀착시킨다.");
			iv2.setBackgroundResource(R.drawable.kind412);
			tv2.setText("2.양발을 발판에 대고 어깨너비만큼 벌린 다음 무릎을 편다.");
			iv3.setBackgroundResource(R.drawable.kind413);
			tv3.setText("3.앉는다는 느낌으로 천천히 무릎이 90도가 될 때까지 구부린다.");
			iv4.setBackgroundResource(R.drawable.kind414);
			tv4.setText("4.발뒤꿈치로 민다는 느낌으로 허벅지에 힘을 주면서 무릎을 편다.");
			tv5.setText("레그 프레스\n주요 운동 부위 : 대퇴사두근");
			break;
		case 42:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind420);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind421);
			tv1.setText("1.등받이에 등을 대고 손잡이를 잡은 다음, 발목을 어깨너비보다 좁게 벌려서 롤패드에 고정시킨다.");
			iv2.setBackgroundResource(R.drawable.kind422);
			tv2.setText("2.다리를 들어올려 무릎을 펴서 허벅지 근육을 수축시킨다.");
			iv3.setBackgroundResource(R.drawable.kind423);
			tv3.setText("3.천천히 저항을 느끼면서 다리를 내리며 긴장을 유지한다.");
			tv5.setText("레그 익스텐션\n주요 운동 부위 : 대퇴사두근");
			break;
			default:
				break;
		}
		
		
	}

}
