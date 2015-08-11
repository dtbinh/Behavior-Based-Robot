import lejos.nxt.Sound;
import lejos.robotics.subsumption.Behavior;

public class AvoidBehavior implements Behavior {
	public static boolean suppressed;
	private static MyRobot r;
	int countAvoid = 0;

	public AvoidBehavior(MyRobot r1) {
		r = r1;
	}

	public boolean takeControl() {
		return (r.us.getRange() < 20);
	}

	public void suppress() {
		
		suppressed = true;
	}

	public void action() {
		suppressed = false;
		countAvoid++;
		Sound.beep();
		r.nav.stop();
		r.dp.rotate(90);
		r.dp.travel(24);
		r.dp.rotate(-90);
		if(r.us.getRange() > 20){
			r.dp.travel(50);
			r.dp.rotate(-90);
			r.dp.travel(24*countAvoid);
			countAvoid = 0;
			r.dp.rotate(90);
		}		
		/**
		r.dp.rotate(90);
		r.dp.travel(22);
		r.dp.rotate(90);
		if(r.us.getRange() > 20){
			r.dp.travel(22);
			r.dp.rotate(90);
		} */
		r.nav.followPath();
		r.countMove++;
	}
}
