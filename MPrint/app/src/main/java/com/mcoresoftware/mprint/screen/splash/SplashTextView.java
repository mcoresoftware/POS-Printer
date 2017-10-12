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
package com.mcoresoftware.mprint.screen.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import java.io.File;


@SuppressLint("AppCompatCustomView")
public class SplashTextView extends TextView {

    public SplashTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parseAttributes(context, attrs);
    }

    public SplashTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context, attrs);
    }

    public SplashTextView(Context context) {
        super(context);
    }

    private void parseAttributes(Context context, AttributeSet attrs) {
        setTypeface(Typeface.createFromAsset(context.getAssets(),
                "fonts" + File.separator + "Roboto-Light.ttf"));
    }
}
