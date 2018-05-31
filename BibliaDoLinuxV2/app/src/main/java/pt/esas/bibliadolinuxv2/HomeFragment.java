package pt.esas.bibliadolinuxv2;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import com.tomer.fadingtextview.FadingTextView;

import static com.tomer.fadingtextview.FadingTextView.SECONDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Switch aSwitch;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        String[] texts = {"Olá.","Bem-vindo ao esasOS Helper!","Para começar, carrega no botão esquerdo, lá em cima!", "Diverte-te! :D"};
        FadingTextView FTV = view.findViewById(R.id.ftextview);
        aSwitch = view.findViewById(R.id.musicswitch);
        aSwitch.setTextOff("Música desativada");
        aSwitch.setTextOn("Música ativada");

        SharedPreferences sharedPrefs = this.getActivity().getSharedPreferences("pt.esas.bibliadolinuxv2", 0);
        boolean silent = sharedPrefs.getBoolean("MUSIC_KEY", true);
        aSwitch.setChecked(silent);

        if (aSwitch.isChecked()) {
            aSwitch.setText("Música ativada");
        }
        else {
            aSwitch.setText("Música desativada");
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                   aSwitch.setText("Música ativada");
                }

                else {
                    aSwitch.setText("Música desativada");
                }

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("pt.esas.bibliadolinuxv2", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("MUSIC_KEY", isChecked);
                editor.commit();

                //Process.killProcess(Process.myPid());

                getActivity().moveTaskToBack(true);
                getActivity().finishAndRemoveTask();

                Intent i = getActivity().getPackageManager().
                        getLaunchIntentForPackage(getActivity().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        FTV.setTexts(texts);
        FTV.setTimeout(4, SECONDS);

        return view;
    }
}
