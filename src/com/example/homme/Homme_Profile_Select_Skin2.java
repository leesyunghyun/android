package com.example.homme;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Homme_Profile_Select_Skin2 extends Activity {

	private ListView listselectskin2;
	private MyAdapter m_adapter;
	private int agepoint = 0;
	private Boolean checkflag[];
	private Button btnselectskin2;
	private ArrayList<String> items;
	private String[] str = { "�Ϸ翡 Ŀ�Ǹ� ���� 3���̻� ���Ŵ�", "�� 3ȸ �̻� ���ָ� �ϴ� ���̴�",
			"���� ���� �Ѵ�", "�����Ͽ� 3�ð� �̻� ������ ��Ѵ�", "���� 8�ð� �̻� ǫ �ܴ�",
			"���ĺ��ٴ� ä���� �� ��ȣ�Ѵ�", "�����Ͽ� 1�ð� �̻��� �Ǻΰ����� �Ѵ�", "�Ļ�� ��Ģ������ �ϴ� ���̴�",
			"���� 3�ð� �̻� �޺��� �ٴ�", "������ ���� �� �ڿܼ� �������� �ٸ���", "�� �Ǻο� �´� �������� ����Ѵ�",
			"��ħ�� �������� �Ϸ� 2�� ������ �Ѵ�", "����� �ϴ� ���̴�", "���� ������ ����Ѵ�",
			"��� ��Ʈ������ ���� �޴� ���̴�", "�Ǻ� Ʈ������ ����� �ٷ� �Ǻΰ��� ã�´�",
			"�ָ������� ���� ��ɼ� ȭ��ǰ�� ����Ѵ�" };
	private Intent result;
	private Intent intent;
	private int activityflag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profileselectskin2);

		intent = getIntent();
		activityflag = intent.getIntExtra("activityflag", 0);
		
		btnselectskin2 = (Button) findViewById(R.id.btnselectskin2);
		listselectskin2 = (ListView) findViewById(R.id.listselectskin2);

		items = new ArrayList<String>();

		for (int i = 0; i < str.length; i++)
			items.add(str[i]);
		
		checkflag = new Boolean[str.length];
		
		for(int i=0;i<checkflag.length;i++)
			checkflag[i] = false;
		m_adapter = new MyAdapter(this, android.R.layout.simple_list_item_1,
				items);

		listselectskin2.setAdapter(m_adapter);
		listselectskin2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				CheckBox checkBox = (CheckBox) view;
				checkBox.setChecked(!checkBox.isChecked());
				if(checkflag[position] == false)
				{
					checkflag[position] = true;
				}
				else
				{
					checkflag[position] = false;
				}
				
				m_adapter.notifyDataSetChanged();
			}
		});

		btnselectskin2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				//����Ʈ���
				if(checkflag[0] == true)
					agepoint = agepoint + 1;
				else
					agepoint = agepoint;
				if(checkflag[1] == true)
					agepoint = agepoint + 2;
				else
					agepoint = agepoint - 1;
				if(checkflag[2] == true)
					agepoint = agepoint + 2;
				else
					agepoint = agepoint - 1;
				if(checkflag[3] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint + 1;
				if(checkflag[4] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint + 1;
				if(checkflag[5] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint + 1;
				if(checkflag[6] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint + 1;
				if(checkflag[7] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint;
				if(checkflag[8] == true)
					agepoint = agepoint + 3;
				else
					agepoint = agepoint - 1;
				if(checkflag[9] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint + 2;
				if(checkflag[10] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint;
				if(checkflag[11] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint + 1;
				if(checkflag[12] == true)
					agepoint = agepoint + 2;
				else
					agepoint = agepoint - 1;
				if(checkflag[13] == true)
					agepoint = agepoint + 2;
				else
					agepoint = agepoint;
				if(checkflag[14] == true)
					agepoint = agepoint + 2;
				else
					agepoint = agepoint - 1;
				if(checkflag[15] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint + 1;
				if(checkflag[16] == true)
					agepoint = agepoint - 1;
				else
					agepoint = agepoint + 1;
				
				switch(activityflag)
				{
				case 0:
					result = new Intent();
					result.putExtra("skinageflag", agepoint);
					setResult(1,result);
					finish();
					break;
				case 1:
					LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					LinearLayout abc = (LinearLayout) vi.inflate(
							R.layout.dlgback, null);
					TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
					tvdlg1.setText("\n������ ����� �����ʿ� �ݿ��Ͻðڽ��ϱ�?");
					
					AlertDialog.Builder dlg = new AlertDialog.Builder(Homme_Profile_Select_Skin2.this);
					dlg.setView(abc);
					dlg.setPositiveButton("�ݿ�", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							result = new Intent();
							result.putExtra("skinageflag2", agepoint);
							setResult(1,result);
							finish();
						}
					});
					
					dlg.setNegativeButton("���", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							finish();
						}
					});
					dlg.show();
					break;
					
					
				}
				
				
			}
		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout abc = (LinearLayout) vi.inflate(
				R.layout.dlgback, null);
		TextView tvdlg1 = (TextView) abc.findViewById(R.id.tvdlg1);
		tvdlg1.setText("\n�����ϸ� �ۼ��� ������ �������ϴ�.\n�����Ͻðڽ��ϱ�?");
		
		AlertDialog.Builder dlg = new AlertDialog.Builder(
				Homme_Profile_Select_Skin2.this);
		dlg.setTitle("���!");
		dlg.setView(abc);
		dlg.setPositiveButton("Ȯ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

				finish();
			}
		});
		dlg.setNegativeButton("���", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		dlg.setCancelable(false);
		dlg.show();
	}

	public class MyAdapter extends ArrayAdapter {

		private Activity m_context;
		private ArrayList<String> m_arrayList;
		private ArrayList<CheckBox> m_checkBoxList;

		public MyAdapter(Activity context, int textViewResourceId,
				ArrayList<String> objects) {
			super(context, textViewResourceId, objects);
			// TODO Auto-generated constructor stub
			m_context = context;
			m_arrayList = objects;
			setCheckBoxList();
		}

		private void setCheckBoxList() {
			m_checkBoxList = new ArrayList<CheckBox>();
			for (int i = 0; i < m_arrayList.size(); i++) {
				CheckBox checkBox = new CheckBox(m_context);
				checkBox.setFocusable(false);
				checkBox.setClickable(false);
				checkBox.setText(m_arrayList.get(i));
				m_checkBoxList.add(checkBox);
			}
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return m_checkBoxList.get(position);
		}

	}
}
