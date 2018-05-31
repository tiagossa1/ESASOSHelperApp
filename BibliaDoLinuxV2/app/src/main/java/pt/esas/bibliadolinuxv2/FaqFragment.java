package pt.esas.bibliadolinuxv2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaqFragment extends Fragment {


    public FaqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_faq, container, false);

        ((TextView) v.findViewById(R.id.textview7)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) v.findViewById(R.id.textview7)).setText(Html.fromHtml(getResources().getString(R.string.github)));

        return v;
    }

}
