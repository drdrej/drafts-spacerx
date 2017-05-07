package com.touchableheroes.drafts.spacerx.ui;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.listener.DOMChangeListener;
import com.touchableheroes.drafts.spacerx.dom.listener.MatcheOneOfDOMChangeListener;

/**
 * Created by asiebert on 06.05.2017.
 */
public class ChangeValueBinding {

    private final SyntheticDOM dom;
    private final Enum[] keys;

    public ChangeValueBinding(final SyntheticDOM dom,
                              final Enum[] keys) {
        this.dom = dom;
        this.keys = keys;
    }

    public ChangeValueBinding ifOneOf(
            final DOMChangeListener chain) {
        this.dom.addChangeListener(
                new MatcheOneOfDOMChangeListener(chain, keys));

        return this;
    }

    public ChangeValueBinding onAll(final DOMChangeListener chain,
                                    final Enum... keys) {
        throw new UnsupportedOperationException();
    }

}
