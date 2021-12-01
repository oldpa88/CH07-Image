package tw.oldpa.m0708;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class M0708 extends ListActivity {
    private TextView mTxtResult;
    private ArrayList<Map<String,Object>> mList;
    private TextView mDesc;
    private String[] listDescr;
    private String[] listFromResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0708);
        setupViewComponent();
    }

    private void setupViewComponent() {
        mTxtResult=(TextView)findViewById(R.id.m0708_t001);
        mDesc=(TextView)findViewById(R.id.m0708_t002);
        //抓資料放到陣列中
         listFromResource = getResources().getStringArray(R.array.teacname);
         listDescr = getResources().getStringArray(R.array.descr);
        Integer[] imgArr={
                R.drawable.t001,
                R.drawable.t002,
                R.drawable.t003,
                R.drawable.t004,
                R.drawable.t005,
                R.drawable.t006,
                R.drawable.t007};
        mList = new ArrayList<Map<String,Object>>();

        for(int i=0; i<listFromResource.length;i++){
            Map<String,Object> item = new HashMap<String,Object>();

            item.put("imgView",imgArr[i]);
            item.put("txtView",listFromResource[i]);
            mList.add(item);
        }
        //建立Adapter
        SimpleAdapter adapter = new SimpleAdapter(this,mList,R.layout.list_item,
                new String[]{"imgView","txtView"},
                new int[]{R.id.imgView,R.id.txtView});
        //設定Adapter
        setListAdapter(adapter);

        ListView listview = getListView();
        listview.setTextFilterEnabled(true);
        listview.setOnItemClickListener(listviewOnItemClkLis);

    }

    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String s =((TextView)view.findViewById(R.id.txtView)).getText().toString();
            mTxtResult.setText(getString(R.string.m0708_t002)+s);
            mDesc.setText(getString(R.string.m0708_descr)+listDescr[position]);
        }
    };
}
