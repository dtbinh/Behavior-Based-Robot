import lejos.robotics.subsumption.Behavior;

public class NavigateBehavior implements Behavior {
	public static boolean suppressed;
	private static MyRobot r;

	public NavigateBehavior(MyRobot r1) {
		r = r1;
	}

	public boolean takeControl() {
		return true;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		r.nav.followPath();
	}

}
