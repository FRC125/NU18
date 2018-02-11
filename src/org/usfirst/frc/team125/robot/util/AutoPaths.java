package org.usfirst.frc.team125.robot.util;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.nio.file.Path;

public class AutoPaths {

    private static final double DRIVETRAIN_LENGTH = 0.0;
    /*public static Waypoint[] toLine = new Waypoint[] {
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
    */

    public static Waypoint[] toFarSwitchLine = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9784 - DRIVETRAIN_LENGTH, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] left_closeSideSwitchCubeGrab = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.3, 0.5, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] left_postCloseSideSwitchCubeGrabToCloseScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.8, 2.0, Pathfinder.d2r(-90.0)),
    };

    public static Waypoint[] left_postCloseSideSwitchCubeGrabToFarScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.867 + 0.8 + 0.25, 2.0, Pathfinder.d2r(-90.0)),
    };

    public static Waypoint[] left_postSwitchLineToFarSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.2, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.4, 1.867, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] left_backwards_postFarSwitchCubeGrabBackup = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, 0.5, Pathfinder.d2r(-120.0)),
    };

    public static Waypoint[] left_postFarSwitchCubeGrabBackupIntoGrab = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.2, 0.0, Pathfinder.d2r(-60.0)),
    };

    public static Waypoint[] left_postFarSwitchCubeGrabIntoScalePosition = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, 2.75, Pathfinder.d2r(-90.0)),
    };



    public static Waypoint[] straightLineGenerator(double meters) {
        return new Waypoint[]{
                new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
                new Waypoint(meters, 0.0, Pathfinder.d2r(0.0)),
        };
    }
    //Running Paths reverse flips both x y and angle is measured from the back of the robot also the relative point switches
}
