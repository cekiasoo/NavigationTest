package com.ce.navigationtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @author CE Chen
 */
public class MainFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.btn_simple)
    Button btnSimple;
    @BindView(R.id.btn_bottom_navigation_view)
    Button btnBottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_simple, R.id.btn_bottom_navigation_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_simple:
                Navigation.findNavController(view).navigate(R.id.action_nav_main_to_nav_simple);
                break;
            case R.id.btn_bottom_navigation_view:
                Navigation.findNavController(view).navigate(R.id.action_nav_main_to_nav_bottom_navigation_view);
                break;
            default:
        }
    }
}
