package com.example.akshay.dentalcare3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DocBlogActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_blog);

        getSupportActionBar().setTitle("Doc Blog");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<DocBlogItem> docBlogItemArrayList = new ArrayList<>();
        docBlogItemArrayList.add(new DocBlogItem(R.drawable.reasonfordentalconsultation,
                "Important reasons for Dental Consultation",
                "22, july 2017",
                "A dental consultation is a non-invasive visit with your dental care provider where you can discuss your issues, concerns, and treatment options. Many of our dentists offer free consultations, though others do ask for a small consultation fee to cover their time. If you’re considering any major dental procedure, a consultation is a good idea, and can be important for several reasons"));
        docBlogItemArrayList.add(new DocBlogItem(R.drawable.reasonfordentalconsultation,
                "Important reasons for Dental Consultation",
                "22, july 2017",
                "A dental consultation is a non-invasive visit with your dental care provider where you can discuss your issues, concerns, and treatment options. Many of our dentists offer free consultations, though others do ask for a small consultation fee to cover their time. If you’re considering any major dental procedure, a consultation is a good idea, and can be important for several reasons"));
        docBlogItemArrayList.add(new DocBlogItem(R.drawable.reasonfordentalconsultation,
                "Important reasons for Dental Consultation",
                "22, july 2017",
                "A dental consultation is a non-invasive visit with your dental care provider where you can discuss your issues, concerns, and treatment options. Many of our dentists offer free consultations, though others do ask for a small consultation fee to cover their time. If you’re considering any major dental procedure, a consultation is a good idea, and can be important for several reasons"));
        docBlogItemArrayList.add(new DocBlogItem(R.drawable.reasonfordentalconsultation,
                "Important reasons for Dental Consultation",
                "22, july 2017",
                "A dental consultation is a non-invasive visit with your dental care provider where you can discuss your issues, concerns, and treatment options. Many of our dentists offer free consultations, though others do ask for a small consultation fee to cover their time. If you’re considering any major dental procedure, a consultation is a good idea, and can be important for several reasons"));
        docBlogItemArrayList.add(new DocBlogItem(R.drawable.reasonfordentalconsultation,
                "Important reasons for Dental Consultation",
                "22, july 2017",
                "A dental consultation is a non-invasive visit with your dental care provider where you can discuss your issues, concerns, and treatment options. Many of our dentists offer free consultations, though others do ask for a small consultation fee to cover their time. If you’re considering any major dental procedure, a consultation is a good idea, and can be important for several reasons"));
        docBlogItemArrayList.add(new DocBlogItem(R.drawable.reasonfordentalconsultation,
                "Important reasons for Dental Consultation",
                "22, july 2017",
                "A dental consultation is a non-invasive visit with your dental care provider where you can discuss your issues, concerns, and treatment options. Many of our dentists offer free consultations, though others do ask for a small consultation fee to cover their time. If you’re considering any major dental procedure, a consultation is a good idea, and can be important for several reasons"));


        mRecyclerView = findViewById(R.id.rvDocBlog);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new DocBlogAdapter(docBlogItemArrayList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
