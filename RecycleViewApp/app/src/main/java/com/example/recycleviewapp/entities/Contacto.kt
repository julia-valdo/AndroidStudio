package com.example.recycleviewapp.entities

import android.os.Parcel
import android.os.Parcelable

class Contacto(nombre: String?, edad: Int?, curso: String?, urlImage: String?): Parcelable {
    var nombre: String = ""
    var edad: Int = 0
    var curso: String = ""
    var urlImage: String = ""

    constructor(parcel: Parcel) : this(
        nombre = parcel.readString(),
        edad = parcel.readInt(),
        curso = parcel.readString(),
        urlImage = parcel.readString()
    )

    class Constants {
        companion object {
            val cursoA = "A"
            val cursoB = "B"
            val cursoC = "C"
        }
    }

    init {
        this.nombre = nombre!!
        this.edad = edad!!
        this.curso = curso!!
        this.urlImage = urlImage!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(curso)
        parcel.writeInt(edad)
        parcel.writeString(urlImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contacto> {
        override fun createFromParcel(parcel: Parcel): Contacto {
            return Contacto(parcel)
        }
        override fun newArray(size: Int): Array<Contacto?> {
            return arrayOfNulls(size)
        }
    }
}