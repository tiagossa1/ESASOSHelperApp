package pt.esas.bibliadolinuxv2;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class CuriosidadesFragment extends Fragment {


    public CuriosidadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_curiosidades, container, false);

        ImageView img = v.findViewById(R.id.imageView4);
        TextView textView = v.findViewById(R.id.creditos);
        String string = "Créditos: [DioLinux]";
        int i1 = string.indexOf("[");
        int i2 = string.indexOf("]");

        Glide.with(this).load("https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fzdnet3.cbsistatic.com%2Fhub%2Fi%2Fr%2F2015%2F11%2F09%2Ffdb872b4-537e-481d-9ef2-978892a3356a%2Fcrop%2FNaNxNaN%2BNaN%2BNaN%2Fresize%2F770xauto%2F4cdb27d13eb38e9c79b26e9d7f1390e4%2Flinus-torvalds-072013.jpg&f=1").into(img);

        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://pt.wikipedia.org/wiki/Linus_Torvalds"));
                v.getContext().startActivity(intent);
            }
        });

        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(string, TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable)textView.getText();
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.diolinux.com.br/2016/08/25-anos-de-linux-e-25-curiosidades.html"));
                startActivity(browserIntent);
            }
        };

        spannable.setSpan(clickableSpan, i1, i2 + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return v;
    }

}
