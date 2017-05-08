package com.touchableheroes.drafts.spacerx.ui.binding;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import java.lang.ref.WeakReference;

public abstract class DialogBinder
            extends AbstractUIBinder<Dialog> {

        public DialogBinder(final Dialog dialog ) {
            super(dialog);
        }

        @Override
        protected abstract View view();
            // return dialog.findViewById( android.support.v4.R.id.contentPanel );

        @Override
        public abstract void bind();

        @Override
        public void init(Context context) {
            ;
        }

    }
