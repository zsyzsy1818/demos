package com.libill.demos.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.libill.demos.R;

public class SimpleAdapterListActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.layout_simpleadapter, new String[] { "title", "info", "img" }, new int[] { R.id.tv_title, R.id.tv_info, R.id.iv_img });
		setListAdapter(adapter);
		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(SimpleAdapterListActivity.this, "收藏："+getData().get(position).get("title"), Toast.LENGTH_SHORT).show();				
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "三星");
		map.put("info", "android phone");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "华为");
		map.put("info", "android phone too");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "小米");
		map.put("info", "also android phone");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		return list;
	}
}
