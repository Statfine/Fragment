package com.sj.at.three;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sj.at.myfragment.R;

/**
 * Created by AT on 2015/8/13.
 */
public class FragmentOne extends Fragment {

    private TextView tv ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_mian_three_one, container, false);
        tv = (TextView) view.findViewById(R.id.fg_tv_getdata);
        return view;
    }

    public void setText(String text)
    {
        tv.setText(text);
    }


}
