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
package com.mcoresoftware.mprint.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.mcoresoftware.mprint.activity.ConnectionActivity;
import com.mcoresoftware.mprint.activity.JobActivity;
import com.mcoresoftware.mprint.activity.PaperActivity;

// Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

  // integer to count number of tabs.
  int tabCount;

  // Constructor to the class.
  public Pager(FragmentManager fm, int tabCount) {
    super(fm);

    // initializing tab count.
    this.tabCount = tabCount;
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        JobActivity tab1 = new JobActivity();
        return tab1;
      case 1:
        PaperActivity tab2 = new PaperActivity();
        return tab2;
      case 2:
        ConnectionActivity tab3 = new ConnectionActivity();
        return tab3;
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return tabCount;
  }
}
