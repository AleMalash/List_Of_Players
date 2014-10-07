package com.example.alexander.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Alexander on 05.10.2014.
 */
public class MyView extends RelativeLayout {

    //region Constructors
    public MyView(Context context){
        super(context);
        init(null);
    }

    public MyView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        init(attrs);
    }
    //endregion

    private void init(AttributeSet attrs){

        inflate(getContext(), R.layout.my_view,this);

        ImageView image = (ImageView) findViewById(R.id.view_image);
        TextView name = (TextView) findViewById(R.id.view_name);
        ImageButton button1 = (ImageButton) findViewById(R.id.view_button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.view_button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.view_button3);
        TextView info = (TextView) findViewById(R.id.view_info);

        if (attrs!=null){
            TypedArray array = getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.view_attrs,0,0);
            try{
                Drawable drawable = array.getDrawable(R.styleable.view_attrs_res_icon);
                if (drawable==null){
                    drawable = getResources().getDrawable(R.drawable.ic_launcher);
                }

                String viewName=array.getString(R.styleable.view_attrs_res_name);
                String viewInfo=array.getString(R.styleable.view_attrs_res_info);

                Drawable drawable1 = array.getDrawable(R.styleable.view_attrs_res_button1);
                if (drawable==null){
                    drawable = getResources().getDrawable(R.drawable.ic_launcher);
                }

                Drawable drawable2 = array.getDrawable(R.styleable.view_attrs_res_button2);
                if (drawable==null){
                    drawable = getResources().getDrawable(R.drawable.ic_launcher);
                }

                Drawable drawable3 = array.getDrawable(R.styleable.view_attrs_res_button3);
                if (drawable==null){
                    drawable = getResources().getDrawable(R.drawable.ic_launcher);
                }

                image.setImageDrawable(drawable);
                name.setText(viewName);
                button1.setImageDrawable(drawable1);
                button2.setImageDrawable(drawable2);
                button3.setImageDrawable(drawable3);
                info.setText(viewInfo);
            } finally{
                array.recycle();
            }
        }
    }
}
