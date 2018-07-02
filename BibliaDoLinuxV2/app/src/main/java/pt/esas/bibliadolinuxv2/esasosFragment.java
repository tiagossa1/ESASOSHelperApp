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

        Glide.with(this).load("https://i.imgur.com/fidKKHo.png").into(desktop);
        Glide.with(this).load("https://i.imgur.com/oSyS6qr.png").into(comandos);
        Glide.with(this).load("https://i.imgur.com/M7iSsHW.png").into(c_site);
        Glide.with(this).load("https://i.imgur.com/0kYNgz7.png").into(c_esasos);
        Glide.with(this).load("https://i.imgur.com/Z9rsj5Q.png").into(c_software);

        c_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://i.imgur.com/M7iSsHW.png"));
                startActivity(browserIntent);
            }
        });

        return v;
    }

}
