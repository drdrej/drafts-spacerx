package com.touchableheroes.drafts.spacerx.tx;

import java.io.Serializable;
import java.lang.ref.WeakReference;

/**
 * Created by asiebert on 05.05.2017.
 */

public class Remove implements Serializable {

    private final Enum key;

    private final WeakReference ref;

    public Remove(
            final Enum key,
            final Serializable obj) {
        ;
        this.key = key;
        this.ref = new WeakReference(obj);
    }
}
