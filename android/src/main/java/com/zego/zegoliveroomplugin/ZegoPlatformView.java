package com.zego.zegoliveroomplugin;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

import io.flutter.plugin.platform.PlatformView;

public class ZegoPlatformView implements PlatformView , SurfaceHolder.Callback{

    private SurfaceView mSurfaceView;
    //private Surface mSurface;
    private int mViewID;
    //private boolean mIsSurface;
    public ZegoPlatformView(Context context, int viewID, int width, int height/*, boolean isSurface, int width, int height*/) {
        //mIsSurface = isSurface;
        //if(mIsSurface) {
        this.mSurfaceView = new SurfaceView(context);
        this.mSurfaceView.getHolder().addCallback(this);
        if(width != 0 && height != 0)
        {
            this.mSurfaceView.getHolder().setFixedSize(width, height);
        }

        ZegoLogJNI.logNotice("ZegoPlatformView new, viewID: "+ viewID + " context: " + context + ", width :" + width + ", height: " + height);
        mViewID = viewID;
    }

    public SurfaceView getSurfaceView() {
        return mSurfaceView;
    }

    public void setSurfaceFixedSize(int width, int height) {
        //this.mSurfaceView.getHolder().setFixedSize(width, height);
    }

    @Override
    public View getView() {
        return mSurfaceView;
    }

    @Override
    public void dispose() {
        ZegoLogJNI.logNotice("ZegoPlatformView dispose, viewID: " + mViewID);
        mSurfaceView.getHolder().removeCallback(this);
        Surface surface = mSurfaceView.getHolder().getSurface();
        if(surface != null)
            surface.release();

        mSurfaceView = null;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        ZegoLogJNI.logNotice("ZegoPlatformView Created, viewID: " + mViewID);
        System.out.println("[ZegoPlatformView] surfaceCreated");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        ZegoLogJNI.logNotice("ZegoPlatformView Changed, viewID: " + mViewID + ", size: (" + width + ", " + height + ")");
        System.out.println("[ZegoPlatformView] surfaceChanged, width: " + width + ", height: " + height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        ZegoLogJNI.logNotice("[ZegoPlatformView] onSurfaceTextureDestroyed");
        System.out.println("[ZegoPlatformView] surfaceDestroyed");
    }
}
