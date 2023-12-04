package com.example.messenger.module


import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.messenger.R

data class Person(
    val id: Int = 0,
    val name: String? = "",
    @DrawableRes val icon: Int = R.drawable.person_1
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(icon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}

val personList = listOf(
    Person(
        1,
        "Elon Musk",
        R.drawable.person_1
    ),
    Person(
        2,
        "Zuckerberg",
        R.drawable.person_2
    ),
    Person(
        3,
        "Cristiano",
        R.drawable.person_3
    ),
    Person(
        4,
        "Leo Messi",
        R.drawable.person_4
    ),
    Person(
        5,
        "Donald Trump",
        R.drawable.person_5
    )
)