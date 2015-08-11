import lejos.nxt.LCD;
import lejos.nxt.Sound;
import lejos.robotics.subsumption.Behavior;

public class GoalBehavior implements Behavior {
	public static boolean suppressed;
	private static MyRobot r;

	public GoalBehavior(MyRobot r1) {
		r = r1;
	}

	public boolean takeControl() {
		return r.nav.pathCompleted();
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		r.dp.rotate(90);
		for (int i = 0; i < 3; i++) {
			Sound.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		System.exit(0);
	}

}
