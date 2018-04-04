package org.usfirst.frc.team125.robot.util.Paths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class GenericPaths {

    public static Waypoint[] pathOne = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.85, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] pathTwo = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.95, -0.72, Pathfinder.d2r(-100.0)),
    };

    public static Waypoint[] variablePath = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.1, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] toSwitchGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.6, 1.3, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_goBackGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.6, -1.3, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] toCubeGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.55, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_backOffCubeGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.55, 0.0, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] toSwitchAgainGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(1.6, 1.3, Pathfinder.d2r(0.0)),
    };

    public static Waypoint[] reverse_kTurnToSwitch1AGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.72, 1.15, Pathfinder.d2r(-90.0)),
    };

    public static Waypoint[] kTurnToSwitch1BGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.85, -0.68, Pathfinder.d2r(-30.0)),
    };

    public static Waypoint[] reverse_kTurnToScaleAGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.85, 0.0, Pathfinder.d2r(-30.0)),
    };

    public static Waypoint[] kTurnToScaleBGeneric = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(0.72, 1.4, Pathfinder.d2r(90.0)),
    };

}
