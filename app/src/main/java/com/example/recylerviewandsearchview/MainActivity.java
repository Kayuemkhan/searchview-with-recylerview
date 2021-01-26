package com.example.recylerviewandsearchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.example.recylerviewandsearchview.Adapters.ExampleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;
    private androidx.appcompat.widget.SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
    }
    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "One", "Ten"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_search_24, "Two", "Eleven"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "Three", "Twelve"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_search_24, "Four", "Thirteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "Five", "Fourteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_search_24, "Six", "Fifteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "Seven", "Sixteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_search_24, "Eight", "Seventeen"));
        exampleList.add(new ExampleItem(R.drawable.ic_launcher_background, "Nine", "Eighteen"));
    }
    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_meny, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}