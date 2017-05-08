package com.touchableheroes.drafts.spacerx.ui.binding;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDomFactory;
import com.touchableheroes.drafts.spacerx.dom.values.Getter;
import com.touchableheroes.drafts.spacerx.ui.builder.ChangeValueBindingBuilder;
import com.touchableheroes.drafts.spacerx.ui.builder.ViewBindingBuilder;

import java.io.Serializable;
import java.lang.ref.WeakReference;

/**
 * Created by asiebert on 12.04.2017.
 */
public abstract class AbstractUIBinder<T>
        implements HasOwner<T> {

    private final SyntheticDOM synthDom;
    private final WeakReference<T> owner;

    protected abstract View view();

    public AbstractUIBinder(T owner) {
        this.owner = new WeakReference<T>(owner);
        this.synthDom = SyntheticDomFactory.create();
    }

    @Override
    public T owner() {
        final T rval = (T) owner.get();

        if( rval == null ) {
            throw new IllegalStateException( "Backref.Fragement is broken/ maybe destroyed." );
        }

        return rval;
    }

    public SyntheticDOM syntheticDom() {
        return synthDom;
    }

    public abstract void bind();

    public abstract void init(final Context ctx);

    public void destroy() {
        this.syntheticDom().unbind();
    }

    protected <T extends Serializable> void getter(
            final Enum key,
            final Getter<T> getterImpl) {
        syntheticDom().register(key, getterImpl);
    }


    protected ViewBindingBuilder bind(final int id) {
        final View view = view().findViewById(id);

        if( view == null ) {
            throw new IllegalStateException( ("View not found. ID = " + id) );
        }

        try {
            return new ViewBindingBuilder( view, syntheticDom() );
        } catch (final ClassCastException ccx) {
            throw new IllegalStateException( "Cast not correct. View is of type [= " + view.getClass().getName() + "]" );
        }
    }

    protected ChangeValueBindingBuilder onChange(final Enum... changes) {
        return new ChangeValueBindingBuilder( syntheticDom(),
                changes);
    }




}
