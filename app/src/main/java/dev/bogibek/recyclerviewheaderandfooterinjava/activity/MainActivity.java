package dev.bogibek.recyclerviewheaderandfooterinjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import dev.bogibek.recyclerviewheaderandfooterinjava.R;
import dev.bogibek.recyclerviewheaderandfooterinjava.adapter.MyRecyclerViewAdapter;
import dev.bogibek.recyclerviewheaderandfooterinjava.model.Member;

public class MainActivity extends AppCompatActivity {
    Context context;
    MyRecyclerViewAdapter myRecyclerViewAdapter;
    ArrayList<Member> members;
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        context = this;
        members = new ArrayList();
        prepareMembers();
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(members);
        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new GridLayoutManager(context, 1));
        rvMain.setAdapter(myRecyclerViewAdapter);
    }

    private void prepareMembers() {
        members.add(new Member());
        for (int i = 0; i < 100; i++) {
            if (i == 4 || i == 23 || i == 54 || i == 75) {
                members.add(new Member("Bogibek" + i, "+99894234432", false));
            } else {
                members.add(new Member("Matyaqubov" + i, "+998975259712", true));
            }

        }
        members.add(new Member());
    }
}