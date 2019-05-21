package com.example.administrator.diandiantv;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储电影信息,它在整个应用程序中应该只有一个实例，所以采用单例设计模式来完成
 */

public class MovieLab {
    private  static MovieLab instance=null;
    private List<String>movies;
    private List<String>url;
    private List<String>list;

    /**
     *让构造方法变为私有，避免外部调用
     */
    private MovieLab(){
        init ();

    }

    /** ....*/
    public static MovieLab get(){
        if (null==instance){
            instance=new MovieLab ();
        }
        return instance;
    }
    /**
     *返回此仓库中有几部电影，
     * @return  电影数量，整数。
     */
    public int getSize(){
        return movies.size ();
    }
    /**
     *返回指定的电影信息（目前只有名称）
     * @param n 电影的编号，或称为第几部电影。
     * @return 电影信息（目前只有名称信息）
     */
    public String getMovie(int n){
        return movies.get ( n );
    }

    public String getUrl(int n){
        return url.get ( n );
    }

    private void chaifen(){
        int n=0;

        for (String i:list){
            String[] tmp=i.split ( "," );
            movies.add ( tmp[0] );
            url.add ( tmp[1] );
        }
    }

    /**
     *初始化一些电影信息用于测试
     */
    private void init(){
        movies=new ArrayList<> ();
        url=new ArrayList <> (  );
        list=new ArrayList <> (  );
        movies.add ( "峨眉电影,http://scgctvshow.sctv.com/hdlive/emei/3.m3u8" );
        movies.add ( "北京怀柔1套,http://live.huairtv.com:1935/dvrLive/hrtvmb/playlist.m3u8" );
        movies.add ( "峨眉电影,http://scgctvshow.sctv.com/hdlive/emei/3.m3u8" );
        movies.add ( "济南影视,http://ts1.ijntv.cn/yshd/hd/live.m3u8" );
        movies.add ( "四川文化,http://scgctvshow.sctv.com/hdlive/sctv2/3.m3u8" );
        movies.add ( "四川经济,http://scgctvshow.sctv.com/hdlive/sctv3/3.m3u8" );
        movies.add ( "四川影视,http://scgctvshow.sctv.com/hdlive/sctv5/3.m3u8" );
        movies.add ( "四川妇女,http://scgctvshow.sctv.com/hdlive/sctv7/3.m3u8" );
        movies.add ( "四川公共,http://scgctvshow.sctv.com/sdlive/sctv9/3.m3u8" );

        movies.add ( "CCTV4,http://ivi.bupt.edu.cn/hls/cctv4.m3u8" );

        chaifen ();
    }
}
