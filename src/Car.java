import lejos.nxt.Button;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Car {

	public static void main(String[] args) throws Exception {

		while (!Button.ENTER.isDown()) {

		}
		MyRobot me = new MyRobot();
		MySensors rm = new MySensors(me, 300);
		rm.start();

		Behavior b1 = new NavigateBehavior(me);
		Behavior b3 = new AvoidBehavior(me);
		Behavior b4 = new GoalBehavior(me);

		Behavior[] bArray = { b1, b3 , b4};
		Arbitrator arb = new Arbitrator(bArray);
		arb.start();
	}

}