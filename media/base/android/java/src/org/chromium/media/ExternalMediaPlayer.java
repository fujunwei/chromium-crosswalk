// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.TrackInfo;
import android.net.Uri;
import android.view.Surface;

import org.chromium.base.Log;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/**
* Use Android system MediaPlayer by default.
*/
public class ExternalMediaPlayer {
    private static final String TAG = "ExternalMediaPlayer";

    private MediaPlayer mPlayer;

    protected MediaPlayer getLocalPlayer() {
        if (mPlayer == null) {
            mPlayer = new MediaPlayer();
            Log.d(TAG, "Create a Android System Media Player.");
        }
        return mPlayer;
    }

    public void setSurface(Surface surface) {
        getLocalPlayer().setSurface(surface);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> headers)
            throws Exception {
        getLocalPlayer().setDataSource(context, uri, headers);
    }

    public void setDataSource(FileDescriptor fd, long offset, long length) throws IOException {
        getLocalPlayer().setDataSource(fd, offset, length);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        getLocalPlayer().setDataSource(context, uri);
    }

    public void prepareAsync() throws IllegalStateException {
        getLocalPlayer().prepareAsync();
    }

    public TrackInfo[] getTrackInfo() throws RuntimeException {
        return getLocalPlayer().getTrackInfo();
    }

    public boolean isPlaying() {
        return getLocalPlayer().isPlaying();
    }

    public int getVideoWidth() {
        return getLocalPlayer().getVideoWidth();
    }

    public int getVideoHeight() {
        return getLocalPlayer().getVideoHeight();
    }

    public int getCurrentPosition() {
        return getLocalPlayer().getCurrentPosition();
    }

    public int getDuration() {
        return getLocalPlayer().getDuration();
    }

    public void release() {
        getLocalPlayer().release();
    }

    public void setVolume(float volume1, float volume2) {
        getLocalPlayer().setVolume((float) volume1, (float) volume2);
    }

    public void start() {
        getLocalPlayer().start();
    }

    public void pause() {
        getLocalPlayer().pause();
    }

    public void seekTo(int msec) {
        getLocalPlayer().seekTo(msec);
    }

    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener listener) {
        getLocalPlayer().setOnBufferingUpdateListener(listener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener listener) {
        getLocalPlayer().setOnCompletionListener(listener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener listener) {
        getLocalPlayer().setOnErrorListener(listener);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener listener) {
        getLocalPlayer().setOnPreparedListener(listener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener listener) {
        getLocalPlayer().setOnSeekCompleteListener(listener);
    }

    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener listener) {
        getLocalPlayer().setOnVideoSizeChangedListener(listener);
    }
}
