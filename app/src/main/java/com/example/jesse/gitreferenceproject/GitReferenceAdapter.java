package com.example.jesse.gitreferenceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 3/1/2018.
 */

public class GitReferenceAdapter extends BaseAdapter {
    private Context gitContext;
    private LayoutInflater mInflater;
    private List<GitReference> mGitReference;

    public GitReferenceAdapter(Context gitContext, List<GitReference> mGitReference){
        this.gitContext = gitContext;
        this.mGitReference = mGitReference;
        mInflater = (LayoutInflater) gitContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return mGitReference.size();
    }

    @Override
    public Object getItem(int position) {
        return mGitReference.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArrayList<GitReference> results = new ArrayList<GitReference>();
        View rowView = mInflater.inflate(R.layout.listview, (ViewGroup) convertView.getParent(), false);

        GitReference arr1 = new GitReference();

        TextView gitCommand = rowView.findViewById(R.id.command);
        TextView gitExample = rowView.findViewById(R.id.example);
        TextView gitExplanation = rowView.findViewById(R.id.explanation);
        TextView gitSection = rowView.findViewById(R.id.section);

        GitReference gitReference = (GitReference) getItem(position);
        gitCommand.setText(gitReference.getCommand());
        gitExample.setText(gitReference.getExample());
        gitExplanation.setText(gitReference.getExplaination());
        gitSection.setText(gitReference.getSection());


        return rowView;
    }
}
