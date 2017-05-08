package com.touchableheroes.drafts.spacerx.ui.binding;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import java.lang.ref.WeakReference;

public abstract class DialogBinder
            extends AbstractUIBinder {

        private final WeakReference<Dialog> dialog;

        public DialogBinder(final Dialog dialog ) {
            this.dialog = new WeakReference<Dialog>(dialog);
        }

        public Dialog dialog() {
            return this.dialog.get();
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
