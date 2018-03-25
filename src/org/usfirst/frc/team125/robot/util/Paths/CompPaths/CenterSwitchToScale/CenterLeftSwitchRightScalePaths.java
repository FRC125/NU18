package org.usfirst.frc.team125.robot.util.Paths.CompPaths.CenterSwitchToScale;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class CenterLeftSwitchRightScalePaths {

    public static Waypoint[] toSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.5, 1.2, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_goBack = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.5, -1.2, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] toCube = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.5, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_backOffCube = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.25, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, -1.0, Pathfinder.d2r(-90.0)),
            new Waypoint(1.0, -1.9, Pathfinder.d2r(-90.0)),
    };


}
