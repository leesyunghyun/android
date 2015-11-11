package com.example.homme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Homme_Skin_Kind extends Activity {

	private Button btnskinkind1, btnskinkind2, btnskinkind3;
	private TextView tvskinkind1, tvskinkind2;
	private ImageView imageskinkind;
	private PointF mLastPoint = null;
	private String[] strskinkind1 = {
			"������ �Ǻ� ���¿� �ֱ⸦ ����� ��ɼ� ��Ų, ���帧�� �Ǻλ�뿡 �����ϸ� �ӻ���� �Ϸ�. �̹�, �ָ����� ��ɼ� ����",
			"�Ǻ� ������ �뷱�� ����, �Ǻΰ� ����, ��� �ɾ�, �Ǻ� ���� �� ����ȿ��",
			"Ư�� ���� 7���� ȥ�� ������ �����Ǿ� ǳ���� ����ȿ���� ���� �Ǻ����� ȿ���� ����. �̹�/�ָ����� 2�� ��ɼ�,",
			"����Ÿ��� ��ȭ�� �ִ� ����/Ʈ���� ���� ���. �Ĺ����� �ϸ��Ḯ�� ���⹰�� �Ͻ������� ����� ������ �Ǻΰ��� ����.",
			"�ΰ��� ���� �Ǻθ� ����ϰ� �� ���������ְ�, ������ ���� �к� ����. ������ ȭ��ǰ�� ó�� ����ϴ� 20�� ������ ����� ���� �����е鿡�� ��õ.",
			"����� ���󹰰� ������ ������ �۾��ְ�, ����� ���а��� �ο�. ���ο�����⹰�� �����Ǻ��� ��� ���� ���ſ� �Ǻ� ��ȭ�� ������ �ش�.",
			"�ܺ� �ڱؿ� �ΰ��ϰ� �����ϴ� �ΰ��� �Ǻ�, �Ǻΰ��� ��� ���� �����, ����� ���а��� ���� ��ǰ�� ã�� ������� ��õ.10�� ~ 20�� �ʹݿ��� ��õ.",
			"���帧�� �Ǻο� ����� �����ϸ�, �Ǻ� �ջ��� ���������� ���������ִ� ���� ��ɼ� ũ��, �ջ�� �Ǻθ� ȸ����Ű�� �ڱ��� ��ȭ���ִ� ���� ȸ���� ������ ��ɼ� ����",
			"�����ϰ� �ΰ��� �Ǻ�, Ǫ��Ǫ�� ������ �Ǻ�, ������ ������ ���� �Ǻο��� ��õ.",
			"������ ����Ÿ��� �����Ͽ� ����ϰ� ����� ���� �Ǻη� �����ִ� ���� ��Ʈ�� �μ� 20���ʹ�~20���߹� ������ ��õ",
			"����ݸ��� ���⹰ 78%�� ������ �ΰ��� �Ǻθ� ���� ���� ������. ȭ�� ������ �ּҷ� ������ ���� ��ǰ.",
			"����/Ʈ���� �Ǻθ� ��Ʈ�ϰ� �� �ִ� ����Ÿ� ���� �μ�. ������ ���� �Ǻο� ������ ����Ǵ� �� Ÿ���� ���� ��� ������ �ؽ�ó��, L.����ŸŸ ���а� ���ּ� �Ŀ�� ������ ���� ������ �ɾ��Ͽ� Ʈ������ ����." };

	private String[] strskinkind2 = {
			"���� �� ���� ���� ����.�̹�, �ָ� ��ɼ� ��Ų. ������ �Ǻΰ� ���� ��ħ�� ��Ų �ɾ� �Ŀ��� ���� �ݻ� Ǫ�������� �Ǻ�, ���ӵ� ���������� ź���� ���� �Ǻ��� ������� ��õ",
			"���� ����� ���������� �ﰢ���� �Ǻ� ����� �ؼ����ִ� ����� ������ ��Ų",
			"�鵵�� �ܺ� �ڱ����� ���� ��ĥ���� ���� �Ǻο� û������ ���а��� �������ָ�, ��ȭ�� ����ǰ� �ִ� ���� �Ǻ��� �ָ��� ��ȭ���� ź���ִ� �Ǻη� �������ִ� ������ ��Ƽ-��Ŭ ��Ų. 20���Ĺ�~40���ʹ� ������ ��õ",
			"����� ����-�� Ÿ���� ������ ���� ������ ���̺�. �󱼿� ��� ���� ������ ���� ������ ����Ǵ� ����-�� Ÿ������ ���� �ö�ũ�� PTP�� �ø��� �̳׶� ����ü�� ������ ��ȭ�ϰ� ���� �� �ﰢ������ �Ǻο� ����� �������� �ο�.",
			"�ƷδϾƿ������⹰�� �����Ǿ� �ְ�, ��� ������ �������ְ� �Ǻο� ������ �������ִ� ���. ȯ���� �Ǻ� ���� ������ �ְų� ���� �ְ� ������ �Ǻη� ���ٰ� ���� ������� ��õ.",
			"���� ����� ���������� �ﰢ���� �������� �����Ͽ� �����ϰ� ���پ��ִ� ����� ũ��",
			"5000���� ���Ŀ��� ���� �����μ�. ���Ŀ��� ���а� �ø��� �̳׶� ����ü, ���� ��Ÿ���� ���� �Ǻο� �ʼ����� ������ ������ �־� �Ǻΰ� �Ϸ� ���� ������������ �����ش�.",
			"������ ����� �������� �ʵ��� ǳ���� ���а� ������ �����Ͽ� ���� �Ǻ��� �ָ��� �������ִ� �μ�",
			"�ƷδϾƿ������⹰�� �����Ǿ� �ְ�, ������ �߸��� �Ǻο� ������ �������ִ� ���� ������. ȯ���� �Ǻ� ���� ������ �ְų� ���� �ְ� ������ �Ǻη� ���ٰ� ���� ������� ��õ." };

	private String[] strskinkind11 = { "���� �뷱�� ��� ����", "���� ǻ�� �ö�� Ŭ�������� ��Ų",
			"����� �ͺ� �ν��� ��Ų ����", "����� Ƽ-�ظ� ��� �ɾ� ���", "�̻� ���� ǻ�� ��Ƽ�� ��Ų",
			"�̴Ͻ����� �׸�Ƽ ������ ��Ų", "��ŲǪ�� ��� ǻ�� ����ݸ� ���", "���� �뷱�� ���̽�������� ����",
			"����� ����Ǯ �μ�", "�̻� ���� ǻ�� ��Ƽ�� �μ�", "��ŲǪ�� ��� ǻ�� ����ݸ� ������",
			"����� �ȹ� Ƽ-�ظ� ����Ÿ� ���� �μ�" };

	private String[] strskinkind21 = { "���� ����� ������ ���̵�� ������",
			"�̴Ͻ����� �׸�Ƽ ���̽�ó ��Ų", "�̻� ���� ���� �Ŀ� ��Ų", "����� �ȹ� ������Ŀ� ���",
			"��ŲǪ�� ���к��� ���", "�̴Ͻ����� �׸�Ƽ ���̽�ó ũ��", "����� �ȹ� ������Ŀ�",
			"�̻� �ȹ� ���� �Ŀ� �μ�", "��ŲǪ�� ���к��� ������" };

	private int[] nkind111 = { R.drawable.skinimage11, R.drawable.skinimage12,
			R.drawable.skinimage13, R.drawable.skinimage14,
			R.drawable.skinimage15, R.drawable.skinimage16,
			R.drawable.skinimage17, R.drawable.skinimage18,
			R.drawable.skinimage19, R.drawable.skinimage20,
			R.drawable.skinimage21, R.drawable.skinimage22 };

	private int[] nkind211 = { R.drawable.skinimage31, R.drawable.skinimage32,
			R.drawable.skinimage33, R.drawable.skinimage34,
			R.drawable.skinimage35, R.drawable.skinimage36,
			R.drawable.skinimage37, R.drawable.skinimage38,
			R.drawable.skinimage39 };

	private String[] strskinkind01 = { "42,000", "16,500", "35,000", "49,000",
			"14,800", "14,000", "11,000", "42,000", "37,000", "14,800",
			"11,000", "49,000" };

	private String[] strskinkind02 = { "52,000", "14,000", "19,800", "51,000",
			"15,000", "15,000", "53,000", "19,800", "15,000" };

	private String[] strskinkind = { "��Ų(���)", "�μ�(������.ũ��)" };
	private int viewindex = 0;
	private int skintype;
	private boolean skinviewflag;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.skinkind);
		mLastPoint = new PointF();

		btnskinkind1 = (Button) findViewById(R.id.btnskinkind1);
		btnskinkind2 = (Button) findViewById(R.id.btnskinkind2);
		btnskinkind3 = (Button) findViewById(R.id.btnskinkind3);
		tvskinkind1 = (TextView) findViewById(R.id.tvskinkind1);
		tvskinkind2 = (TextView) findViewById(R.id.tvskinkind2);
		imageskinkind = (ImageView) findViewById(R.id.imageskinkind);

		btnskinkind1.setEnabled(false);
		btnskinkind1.setVisibility(View.INVISIBLE);
		intent = getIntent();
		skintype = intent.getIntExtra("skintypes", 0);

		switch (skintype) {
		case 0:
			skinviewflag = false;
			imageskinkind.setBackgroundResource(R.drawable.skinimage31);
			tvskinkind1.setText(strskinkind21[viewindex]);
			tvskinkind2.setText(strskinkind2[viewindex]);
			break;
		case 1:
			skinviewflag = false;
			imageskinkind.setBackgroundResource(R.drawable.skinimage31);
			tvskinkind1.setText(strskinkind21[viewindex]);
			tvskinkind2.setText(strskinkind2[viewindex]);
			break;
		case 2:
			skinviewflag = false;
			imageskinkind.setBackgroundResource(R.drawable.skinimage31);
			tvskinkind1.setText(strskinkind21[viewindex]);
			tvskinkind2.setText(strskinkind2[viewindex]);
			break;
		case 3:
			skinviewflag = true;
			imageskinkind.setBackgroundResource(R.drawable.skinimage11);
			tvskinkind1.setText(strskinkind11[viewindex]);
			tvskinkind2.setText(strskinkind1[viewindex]);
			break;
		case 4:
			skinviewflag = true;
			imageskinkind.setBackgroundResource(R.drawable.skinimage11);
			tvskinkind1.setText(strskinkind11[viewindex]);
			tvskinkind2.setText(strskinkind1[viewindex]);
			break;
		}

		btnskinkind1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (viewindex == 0)
					return;

				if (skinviewflag) {// ����
					viewindex--;
					imageskinkind.setBackgroundResource(nkind111[viewindex]);
					tvskinkind1.setText(strskinkind11[viewindex]);
					tvskinkind2.setText(strskinkind1[viewindex]);

					if (viewindex == nkind111.length - 1) {
						btnskinkind2.setEnabled(false);
						btnskinkind2.setVisibility(View.INVISIBLE);
					} else {
						btnskinkind2.setEnabled(true);
						btnskinkind2.setVisibility(View.VISIBLE);
					}

				} else {// �Ǽ�
					viewindex--;
					imageskinkind.setBackgroundResource(nkind211[viewindex]);
					tvskinkind1.setText(strskinkind21[viewindex]);
					tvskinkind2.setText(strskinkind2[viewindex]);

					if (viewindex == nkind211.length - 1) {
						btnskinkind2.setEnabled(false);
						btnskinkind2.setVisibility(View.INVISIBLE);
					} else {
						btnskinkind2.setEnabled(true);
						btnskinkind2.setVisibility(View.VISIBLE);
					}
				}

				if (viewindex == 0) {
					btnskinkind1.setEnabled(false);
					btnskinkind1.setVisibility(View.INVISIBLE);
				} else {
					btnskinkind1.setEnabled(true);
					btnskinkind1.setVisibility(View.VISIBLE);
				}
			}
		});

		btnskinkind2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (skinviewflag) {
					if (viewindex == nkind111.length - 1)
						return;

					viewindex++;
					imageskinkind.setBackgroundResource(nkind111[viewindex]);
					tvskinkind1.setText(strskinkind11[viewindex]);
					tvskinkind2.setText(strskinkind1[viewindex]);

					if (viewindex == nkind111.length - 1) {
						btnskinkind2.setEnabled(false);
						btnskinkind2.setVisibility(View.INVISIBLE);
					} else {
						btnskinkind2.setEnabled(true);
						btnskinkind2.setVisibility(View.VISIBLE);
					}
				} else {
					if (viewindex == nkind211.length - 1)
						return;

					viewindex++;
					imageskinkind.setBackgroundResource(nkind211[viewindex]);
					tvskinkind1.setText(strskinkind21[viewindex]);
					tvskinkind2.setText(strskinkind2[viewindex]);

					if (viewindex == nkind211.length - 1) {
						btnskinkind2.setEnabled(false);
						btnskinkind2.setVisibility(View.INVISIBLE);
					} else {
						btnskinkind2.setEnabled(true);
						btnskinkind2.setVisibility(View.VISIBLE);
					}
				}

				if (viewindex == 0) {
					btnskinkind1.setEnabled(false);
					btnskinkind1.setVisibility(View.INVISIBLE);
				} else {
					btnskinkind1.setEnabled(true);
					btnskinkind1.setVisibility(View.VISIBLE);
				}

			}
		});

		btnskinkind3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (skinviewflag) {
					if (viewindex < 7) {
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc
								.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n��ǰ���� : " + strskinkind[0]
								+ "\n\n��ǰ���� : " + strskinkind01[viewindex]
								+ " (��)");

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Skin_Kind.this);
						dlg.setTitle("��ǰ����");
						dlg.setView(abc);
						dlg.setPositiveButton("�ݱ�",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						dlg.show();
					} else {
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc
								.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n��ǰ���� : " + strskinkind[1]
								+ "\n\n��ǰ���� : " + strskinkind01[viewindex]
								+ " (��)");

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Skin_Kind.this);
						dlg.setTitle("��ǰ����");
						dlg.setView(abc);
						dlg.setPositiveButton("�ݱ�",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						dlg.show();
					}
				} else {
					if (viewindex < 5) {
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc
								.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n��ǰ���� : " + strskinkind[0]
								+ "\n\n��ǰ���� : " + strskinkind02[viewindex]
								+ " (��)");

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Skin_Kind.this);
						dlg.setTitle("��ǰ����");
						dlg.setView(abc);
						dlg.setPositiveButton("�ݱ�",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						dlg.show();
					} else {
						LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						LinearLayout abc = (LinearLayout) vi.inflate(
								R.layout.dlgback, null);
						TextView tvdlg1 = (TextView) abc
								.findViewById(R.id.tvdlg1);
						tvdlg1.setText("\n��ǰ���� : " + strskinkind[1]
								+ "\n\n��ǰ���� : " + strskinkind02[viewindex]
								+ " (��)");

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Skin_Kind.this);
						dlg.setTitle("��ǰ����");
						dlg.setView(abc);
						dlg.setPositiveButton("�ݱ�",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});

						dlg.show();
					}

				}
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

			if (skinviewflag) {
				if (viewindex == nkind111.length - 1)
					return false;
				viewindex++;
				imageskinkind.setBackgroundResource(nkind111[viewindex]);
				tvskinkind1.setText(strskinkind11[viewindex]);
				tvskinkind2.setText(strskinkind1[viewindex]);

				if (viewindex == nkind111.length - 1) {
					btnskinkind2.setEnabled(false);
					btnskinkind2.setVisibility(View.INVISIBLE);
				} else {
					btnskinkind2.setEnabled(true);
					btnskinkind2.setVisibility(View.VISIBLE);
				}

			} else {
				if (viewindex == nkind211.length - 1)
					return false;

				viewindex++;
				imageskinkind.setBackgroundResource(nkind211[viewindex]);
				tvskinkind1.setText(strskinkind21[viewindex]);
				tvskinkind2.setText(strskinkind2[viewindex]);

				if (viewindex == nkind211.length - 1) {
					btnskinkind2.setEnabled(false);
					btnskinkind2.setVisibility(View.INVISIBLE);
				} else {
					btnskinkind2.setEnabled(true);
					btnskinkind2.setVisibility(View.VISIBLE);
				}
			}

			if (viewindex == 0) {
				btnskinkind1.setEnabled(false);
				btnskinkind1.setVisibility(View.INVISIBLE);
			} else {
				btnskinkind1.setEnabled(true);
				btnskinkind1.setVisibility(View.VISIBLE);
			}
		} else {
			if (viewindex == 0)
				return false;

			if (skinviewflag) {// ����
				viewindex--;
				imageskinkind.setBackgroundResource(nkind111[viewindex]);
				tvskinkind1.setText(strskinkind11[viewindex]);
				tvskinkind2.setText(strskinkind1[viewindex]);

				if (viewindex == nkind111.length - 1) {
					btnskinkind2.setEnabled(false);
					btnskinkind2.setVisibility(View.INVISIBLE);
				} else {
					btnskinkind2.setEnabled(true);
					btnskinkind2.setVisibility(View.VISIBLE);
				}

			} else {// �Ǽ�
				viewindex--;
				imageskinkind.setBackgroundResource(nkind211[viewindex]);
				tvskinkind1.setText(strskinkind21[viewindex]);
				tvskinkind2.setText(strskinkind2[viewindex]);

				if (viewindex == nkind211.length - 1) {
					btnskinkind2.setEnabled(false);
					btnskinkind2.setVisibility(View.INVISIBLE);
				} else {
					btnskinkind2.setEnabled(true);
					btnskinkind2.setVisibility(View.VISIBLE);
				}
			}

			if (viewindex == 0) {
				btnskinkind1.setEnabled(false);
				btnskinkind1.setVisibility(View.INVISIBLE);
			} else {
				btnskinkind1.setEnabled(true);
				btnskinkind1.setVisibility(View.VISIBLE);
			}
		}
		return true;
	}

}
