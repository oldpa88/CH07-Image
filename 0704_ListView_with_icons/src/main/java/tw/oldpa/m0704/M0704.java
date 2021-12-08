package tw.oldpa.m0704;


import android.app.ActionBar;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0704 extends ListActivity {
    private TextView mTxtResult;
    private ArrayList<Map<String, Object>> mList;
    private String[] listFromResource01,listFromResource02;
    private ActionBar mActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0704);

        setupViewComponent();
    }

//    private void init() {
//            mActionBar = getActionBar(); //取得Activity的ActionBar
////            mActionBar.setDisplayShowTitleEnabled(true); //false : 隱藏程式標題
////            mActionBar.setDisplayUseLogoEnabled(true); //true : 允許改變成式的小圖示
//            mActionBar.show(); //顯示ActionBar
////            mActionBar.hide(); //隱藏ActionBar
//     }

    private void setupViewComponent() {
        mTxtResult = (TextView) findViewById(R.id.m0704_t001);
        listFromResource01 = getResources().getStringArray(R.array.weekday01);
        listFromResource02 = getResources().getStringArray(R.array.weekday02);
//---------------------------------------------------------------
        mList = new ArrayList<Map<String, Object>>();
//---------------------------------------------------------------

        for (int i = 0; i < listFromResource01.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String idName = "img" + String.format("%02d"+"th", i+1);
            int resID = getResources().getIdentifier(idName, "drawable", getPackageName());
//            item.put("imgView", R.drawable.img01th);  //
            item.put("imgView", resID);  //
            item.put("txtView01", listFromResource01[i]);
            item.put("txtView02", listFromResource02[i]);
            mList.add(item);  //增加一筆
            //
            SimpleAdapter adapter = new SimpleAdapter(
                    this,
                    mList,
                    R.layout.list_item,
                    new String[]{"imgView", "txtView01","txtView02"},
                    new int[]{R.id.imgView, R.id.txtView01,R.id.txtView02});
            //----------------------------------------------------------------
            setListAdapter(adapter);
            ListView listview = getListView();
            listview.setTextFilterEnabled(true);
            listview.setOnItemClickListener(listviewOnItemClkLis);
        }
    }


    AdapterView.OnItemClickListener    listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            // When clicked, show a toast with the TextView text
            mTxtResult.setText(getText(R.string.ans)+listFromResource01[position]);
        }
    };
    //*******************************************************************************************
    @Override
    public void onBackPressed() {
//super.onBackPressed();//不執行這行
        Toast.makeText(getApplication(), "禁用返回鍵", Toast.LENGTH_SHORT).show();
    }


}