package com.yaydev.blackbook.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.yaydev.blackbook.Configs;
import com.yaydev.blackbook.R;
import com.yaydev.blackbook.model.Board;

import java.util.List;

public class PermissionsAdapter extends PagerAdapter {

    private List<Board> list;
    private Listener listener;
    private Configs configs;

    public PermissionsAdapter(List<Board> list, Listener listener, Configs configs) {
        this.list = list;
        this.listener = listener;
        this.configs = configs;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.permission_item, container, false);

        TextView title = view.findViewById(R.id.permission);
        title.setTextColor(container.getContext().getResources().getColor(configs.getColor()));
        TextView message = view.findViewById(R.id.permission_message);
        CardView allow = view.findViewById(R.id.allow);
        ImageView image = view.findViewById(R.id.image);

        image.setImageResource(list.get(position).getImage());
        image.setImageTintList(ColorStateList.valueOf(container.getContext().getResources().getColor(configs.getColor())));

        allow.setCardBackgroundColor(container.getContext().getResources().getColor(configs.getColor()));

        allow.setOnClickListener(view1 -> listener.onAllowTriggered(list.get(position).getPermission()));

        title.setText(list.get(position).getTitle());
        message.setText(list.get(position).getMessage());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public interface Listener {
        void onAllowTriggered(String permission);
    }

}
