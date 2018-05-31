package pt.esas.bibliadolinuxv2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
        View teste = inflater.inflate(R.layout.fragment_esasos, container, false);

        ((TextView) teste.findViewById(R.id.textview7)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) teste.findViewById(R.id.textview7)).setText(Html.fromHtml(getResources().getString(R.string.video)));

        return teste;
    }

}
