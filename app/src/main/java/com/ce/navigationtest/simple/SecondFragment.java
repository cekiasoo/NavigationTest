package com.ce.navigationtest.simple;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ce.navigationtest.R;

import androidx.navigation.Navigation;

/**
 * @author CE Chen
 */
public class SecondFragment extends Fragment {
    private static final String TAG = "SecondFragment";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Bundle arguments = getArguments();
        String data = arguments.getString("KEY");
        Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();*/

        /*SecondFragmentArgs fragmentArgs = SecondFragmentArgs.fromBundle(getArguments());
        Log.v(TAG, "boolean data = " + fragmentArgs.getBooleanData());
        Log.v(TAG, "int data = " + fragmentArgs.getIntData());
        Log.v(TAG, "float data = " + fragmentArgs.getFloatData());
        Log.v(TAG, "string data = " + fragmentArgs.getStringData());*/
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btnToThirdFrag = view.findViewById(R.id.btn_to_third_fragment);
        btnToThirdFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Navigation.findNavController(getView()).navigateUp();
                Navigation.findNavController(getView()).navigate(R.id.action_nav_second_frag_to_nav_third_frag);
            }
        });
    }
}
