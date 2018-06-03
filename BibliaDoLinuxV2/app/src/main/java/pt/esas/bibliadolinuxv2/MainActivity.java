package pt.esas.bibliadolinuxv2;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    Dialog dialogEmail;
    RadioButton bugType, outroType;
    Button enviarEmail;
    MediaPlayer player;
    Intent intent;
    boolean userWantsMusic;

    public void CustomAlertEmail() {
        dialogEmail = new Dialog(MainActivity.this);
        dialogEmail.setContentView(R.layout.choose_email_type);
        dialogEmail.setTitle("Escolhe o tipo de email:");

        bugType = dialogEmail.findViewById(R.id.rbuttonBug);
        outroType = dialogEmail.findViewById(R.id.rbuttonThanks);
        enviarEmail = dialogEmail.findViewById(R.id.btnEnviarEmail);

        enviarEmail.setEnabled(true);

        enviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bugType.isChecked())
                {
                    try {
                        //Strings para reporte de bugs.
                        String deviceModel = Build.MODEL;
                        String manufacturer = Build.MANUFACTURER;
                        String androidVersion = Build.VERSION.RELEASE;
                        String checkCustom = Build.DISPLAY;

                        Intent intent = new Intent(Intent.ACTION_SEND);
                        Intent chooser;
                        intent.setData(Uri.parse("mailto:"));
                        String[] to = {"tiagosaesas@gmail.com"};
                        String corpoMensagem = "Olá, encontrei este bug na aplicação: (DESCREVE AQUI O ERRO).\n O meu gadget é: " + manufacturer + ", " + deviceModel + ", " + checkCustom + ",\n versão do Android: " + androidVersion + ".";
                        intent.putExtra(Intent.EXTRA_EMAIL, to);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Reporte de um bug: esasOS Helper.");
                        intent.putExtra(Intent.EXTRA_TEXT, corpoMensagem);
                        intent.setType("message/rfc822");
                        chooser=Intent.createChooser(intent, "Escolha a aplicação para enviar o email");
                        startActivity(chooser);

                        dialogEmail.dismiss();

                        Context context = getApplicationContext();
                        CharSequence text = "Escolha a aplicação para enviar o email.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                else if (outroType.isChecked()) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        Intent chooser = null;
                        intent.setData(Uri.parse("mailto:"));
                        String[] to = {"tiagosaesas@gmail.com"};
                        String corpoMensagem = "";
                        intent.putExtra(Intent.EXTRA_EMAIL, to);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Email - esasOS Helpera.");
                        intent.putExtra(Intent.EXTRA_TEXT, corpoMensagem);
                        intent.setType("message/rfc822");
                        chooser=Intent.createChooser(intent, "Escolha a aplicação para enviar o email");
                        startActivity(chooser);

                        dialogEmail.dismiss();

                        Context context = getApplicationContext();
                        CharSequence text = "Escolha a aplicação para enviar o email.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        dialogEmail.show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (isNetworkAvailable() == false)
        {
            Toast.makeText(this, "Esta aplicação precisa de internet.",
                    Toast.LENGTH_LONG).show();
            finishAndRemoveTask();
        }

        SharedPreferences prefs = getSharedPreferences("pt.esas.bibliadolinuxv2", 0);
        userWantsMusic = prefs.getBoolean("MUSIC_KEY", true);
        player = MediaPlayer.create(this, R.raw.track1);

        if (userWantsMusic == true) {
            player.start();
        }

        else {

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide both the navigation bar and the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        mDrawerLayout = findViewById(R.id.myDrawer);
        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close );

        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("esasOS Helper");

        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.inicio_id:

                            fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                            item.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            break;

                    case R.id.linux_id:

                            fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_container, new LinuxFragment());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                            item.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            break;

                    case R.id.curiosidades_id:

                            fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_container, new CuriosidadesFragment());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                            item.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            break;

                    case R.id.esasos_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new esasosFragment());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.tutoriais_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new TutoriaisFragment());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)){
            return true;
        }

        switch (item.getItemId()) {
            case R.id.faq:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new FaqFragment());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
                return true;

            case R.id.duvidas:
                CustomAlertEmail();
                return true;

                default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        if (player.isPlaying())
            player.stop();
        super.onDestroy();
    }
}
