package org.usfirst.frc.team125.robot.util.Paths.CompPaths.ScaleToSwitchPaths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class RightSideFarScaleCloseSwitchPaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.7, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(5.2, 2.0, Pathfinder.d2r(90.0)),
            new Waypoint(5.2, 4.0, Pathfinder.d2r(90.0)),
            new Waypoint(6.5, 5.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_kTurnToSwitch1A = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.75, 1.0, Pathfinder.d2r(-90.0)),
    };

    public static Waypoint[] kTurnToSwitch1B = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.0, -1.0, Pathfinder.d2r(-90.0)),
    };

}
