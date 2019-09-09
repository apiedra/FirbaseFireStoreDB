package com.samples.apiedra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.samples.apiedra.Fragments.AddFireStore;
import com.samples.apiedra.Fragments.EditFireStore;

public class MainActivity extends AppCompatActivity implements AddFireStore.OnFragmentInteractionListener,EditFireStore.OnFragmentInteractionListener  {


    BottomNavigationView menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponentes();
        menuActions();
    }

    public void initComponentes(){
        menu= (BottomNavigationView)findViewById(R.id.menu);
    }
    public void menuActions(){
        menu.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottomNavigationAdd:
                                manageFragment(new AddFireStore());
                                break;
                            case R.id.bottomNavigationEdit:
                                manageFragment(new EditFireStore());
                                break;

                        }
                        return true;
                    }
                });
    }

    public void manageFragment(Fragment fragment){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.principal_layout, fragment);
        fragmentTransaction.commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
