/**
 * @author Jeffrey Finkelstein <jeffrey.finkelstein@gmail.com>
 * @author Zezhou Sun <micou@bu.edu>
 * @since Spring 2011
 */

import java.util.HashMap;
import java.util.Map;

public class TestCases extends CyclicIterator<Map<String, Configuration>> {

	public static String INDEX_PALM_NAME = "index palm";
	public static String INDEX_MIDDLE_NAME = "index middle";
	public static String INDEX_DISTAL_NAME = "index distal";
	public static String RING_PALM_NAME = "ring palm";
	public static String RING_MIDDLE_NAME = "ring middle";
	public static String RING_DISTAL_NAME = "ring distal";
	public static String MIDDLE_PALM_NAME = "middle palm";
	public static String MIDDLE_MIDDLE_NAME = "middle middle";
	public static String MIDDLE_DISTAL_NAME = "middle distal";
	public static String PINKY_PALM_NAME = "pinky palm";
	public static String PINKY_MIDDLE_NAME = "pinky middle";
	public static String PINKY_DISTAL_NAME = "pinky distal";
	public static String THUMB_PALM_NAME = "thumb palm";
	public static String THUMB_MIDDLE_NAME = "thumb middle";
	public static String THUMB_DISTAL_NAME = "thumb distal";
	public static String HAND_NAME = "hand";
	public static String FOREARM_NAME = "forearm";
	public static String UPPER_ARM_NAME = "upper arm";
	
	
	Map<String, Configuration> stop() {
		return this.stop;
	}
	

	private final Map<String, Configuration> stop;
	

	@SuppressWarnings("unchecked")
	TestCases() {
		this.stop = new HashMap<String, Configuration>();
		final Map<String, Configuration> peace = new HashMap<String, Configuration>();
		final Map<String, Configuration> fist = new HashMap<String, Configuration>();
		final Map<String, Configuration> shaka = new HashMap<String, Configuration>();
		final Map<String, Configuration> spread = new HashMap<String, Configuration>();
		final Map<String, Configuration> claw = new HashMap<String, Configuration>();
		
		final Map<String, Configuration> spreadd = new HashMap<String, Configuration>();
	    final Map<String, Configuration> walk = new HashMap<String, Configuration>();
	    final Map<String, Configuration> curl = new HashMap<String, Configuration>();
	    final Map<String, Configuration> raise = new HashMap<String, Configuration>();
	    final Map<String, Configuration> balance = new HashMap<String, Configuration>();
	    
		
	    
		super.add(stop, peace, fist, shaka, spread, claw);
		super.add(stop, spreadd, walk, curl, raise, balance);

		// the upper arm, forearm, and hand angles do not change through any of the
		// test cases
		stop.put(UPPER_ARM_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(UPPER_ARM_NAME, new BaseConfiguration(0, 0, 0));
		fist.put(UPPER_ARM_NAME, new BaseConfiguration(0, 0, 0));
		shaka.put(UPPER_ARM_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(UPPER_ARM_NAME, new BaseConfiguration(0, 0, 0));
		claw.put(UPPER_ARM_NAME, new BaseConfiguration(0, 0, 0));

		stop.put(FOREARM_NAME, new BaseConfiguration(0, 90, 0));
		peace.put(FOREARM_NAME, new BaseConfiguration(0, 90, 0));
		fist.put(FOREARM_NAME, new BaseConfiguration(0, 90, 0));
		shaka.put(FOREARM_NAME, new BaseConfiguration(0, 90, 0));
		spread.put(FOREARM_NAME, new BaseConfiguration(0, 90, 0));
		claw.put(FOREARM_NAME, new BaseConfiguration(0, 90, 0));

		stop.put(HAND_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(HAND_NAME, new BaseConfiguration(0, 0, 0));
		fist.put(HAND_NAME, new BaseConfiguration(0, 0, 0));
		shaka.put(HAND_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(HAND_NAME, new BaseConfiguration(0, 0, 0));
		claw.put(HAND_NAME, new BaseConfiguration(0, 0, 0));

		// the stop test case
		stop.put(PINKY_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(PINKY_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(PINKY_PALM_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(RING_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(RING_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(RING_PALM_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(MIDDLE_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(MIDDLE_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(MIDDLE_PALM_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(INDEX_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(INDEX_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(INDEX_PALM_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(THUMB_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(THUMB_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(THUMB_PALM_NAME, new BaseConfiguration(0, 50, -60));

		// the peace sign test case
		peace.put(PINKY_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		peace.put(PINKY_MIDDLE_NAME, new BaseConfiguration(90, 0, 0));
		peace.put(PINKY_PALM_NAME, new BaseConfiguration(60, 0, 0));
		peace.put(RING_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		peace.put(RING_MIDDLE_NAME, new BaseConfiguration(90, 0, 0));
		peace.put(RING_PALM_NAME, new BaseConfiguration(60, 0, 0));
		peace.put(MIDDLE_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(MIDDLE_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(MIDDLE_PALM_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(INDEX_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(INDEX_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(INDEX_PALM_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(THUMB_DISTAL_NAME, new BaseConfiguration(10, 0, 0));
		peace.put(THUMB_MIDDLE_NAME, new BaseConfiguration(90, 0, 0));
		peace.put(THUMB_PALM_NAME, new BaseConfiguration(30, 50, -60));

		// the fist test case
		fist.put(PINKY_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		fist.put(PINKY_MIDDLE_NAME, new BaseConfiguration(90, 0, 0));
		fist.put(PINKY_PALM_NAME, new BaseConfiguration(60, 0, 0));
		fist.put(RING_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		fist.put(RING_MIDDLE_NAME, new BaseConfiguration(90, 0, 0));
		fist.put(RING_PALM_NAME, new BaseConfiguration(60, 0, 0));
		fist.put(MIDDLE_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		fist.put(MIDDLE_MIDDLE_NAME, new BaseConfiguration(90, 0, 0));
		fist.put(MIDDLE_PALM_NAME, new BaseConfiguration(60, 0, 0));
		fist.put(INDEX_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		fist.put(INDEX_MIDDLE_NAME, new BaseConfiguration(90, 0, 0));
		fist.put(INDEX_PALM_NAME, new BaseConfiguration(60, 0, 0));
		fist.put(THUMB_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		fist.put(THUMB_MIDDLE_NAME, new BaseConfiguration(60, 0, 0));
		fist.put(THUMB_PALM_NAME, new BaseConfiguration(30, 50, -60));

		// the shaka test case
		shaka.put(PINKY_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		shaka.put(PINKY_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		shaka.put(PINKY_PALM_NAME, new BaseConfiguration(0, -15, 0));
		shaka.put(RING_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		shaka.put(RING_MIDDLE_NAME, new BaseConfiguration(80, 0, 0));
		shaka.put(RING_PALM_NAME, new BaseConfiguration(45, 0, 0));
		shaka.put(MIDDLE_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		shaka.put(MIDDLE_MIDDLE_NAME, new BaseConfiguration(80, 0, 0));
		shaka.put(MIDDLE_PALM_NAME, new BaseConfiguration(45, 0, 0));
		shaka.put(INDEX_DISTAL_NAME, new BaseConfiguration(50, 0, 0));
		shaka.put(INDEX_MIDDLE_NAME, new BaseConfiguration(80, 0, 0));
		shaka.put(INDEX_PALM_NAME, new BaseConfiguration(45, 0, 0));
		shaka.put(THUMB_DISTAL_NAME, new BaseConfiguration(-10, 0, 0));
		shaka.put(THUMB_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		shaka.put(THUMB_PALM_NAME, new BaseConfiguration(0, 60, -60));

		// the spread test case
		spread.put(PINKY_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(PINKY_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(PINKY_PALM_NAME, new BaseConfiguration(0, -10, 0));
		spread.put(RING_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(RING_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(RING_PALM_NAME, new BaseConfiguration(0, -7, 0));
		spread.put(MIDDLE_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(MIDDLE_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(MIDDLE_PALM_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(INDEX_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(INDEX_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(INDEX_PALM_NAME, new BaseConfiguration(0, 10, 0));
		spread.put(THUMB_DISTAL_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(THUMB_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(THUMB_PALM_NAME, new BaseConfiguration(0, 60, -60));

		// the claw test case
		claw.put(PINKY_DISTAL_NAME, new BaseConfiguration(60, 0, 0));
		claw.put(PINKY_MIDDLE_NAME, new BaseConfiguration(80, 0, 0));
		claw.put(PINKY_PALM_NAME, new BaseConfiguration(0, 0, 0));
		claw.put(RING_DISTAL_NAME, new BaseConfiguration(60, 0, 0));
		claw.put(RING_MIDDLE_NAME, new BaseConfiguration(80, 0, 0));
		claw.put(RING_PALM_NAME, new BaseConfiguration(0, 0, 0));
		claw.put(MIDDLE_DISTAL_NAME, new BaseConfiguration(60, 0, 0));
		claw.put(MIDDLE_MIDDLE_NAME, new BaseConfiguration(80, 0, 0));
		claw.put(MIDDLE_PALM_NAME, new BaseConfiguration(0, 0, 0));
		claw.put(INDEX_DISTAL_NAME, new BaseConfiguration(60, 0, 0));
		claw.put(INDEX_MIDDLE_NAME, new BaseConfiguration(80, 0, 0));
		claw.put(INDEX_PALM_NAME, new BaseConfiguration(0, 0, 0));
		claw.put(THUMB_DISTAL_NAME, new BaseConfiguration(70, 0, 0));
		claw.put(THUMB_MIDDLE_NAME, new BaseConfiguration(20, 0, 0));
		claw.put(THUMB_PALM_NAME, new BaseConfiguration(30, 50, -60));
		
		//test cases for the bug 
		// angle of body does not change in any of the test cases
	    // test cases

	    stop.put(Bug.BODY_NAME, new BaseConfiguration(0, 0, 0));
	    spreadd.put(Bug.BODY_NAME, new BaseConfiguration(0, 0, 0));
	    walk.put(Bug.BODY_NAME, new BaseConfiguration(0, 0, 0));
	    curl.put(Bug.BODY_NAME, new BaseConfiguration(0, 0, 0));
	    raise.put(Bug.BODY_NAME, new BaseConfiguration(0, 0, 0));
	    balance.put(Bug.BODY_NAME, new BaseConfiguration(0, 0, 0));

	    // the stop test case
	    //Back left
	    stop.put(Bug.BACK_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    stop.put(Bug.BACK_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    stop.put(Bug.BACK_LEFT_UPPER, new BaseConfiguration(15, -30, 0));
	    //middle left
	    stop.put(Bug.MIDDLE_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    stop.put(Bug.MIDDLE_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    stop.put(Bug.MIDDLE_LEFT_UPPER, new BaseConfiguration(15, 0, 0));
	    //Front left
	    stop.put(Bug.FRONT_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    stop.put(Bug.FRONT_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    stop.put(Bug.FRONT_LEFT_UPPER, new BaseConfiguration(15, 30, 0));
	    
	    //Back Right
	    stop.put(Bug.BACK_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    stop.put(Bug.BACK_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    stop.put(Bug.BACK_RIGHT_UPPER, new BaseConfiguration(-15, -150, 0));
	    
	    //Middle Right
	    stop.put(Bug.MIDDLE_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    stop.put(Bug.MIDDLE_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    stop.put(Bug.MIDDLE_RIGHT_UPPER, new BaseConfiguration(-15, -180, 0));
	    
	    //Front Right
	    stop.put(Bug.FRONT_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    stop.put(Bug.FRONT_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    stop.put(Bug.FRONT_RIGHT_UPPER, new BaseConfiguration(-15, -210, 0));
	   
	    
	    // the spread legs test case
	    //Back Left
	    spreadd.put(Bug.BACK_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    spreadd.put(Bug.BACK_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    spreadd.put(Bug.BACK_LEFT_UPPER, new BaseConfiguration(-20, -50, 0));
	 
	    spreadd.put(Bug.MIDDLE_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    spreadd.put(Bug.MIDDLE_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    spreadd.put(Bug.MIDDLE_LEFT_UPPER, new BaseConfiguration(-20, 0, 0));
	    
	    spreadd.put(Bug.FRONT_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    spreadd.put(Bug.FRONT_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    spreadd.put(Bug.FRONT_LEFT_UPPER, new BaseConfiguration(-20, 50, 0));
	    
	    spreadd.put(Bug.BACK_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    spreadd.put(Bug.BACK_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    spreadd.put(Bug.BACK_RIGHT_UPPER, new BaseConfiguration(20, -130, 0));
	    
	    spreadd.put(Bug.MIDDLE_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    spreadd.put(Bug.MIDDLE_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    spreadd.put(Bug.MIDDLE_RIGHT_UPPER, new BaseConfiguration(20, -180, 0));
	    
	    spreadd.put(Bug.FRONT_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    spreadd.put(Bug.FRONT_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    spreadd.put(Bug.FRONT_RIGHT_UPPER, new BaseConfiguration(20, -230, 0));
	    

	    // the walk test case
	    //Back left
	    walk.put(Bug.BACK_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    walk.put(Bug.BACK_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    walk.put(Bug.BACK_LEFT_UPPER, new BaseConfiguration(15, 5, 0));
	    //middle left
	    walk.put(Bug.MIDDLE_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    walk.put(Bug.MIDDLE_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    walk.put(Bug.MIDDLE_LEFT_UPPER, new BaseConfiguration(15, 20, 0));
	    //Front left
	    walk.put(Bug.FRONT_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    walk.put(Bug.FRONT_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    walk.put(Bug.FRONT_LEFT_UPPER, new BaseConfiguration(15, 50, 0));
	    
	    //Back Right
	    walk.put(Bug.BACK_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    walk.put(Bug.BACK_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    walk.put(Bug.BACK_RIGHT_UPPER, new BaseConfiguration(-15, -130, 0));
	    
	    //Middle Right
	    walk.put(Bug.MIDDLE_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    walk.put(Bug.MIDDLE_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    walk.put(Bug.MIDDLE_RIGHT_UPPER, new BaseConfiguration(-15, -150, 0));
	    
	    //Front Right
	    walk.put(Bug.FRONT_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    walk.put(Bug.FRONT_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    walk.put(Bug.FRONT_RIGHT_UPPER, new BaseConfiguration(-15, -180, 0));

	    
	    
	    // the curl test case
	    //Back left
	    curl.put(Bug.BACK_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    curl.put(Bug.BACK_LEFT_MIDDLE, new BaseConfiguration(45, 0, 0));
	    curl.put(Bug.BACK_LEFT_UPPER, new BaseConfiguration(35, -30, 0));
	    //middle left
	    curl.put(Bug.MIDDLE_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    curl.put(Bug.MIDDLE_LEFT_MIDDLE, new BaseConfiguration(45, 0, 0));
	    curl.put(Bug.MIDDLE_LEFT_UPPER, new BaseConfiguration(35, 0, 0));
	    //Front left
	    curl.put(Bug.FRONT_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    curl.put(Bug.FRONT_LEFT_MIDDLE, new BaseConfiguration(45, 0, 0));
	    curl.put(Bug.FRONT_LEFT_UPPER, new BaseConfiguration(35, 30, 0));
	    
	    //Back Right
	    curl.put(Bug.BACK_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    curl.put(Bug.BACK_RIGHT_MIDDLE, new BaseConfiguration(45, 0, 0));
	    curl.put(Bug.BACK_RIGHT_UPPER, new BaseConfiguration(-35, -150, 0));
	    
	    //Middle Right
	    curl.put(Bug.MIDDLE_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    curl.put(Bug.MIDDLE_RIGHT_MIDDLE, new BaseConfiguration(45, 0, 0));
	    curl.put(Bug.MIDDLE_RIGHT_UPPER, new BaseConfiguration(-35, -180, 0));
	    
	    //Front Right
	    curl.put(Bug.FRONT_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    curl.put(Bug.FRONT_RIGHT_MIDDLE, new BaseConfiguration(45, 0, 0));
	    curl.put(Bug.FRONT_RIGHT_UPPER, new BaseConfiguration(-35, -210, 0));

	    
	    
	    // the raise test case
	    raise.put(Bug.BACK_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    raise.put(Bug.BACK_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    raise.put(Bug.BACK_LEFT_UPPER, new BaseConfiguration(15, -30, 0));
	    //middle left
	    raise.put(Bug.MIDDLE_LEFT_LOWER, new BaseConfiguration(50, 0, 0));
	    raise.put(Bug.MIDDLE_LEFT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    raise.put(Bug.MIDDLE_LEFT_UPPER, new BaseConfiguration(15, 20, 0));
	    //Front left
	    raise.put(Bug.FRONT_LEFT_LOWER, new BaseConfiguration(20, 0, 0));
	    raise.put(Bug.FRONT_LEFT_MIDDLE, new BaseConfiguration(-20, 10, 20));
	    raise.put(Bug.FRONT_LEFT_UPPER, new BaseConfiguration(-5, 50, 0));
	    
	    //Back Right
	    raise.put(Bug.BACK_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    raise.put(Bug.BACK_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    raise.put(Bug.BACK_RIGHT_UPPER, new BaseConfiguration(-15, -150, 0));
	    
	    //Middle Right
	    raise.put(Bug.MIDDLE_RIGHT_LOWER, new BaseConfiguration(50, 0, 0));
	    raise.put(Bug.MIDDLE_RIGHT_MIDDLE, new BaseConfiguration(0, 0, 0));
	    raise.put(Bug.MIDDLE_RIGHT_UPPER, new BaseConfiguration(-15, -200, 0));
	    
	    //Front Right
	    raise.put(Bug.FRONT_RIGHT_LOWER, new BaseConfiguration(20, 0, 0));
	    raise.put(Bug.FRONT_RIGHT_MIDDLE, new BaseConfiguration(-20, -10, -20));
	    raise.put(Bug.FRONT_RIGHT_UPPER, new BaseConfiguration(5, -230, 0));
	   
	    
	    // the balance test case
		balance.put(Bug.BACK_LEFT_LOWER, new BaseConfiguration(30, 0, 0));
	    balance.put(Bug.BACK_LEFT_MIDDLE, new BaseConfiguration(-20, 0, 0));
	    balance.put(Bug.BACK_LEFT_UPPER, new BaseConfiguration(-20, -50, 0));
	 
	    balance.put(Bug.MIDDLE_LEFT_LOWER, new BaseConfiguration(30, 0, 0));
	    balance.put(Bug.MIDDLE_LEFT_MIDDLE, new BaseConfiguration(-20, 0, 0));
	    balance.put(Bug.MIDDLE_LEFT_UPPER, new BaseConfiguration(-20, 0, 0));
	    
	    balance.put(Bug.FRONT_LEFT_LOWER, new BaseConfiguration(30, 0, 0));
	    balance.put(Bug.FRONT_LEFT_MIDDLE, new BaseConfiguration(-20, 0, 0));
	    balance.put(Bug.FRONT_LEFT_UPPER, new BaseConfiguration(-20, 50, 0));
	    //Back Right
	    balance.put(Bug.BACK_RIGHT_LOWER, new BaseConfiguration(30, 0, 0));
	    balance.put(Bug.BACK_RIGHT_MIDDLE, new BaseConfiguration(20, 0, 0));
	    balance.put(Bug.BACK_RIGHT_UPPER, new BaseConfiguration(-35, -150, 0));
	    
	    //Middle Right
	    balance.put(Bug.MIDDLE_RIGHT_LOWER, new BaseConfiguration(30, 0, 0));
	    balance.put(Bug.MIDDLE_RIGHT_MIDDLE, new BaseConfiguration(20, 0, 0));
	    balance.put(Bug.MIDDLE_RIGHT_UPPER, new BaseConfiguration(-35, -180, 0));
	    
	    //Front Right
	    balance.put(Bug.FRONT_RIGHT_LOWER, new BaseConfiguration(30, 0, 0));
	    balance.put(Bug.FRONT_RIGHT_MIDDLE, new BaseConfiguration(20, 0, 0));
	    balance.put(Bug.FRONT_RIGHT_UPPER, new BaseConfiguration(-35, -210, 0));
		
	}
}
