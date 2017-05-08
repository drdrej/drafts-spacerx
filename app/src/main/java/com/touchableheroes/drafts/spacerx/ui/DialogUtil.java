package com.touchableheroes.drafts.spacerx.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.touchableheroes.drafts.spacerx.ui.binding.DialogBinder;

import java.lang.reflect.Constructor;

/**
 * Created by asiebert on 08.05.2017.
 */

public class DialogUtil {


    public static class DialogBuilder {

        private final Dialog dialog;

        public DialogBuilder(
                final Class<? extends DialogBinder> binderType,
                final Context ctx) {

            dialog = new Dialog(ctx) {
                public DialogBinder dialogBinder;

                @Override
                protected void onCreate(
                        final Bundle savedInstanceState) {

                    super.onCreate(savedInstanceState);
                }

                @Override
                protected void onStart() {
                    super.onStart();

                    try {
                        final Constructor<? extends DialogBinder> constructor = binderType.getConstructor(Dialog.class);
                        dialogBinder = (DialogBinder) constructor.newInstance( this );
                    } catch (final Throwable e) {
                        e.printStackTrace();

                        throw new IllegalStateException("dasdas", e);
                    }

                    this.dialogBinder.bind();
                }

                @Override
                protected void onStop() {
                    super.onStop();
                    this.dialogBinder.destroy();
                }
            };
        }

        public DialogBuilder title(final String title) {
            dialog.setTitle( title );
            return this;
        }

        public DialogBuilder view(final int layoutId) {
            dialog.setContentView( layoutId );
            return this;
        }

        public DialogBuilder show() {
            dialog.show();

            return this;
        }
    }

    public static DialogBuilder create(final Class<? extends DialogBinder> binder,
                                       final Context ctx) {
        return new DialogBuilder(binder, ctx);
    }

}
