package com.example.homework_shop;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstAdapter extends BaseAdapter {
    private Context context;
    String[] socialSites;
    private Button buy;
    int[] images= {R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery, R.drawable.ic_menu_manage,
            R.drawable.ic_menu_send, R.drawable.ic_menu_share};

    public FirstAdapter(Context context){
        this.context=context;
        socialSites=context.getResources().getStringArray(R.array.social);
    }
    @Override
    public int getCount() {
        return socialSites.length;
    }

    @Override
    public Object getItem(int position) {
        return socialSites[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=null;
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.first_custom_row, parent, false);

        }else{
            row=convertView;
        }
        TextView nav_custom_text=(TextView) row.findViewById(R.id.product_name);
        ImageView nav_custom_image=(ImageView) row.findViewById(R.id.product_image);
        nav_custom_text.setText(socialSites[position]);
        nav_custom_image.setImageResource(R.drawable.product);
        /*Button buy = (Button)row.findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(first_custom_row.this,"已加入購物車",Toast.LENGTH_SHORT).show();
            }
        });*/
        return row;
    }
}
