package com.ce.navigationtest.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ce.navigationtest.R;

import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

/**
 * @author CE Chen
 */
public class SimpleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment)fragmentManager.findFragmentById(R.id.frag_nav_simple);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(SimpleActivity.this, navController);*/


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.frag_nav_simple);
        NavGraph navSimple = navHostFragment.getNavController().getNavInflater().inflate(R.navigation.nav_simple);
        NavDestination firstFragDestination = navSimple.findNode(R.id.nav_simple_first_frag);
        FirstFragmentArgs fragmentArgs = new FirstFragmentArgs.Builder("给 First 的数据").build();
        firstFragDestination.setDefaultArguments(fragmentArgs.toBundle());
        navHostFragment.getNavController().setGraph(navSimple);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.frag_nav_simple).navigateUp();
    }
}
