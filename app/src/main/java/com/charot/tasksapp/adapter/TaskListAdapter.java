package com.charot.tasksapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.charot.tasksapp.R;
import com.charot.tasksapp.dto.TaskDto;

import java.util.List;

public class TaskListAdapter extends  RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {

    private List<TaskDto> data;

    public TaskListAdapter(List<TaskDto> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskDto item = data.get(position);

        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;

        public TaskViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView)  itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
