package com.sj.at.two;

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
public class FragmentTwo extends Fragment implements View.OnClickListener
{


    private Button mBtn ;

    private FTwoBtnClickListener fTwoBtnClickListener ;

    public interface FTwoBtnClickListener
    {
        void onFTwoBtnClick();
    }
    //设置回调接口
    public void setfTwoBtnClickListener(FTwoBtnClickListener fTwoBtnClickListener)
    {
        this.fTwoBtnClickListener = fTwoBtnClickListener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        mBtn = (Button) view.findViewById(R.id.btn_two);
        mBtn.setOnClickListener(this);
        return view ;
    }
    @Override
    public void onClick(View v)
    {
        if(fTwoBtnClickListener != null)
        {
            fTwoBtnClickListener.onFTwoBtnClick();
        }
    }

}
