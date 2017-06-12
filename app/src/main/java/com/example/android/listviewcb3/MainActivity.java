package com.example.android.listviewcb3;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText movie_name, movie_rating, movie_release;
    Button btnadd;
    ListView listView;
    ArrayList<Movies> movies=generatemovies();
    MovieAdapter movieAdapter=new MovieAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movie_name = (EditText) findViewById(R.id.et_movieName);
        movie_rating = (EditText) findViewById(R.id.movie_Rating);
        movie_release = (EditText) findViewById(R.id.et_movie_release);
        btnadd = (Button) findViewById(R.id.btnAdd);
        listView = (ListView) findViewById(R.id.lv_Movies);
        listView.setAdapter(movieAdapter);
        btnadd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                movies.add(new Movies(movie_name,movie_release,movie_rating));
                movieAdapter.notifyDataSetChanged();
            }
        });
    }
    static ArrayList<Movies> generatemovies () {
        ArrayList<Movies> movies = new ArrayList<>();
        return movies;
    }
    class MovieAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return movies.size();
        }

        @Override
        public Object getItem(int position) {
            return movies.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li=getLayoutInflater();
            Movies thisMovie =(Movies) getItem(position);

            if(convertView==null){
                convertView=li.inflate(R.layout.list_item_movies,null);
            }

            View itemView =li.inflate(R.layout.list_item_movies,null);

            ((TextView)itemView.findViewById(R.id.tv_Moviename)).setText(thisMovie.getName().getText().toString());
            ((TextView)itemView.findViewById(R.id.tv_movieRating)).setText(thisMovie.getRating().getText().toString());
            ((TextView)itemView.findViewById(R.id.tv_MovieRelease)).setText(thisMovie.getRelease_Date().getText().toString());
            return itemView;
        }
        }

}