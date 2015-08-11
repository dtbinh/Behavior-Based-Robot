import lejos.nxt.LCD;

public class MySensors extends Thread {
	private static int delay;
	private static MyRobot me;

	public MySensors(MyRobot r, int d) {
		this.setDaemon(true);
		me = r;
		delay = d;
	}

	public void run() {
		while (true) {
			LCD.clear();
			//LCD.drawString("Color = " + me.cs.getColorID(), 0, 0);
			LCD.drawString("Range = " + me.us.getRange(), 0, 1);
			LCD.drawString("MotorA = " + me.ma.getPower(), 0, 2);
			LCD.drawString("MotorB = " + me.ma.getPower(), 0, 3);
			LCD.drawString("PoseX = " + me.nav.getPoseProvider().getPose().getX(), 0, 4);
			LCD.drawString("PoseY = " + me.nav.getPoseProvider().getPose().getY(), 0, 5);
			try {
				this.sleep(delay);
			} catch (Exception e) {
				;
			}
		} // end while
	} // end run
} // end class