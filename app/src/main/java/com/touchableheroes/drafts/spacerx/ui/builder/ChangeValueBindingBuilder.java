package com.touchableheroes.drafts.spacerx.ui.builder;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.listener.DOMChangeListener;
import com.touchableheroes.drafts.spacerx.dom.listener.MatcheOneOfDOMChangeListener;

/**
 * Created by asiebert on 06.05.2017.
 */
public class ChangeValueBindingBuilder {

    private final SyntheticDOM dom;
    private final Enum[] keys;

    public ChangeValueBindingBuilder(final SyntheticDOM dom,
                                     final Enum[] keys) {
        this.dom = dom;
        this.keys = keys;
    }

    public ChangeValueBindingBuilder ifOneOf(
            final DOMChangeListener chain) {
        this.dom.addChangeListener(
                new MatcheOneOfDOMChangeListener(chain, keys));

        return this;
    }

    public ChangeValueBindingBuilder onAll(final DOMChangeListener chain,
                                           final Enum... keys) {
        throw new UnsupportedOperationException();
    }

}
