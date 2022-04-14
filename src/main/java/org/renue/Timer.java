package org.renue;

public class Timer
{
    private long _start;
    private long _end;

    private boolean _isRunning;

    public Timer()
    {
        _start = _end = 0;
        _isRunning = false;
    }

    public void StartTimer()
    {
        _isRunning = true;
        _start = System.currentTimeMillis();
    }

    public void StopTimer()
    {
        _isRunning = false;
        _end = System.currentTimeMillis();
    }

    public long GetTimerTime()
    {
        if(_isRunning) StopTimer();
        return _end - _start;
    }
}
