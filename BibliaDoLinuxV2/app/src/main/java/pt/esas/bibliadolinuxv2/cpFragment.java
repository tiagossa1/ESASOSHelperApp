package pt.esas.bibliadolinuxv2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 */
public class cpFragment extends Fragment {


    public cpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cp, container, false);
        ImageView imageView = v.findViewById(R.id.cp);
        ImageView imageView1 = v.findViewById(R.id.mv);
        ImageView imageView2 = v.findViewById(R.id.rm);

        Glide.with(this).load("https://i.imgur.com/5dLrbYi.png").into(imageView);
        Glide.with(this).load("https://i.imgur.com/TECOWxG.png").into(imageView1);
        Glide.with(this).load("https://i.imgur.com/vuyDkeC.png").into(imageView2);

        return v;
    }

}
