package com.touchableheroes.drafts.spacerx.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDomFactory;

import java.lang.ref.WeakReference;

/**
 * Created by asiebert on 12.04.2017.
 */

public abstract
       class ActivityBinder extends AbstractUIBinder {

    private final WeakReference<Activity> src;

    public final SyntheticDOM synthDom;

    public ActivityBinder(final Activity activity) {
        this.src = new WeakReference<Activity>(activity);
        this.synthDom = SyntheticDomFactory.create();
    }

    @Override
    protected View view() {
        return activity().findViewById(android.R.id.content);
    }



    private Activity activity() {
        final Activity rval = this.src.get();

        if( rval == null ) {
            throw new IllegalStateException( "Backref.Fragement is broken/ maybe destroyed." );
        }

        return rval;
    }

    @Override
    public void init(Context ctx) {

    }

}
