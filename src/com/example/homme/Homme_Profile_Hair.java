package com.example.homme;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Homme_Profile_Hair extends Activity {

	private Button btnHair1, btnHair2, btnHair3;
	private TextView tvHair1, tvHair2;
	private ImageView imageHair;
	private String[] strhair1 = { "±ä ¾ó±¼Çü", "Å¸¿øÀÇ ¾ó±¼Çü", "»ç°¢ÀÇ ¾ó±¼Çü", "µÕ±Ù ¾ó±¼Çü",
			"´ÙÀÌ¾Æ¸óµåÀÇ ¾ó±¼Çü" };
	private int[] strhair2 = { R.drawable.hair11, R.drawable.hair12,
			R.drawable.hair13, R.drawable.hair14, R.drawable.hair15 };
	private PointF mLastPoint = null;
	private int viewindex = 0;
	private Intent result;
	private LinearLayout lihairface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.skinkind);
		mLastPoint = new PointF();

		btnHair1 = (Button) findViewById(R.id.btnskinkind1);
		btnHair2 = (Button) findViewById(R.id.btnskinkind2);
		btnHair3 = (Button) findViewById(R.id.btnskinkind3);
		tvHair1 = (TextView) findViewById(R.id.tvskinkind1);
		tvHair2 = (TextView) findViewById(R.id.tvskinkind2);
		imageHair = (ImageView) findViewById(R.id.imageskinkind);
		lihairface = (LinearLayout) findViewById(R.id.layoutskinkind);

		btnHair3.setBackgroundResource(R.drawable.btnonoff13);
		btnHair1.setVisibility(View.INVISIBLE);
		tvHair1.setText(strhair1[viewindex]);
		lihairface.setGravity(Gravity.CENTER);
		imageHair.setBackgroundResource(strhair2[viewindex]);
		btnHair1.setEnabled(false);

		btnHair1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (viewindex == 0)
					return;

				viewindex--;
				tvHair1.setText(strhair1[viewindex]);
				imageHair.setBackgroundResource(strhair2[viewindex]);

				if (viewindex == strhair1.length - 1) {
					btnHair2.setEnabled(false);
					btnHair2.setVisibility(View.INVISIBLE);
				} else {
					btnHair2.setEnabled(true);
					btnHair2.setVisibility(View.VISIBLE);
				}

				if (viewindex == 0) {
					btnHair1.setEnabled(false);
					btnHair1.setVisibility(View.INVISIBLE);
				} else {
					btnHair1.setEnabled(true);
					btnHair1.setVisibility(View.VISIBLE);
				}
			}
		});

		btnHair2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (viewindex == strhair1.length - 1)
					return;

				viewindex++;
				tvHair1.setText(strhair1[viewindex]);
				imageHair.setBackgroundResource(strhair2[viewindex]);

				if (viewindex == strhair1.length - 1) {
					btnHair2.setEnabled(false);
					btnHair2.setVisibility(View.INVISIBLE);
				} else {
					btnHair2.setEnabled(true);
					btnHair2.setVisibility(View.VISIBLE);
				}

				if (viewindex == 0) {
					btnHair1.setEnabled(false);
					btnHair1.setVisibility(View.INVISIBLE);
				} else {
					btnHair1.setEnabled(true);
					btnHair1.setVisibility(View.VISIBLE);
				}

			}
		});

		btnHair3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				result = new Intent();
				result.putExtra("facetype", viewindex);
				setResult(2, result);
				finish();
			}
		});

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

		if (Math.abs(distance) < 100) {
			return false;
		}

		if (distance > 0) {
			if (viewindex == strhair1.length - 1)
				return false;

			viewindex++;
			tvHair1.setText(strhair1[viewindex]);
			imageHair.setBackgroundResource(strhair2[viewindex]);

			if (viewindex == strhair1.length - 1) {
				btnHair2.setEnabled(false);
				btnHair2.setVisibility(View.INVISIBLE);
			} else {
				btnHair2.setEnabled(true);
				btnHair2.setVisibility(View.VISIBLE);
			}

			if (viewindex == 0) {
				btnHair1.setEnabled(false);
				btnHair1.setVisibility(View.INVISIBLE);
			} else {
				btnHair1.setEnabled(true);
				btnHair1.setVisibility(View.VISIBLE);
			}

		} else {

			if (viewindex == 0)
				return false;

			viewindex--;
			tvHair1.setText(strhair1[viewindex]);
			imageHair.setBackgroundResource(strhair2[viewindex]);

			if (viewindex == strhair1.length - 1) {
				btnHair2.setEnabled(false);
				btnHair2.setVisibility(View.INVISIBLE);
			} else {
				btnHair2.setEnabled(true);
				btnHair2.setVisibility(View.VISIBLE);
			}

			if (viewindex == 0) {
				btnHair1.setEnabled(false);
				btnHair1.setVisibility(View.INVISIBLE);
			} else {
				btnHair1.setEnabled(true);
				btnHair1.setVisibility(View.VISIBLE);
			}
		}
		return true;
	}

}
