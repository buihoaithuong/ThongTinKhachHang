package com.example.thongtinkhachhang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private MainActivity Mycontext;
    private int Mylayout;
    private List<ThongTin> arrayThongTin;
    public Adapter(MainActivity context, int layout, List<ThongTin> thongTinList) {
        Mycontext = context;
        Mylayout = layout;
        arrayThongTin = thongTinList;
    }

    @Override
    public int getCount() {
        return arrayThongTin.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private  class  ViewHolder{
        TextView TxtTenKH;
        TextView TxtSodtKH;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) Mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(Mylayout, null);

            // ánh xạ
            holder.TxtTenKH = (TextView) convertView.findViewById(R.id.txtHoTen);
            holder.TxtSodtKH = (TextView) convertView.findViewById(R.id.sdt);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ThongTin thongTin = arrayThongTin.get(position);

        holder.TxtTenKH.setText(thongTin.getTenKH());

        return convertView;
    }
}
