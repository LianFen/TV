package com.example.administrator.diandiantv;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.Objects;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>{


    private Context mContext;
    private AdapterView.OnItemClickListener mListener;
    private View itemView;


    public MovieListAdapter( Context context, AdapterView.OnItemClickListener listener ){
        this.mContext=context;
        this.mListener=listener;
    }

    public MovieListAdapter( MainActivity context, OnItemClickListener onItemClickListener ) {

    }


    @Override
    public MovieViewHolder onCreateViewHolder( ViewGroup parent,int viewType){
        //找到电影行对应的xml，并将其“反析”出来（inflate）
        boolean attachToRoot;
        View container = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view, parent, false);
        MovieViewHolder a=new MovieViewHolder ( LayoutInflater.from ( mContext ).inflate ( R.Layout.movie_view,parent,false ) );
;
        
        return new MovieViewHolder(itemView );
    }


    @Override
    public void onBindViewHolder(  MovieViewHolder holder, final int position){
        String name=MovieLab.get ().getMovie ( position );
        holder.bind(name);
        holder.itemView.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick( View v ) {
                mListener.onClick(position);
            }
        } );
    }


    @Override
    public int getItemCount(){
        return MovieLab.get ().getSize ();
    }

    //内容类,应该于电影布局XML对应
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView movieName;

        public MovieViewHolder(View itemView){
            super(itemView);
            movieName=(TextView) itemView.findViewById ( R.id.movieName );
        }
        /**
         * 把穿入的信息显示到对应控件上
         * @param movieName
         */
        public void bind(String movieName){
            this.movieName.setText(movieName);
        }


        }
    public interface OnItemClickListener{
        void onClick(int pos);

    }
}
