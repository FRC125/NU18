package org.usfirst.frc.team125.robot.util.Paths.CompPaths.CenterPaths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class CenterLeftPath {

    public static Waypoint[] toSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.7, 1.2, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_goBack = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.0, -1.2, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] toCube = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_backOffCube = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.5, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] toSwitchAgain = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.85, 1.2, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] backOffSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, 0.0, Pathfinder.d2r(0.0)),
    };

    public static final double turnTowardsCubes = -90;

    public static Waypoint[] toCubeAgain = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.75, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] backOffCubeAgain = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.75, 0.0, Pathfinder.d2r(0.0)),
    };

    public static final double turnBack = 90;

    public static Waypoint[] toSwitchAgainAgain = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.0, 0.0, Pathfinder.d2r(0.0)),
    };

}
