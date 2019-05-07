package com.muxin.app.n3r;

public interface RandomCodeStrategy {
    void init();

    int prefix();

    int next();

    void release();
}
