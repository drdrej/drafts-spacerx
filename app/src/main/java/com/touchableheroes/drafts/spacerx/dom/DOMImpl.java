package com.touchableheroes.drafts.spacerx.dom;

import android.util.Log;

import com.touchableheroes.drafts.spacerx.tx.Remove;
import com.touchableheroes.drafts.spacerx.tx.StateTX;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asiebert on 08.04.2017.
 */

public class DOMImpl implements DOM {

    private final Map<Enum, Serializable> values = new HashMap<Enum, Serializable>();

    private List<DOMChangeListener> listeners = new ArrayList<>(2);

    @Override
    public void init() {
        System.err.println("Impl.");
    }

    @Override
    public StateTX transaction(final Enum... keys) {
        final Map<Enum, Serializable>
                values = new HashMap<Enum, Serializable>();
        final StateTX tx = new StateTX(this);
        return tx;
    }


    @Override
    public void commit(final StateTX tx) {
        final Map<Enum, Serializable> changed = tx.getChanged();

        commitChanges(changed);
        notifyChanges(changed);
    }

    private void commitChanges(
            final Map<Enum, Serializable> changed) {

        for (final Enum key : changed.keySet() ) {
            // lock key

            // copy key/val to dom
            final Serializable value = changed.get(key);

            if( value instanceof Remove ) {
                Log.d( "StateTX", "remove item" );
                this.values.remove(key);
            } else {
                Log.d( "StateTX", "set item" );
                this.values.put(key, value);
            }

            // unlock

            // remember change
        }
    }

    private void notifyChanges(
            final Map<Enum, Serializable> changedMap) {
        for (final DOMChangeListener listener : this.listeners ) {
            listener.changed( changedMap );
        }
    }

    @Override
    public <T extends Serializable> T get(final Enum key) {
        return (T) values.get(key);
    }

    @Override
    public String rollback(final StateTX tx) {
        System.err.println( " >> ROLLBACK TX: " + tx.getId());

        return tx.getId();
    }

    @Override
    public void addChangeListener(final DOMChangeListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(final DOMChangeListener listener) {
        this.listeners.remove( listener );
    }


}
