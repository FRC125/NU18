package org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale.TurnInPlacePaths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;
import org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants;

public class LeftSideFarTwoScaleTurnInPlacePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.7, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9, -1.95, Pathfinder.d2r(-90.0)),
            new Waypoint(4.9, -3.95, Pathfinder.d2r(-90.0)),
            new Waypoint(6.7, -4.95, Pathfinder.d2r(10.0)),
    };

    public static Waypoint[] reverse_backUpFromScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.5, 0.0, Pathfinder.d2r(0.0)),
    };

    public static final double turnToSwitch = -190;

    public static Waypoint[] toSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.2 - AutoPathsConstants.DRIVETRAIN_LENGTH, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_backUpFromSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.5, 0.0, Pathfinder.d2r(0.0)),
    };

    public static final double turnToScale = 180;

    public static Waypoint[] toScaleAgain = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.2 - AutoPathsConstants.DRIVETRAIN_LENGTH, 0.0, Pathfinder.d2r(0.0)),
    };

}
