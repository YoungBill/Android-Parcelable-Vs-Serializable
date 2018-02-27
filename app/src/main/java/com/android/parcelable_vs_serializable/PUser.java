package com.android.parcelable_vs_serializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chentao on 2018/2/27.
 */

public class PUser implements Parcelable {

    public int userId;
    public String userName;
    public boolean isMale;

    public PUser(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    protected PUser(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
    }

    public static final Creator<PUser> CREATOR = new Creator<PUser>() {
        @Override
        public PUser createFromParcel(Parcel in) {
            return new PUser(in);
        }

        @Override
        public PUser[] newArray(int size) {
            return new PUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
    }

    @Override
    public String toString() {
        return "PUser{ " +
                "userId = " + userId +
                ", userName = " + userName +
                ", isMale = " + isMale +
                " }";
    }
}
