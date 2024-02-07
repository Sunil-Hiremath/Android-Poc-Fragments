package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AFragment extends Fragment {

    //setting keys
    private static final String ARG1="argument1";//both acts as a key
    private static final String ARG2="argument2";




    public AFragment() {
        // Required empty public constructor
    }


    // below method gives the instance of the AFragment with preloaded data/values.
    public static AFragment getInstance(String value1,int value2){
        AFragment aFragment=new AFragment();

        Bundle bundle=new Bundle();
        bundle.putString(ARG1,value1);//ARG1 and ARG2 are keys
        bundle.putInt(ARG2,value2);

        aFragment.setArguments(bundle);

        return aFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // xml and java file yahan par jud rahe hain
        View view= inflater.inflate(R.layout.fragment_a, container, false);//converting layout to view

        if(getArguments()!=null){
            String name=getArguments().getString(ARG1);
            int rollNo=getArguments().getInt(ARG2);
            Log.d("Values from activity","Name is: "+name+", RollNo is: "+rollNo );



            //in this way we can access the values and method defined in the main activity
            ((MainActivity)getActivity()).CallFragment();
        }
/*
        TextView textView= view.findViewById(R.id.txtFrag);
*/
        return view;

        //hello
    }

}