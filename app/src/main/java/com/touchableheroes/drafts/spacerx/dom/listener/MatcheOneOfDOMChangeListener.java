package com.touchableheroes.drafts.spacerx.dom.listener;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by asiebert on 06.05.2017.
 */
public abstract class MatcheOneOfDOMChangeListener
       implements DOMChangeListener {

    private final Enum[] loaderId;
    private final DOMChangeListener chain;

    public MatcheOneOfDOMChangeListener(final DOMChangeListener chain,
                                        final Enum... loaderId) {
        this.loaderId = loaderId;
        this.chain = chain;
    }

    @Override
    public void changed(
            final Map<Enum, Serializable> changedMap) {

        if( match(changedMap) ) {
            chain.changed( changedMap );
        }
    }


    private boolean match(final Map<Enum, Serializable> changedMap) {
        for( final Enum key : loaderId ) {
            if( changedMap.containsKey(key) ) {
                return true;
            }
        }

        return false;
    }

}
