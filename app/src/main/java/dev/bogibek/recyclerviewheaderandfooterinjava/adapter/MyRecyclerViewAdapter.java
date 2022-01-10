package dev.bogibek.recyclerviewheaderandfooterinjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.bogibek.recyclerviewheaderandfooterinjava.R;
import dev.bogibek.recyclerviewheaderandfooterinjava.model.Member;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_ITEM_HEADER=0;
    private static final int TYPE_ITEM_ONLINE=1;
    private static final int TYPE_ITEM_OFFLINE=2;
    private static final int TYPE_ITEM_FOOTER=3;

    Context context;
    ArrayList<Member> members;

    public MyRecyclerViewAdapter(ArrayList<Member> members) {
        this.members = members;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType==TYPE_ITEM_HEADER){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header,parent,false);
            return new ViewHeaderHolder(view);
        }else if(viewType==TYPE_ITEM_FOOTER){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer,parent,false);
            return new ViewFooterHolder(view);
        } else if (viewType==TYPE_ITEM_ONLINE){
            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_online,parent,false);
            return new ViewOnlineHolder(view);
        }
        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact_offline,parent,false);
        return new ViewOfflineHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return TYPE_ITEM_HEADER;
        if (isFooter(position)) return TYPE_ITEM_FOOTER;

        Member member = members.get(position);
        if (member.isOnline()){
            return TYPE_ITEM_ONLINE;
        } else {
            return TYPE_ITEM_OFFLINE;
        }
    }

    private boolean isFooter(int position) {
        return position==members.size()-1;
    }

    private boolean isHeader(int position) {
        return position==0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (isHeader(position) || isFooter(position)) return;
        Member member=members.get(position);
        if (holder instanceof ViewOnlineHolder){
            ((ViewOnlineHolder) holder).tvFullName.setText(member.getName());
            ((ViewOnlineHolder) holder).tvphoneNumber.setText(member.getPhoneNumber());
        }
        if (holder instanceof ViewOfflineHolder){
            ((ViewOfflineHolder) holder).tvFullName.setText(member.getName());
            ((ViewOfflineHolder) holder).tvphoneNumber.setText(member.getPhoneNumber());
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }


    class ViewHeaderHolder extends RecyclerView.ViewHolder {
       public View view;

        public ViewHeaderHolder( View view) {
            super(view);
            this.view=view;
        }
    }

    class ViewOnlineHolder extends RecyclerView.ViewHolder {
        View view;
        TextView tvFullName,tvphoneNumber;

        public ViewOnlineHolder( View view) {
            super(view);
            this.view=view;
            tvFullName=view.findViewById(R.id.tv_name_online);
            tvphoneNumber=view.findViewById(R.id.tv_phone_number_online);

        }
    }

    class ViewOfflineHolder extends RecyclerView.ViewHolder {
        View view;
        TextView tvFullName,tvphoneNumber;

        public ViewOfflineHolder( View view) {
            super(view);
            tvFullName=view.findViewById(R.id.tv_name_offline);
            tvphoneNumber=view.findViewById(R.id.tv_phone_number_offline);
            this.view=view;
        }
    }

    class ViewFooterHolder extends RecyclerView.ViewHolder {
        View view;

        public ViewFooterHolder( View view) {
            super(view);
            this.view=view;
        }
    }
}
