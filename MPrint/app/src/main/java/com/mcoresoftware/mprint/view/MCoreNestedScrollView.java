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
package com.mcoresoftware.mprint.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class MCoreNestedScrollView extends NestedScrollView {

  private int mSlop;

  private float mXDistance;
  private float mYDistance;
  private float mLastX;
  private float mLastY;

  public MCoreNestedScrollView(Context context) {
    super(context);
    init(context);
  }

  public MCoreNestedScrollView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public MCoreNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  private void init(Context context) {
    ViewConfiguration config = ViewConfiguration.get(context);
    mSlop = config.getScaledEdgeSlop();
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent event) {
    final float x = event.getX();
    final float y = event.getY();
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        mXDistance = mYDistance = 0.0f;
        mLastX     = event.getX();
        mLastY     = event.getY();
        break;

      case MotionEvent.ACTION_MOVE:
        final float curX = event.getX();
        final float curY = event.getY();
        mXDistance += Math.abs(curX - mLastX);
        mYDistance += Math.abs(curY - mLastY);
        mLastX = curX;
        mLastY = curY;
        if (mXDistance > mYDistance) {
          return false;
        }
    }

    return super.onInterceptTouchEvent(event) || event.getPointerCount() == 2;
  }
}
