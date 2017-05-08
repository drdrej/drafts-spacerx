package com.touchableheroes.drafts.spacerx.ui.binding;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDomFactory;

import java.lang.ref.WeakReference;

/**
 * Created by asiebert on 12.04.2017.
 */

public abstract class ActivityBinder
       extends AbstractUIBinder<Activity> {

    public ActivityBinder(final Activity activity) {
        super(activity);
    }

    @Override
    protected View view() {
        return owner().findViewById(android.R.id.content);
    }

    @Override
    public void init(Context ctx) {

    }

}
