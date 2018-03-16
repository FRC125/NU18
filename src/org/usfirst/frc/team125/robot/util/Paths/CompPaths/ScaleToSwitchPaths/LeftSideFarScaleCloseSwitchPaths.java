package org.usfirst.frc.team125.robot.util.Paths.PalmettoPaths.ScaleToSwitchPaths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class LeftSideFarScaleCloseSwitchPaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.7, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9, -1.2, Pathfinder.d2r(-90.0)),
            new Waypoint(4.9, -3.2, Pathfinder.d2r(-90.0)),
            new Waypoint(6.5, -4.2, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_kTurnToSwitch1A = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.8, -1.0, Pathfinder.d2r(90.0)),
    };

    public static Waypoint[] kTurnToSwitch1B = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.5, 0, Pathfinder.d2r(0.0)),
            new Waypoint(3.4, 1.9, Pathfinder.d2r(90.0)),
    };

}
