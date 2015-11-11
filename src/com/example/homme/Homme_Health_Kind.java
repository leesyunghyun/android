package com.example.homme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homme_Health_Kind extends Activity {

	private Button btnkind1, btnkind2, btnkind3, btnkind4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.healthkind);
		btnkind1 = (Button) findViewById(R.id.btnhealthkind1);
		btnkind2 = (Button) findViewById(R.id.btnhealthkind2);
		btnkind3 = (Button) findViewById(R.id.btnhealthkind3);
		btnkind4 = (Button) findViewById(R.id.btnhealthkind4);
		
		btnkind1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Health_Kind.this);
				dlg.setTitle("�ｺ3��");
				String str[] ={"���帮��Ʈ","��ġ������","����Ʈ"};
				dlg.setItems(str, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Homme_Health_Kind.this, Homme_Health_Health.class);
						switch(which){
						case 0:
							intent.putExtra("kind", 11);
							break;
						case 1:
							intent.putExtra("kind", 12);
							break;
						case 2:
							intent.putExtra("kind", 13);
							break;
						}
						startActivity(intent);
					}
				});
				
				dlg.show();
			}
		});

		btnkind2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Health_Kind.this);
				dlg.setTitle("���ο");
				String str[] ={"ũ��ġ","���׷�����"};
				dlg.setItems(str, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Homme_Health_Kind.this, Homme_Health_Health.class);
						switch(which){
						case 0:
							intent.putExtra("kind", 21);
							break;
						case 1:
							intent.putExtra("kind", 22);
							break;
						}
						startActivity(intent);
					}
				});
				
				dlg.show();
			}
		});

		btnkind3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Health_Kind.this);
				dlg.setTitle("�ȿ");
				String str[] ={"��-�ٺ�","�� ������-����"};
				dlg.setItems(str, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Homme_Health_Kind.this, Homme_Health_Health.class);
						switch(which){
						case 0:
							intent.putExtra("kind", 31);
							break;
						case 1:
							intent.putExtra("kind", 32);
							break;
						}
						startActivity(intent);
					}
				});
				
				dlg.show();
			}
		});

		btnkind4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Health_Kind.this);
				dlg.setTitle("�ｺ3��");
				String str[] ={"����������","���� �ͽ��ټ�"};
				dlg.setItems(str, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Homme_Health_Kind.this, Homme_Health_Health.class);
						switch(which){
						case 0:
							intent.putExtra("kind", 41);
							break;
						case 1:
							intent.putExtra("kind", 42);
							break;
						}
						startActivity(intent);
					}
				});
				
				dlg.show();
			}
		});
	}

}
