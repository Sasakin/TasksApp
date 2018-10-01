package com.charot.tasksapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charot.tasksapp.R;
import com.charot.tasksapp.adapter.TaskListAdapter;
import com.charot.tasksapp.dto.TaskDto;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_history;

    public static HistoryFragment getInstance(Context context) {
        Bundle args = new Bundle();
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_history));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        RecyclerView rv =  (RecyclerView)view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new TaskListAdapter(createMockData()));



        return view;
    }

    private List<TaskDto> createMockData() {
        List<TaskDto> res = new ArrayList<>();
        res.add(new TaskDto("item 1"));
        res.add(new TaskDto("item 2"));
        res.add(new TaskDto("item 3"));
        res.add(new TaskDto("item 4"));
        res.add(new TaskDto("item 5"));
        res.add(new TaskDto("item 6"));

        return res;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
