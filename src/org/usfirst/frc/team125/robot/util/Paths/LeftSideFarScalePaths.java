package org.usfirst.frc.team125.robot.util.Paths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class LeftSideFarScalePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint((4.9784 - DRIVETRAIN_LENGTH) - 1.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint((4.9784 - DRIVETRAIN_LENGTH) + 1.31, -5.0, Pathfinder.d2r(-90.0)),
            new Waypoint((4.9784 - DRIVETRAIN_LENGTH) + 2.7, -6.0, Pathfinder.d2r(0.0)),
    };


}
