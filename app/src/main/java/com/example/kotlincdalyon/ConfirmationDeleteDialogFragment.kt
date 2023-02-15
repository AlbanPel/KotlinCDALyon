package com.example.kotlincdalyon

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class ConfirmationDeleteDialogFragment : DialogFragment() {
    val TAG = ConfirmationDeleteDialogFragment::class.java.simpleName
    // creer l'interface de recuperation
    interface ConfirmationDeleteListener {
        fun onDialogPosistiveClick()
        fun onDialogNegativeClick()
    }

    var listener: ConfirmationDeleteListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //Design pattern builder
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Supprimer tout le contenu")
        //logic pour la reponse  positive une une interface anonyme avec un objet
            .setPositiveButton("oui", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, id: Int) {
                  Log.i(TAG, "Ok mais tu vas tout casser ")
                  listener?.onDialogPosistiveClick()
                }
            })
        //logic pour reponse negative
            .setNegativeButton("Surtout Pas", DialogInterface.OnClickListener{dialog, id ->
                Log.i(TAG, "Ok je casse rien")
                listener?.onDialogNegativeClick()
            })

        return builder.create()
    }


}