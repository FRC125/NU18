package org.usfirst.frc.team125.robot.util;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.nio.file.Path;

public class AutoPaths {
    public static Waypoint[] toLine = new Waypoint[] {
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.048, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] backUp = new Waypoint[] {
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.75, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] toLineFar = new Waypoint[] {
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.25, 2.0, Pathfinder.d2r(0.0)),
            new Waypoint((4.572 + 2.159 - 2.048 + 0.75), (2.0), Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] postToLineFar = new Waypoint[] {
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.5, -1.0, Pathfinder.d2r(-120.0)),
    };

    //Running Paths reverse flips both x y and angle is measured from the back of the robot also the relative point switches
}
