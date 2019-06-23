package com.example.aplicativomural;

import android.content.Context;
import android.view.MotionEvent;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Overlay;

abstract class MapOverlay extends Overlay {
    public MapOverlay(Context ctx) {
        super(ctx);
    }

    public abstract boolean OnSingleTapConfirmed(MotionEvent me, MapView mv);
}
