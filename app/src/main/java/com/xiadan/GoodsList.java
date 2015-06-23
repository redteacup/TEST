package com.nju.xiadan;

import com.example.xiadan.R;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class GoodsList extends Activity {
	private EditText edittext;
	private TextView textview;
	private Spinner mainspinner;
	private Spinner lastspinner;
	ArrayAdapter<String> mainadapter;
	ArrayAdapter<String> lastadapter;
	static int pot;
	public String item1;
	public String item2;

	private String[] main = new String[] { "全部", "饮料", "食品", "文教", "日用", "电子",
			"其他", };
	private String[][] last = new String[][] { { "" },
			{ "可口可乐", "百事可乐", "美年达", "芬达", "七喜", "矿泉水", "其他" },
			{ "小吃", "水果", "正餐", "蔬菜", "特色食品", "休闲食品", "点心", "其他" },
			{ "文具类", "纸本类", "教科书", "健身类", "代复印", "装扮类", "纪念品类", "其他" },
			{ "洗漱类", "洗衣类", "安全类", "洗澡用品", "防蚊防虫", "日用药品类", "厨房用品类", "其他" },
			{ "计算器", "收音机", "电灯类", "数据线充电器", "电池类", "日用电子", "其他" },
			{ "杂货", "代理" } };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods_list);
		setSpinner();
		edittext = (EditText) findViewById(R.id.editText1);
		textview = (TextView) findViewById(R.id.textView5);

		// textview.setText("您选择的是："+item1+edittext.getText().toString());
	}

	private void setSpinner() {
		// TODO Auto-generated method stub
		mainspinner = (Spinner) findViewById(R.id.spinner1);
		lastspinner = (Spinner) findViewById(R.id.spinner2);

		mainadapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, main);
		mainspinner.setAdapter(mainadapter);
		mainspinner.setSelection(0, true);

		lastadapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, last[0]);
		lastspinner.setAdapter(lastadapter);
		lastspinner.setSelection(0, true);

		mainspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						lastadapter = new ArrayAdapter<String>(GoodsList.this,
								android.R.layout.simple_spinner_item,
								last[arg2]);
						lastspinner.setAdapter(lastadapter);
						item1 = mainadapter.getItem(arg2);
						pot = arg2;
						
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});
		
		lastspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				item2=lastadapter.getItem(arg2);
				textview.setText("   您选择的是："+item1+"类"+"  "+item2);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.goods_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
