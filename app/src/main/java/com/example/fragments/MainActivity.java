package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    public static final String ROOT_FRAGMENT_TAG = "AFragment";
    Button btnFragA,btnFragB,btnFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragA=findViewById(R.id.btnFragA);
        btnFragB=findViewById(R.id.btnFragB);
        btnFragC=findViewById(R.id.btnFragC);


        //setting by default
        loadFragment(new AFragment(),0);


        //whenever we want to load the fragments dynamically we use fragment manager
        //fragment manager has transaction class which have methods like add,remove and replace

        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //example for values/data sending from activity to fragments
                loadFragment(AFragment.getInstance("rajan",11),1);

            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new BFragment(),1);

            }
        });

        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CFragment(),1);

            }
        });

    }

//loading the fragment into the frame layout
    public void loadFragment(Fragment fragment, int flag){
        FragmentManager fm=getSupportFragmentManager();

        FragmentTransaction ft=fm.beginTransaction();

       /*
       this was 1st method
        Bundle bundle=new Bundle();
        bundle.putString("Arg1","Raman");
        bundle.putInt("Arg2",7);

        fragment.setArguments(bundle);*/


        if (flag==0) {
            ft.add(R.id.Container, fragment);// it says add the fragment into the container
            fm.popBackStack(ROOT_FRAGMENT_TAG ,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        }
        else{
                ft.replace(R.id.Container, fragment);// for replace first we need to add a fragment

                ft.addToBackStack(null);
            }

        ft.commit();



    }
    //example for method created in main activity and accessed in fragment class
    public void CallFragment(){
        Log.d("inAct","fromFragment");
    }
}