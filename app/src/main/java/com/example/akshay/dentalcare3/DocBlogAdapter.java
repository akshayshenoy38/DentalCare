package com.example.akshay.dentalcare3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DocBlogAdapter extends RecyclerView.Adapter<DocBlogAdapter.DocBlogViewHolder> {
    private ArrayList<DocBlogItem> mDocBlogItemArrayList = new ArrayList<>();


    public static class DocBlogViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivDocBlog;
        public TextView tvDocBlogTitle,tvDocBlogDate,tvDocBlogContent;

        public DocBlogViewHolder(View itemView) {
            super(itemView);
            ivDocBlog = (ImageView) itemView.findViewById(R.id.ivDocBlog);
            tvDocBlogTitle = (TextView) itemView.findViewById(R.id.tvDocBlogTitle);
            tvDocBlogDate = (TextView) itemView.findViewById(R.id.tvDocBlogDate);
            tvDocBlogContent = (TextView) itemView.findViewById(R.id.tvDocBlogContent);
        }
    }

    public DocBlogAdapter(ArrayList<DocBlogItem> docBlogItemArrayList){
        mDocBlogItemArrayList = docBlogItemArrayList;
    }


    @NonNull
    @Override
    public DocBlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_blog_item,parent,false);
        DocBlogViewHolder docBlogViewHolder = new DocBlogViewHolder(view);
        return docBlogViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DocBlogViewHolder holder, int position) {
        DocBlogItem currentItem = mDocBlogItemArrayList.get(position);

        holder.ivDocBlog.setImageResource(currentItem.getImageResource());
        holder.tvDocBlogTitle.setText(currentItem.getDocBlogTitle());
        holder.tvDocBlogDate.setText(currentItem.getBlogDate());
        holder.tvDocBlogContent.setText(currentItem.getContent());
    }

    @Override
    public int getItemCount() {
        return mDocBlogItemArrayList.size();
    }



}
