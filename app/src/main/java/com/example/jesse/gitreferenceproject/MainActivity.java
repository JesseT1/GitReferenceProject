package com.example.jesse.gitreferenceproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<GitReference> arr1 = new ArrayList<>();
        List<GitReference> listItems = JsonUtils.populateGitReferences("gitReference.json");
        GitReference gitReference;
        gitReference = new GitReference();
        GitReferenceAdapter adapter = new GitReferenceAdapter(this, listItems);
        ListView listView = (ListView) findViewById(R.id.list1);
        listView.setAdapter(adapter);

        ArrayList<GitReference> gitReferences = new ArrayList<>();

        gitReference = new GitReference();
        gitReference.setCommand(gitReference.getCommand());
        gitReference.setExample(gitReference.getExample());
        gitReference.setExplaination(gitReference.getExample());
        gitReference.setSection(gitReference.getSection());
        arr1.add(gitReference);


    }
    public void ProcessJson(View view) {
        try {
            InputStream is = getApplicationContext().getAssets().open("gitReference.json");
            String jsonString = JsonUtils.parseJsonToString(is);
            JsonUtils.populateGitReferences(jsonString);
        }
        catch (Exception e) {

        }
    }
}
