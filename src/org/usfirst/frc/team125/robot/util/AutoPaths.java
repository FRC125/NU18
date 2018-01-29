package org.usfirst.frc.team125.robot.util;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.nio.file.Path;

public class AutoPaths {
    private static final double drivetrainLength = 0.79375;

    public static Waypoint[] straightPath = new Waypoint[] {
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.4384, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] curvedPath = new Waypoint[] {
            new Waypoint(0., 0., Pathfinder.d2r(0.0)),
            new Waypoint(2.4384, -1.22, Pathfinder.d2r(-90.0)),
    };

    public static Waypoint[] wallToSwitch = new Waypoint[] {
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.53568, 0.0, Pathfinder.d2r(0.0)), // 1:3.53568 1/2:1.77 1/4:2.63 !:!:! 5.125!
};

    public static Waypoint[] rPath = new Waypoint[] {
        new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)) ,
        new Waypoint(5.125, 0.0, Pathfinder.d2r(0.0)),
        new Waypoint(7, -1.0, Pathfinder.d2r(-90)),
    };

    public static Waypoint[] toSwitch = new Waypoint[] {
           new Waypoint(0.0,0.0, Pathfinder.d2r(0.0)),
           new Waypoint(2.743, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] postBackup = new Waypoint[] {
            new Waypoint(0.0,0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0,1.25, Pathfinder.d2r(0.0)),
            new Waypoint(4.8,1.5, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] backUp = new Waypoint[] {
            new Waypoint(0.0,0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, 0.0, Pathfinder.d2r(0.0)),
    };

}
