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
public class LinuxFragment extends Fragment {


    public LinuxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_linux, container, false);
        ImageView kernel = (ImageView) v.findViewById(R.id.kernel);
        ImageView linux_image = (ImageView) v.findViewById(R.id.imageView3);

        Glide.with(this).load("https://blog.digilentinc.com/wp-content/uploads/2015/05/1280px-Kernel_Layout.svg_.png").into(kernel);
        Glide.with(this).load("http://www.windowsteam.com.br/wp-content/uploads/2015/08/Linux-Android-150x200.png").into(linux_image);

        return v;
    }

}
