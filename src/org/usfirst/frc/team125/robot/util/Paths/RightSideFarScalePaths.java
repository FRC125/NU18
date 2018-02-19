package org.usfirst.frc.team125.robot.util.Paths;

        import jaci.pathfinder.Pathfinder;
        import jaci.pathfinder.Waypoint;

        import static org.usfirst.frc.team125.robot.util.Paths.AutoPathsConstants.DRIVETRAIN_LENGTH;

public class RightSideFarScalePaths {

    public static Waypoint[] toScale = new Waypoint[]{
            new Waypoint(0.0, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(3.7, 0.0, Pathfinder.d2r(0.0)),
            new Waypoint(5.2, 1.5, Pathfinder.d2r(90.0)),
            new Waypoint(5.2, 4.02, Pathfinder.d2r(90.0)),
            new Waypoint(5.75, 5.2, Pathfinder.d2r(0.0)),
    };
    
}
