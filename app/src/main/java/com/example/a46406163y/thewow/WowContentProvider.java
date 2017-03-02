package com.example.a46406163y.thewow;


import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class WowContentProvider extends CupboardContentProvider  {

    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

    static {
        cupboard().register(WOW.class);
    }

    public WowContentProvider() {
        super(AUTHORITY, 1);
    }

}
