package org.usfirst.frc.team125.robot.util.Paths;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class CenterLeftPath {

    public static Waypoint[] toSwitch = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(2.5, 1.25, Pathfinder.d2r(0.0)),
    };

}
