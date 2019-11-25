package com.zego.zegoliveroomplugin;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import io.flutter.plugin.platform.PlatformView;

public class ZegoPlatformView implements PlatformView {

    private SurfaceView mSurfaceView;
    private int mViewID;
    public ZegoPlatformView(Context context, int viewID) {
        this.mSurfaceView = new SurfaceView(context);
        ZegoLogJNI.logNotice("ZegoPlatformView new, viewID: "+ viewID + " context: " + context);
        mViewID = viewID;
        this.mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                ZegoLogJNI.logNotice("ZegoPlatformView Created, viewID: " + mViewID);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                ZegoLogJNI.logNotice("ZegoPlatformView Changed, viewID: " + mViewID + ", size: (" + width + ", " + height + ")");
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                ZegoLogJNI.logNotice("ZegoPlatformView Destroyed, viewID: " + mViewID);
            }
        });
    }

    public SurfaceView getSurfaceView() {
        return mSurfaceView;
    }

    @Override
    public View getView() {
        return mSurfaceView;
    }

    @Override
    public void dispose() {

    }
}
