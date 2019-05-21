package com.example.administrator.diandiantv;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private RecyclerView movieList;
    private MovieListAdapter movieAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        movieList = findViewById ( R.id.movieList );


        movieList.setLayoutManager ( new LinearLayoutManager ( this ) );

        movieList.setAdapter ( new MovieListAdapter ( MainActivity.this, new MovieListAdapter.OnItemClickListener ( ) {
            @Override
            public void onClick( int pos ) {
                String movieName = MovieLab.get ( ).getMovie ( pos );
                String movieUrl = MovieLab.get ( ).getUrl ( pos );
                Intent intent = new Intent ( MainActivity.this, LiveActivity.class );
                intent.putExtra ( "url", movieUrl );
                intent.putExtra ( "name", movieName );
                startActivity ( intent );
            }
        } ) );

        movieList.addItemDecoration ( new MyDecoration ( ) );

    }
        class MyDecoration extends RecyclerView.ItemDecoration{
            @Override
                    public void getItemOffsets(Rect outRect,View view,RecyclerView parent,RecyclerView.State state){
                super.getItemOffsets(outRect,view,parent,state);
                outRect.set(0,0,0,getResources ().getDimensionPixelOffset ( R.dimen.dividerHeight ));
            }
        }
    }
}
