package com.touchableheroes.drafts.spacerx.ui.builder;

import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.listener.UIUpdaterListenerImpl;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIAction;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIUpdater;

import java.lang.ref.WeakReference;

/**
 * Created by asiebert on 08.04.2017.
 */

public class ViewBindingBuilder {

    private final WeakReference<View> owner;

    private final SyntheticDOM syntheticDom;

    private Enum boundTo;

    public ViewBindingBuilder(
            final View view,
            final SyntheticDOM synth) {
        this.owner = new WeakReference<View>(view);
        this.syntheticDom = synth;
    }

    public ViewBindingBuilder click(final UIAction clickListener) {
        final View owner = view();
        owner.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                clickListener.action(view);
            }
        });
        return this;
    }

    public final <V extends View> V view( ) {
        final View rval = this.owner.get();

        if( rval == null ) {
            throw new IllegalStateException( "Back.ref.view is NULL! Lost View Ref." );
        }

        return (V) rval;
    }

    public ViewBindingBuilder updater(final UIUpdater uiUpdater) {
        this.syntheticDom.addChangeListener(
                new UIUpdaterListenerImpl(
                        syntheticDom,
                        boundTo,
                        uiUpdater,
                        owner ));

        return this;
    }

    public ViewBindingBuilder value(final Enum key) {
        this.boundTo = key;
        return this;
    }

}
