package org.usfirst.frc.team125.robot.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class WindowedError {

    private int windowSize;
    private double lastSum;
    private ArrayDeque<Double> errors = new ArrayDeque<>();

    public WindowedError(int windowSize) {
        this.windowSize = windowSize;
        this.lastSum = 0.;
    }

    public double getWindowedError() {
        if(errors.size() < windowSize) {
            return 0.;
        }
        return lastSum;
    }

    public void updateWindowedError(double newError) {
        errors.add(newError);
        lastSum += newError;
        if(errors.size() > windowSize) {
            lastSum -= errors.remove();
        }
    }

    public void resetWindow() {
        lastSum = 0.0;
        errors.clear();
    }
}
