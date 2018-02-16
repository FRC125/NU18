package org.usfirst.frc.team125.robot.util.Paths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class RightSideCloseSwitchPaths {

    public static Waypoint[] backwards_pastFarSwitchLine = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9784 - DRIVETRAIN_LENGTH + 1.5, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] sPathToSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.5, 1.5, Pathfinder.d2r(0.0)),
    };


}
