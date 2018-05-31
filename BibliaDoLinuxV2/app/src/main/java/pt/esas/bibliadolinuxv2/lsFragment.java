package pt.esas.bibliadolinuxv2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class lsFragment extends Fragment {

    public lsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ls, container, false);

        ImageView imageView = v.findViewById(R.id.ls);
        ImageView imageView1 = v.findViewById(R.id.lsa);
        ImageView imageView2 = v.findViewById(R.id.mkdir);

        //http://www.ee.surrey.ac.uk/Teaching/Unix/unix1.html
        TextView textView = v.findViewById(R.id.creditos);
        String string = "Créditos: [UNIX Tutorial for Beginners]";
        int i1 = string.indexOf("[");
        int i2 = string.indexOf("]");

        Glide.with(this).load("http://www.ee.surrey.ac.uk/Teaching/Unix/media/unix-xterm1.gif").into(imageView);
        Glide.with(this).load("http://www.ee.surrey.ac.uk/Teaching/Unix/media/unix-xterm2.gif").into(imageView1);
        Glide.with(this).load("https://i.imgur.com/fhA0Hoi.png").into(imageView2);

        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(string, TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable)textView.getText();
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ee.surrey.ac.uk/Teaching/Unix/unix1.html"));
                startActivity(browserIntent);
            }
        };

        spannable.setSpan(clickableSpan, i1, i2 + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return v;
    }

}
