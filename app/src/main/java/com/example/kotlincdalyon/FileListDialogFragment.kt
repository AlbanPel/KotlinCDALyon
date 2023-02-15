package com.example.kotlincdalyon

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class FileListDialogFragment : DialogFragment() {
    val TAG =  FileListDialogFragment::class.java.simpleName

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater

        builder.setView(inflater?.inflate(R.layout.dialog_file, null))
        //Reponse Positive
            .setPositiveButton("Supprimer", DialogInterface.OnClickListener{dialog, id ->
                Log.i(TAG, "Suppression en cours....")
            })
        //reponse negative
            .setNegativeButton("Annuler", DialogInterface.OnClickListener{dialog, id->
                dialog.dismiss()
            })
            .setTitle("Contenu Supprimé")
        return builder.create()
    }
}