package org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class LeftSideCloseNullScorePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint((3.9784 - DRIVETRAIN_LENGTH), 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(7.0, 0.9, Pathfinder.d2r(0.0)),
    };

    public static final double turnToScale = -90;


}