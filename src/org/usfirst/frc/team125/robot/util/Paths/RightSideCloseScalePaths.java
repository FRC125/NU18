package org.usfirst.frc.team125.robot.util.Paths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class RightSideCloseScalePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint((3.9784 - DRIVETRAIN_LENGTH), 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(6.0, 0.35, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] kTurnToSwitch1A = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, -1.5, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] kTurnToSwitch1B = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.5, 0.5, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] kTurnToScale1A = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.5, 1.5, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] kTurnToScale1B = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, -1.5, Pathfinder.d2r(-90.0)),
    };

}