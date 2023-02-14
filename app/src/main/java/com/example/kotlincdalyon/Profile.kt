package com.example.kotlincdalyon

import android.os.Parcel
import android.os.Parcelable

data class Profile(var name: String?, var age:Int) : Parcelable {
    //Parcel pour lire mes types primitif
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    )

    //Override convertir mon objet en parcelable
    //Il est important de respecter l'ordre
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }


    //Permet de creer des utilisateurs via mon objet
    companion object CREATOR : Parcelable.Creator<Profile> {
        override fun createFromParcel(parcel: Parcel): Profile {
            return Profile(parcel)
        }
        // Permet de creer une liste utilisateur via mon objet

        override fun newArray(size: Int): Array<Profile?> {
            return arrayOfNulls(size)
        }
    }
}
