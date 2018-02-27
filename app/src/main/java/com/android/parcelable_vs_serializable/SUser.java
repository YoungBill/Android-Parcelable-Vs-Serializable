package com.android.parcelable_vs_serializable;

import java.io.Serializable;

/**
 * Created by chentao on 2018/2/27.
 */

public class SUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public int userId;
    public String userName;
    public boolean isMale;

    public SUser(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        return "SUser{ " +
                "userId = " + userId +
                ", userName = " + userName +
                ", isMale = " + isMale +
                " }";
    }
}
