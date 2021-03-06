package com.sj.at.two;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;

import com.sj.at.myfragment.R;

/**
 * Created by AT on 2015/8/13.
 */
public class MainTwoActivity extends Activity implements FragmentOne.FOneBtnClickListener,
        FragmentTwo.FTwoBtnClickListener
{

    private FragmentOne mFOne;
    private FragmentTwo mFTwo;
    private FragmentThree mFThree;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_mian_two);

        //避免重新绘制时，Fragment发生重建
        if(savedInstanceState == null) {
            mFOne = new FragmentOne();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction tx = fm.beginTransaction();
            tx.add(R.id.id_content, mFOne, "ONE");
            tx.commit();
        }
    }

    /**
     * FragmentOne 按钮点击时的回调
     *
     * replace方法再回来的时候Edittext里面的数据会被清空
     */
    @Override
    public void onFOneBtnClick()
    {

        if (mFTwo == null)
        {
            mFTwo = new FragmentTwo();
            mFTwo.setfTwoBtnClickListener(this);
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.id_content, mFTwo, "TWO");
        tx.addToBackStack(null);
        tx.commit();
    }

    /**
     * FragmentTwo 按钮点击时的回调
     *
     * hide方法再回来的时候Edittext里面的数据不会被清空
     */
    @Override
    public void onFTwoBtnClick()
    {
        if (mFThree == null)
        {
            mFThree = new FragmentThree();

        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.hide(mFTwo);
        tx.add(R.id.id_content, mFThree, "THREE");
        // tx.replace(R.id.id_content, fThree, "THREE");
        tx.addToBackStack(null);
        tx.commit();
    }

}
