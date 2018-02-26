package org.usfirst.frc.team125.robot.util.Paths.PalmettoPaths.ScaleToSwitchPaths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class RightSideCloseScaleFarSwitchPaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint((3.9784 - DRIVETRAIN_LENGTH), 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(6.2, 0.5, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_kTurnToSwitch1A = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.75, -1.0, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] kTurnToSwitch1B = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.5, 0, Pathfinder.d2r(0.0)),
            new Waypoint(3.4, 1.9, Pathfinder.d2r(90.0)),
    };

}
