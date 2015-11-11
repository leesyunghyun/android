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
		Toast.makeText(getApplicationContext(), "������ ��ġ : ���/�Ͻ�����", 0).show();
		
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
						Toast.makeText(getApplicationContext(), "������ �Ͻ�����", 0).show();
					}
					else
					{
						video.start();
						Toast.makeText(getApplicationContext(), "������ ���", 0).show();
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
			tv1.setText("1.����ʺ񺸴� �ణ �а� �ٸ��� ������ ���� ����ʺ�� �ٺ��� ��´�.\n�㸮�� �ȹٷ� ���� ���� �ڼ��� ���ϵ� ������ ���а� �����̸� �ڷ� ġ�ѵ��.");
			iv2.setBackgroundResource(R.drawable.kind112);
			tv2.setText("2.������ ��¦ ���θ��鼭 �ٺ��� �����̱��� ���� ���� ������ ���̸鼭 ���ο� ���� �����Ų��.");
			iv3.setBackgroundResource(R.drawable.kind113);
			tv3.setText("3.�ٽ� ������ ������� �������� �ٺ��� ���ø��鼭 ����ġ�ؼ� �Ͼ��.");
			tv5.setText("���帮��Ʈ\n�ֿ� � ���� : ô�� �⸳��, �б�, �������");
			break;
		case 12:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind120);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind121);
			tv1.setText("1.��ġ�� ���� �����̿� �߰����� ����̿� ���̰�, �㸮�� 10cm���� ��ġ���� ������ش�.\n����ʺ� �� ��� �ٸ� ��� ���� �ٺ��� ������ �ǵ��� ��ġ��Ų��.");
			iv2.setBackgroundResource(R.drawable.kind122);
			tv2.setText("2.�ٸ� ��� ���� �߾Ӱ� �ٰ� ������ �ǵ��� ��ġ��Ų �� �Ȳ�ġ�� ��¦ ���η� �����Ѵ�.");
			iv3.setBackgroundResource(R.drawable.kind123);
			tv3.setText("3.������ �ٰ� �ڼ�ó�� ���� ������ �������� ���� ���� 5~10cm���� ������ ������ �ٺ��� õõ�� ����");
			iv4.setBackgroundResource(R.drawable.kind124);
			tv4.setText("4.�ܵ���̿� ���� �شٴ� �������� �ٺ��� �о� �ø���.");
			tv5.setText("��ġ������\n�ֿ� � ���� : �����,��ϻ�α�,�ﰢ��");
			break;
		case 13:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind130);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind131);
			tv1.setText("1.�� �ڼ����� ����ʺ񺸴� �а� �ٺ��� ��´�.");
			iv2.setBackgroundResource(R.drawable.kind132);
			tv2.setText("2.�ٺ��� ��� �Ӹ� ���� �¸�ٿ� ��ġ��Ų��.\n�ü��� ������ ���ϰ� ���ο� ���� �־� �㸮�� �ܴ��� �����ش�.");
			iv3.setBackgroundResource(R.drawable.kind133);
			tv3.setText("3.������ �߳����� ������ ������ �ʵ��� �ϸ鼭 ������� ������ �� ������ �ɴ´�.");
			iv4.setBackgroundResource(R.drawable.kind134);
			tv4.setText("4.�ߵڲ�ġ�� �δٴ� �������� ������� ���� �ָ鼭 �Ͼ��.");
			tv5.setText("����Ʈ\n�ֿ� � ���� : �����α�,��б�,�������");
			break;
		case 21:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind210);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind211);
			tv1.setText("1.�ٴڿ� ���� ������ ���θ��� ���� �ٴڰ� �������� �ʵ��� �Ѵ�.");
			iv2.setBackgroundResource(R.drawable.kind212);
			tv2.setText("2.����� �Ϳ� ��� ���ο� ���� �ָ鼭 ���� ��¦ ���.");
			iv3.setBackgroundResource(R.drawable.kind213);
			tv3.setText("3.����� �ٴڿ��� �� 10cm ���������� ���� �ձ۰� ���θ��鼭 �󺹺θ� �����Ѵ�");
			iv4.setBackgroundResource(R.drawable.kind214);
			tv4.setText("4.�󺹺��� ������ �����鼭 õõ�� ������ �ٴ����� ������.\n�̶� �Ӹ��� ������ �ٴڿ� ���� �ʵ��� �Ѵ�.");
			tv5.setText("ũ��ġ\n�ֿ� � ���� : ������ ���");
			break;
		case 22:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind220);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind221);
			tv1.setText("1.��ġ�� ���� ��ġ ���κ��� �� ������ ��´�.");
			iv2.setBackgroundResource(R.drawable.kind222);
			tv2.setText("2.�ٸ��� ���ø� �� ������ ��¦ ���θ���. ����� ���� ������ ���� �ø���.");
			iv3.setBackgroundResource(R.drawable.kind223);
			tv3.setText("3.������ ������ �ٽ� ����ġ�Ѵ�.");
			tv5.setText("���� ������\n�ֿ� � ���� : ������ �Ϻ�");
			break;
		case 31:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind310);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind311);
			tv1.setText("1.�� ������ �ٺ��� ����ʺ�� ��� �ٸ��� ����ʺ�ŭ ������ ����.");
			iv2.setBackgroundResource(R.drawable.kind312);
			tv2.setText("2.�Ȳ�ġ�� �������� ������Ű��, �̵α��� ���� �̿��� �ٺ��� ���ø���.\n���� ������ �ﰢ�� ������ ���ϵ��� �Ѵ�.");
			iv3.setBackgroundResource(R.drawable.kind313);
			tv3.setText("3.õõ�� �̵α��� ������ �����鼭 �ٺ��� ������.");
			tv5.setText("��-�ٺ�\n�ֿ� � ���� : ����̵α�,����,�����");
			break;
		case 32:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind320);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind321);
			tv1.setText("1.����ʺ�� ���� ������ ������� ��� �չٴ��� �������� ���ϰ� �� �� ���� ���� ��ġ��Ų��.");
			iv2.setBackgroundResource(R.drawable.kind322);
			tv2.setText("2.������ �̵α��� ������ ���÷� �ִ� ������ �����ϰ� �����Ͽ� �ո��� �ٱ������� ��Ʋ���ش�.");
			iv3.setBackgroundResource(R.drawable.kind323);
			tv3.setText("3.������ �Ӹ� ���� ���ø���.");
			iv4.setBackgroundResource(R.drawable.kind324);
			tv4.setText("4.�չٴ��� ������ ���ϰ� �ؼ� ������ õõ�� ������.");
			tv5.setText("�� ������-����\n�ֿ� � ���� : ����̵α�,�ﰢ��");
			break;
		case 41:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind410);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind411);
			tv1.setText("1.�ӽſ� �ɾ� �����̿� ����� ������Ų��.");
			iv2.setBackgroundResource(R.drawable.kind412);
			tv2.setText("2.����� ���ǿ� ��� ����ʺ�ŭ ���� ���� ������ ���.");
			iv3.setBackgroundResource(R.drawable.kind413);
			tv3.setText("3.�ɴ´ٴ� �������� õõ�� ������ 90���� �� ������ ���θ���.");
			iv4.setBackgroundResource(R.drawable.kind414);
			tv4.setText("4.�ߵڲ�ġ�� �δٴ� �������� ������� ���� �ָ鼭 ������ ���.");
			tv5.setText("���� ������\n�ֿ� � ���� : �����α�");
			break;
		case 42:
			uri = Uri.parse("android.resource://com.example.homme/" + R.raw.kind420);
			video.setVideoURI(uri);
			video.start();
			iv1.setBackgroundResource(R.drawable.kind421);
			tv1.setText("1.����̿� ���� ��� �����̸� ���� ����, �߸��� ����ʺ񺸴� ���� ������ ���е忡 ������Ų��.");
			iv2.setBackgroundResource(R.drawable.kind422);
			tv2.setText("2.�ٸ��� ���÷� ������ �켭 ����� ������ �����Ų��.");
			iv3.setBackgroundResource(R.drawable.kind423);
			tv3.setText("3.õõ�� ������ �����鼭 �ٸ��� ������ ������ �����Ѵ�.");
			tv5.setText("���� �ͽ��ټ�\n�ֿ� � ���� : �����α�");
			break;
			default:
				break;
		}
		
		
	}

}
