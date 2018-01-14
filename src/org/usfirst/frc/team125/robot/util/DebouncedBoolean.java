package org.usfirst.frc.team125.robot.util;

import com.sun.glass.ui.SystemClipboard;

public class DebouncedBoolean {

    private int loopCounter = 0;
    private int minimumLoops;

    public DebouncedBoolean(double minimumSeconds) {
        minimumLoops = (int)Math.ceil(minimumSeconds / 0.02);
    }

    public boolean get() {
        return loopCounter >= minimumLoops;
    }

    public void update(boolean value) {
        if(value) {
            loopCounter++;
        } else {
            loopCounter = 0;
        }
    }

    public static void main(String[] args){
        DebouncedBoolean b = new DebouncedBoolean(2.0);

        for(int j = 0; j <= b.minimumLoops; j++) {
            b.update(true);
        }
        assert(b.get());
    }

}
