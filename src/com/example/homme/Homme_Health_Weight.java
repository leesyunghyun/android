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

		TabSpec spec1 = tabHost.newTabSpec("spec1").setIndicator("����");
		spec1.setContent(R.id.tab1);
		tabHost.addTab(spec1);

		TabSpec spec2 = tabHost.newTabSpec("spec2").setIndicator("������");
		spec2.setContent(R.id.tab2);
		tabHost.addTab(spec2);

		TabSpec spec3 = tabHost.newTabSpec("spec3").setIndicator("�Ĵ�");
		spec3.setContent(R.id.tab3);
		tabHost.addTab(spec3);

		TabSpec spec4 = tabHost.newTabSpec("spec4").setIndicator("���");
		spec4.setContent(R.id.tab4);
		tabHost.addTab(spec4);

		tabHost.setCurrentTab(0);

		switch (flag) {
		case 0:
			tv5.setText("����� ��ü�� �̹Ƿ� �Ʒ��� ���� � �� ������ �䱸�մϴ�");
			iv1.setBackgroundResource(R.drawable.tabimage11);
			iv2.setBackgroundResource(R.drawable.tabimage12);
			iv3.setBackgroundResource(R.drawable.tabimage13);
			tv1.setText("1.Ȱ������ ���� ���Ĺ��� �Դ� ���� ����\n2.���� ���Ĺ��� ����� ��ȭ, ������� ����\n3.����� ����\n4.�����̳� ���󼱱�� ���� ��� ���� �Ҹ� ��ȯ\n5.�ɸ��� ��Ʈ����, �Ҿ�, ���� ������ ���� �Ŀ����");
			tv2.setText("1.�Ŀ����, ��ȭ��� � ���� ����, ��ٰ���\n2.��ü �鿪�� ����, ��������ȯ ����\n3.���� �Ƿΰ��� ������ �Ǻΰ� ���������� ź�¼� ����");
			tv3.setText("1.�ݵ�� 1�� 3ȸ�� �Ļ縦 ��Ģ������ �Ѵ�.\n2.�Ļ�� �Ļ� ���̿� ���緮�� ������ �����Ѵ�.\n3.�ʹ� ���� ���� ������ �Ѳ����� �Ա⺸��, ������ ����Ǿ� �ִ� ��ǰ�� �����Ѵ�.\n4.����ģ ���� ����, Ŀ�� ���� ī���� ����� ����� ����� �����ϹǷ� �ﰣ��.");
			tv4.setText("1.��ð��� �Ϸ� 1�ð� �̳��� ª�� �Ѵ�.\n2.���ſ� ���Է� ���� �ݺ�, ��Ʈ ������ �޽��� 3�� ������ �Ѵ�.\n3.�� ������ 2~3���� �̻��� ��� ���� �ʴ´�.\n4.ª�� ��ϰ� ���� ����� �ʴ´�.");
			break;
		case 1:
			tv5.setText("����� ����ü��/������ �̹Ƿ� �Ʒ��� ���� � �� ������ �䱸�մϴ�");
			iv1.setBackgroundResource(R.drawable.tabimage21);
			iv2.setBackgroundResource(R.drawable.tabimage22);
			iv3.setBackgroundResource(R.drawable.tabimage23);
			tv1.setText("1.�ұ�Ģ�� �Ľ���\n2.���� �Ǵ� ����\n3.��ȭ��ְ� �־ ����� ������� ����\n4.���������� ����");
			tv2.setText("1.������ ��â���� ���� �㸮�ѷ� ����\n2.�索�պ���, ���庴 ���� ����\n3.������������ ���� ���κ� ���� ����");
			tv3.setText("1.��ä�� �������� ���ַ� �� ������ �Ļ�� ��Ģ���� �Ļ����\n2.����,������ ���� �ʰ� �Ϸ� ���� Į�θ��� ���߾ �Ļ�");
			tv4.setText("1.�䰡, ����, ����κ�, ���� �� ����ҿ�� ��Ģ������ �Ѵ�.\n2.���� ��� �����Ͽ� �������� �÷� ���ʴ�緮�� ������Ų��.\n3.����� �Ŀ� ����ҿ�� 30~40�� ���� �Ѵ�.");
			break;
		case 2:
			tv5.setText("����� ��ü��(��) �̹Ƿ� �Ʒ��� ���� � �� ������ �䱸�մϴ�");
			iv1.setBackgroundResource(R.drawable.tabimage31);
			iv2.setBackgroundResource(R.drawable.tabimage32);
			iv3.setBackgroundResource(R.drawable.tabimage33);
			tv1.setText("1.����������\n2.�ұ�Ģ�� �Ļ�� ���� �ð��� �Ļ�\n3.��� ���� �ʴ� ��Ȱ ����\n4.���İ� ������ ź��ȭ��, ���� ����");
			tv2.setText("1.���������� �索�� �ߺ��� ����\n2.�㼮���� �Ϻ��� ��� �� �ߺ�����\n3.�索�� ���� �պ��� �ߺ� ����\n4.���������� ���� �պ��� �ߺ� ����");
			tv3.setText("1.��Ģ���� �Ļ�Ȱ 1�� 3���� ������, 1�� ���差���� 2~300kcal���� ���߾ �Ļ��Ѵ�.\n2.������ �ܽ��� ��ȿ���� ����Ű�Ƿ� ���緮�� �����Ѵ�.\n3.�⸧�� ����, ��Į�θ� ����, �ʰų� ¥�� �ڱ����� ������ �����Ѵ�.\n4.���� 7�� ���ķδ� ������ ���� �ʴ´�.");
			tv4.setText("1.���������� � ���ٴ� ����,���̵�,����,�䰡,����κ� �� ����ҿ�� �� 5�ð� �̻� �ǽ��Ѵ�.\n2.Ư�� ������ ��� �ϱ� ���ٴ� ���� ��� �Ѵ�.\n3.��� �־ ���� �߿��� ���� �Ļ緮 �����̴�. �ڽ��� ������ �Ĵ��� �����ϸ鼭 ��Ģ������ ��� �ϴ� ������ ���δ�.");
			break;
		default:
			tv5.setText("����");
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
