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
			"남성의 피부 상태와 주기를 고려한 기능성 스킨, 여드름성 피부사용에 적합하며 임상실험 완료. 미백, 주름개선 기능성 인증",
			"피부 유수분 밸런스 조절, 피부결 정돈, 모공 케어, 피부 진정 및 보습효과",
			"특허 받은 7가지 혼합 물질이 함유되어 풍부한 수딩효과와 빠른 피부진정 효과를 제공. 미백/주름개선 2중 기능성,",
			"번들거림을 완화해 주는 지성/트러블 전용 토너. 식물설분 하마멜리스 추출물이 일시적으로 모공을 수축해 피부결을 개선.",
			"민감성 남성 피부를 편안하게 해 진정시켜주고, 과다한 피지 분비를 조절. 남성용 화장품을 처음 사용하는 20대 남성과 모공이 넓은 남성분들에게 추천.",
			"모공의 노폐물과 피지는 깨끗이 닦아주고, 산뜻한 수분감을 부여. 윌로우박추출물이 지성피부의 들뜬 각질 제거와 피부 정화에 도움을 준다.",
			"외부 자극에 민감하게 반응하는 민감성 피부, 피부결이 얇고 빠른 흡수력, 산뜻한 수분감의 기초 제품을 찾는 사람에게 추천.10대 ~ 20대 초반에게 추천.",
			"여드름성 피부에 사용이 적합하며, 피부 손상을 집중적으로 개선시켜주는 영양 기능성 크림, 손상된 피부를 회복시키고 자극을 완화해주는 집중 회과의 남성용 기능성 세럼",
			"예민하고 민감한 피부, 푸석푸석 건조한 피부, 피지와 유분이 많은 피부에게 추천.",
			"피지와 번들거림을 관리하여 산뜻하고 깔끔한 남성 피부로 가꿔주는 오일 컨트롤 로션 20대초반~20대중반 연령층 추천",
			"브로콜리싹 추출물 78%가 함유된 민감성 피부를 위한 수분 에멀전. 화학 성분이 최소로 함유된 기초 제품.",
			"지성/트러블 피부를 매트하게 해 주는 번들거림 방지 로션. 끈적임 없이 피부에 빠르게 흡수되는 젤 타입의 피지 흡수 페이퍼 텍스처로, L.디지타타 성분과 진주석 파우더 성분이 과다 피지를 케어하여 트러블을 관리." };

	private String[] strskinkind2 = {
			"세안 후 수분 집중 공급.미백, 주름 기능성 스킨. 촉촉한 피부결 유지 아침의 스킨 케어 후에도 오후 금새 푸석해지는 피부, 지속된 건조함으로 탄력을 잃은 피부인 사람에게 추천",
			"제주 무농약 생녹차수가 즉각적인 피부 당김을 해소해주는 고농축 에센셜 스킨",
			"면도와 외부 자극으로 인해 거칠어진 남성 피부에 청량감과 수분감을 제공해주며, 노화가 진행되고 있는 남성 피부의 주름을 완화시켜 탄력있는 피부로 관리해주는 리퀴드 안티-링클 스킨. 20대후반~40대초반 연령층 추천",
			"산뜻한 워터-젤 타입의 끈적임 없는 애프터 쉐이브. 얼굴에 닿는 순간 끈적임 없이 빠르게 흡수되는 워터-젤 타입으로 순수 플랑크톤 PTP와 올리고 미네랄 복합체가 보습을 강화하고 세안 후 즉각적으로 피부에 생기와 상쾌함을 부여.",
			"아로니아열매추출물이 함유되어 있고, 들뜬 각질을 정돈해주고 피부에 수분을 공급해주는 토너. 환절기 피부 건조 증상이 있거나 생기 있고 촉촉한 피부로 가꾸고 싶은 사람에게 추천.",
			"제주 무농약 생녹차수가 즉각적인 보습막을 형성하여 촉촉하게 가꾸어주는 고농축 크림",
			"5000리터 스파워터 함유 보습로션. 스파워터 성분과 올리고 미네랄 복합체, 각종 비타민이 남성 피부에 필수적인 수분을 공급해 주어 피부가 하루 종일 촉촉해지도록 도와준다.",
			"건조한 당김이 느껴지지 않도록 풍부한 수분과 영양을 공급하여 남성 피부의 주름을 관리해주는 로션",
			"아로니아열매추출물이 함유되어 있고, 가볍게 발리며 피부에 수분을 공급해주는 수분 에멀전. 환절기 피부 건조 증상이 있거나 생기 있고 촉촉한 피부로 가꾸고 싶은 사람에게 추천." };

	private String[] strskinkind11 = { "낫츠 밸런싱 토너 포맨", "라노아 퓨어 플라워 클래리파잉 스킨",
			"보쏘드 터보 부스터 스킨 데이", "비오템 티-쀼르 모공 케어 토너", "미샤 포맨 퓨어 액티브 스킨",
			"이니스프리 그린티 프레시 스킨", "스킨푸드 어린잎 퓨어 브로콜리 토너", "낫츠 밸런싱 모이스춰라이저 포맨",
			"보쏘드 워터풀 로션", "미샤 포맨 퓨어 액티브 로션", "스킨푸드 어린잎 퓨어 브로콜리 에멀전",
			"비오템 옴므 티-쀼르 번들거림 방지 로션" };

	private String[] strskinkind21 = { "낫츠 아쿠아 베리어 하이드로 소프너",
			"이니스프리 그린티 모이스처 스킨", "미샤 포맨 레드 파워 스킨", "비오템 옴므 아쿠아파워 토너",
			"스킨푸드 수분베리 토너", "이니스프리 그린티 모이스처 크림", "비오템 옴므 아쿠아파워",
			"미샤 옴므 레드 파워 로션", "스킨푸드 수분베리 에멀전" };

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

	private String[] strskinkind = { "스킨(토너)", "로션(에멀젼.크림)" };
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

				if (skinviewflag) {// 지성
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

				} else {// 건성
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
						tvdlg1.setText("\n제품종류 : " + strskinkind[0]
								+ "\n\n제품가격 : " + strskinkind01[viewindex]
								+ " (원)");

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Skin_Kind.this);
						dlg.setTitle("제품정보");
						dlg.setView(abc);
						dlg.setPositiveButton("닫기",
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
						tvdlg1.setText("\n제품종류 : " + strskinkind[1]
								+ "\n\n제품가격 : " + strskinkind01[viewindex]
								+ " (원)");

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Skin_Kind.this);
						dlg.setTitle("제품정보");
						dlg.setView(abc);
						dlg.setPositiveButton("닫기",
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
						tvdlg1.setText("\n제품종류 : " + strskinkind[0]
								+ "\n\n제품가격 : " + strskinkind02[viewindex]
								+ " (원)");

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Skin_Kind.this);
						dlg.setTitle("제품정보");
						dlg.setView(abc);
						dlg.setPositiveButton("닫기",
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
						tvdlg1.setText("\n제품종류 : " + strskinkind[1]
								+ "\n\n제품가격 : " + strskinkind02[viewindex]
								+ " (원)");

						AlertDialog.Builder dlg = new AlertDialog.Builder(
								Homme_Skin_Kind.this);
						dlg.setTitle("제품정보");
						dlg.setView(abc);
						dlg.setPositiveButton("닫기",
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

			if (skinviewflag) {// 지성
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

			} else {// 건성
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
