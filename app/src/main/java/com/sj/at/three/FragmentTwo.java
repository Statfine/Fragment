package com.sj.at.three;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sj.at.myfragment.R;

/**
 * Created by AT on 2015/8/13.
 */
public class FragmentTwo extends Fragment
{


    private Button mBtn ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_mian_three_two, container, false);
        mBtn = (Button) view.findViewById(R.id.btn_one);
        mBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                System.out.println("按钮被点击");
                FragmentOne fragment2 = (FragmentOne) getActivity().getFragmentManager().findFragmentById(R.id.fragment1);//建立联系
                fragment2.setText("一点击就改变");
            }
        });
        return view ;
    }


}
