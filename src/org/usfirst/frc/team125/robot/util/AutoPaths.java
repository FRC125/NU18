package org.usfirst.frc.team125.robot.util;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

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
            new Waypoint(2.68, 0.0, Pathfinder.d2r(0.0)),
    };

}
