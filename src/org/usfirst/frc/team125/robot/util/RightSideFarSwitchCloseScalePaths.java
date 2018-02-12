package org.usfirst.frc.team125.robot.util;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.nio.file.Path;

import static org.usfirst.frc.team125.robot.util.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class RightSideFarSwitchCloseScalePaths {

    public static Waypoint[] toFarSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9784 - DRIVETRAIN_LENGTH, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9784 - DRIVETRAIN_LENGTH + 1.0, 1.0, Pathfinder.d2r(90.0)),
            new Waypoint(4.9784 - DRIVETRAIN_LENGTH + 1.0, 3.5, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] backUpAfterSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.5, -2.3, Pathfinder.d2r(-45.0)),
    };

}