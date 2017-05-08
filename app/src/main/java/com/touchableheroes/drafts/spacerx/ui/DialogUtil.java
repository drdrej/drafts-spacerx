package com.touchableheroes.drafts.spacerx.ui;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.touchableheroes.drafts.spacerx.action.AbstractStateAction;

import com.touchableheroes.drafts.spacerx.tx.StateTX;
import com.touchableheroes.drafts.spacerx.ui.binding.AbstractUIBinder;
import com.touchableheroes.drafts.spacerx.ui.binding.DialogBinder;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIAction;

/**
 * Created by asiebert on 08.05.2017.
 */

public class DialogUtil {


    public static class DialogBuilder {

        private final Dialog dialog;

        public DialogBuilder(
                final DialogBinder binder,
                final Context ctx) {
            dialog = new Dialog(ctx) {

                public DialogBinder dialog;

                @Override
                protected void onCreate(
                        final Bundle savedInstanceState) {

                    super.onCreate(savedInstanceState);
                }

                @Override
                protected void onStart() {
                    super.onStart();
                    this.dialog =  binder;
                    this.dialog.bind();
                }

                @Override
                protected void onStop() {
                    super.onStop();
                    this.dialog.destroy();
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

    public static DialogBuilder create(final DialogBinder binder,
                                       final Context ctx) {
        return new DialogBuilder(binder, ctx);
    }

}
