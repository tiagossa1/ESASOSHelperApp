package pt.esas.bibliadolinuxv2;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class PermissoesFragment extends Fragment {


    public PermissoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_permissoes, container, false);
        ImageView imageView = v.findViewById(R.id.ls);
        ImageView imageView1 = v.findViewById(R.id.tabela);
        TextView textView = v.findViewById(R.id.creditos);
        String string = "Créditos: [RyanTutorials]";
        int i1 = string.indexOf("[");
        int i2 = string.indexOf("]");

        Glide.with(this).load("https://i.imgur.com/AsqZhl3.jpg").into(imageView);
        Glide.with(this).load("https://i.imgur.com/G30dzvl.png").into(imageView1);

        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(string, TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable)textView.getText();
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ryanstutorials.net/linuxtutorial/permissions.php"));
                startActivity(browserIntent);
            }
        };

        spannable.setSpan(clickableSpan, i1, i2 + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return v;
    }

}
