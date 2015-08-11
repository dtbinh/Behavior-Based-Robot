import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Waypoint;

public class MyRobot {

	public static TouchSensor ts;
	public static UltrasonicSensor us;
	public static LightSensor ls;
	public static NXTMotor ma, mb;
	public static DifferentialPilot dp;
	public static OdometryPoseProvider opp;
	public static int countMove;
	public static int count = 0;
	public static Navigator nav;

	public MyRobot() {
		// instantiate sensors
		us = new UltrasonicSensor(SensorPort.S1);
		// cs = new ColorSensorHT(SensorPort.S2);
		ts = new TouchSensor(SensorPort.S2);
		ls = new LightSensor(SensorPort.S4);
		// instantiate motors
		ma = new NXTMotor(MotorPort.A);
		mb = new NXTMotor(MotorPort.C);
		dp = new DifferentialPilot(5.6f, 10.62f, Motor.A, Motor.C);
		opp = new OdometryPoseProvider(dp);
		nav = new Navigator(dp);

		dp.setTravelSpeed(30);
		dp.setRotateSpeed(30);
		nav.addWaypoint(new Waypoint(100, 0));
		nav.addWaypoint(new Waypoint(100, 100));
		nav.addWaypoint(new Waypoint(0, 100));
		nav.addWaypoint(new Waypoint(0, 0));

		countMove = 0;
	}
}
