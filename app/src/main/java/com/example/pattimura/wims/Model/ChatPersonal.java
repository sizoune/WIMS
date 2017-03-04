package com.example.pattimura.wims.Model;

import java.util.Date;

/**
 * Created by desmoncode on 04/03/17.
 */

public class ChatPersonal {
    private String message;
    private long waktu;

    public ChatPersonal(String message, long waktu) {
        this.message = message;

        this.waktu = new Date().getTime();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getWaktu() {
        return waktu;
    }

    public void setWaktu(long waktu) {
        this.waktu = waktu;
    }
}
