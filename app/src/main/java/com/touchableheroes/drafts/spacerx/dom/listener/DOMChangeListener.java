package com.touchableheroes.drafts.spacerx.dom.listener;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by asiebert on 11.04.2017.
 */
public interface DOMChangeListener {
    public void changed(Map<Enum, Serializable> changedMap);
}

