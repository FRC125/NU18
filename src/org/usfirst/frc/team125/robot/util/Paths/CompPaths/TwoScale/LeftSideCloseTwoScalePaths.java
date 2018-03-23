package org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class LeftSideCloseTwoScalePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint((3.9784 - DRIVETRAIN_LENGTH), 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(6.5, -0.7, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_kTurnToSwitch1A = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.15, 0.65, Pathfinder.d2r(-90.0)),
    };

    public static Waypoint[] kTurnToSwitch1B = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.65, -0.35, Pathfinder.d2r(-20.0)),
    };

    public static Waypoint[] reverse_kTurnToScaleA = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.65, -0.35, Pathfinder.d2r(20.0)),
    };

    public static Waypoint[] kTurnToScaleB = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.65, 1.05, Pathfinder.d2r(90.0)),
    };
}
