package org.usfirst.frc.team125.robot.util;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import static org.usfirst.frc.team125.robot.util.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class RightSideCloseSwitchCloseScalePaths {

    public static double y = 2.0;

    public static Waypoint[] toFarSwitchLine = new Waypoint[]{ //
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9784 - DRIVETRAIN_LENGTH - 0.9, 0.0, Pathfinder.d2r(0.0)),
    };
    public static Waypoint[] right_closeSideSwitchCubeGrab = new Waypoint[]{ //
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.0, y, Math.atan(y/2.0)),
    };

    public static Waypoint[] right_backwards_postCloseGrabCube = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.0, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] right_postCloseGrabCubeBackupToScaleClose = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.5, -1.5, -Math.atan(y/2.0)),
    };
}