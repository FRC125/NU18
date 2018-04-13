package org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.TurnInPlacePaths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants;

import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class LeftSideCloseTwoScaleTurnInPlacePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint((3.9784 - DRIVETRAIN_LENGTH), 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(6.5, -0.9, Pathfinder.d2r(0.0)),
    };

    public static final double turnToSwitch = 180;

    public static Waypoint[] toSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.6 - AutoPathsConstants.DRIVETRAIN_LENGTH, 0.0, Pathfinder.d2r(0.0)),
    };

    public static final double turnToScale = -180;

    public static Waypoint[] toScaleAgain = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.6 - AutoPathsConstants.DRIVETRAIN_LENGTH, 0.0, Pathfinder.d2r(0.0)),
    };

}
