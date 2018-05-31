package pt.esas.bibliadolinuxv2;


import android.media.Image;
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
public class cdFragment extends Fragment {


    public cdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cd, container, false);
        ImageView imageView = v.findViewById(R.id.cd);
        ImageView imageView1 = v.findViewById(R.id.clear);
        Glide.with(this).load("https://i.imgur.com/vUVUNoS.png").into(imageView);
        Glide.with(this).load("https://i.imgur.com/PL0FA3P.gif").into(imageView1);

        return v;
    }

}
