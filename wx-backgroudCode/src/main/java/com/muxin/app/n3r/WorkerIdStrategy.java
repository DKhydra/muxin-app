package com.muxin.app.n3r;

public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
