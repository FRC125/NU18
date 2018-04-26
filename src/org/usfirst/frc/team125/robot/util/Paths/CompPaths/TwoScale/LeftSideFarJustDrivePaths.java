package org.usfirst.frc.team125.robot.util.Paths.CompPaths.TwoScale;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class LeftSideFarJustDrivePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.7, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(4.9, -1.95, Pathfinder.d2r(-90.0)),
    };



}