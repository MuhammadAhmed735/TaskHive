package com.stride.taskmanager.fragments;



import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.stride.taskmanager.R;
import com.stride.taskmanager.adapters.TaskAdapter;
import com.stride.taskmanager.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TasksFragment extends Fragment {

    private ListView listView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    public TasksFragment() {
        // Required empty public constructor
    }

    public static TasksFragment newInstance(String param1, String param2) {
        TasksFragment fragment = new TasksFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Handle arguments if needed
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        listView = view.findViewById(R.id.taskListView);

        // Initialize the task list and adapter
        taskList = generateRandomTasks();
        taskAdapter = new TaskAdapter(getContext(), taskList);
        listView.setAdapter(taskAdapter);

        return view;
    }

    private List<Task> generateRandomTasks() {
        List<Task> tasks = new ArrayList<>();


        int taskicon = R.drawable.task_icons;
        String taskTitle = "OOAD Assignment";
        String date = "20/10/2024";
        int taskStatus = R.drawable.ic_done;

        for (int i = 0; i < 10; i++) {

            tasks.add(new Task(taskicon, taskTitle, date, taskStatus));
        }

        return tasks;
    }
}
