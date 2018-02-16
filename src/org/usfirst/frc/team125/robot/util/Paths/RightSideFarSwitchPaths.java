package org.usfirst.frc.team125.robot.util.Paths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class RightSideFarSwitchPaths {

    public static Waypoint[] pastFarSwitchLine = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9784 - DRIVETRAIN_LENGTH, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] elbowTurn = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, -1.0, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] driveStraight = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, 0.0, Pathfinder.d2r(0.0)),
    };

}
