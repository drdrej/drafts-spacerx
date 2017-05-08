package com.touchableheroes.drafts.spacerx.ui.binding;

import android.support.v4.app.Fragment;
import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDomFactory;

import java.lang.ref.WeakReference;


/**
 * Created by asiebert on 08.04.2017.
 */
public abstract class FragmentBinder
        extends AbstractUIBinder<Fragment> {

    public FragmentBinder(final Fragment src) {
        super(src);
    }

    @Override
    protected View view() {
        return owner().getView();
    }

}
