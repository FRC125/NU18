package org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class LeftSideFarTwoScalePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.7, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9, -1.95, Pathfinder.d2r(-90.0)),
            new Waypoint(4.9, -3.95, Pathfinder.d2r(-90.0)),
            new Waypoint(6.7, -4.95, Pathfinder.d2r(10.0)),
    };
    // 0.55m change from palmetto matches

    public static Waypoint[] reverse_kTurnToSwitch1A = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.12, -1.25, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] kTurnToSwitch1B = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.45, 0.58, Pathfinder.d2r(30.0)),
    };

    public static Waypoint[] reverse_kTurnToScaleA = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.55, 0.0, Pathfinder.d2r(-30.0)),
    };

    public static Waypoint[] kTurnToScaleB = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.95, -1.12, Pathfinder.d2r(-90.0)),
    };

}