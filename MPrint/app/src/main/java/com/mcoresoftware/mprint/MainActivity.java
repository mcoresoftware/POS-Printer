/////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2017 MCORE Innovation Software. All rights reserved.
//
// Licensed under the MIT License (the "License"); you may not use this file
// except in compliance with the License. You may obtain a copy of the
// License at
//
// http://opensource.org/licenses/MIT
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
// License for the specific language governing permissions and limitations
// under the License.
/////////////////////////////////////////////////////////////////////////////
package com.mcoresoftware.mprint;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.mcoresoftware.mprint.activity.BluetoothDeviceListActivity;
import com.mcoresoftware.mprint.adapter.Pager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TabLayout.OnTabSelectedListener {

  // Intent request codes
  private static final int REQUEST_CONNECT_DEVICE = 1;

  private ImageView imageView;

  DrawerLayout drawerLayout;
  CollapsingToolbarLayout collapsingToolbarLayout;
  Toolbar toolbar;
  TabLayout tabLayout;
  ViewPager viewPager;

  //private Button btnScanButton = null;

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

    // Initialising viewPager.
    viewPager = (ViewPager) findViewById(R.id.pager);
    // creating our pager adapter.
    Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
    viewPager.setAdapter(adapter);

    tabLayout.setOnTabSelectedListener(this);

    //btnScanButton = (Button)findViewById(R.id.button_scan);
    //btnScanButton.setOnClickListener(this);
  }

  @Override
  public void onTabSelected(TabLayout.Tab tab) {
    viewPager.setCurrentItem(tab.getPosition());
  }

  @Override
  public void onTabUnselected(TabLayout.Tab tab) {
  }

  @Override
  public void onTabReselected(TabLayout.Tab tab) {
  }

  @Override
  public void onClick(View v) {
    /*
    switch (v.getId()) {
      case R.id.button_scan:
        Intent serverIntent = new Intent(MainActivity.this, BluetoothDeviceListActivity.class);
        startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
        break;
    }
    */
  }

  private void setImage() {
    Glide.with(this).load(R.drawable.posprinter).into(imageView);
  }

  private void setupTablayout() {
    tabLayout = (TabLayout)findViewById(R.id.tabLayout);
    if (tabLayout == null) {
      return;
    }

    // adding the tabs using addTab() method.
    tabLayout.addTab(tabLayout.newTab().setText("Job"));
    tabLayout.addTab(tabLayout.newTab().setText("Paper"));
    tabLayout.addTab(tabLayout.newTab().setText("Connection"));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
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
