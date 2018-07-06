package pt.esas.bibliadolinuxv2;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class esasosFragment extends Fragment {



    public esasosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_esasos, container, false);
        ImageView desktop = v.findViewById(R.id.desktop);
        ImageView comandos = v.findViewById(R.id.comandos);
        ImageView c_site = v.findViewById(R.id.site);
        ImageView c_esasos = v.findViewById(R.id.esasos);
        ImageView c_software = v.findViewById(R.id.software);
        ImageView c_whatsnew = v.findViewById(R.id.whatsnew);

        Glide.with(this).load("https://i.imgur.com/43l2Duv.png").into(desktop);
        Glide.with(this).load("https://i.imgur.com/O7PnZ1u.png").into(comandos);
        Glide.with(this).load("https://i.imgur.com/hELU9aS.png").into(c_site);
        Glide.with(this).load("https://i.imgur.com/6tg8fTi.png").into(c_esasos);
        Glide.with(this).load("https://i.imgur.com/qCVBI2y.png").into(c_software);
        Glide.with(this).load("https://i.imgur.com/rBeiQ7H.png").into(c_whatsnew);

        c_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://i.imgur.com/hELU9aS.png"));
                startActivity(browserIntent);
            }
        });

        return v;
    }

}
