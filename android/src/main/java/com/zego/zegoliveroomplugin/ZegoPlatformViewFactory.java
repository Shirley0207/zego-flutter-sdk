package com.zego.zegoliveroomplugin;

import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class ZegoPlatformViewFactory extends PlatformViewFactory{

    private static ZegoPlatformViewFactory sInstance;

    private HashMap<Integer, WeakReference<ZegoPlatformView>> mViews;

    public static ZegoPlatformViewFactory shareInstance() {
        if(sInstance == null) {
            sInstance = new ZegoPlatformViewFactory(StandardMessageCodec.INSTANCE);
        }

        return sInstance;
    }

    private ZegoPlatformViewFactory(MessageCodec<Object> createArgsCodec) {
        super(createArgsCodec);
        mViews = new HashMap<>();
        ZegoLogJNI.logNotice("ZegoPlatformViewFactory create");
    }

    public void addView(int viewID, ZegoPlatformView view) {
        ZegoLogJNI.logNotice("ZegoPlatformView, addView: " + viewID);

        WeakReference<ZegoPlatformView> weakView = new WeakReference<ZegoPlatformView>(view);
        mViews.put(Integer.valueOf(viewID), weakView);
    }

    public boolean removeView(int viewID) {

        if(!mViews.containsKey(Integer.valueOf(viewID))) {
            ZegoLogJNI.logNotice("ZegoPlatformView, removeView (" + viewID + ") failed, no such view");
            return false;
        }

        mViews.remove(Integer.valueOf(viewID));
        ZegoLogJNI.logNotice("ZegoPlatformView, removeView (" + viewID + ") success");
        return true;
    }

    public ZegoPlatformView getPlatformView(int viewID) {
        ZegoLogJNI.logNotice("ZegoPlatformView, getView: " + viewID);

        WeakReference<ZegoPlatformView> weakView =  mViews.get(Integer.valueOf(viewID));
        return weakView.get();
    }

    @Override
    public PlatformView create(Context context, int viewID, Object args) {

        ZegoLogJNI.logNotice("ZegoPlatFormViewFactory create view, viewID: " + viewID + ", args: " + args);
       /*System.out.println("[ZegoPlatformViewfactory] create view, viewID: " + viewID + ", args: " + args);
        HashMap<String, Object> map = (HashMap<String, Object>) args;
        Integer objWidth = (Integer) map.get("width");
        Integer objHeight = (Integer) map.get("height");
        Boolean objIsSurfaceView = (Boolean) map.get("isSurfaceView");
        int width = objWidth != null ? objWidth.intValue() : 0;
        int height = objHeight != null ? objHeight.intValue() : 0;
        boolean isSurfaceView = objIsSurfaceView != null ? objIsSurfaceView.booleanValue() : true;*/
        ZegoPlatformView view = new ZegoPlatformView(context, viewID);
        addView(viewID, view);

        return view;
    }
}
