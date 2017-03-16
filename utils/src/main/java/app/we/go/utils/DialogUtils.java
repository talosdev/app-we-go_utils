package app.we.go.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * This class currently offers utility methods for creating progress and confirmation dialogs.
 */
public class DialogUtils {

    private DialogUtils() {
        // Cannont instantiate this class
    }

    /**
     * Returns, but doesn't show, a progress dialog. The client code is responsible for
     * calling {@link AlertDialog#show()}.
     *
     * @param context
     * @param titleRes
     * @param messageRes
     * @return
     */
    @NonNull
    public static ProgressDialog createProgressDialog(@NonNull Context context,
                                                      @StringRes int titleRes,
                                                      @StringRes int messageRes) {

        return ProgressDialog.show(context,
                context.getResources().getString(titleRes),
                context.getResources().getString(messageRes));
    }


    public static void dismissNullSafe(ProgressDialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }


    /**
     * Returns, but doesn't show, a confirmation dialog. The client code is responsible for
     * calling {@link AlertDialog#show()}.
     * @param context
     * @param titleRes
     * @param messageRes
     * @param positiveClickListener
     * @param negativeClickListener If <code>null</code>, the default behaviour of the negative button
     *                              is to dismiss the dialog
     * @param positiveButtonRes
     * @param negativeButtonRes
     * @return
     */
    @NonNull
    public static AlertDialog createConfirmDialog(@NonNull Context context,
                                                  @StringRes int titleRes,
                                                  @StringRes int messageRes,
                                                  @NonNull DialogInterface.OnClickListener positiveClickListener,
                                                  @Nullable DialogInterface.OnClickListener negativeClickListener,
                                                  @StringRes int positiveButtonRes,
                                                  @StringRes int negativeButtonRes) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder.setTitle(titleRes)
                .setMessage(messageRes)
                .setPositiveButton(positiveButtonRes, positiveClickListener)
                .setNegativeButton(negativeButtonRes, negativeClickListener)
                .create();
    }


    /**
     * Creates, but doesn't show, a confirmation dialog, using the standard android resources "OK"
     * and "Cancel" for the positive/negative buttons.
     *
     * @see #createConfirmDialog(Context, int, int, DialogInterface.OnClickListener,
     * DialogInterface.OnClickListener, int, int)
     */
    @NonNull
    public static AlertDialog createConfirmDialog(@NonNull Context context,
                                                  @StringRes int titleRes,
                                                  @StringRes int messageRes,
                                                  @NonNull DialogInterface.OnClickListener positiveClickListener,
                                                  @Nullable DialogInterface.OnClickListener negativeClickListener) {

        return createConfirmDialog(context,
                titleRes,
                messageRes,
                positiveClickListener,
                negativeClickListener,
                android.R.string.ok,
                android.R.string.cancel);
    }
}
