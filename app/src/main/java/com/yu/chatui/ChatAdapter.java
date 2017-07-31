package com.yu.chatui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by D22436 on 2017/7/31.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<Msg> msgs;
    private Context mContex;

    public ChatAdapter(List<Msg> msgs, Context mContex) {
        this.msgs = msgs;
        this.mContex = mContex;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView msgReceive;
        public TextView msgSend;
        public LinearLayout rContainer;
        public LinearLayout sContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            rContainer = (LinearLayout) itemView.findViewById(R.id.id_container_receiver);
            sContainer = (LinearLayout) itemView.findViewById(R.id.id_container_send);
            msgReceive = (TextView) itemView.findViewById(R.id.id_receive);
            msgSend = (TextView) itemView.findViewById(R.id.id_send);

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContex).inflate(R.layout.item_chat_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Msg msg = msgs.get(position);
        if (msg.getMsgType() == Msg.MSG_TYPE_RECEIVE) {   // 判断消息类型
            holder.sContainer.setVisibility(View.GONE);  // 隐藏
            holder.msgReceive.setText(msg.getMsg());
            holder.msgReceive.setOnClickListener(new View.OnClickListener() { // 添加点击事件
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContex,"msgReceive mag:"+msg.getMsg(),Toast.LENGTH_SHORT).show();
                }
            });
        } else if (msg.getMsgType() == Msg.MSG_TYPE_SEND) {
            holder.rContainer.setVisibility(View.GONE);
            holder.msgSend.setText(msg.getMsg());
            holder.msgSend.setOnClickListener(new View.OnClickListener() { // 添加点击事件
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContex,"msgSend mag:"+msg.getMsg(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }
}
