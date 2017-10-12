package com.mcoresoftware.mprint;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

  private ImageView imageView;

  DrawerLayout drawerLayout;
  CollapsingToolbarLayout collapsingToolbarLayout;
  Toolbar toolbar;
  TabLayout tabLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imageView = (ImageView)findViewById(R.id.backdrop);

    setupNavigationView();
    setupToolbar();
    setImage();
    setupTablayout();
    setupCollapsingToolbarLayout();
  }

  private void setImage() {
    Glide.with(this).load(R.drawable.posprinter).into(imageView);
  }

  private void setupTablayout() {
    tabLayout = (TabLayout)findViewById(R.id.tabLayout);
    if (tabLayout == null) {
      return;
    }

    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    tabLayout.addTab(tabLayout.newTab().setText("Job"));
    tabLayout.addTab(tabLayout.newTab().setText("Paper"));
    tabLayout.addTab(tabLayout.newTab().setText("Connection"));
  }

  private void setupCollapsingToolbarLayout() {
    collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
    if (collapsingToolbarLayout != null) {
      collapsingToolbarLayout.setTitle(toolbar.getTitle());
    }
  }

  private void setupNavigationView() {
    drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
  }

  private void setupToolbar() {
    toolbar = (Toolbar)findViewById(R.id.toolbar);
    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }

    // Show menu icon.
    final ActionBar ab = getSupportActionBar();
    ab.setHomeAsUpIndicator(R.drawable.ic_menu);
    ab.setDisplayHomeAsUpEnabled(true);
  }
}
