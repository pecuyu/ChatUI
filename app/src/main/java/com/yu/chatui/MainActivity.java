package com.yu.chatui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Msg> msgs = initDatas();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_rv);
        ChatAdapter adapter = new ChatAdapter(msgs, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.scrollToPosition(msgs.size() - 1); // 滚动到最后一条
        recyclerView.setAdapter(adapter);

    }

    private List<Msg> initDatas() {
        List<Msg> msgs = new ArrayList<>();
        for (int i=0;i<20;i++) {
            Msg msg = new Msg(i, i % 2, "this is msg " + (i % 2 == 0 ? "receive" : "send"));
            msgs.add(msg);
        }
        return msgs;
    }
}
