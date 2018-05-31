package pt.esas.bibliadolinuxv2;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TutoriaisFragment extends Fragment {

    CardView listarAll, tut2, tut3, tut4;

    public TutoriaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tutoriais, container, false);
        android.support.v4.app.FragmentTransaction fragmentTransaction;

        //#1
        listarAll = v.findViewById(R.id.listar);
        //#2
        tut2 = v.findViewById(R.id.cd);
        //#3
        tut3 = v.findViewById(R.id.cpmvrm);
        tut4 = v.findViewById(R.id.permissoes);

        listarAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment lsFragment = new lsFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_container, lsFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        tut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cdFragment = new cdFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_container, cdFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        tut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cpFragment = new cpFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_container, cpFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        tut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PermissoesFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_container, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return v;
    }

}
