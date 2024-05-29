package software.nyxentech.searchtrendstr.helper;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

public class AlertDialogManager {

    public interface DialogClickListener {
        void onPositiveButtonClick();
        void onNegativeButtonClick();
    }

    public static void showConfirmationDialog(Context context, String title, String message, String positiveButton, String negativeButton, final DialogClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null) {
                            listener.onPositiveButtonClick();
                        }
                    }
                })
                .setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null) {
                            listener.onNegativeButtonClick();
                        }
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}