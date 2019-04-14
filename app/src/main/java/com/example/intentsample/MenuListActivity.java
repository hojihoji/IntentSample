package com.example.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvMenu = findViewById(R.id.lvMenu);
        List<Map<String,String>> menuList = new ArrayList<>();
        Map<String,String> menu = new HashMap<>();
        menu.put("name","唐揚げ定食");
        menu.put("price","700");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","ハンバーグ定食");
        menu.put("price","850");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","生姜焼き定食");
        menu.put("price","800");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","ステーキ定食");
        menu.put("price","1050");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","野菜炒め定食");
        menu.put("price","750");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","とんかつ定食");
        menu.put("price","850");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","ミンチかつ定食");
        menu.put("price","850");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","チキンカツ定食");
        menu.put("price","950");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","コロッケ定食");
        menu.put("price","650");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","焼き魚定食");
        menu.put("price","800");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name","焼肉定食");
        menu.put("price","850");
        menuList.add(menu);

        String[] form = {"name","price"};
        int[] to = {android.R.id.text1,android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this,menuList,android.R.layout.simple_list_item_2,form,to);

        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String,String> item = (Map<String, String>) parent.getItemAtPosition(position);
            String menuName = item.get("name");
            String menuPrice = item.get("price");

            Intent intent = new Intent(MenuListActivity.this,MenuThanksActivity.class);
            intent.putExtra("menuName",menuName);
            intent.putExtra("menuPrice",menuPrice);
            startActivity(intent);
        }
    }

}
