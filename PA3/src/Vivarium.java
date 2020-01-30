//Dynnor Shebshaievitz 
//PA3 
//CS480 - 11/12/19
import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import java.util.*;

public class Vivarium implements Displayable, Animate {
	 private Tank tank;
	 private Fish fish;
	 public Shark shark;
	//keeeps track if food has entered or left the viv in order to update the arraylist
	 public boolean foodEaten;
	 public boolean foodAdded;
	  //arraylist of food in the tank
	 public ArrayList<FishFood> food;

	 public ArrayList<Component> vivarium = new ArrayList<Component>();

	public Vivarium() {
		
		
		tank = new Tank(4.0f, 4.0f, 4.0f);
		
	    fish = new Fish(0, 0, 0, 0.6f, this);
	    shark = new Shark(0, 0, -1, 1.7f, 0.5f);
	    foodEaten= false;
	    foodAdded= false;
	    food = new ArrayList<FishFood>();
	    
	    /*
		vivarium.add(new ExampleModel(new Point3D(0, 0, 0), 0.6f));
		vivarium.add(new ExampleModel(new Point3D(1, 1, 1), 0.2f));
		vivarium.add(new ExampleModel(new Point3D(1, 1, -1), 0.2f));
		vivarium.add(new ExampleModel(new Point3D(1, -1, 1), 0.2f));
		vivarium.add(new ExampleModel(new Point3D(1, -1, -1), 0.2f));
		vivarium.add(new ExampleModel(new Point3D(-1, 1, 1), 0.2f));
		vivarium.add(new ExampleModel(new Point3D(-1, 1, -1), 0.2f));
		vivarium.add(new ExampleModel(new Point3D(-1, -1, 1), 0.2f));
		vivarium.add(new ExampleModel(new Point3D(-1, -1, -1), 0.2f));
		*/
	}

	public void initialize(GL2 gl) {
		tank.initialize(gl);
		fish.init(gl);
	    shark.init(gl);
	    fish.addPredator(shark);
	    if(!food.isEmpty()){
	    	for (FishFood f : food){
	    		f.init(gl);
	    }}
		for (Component object : vivarium) {
			object.initialize(gl);
		}
	}

	public void update(GL2 gl) {
		tank.update(gl);
		
		 //tank.update( gl );
		    //helper to delete from arraylist without causing an error
		    Iterator<FishFood> it = food.iterator();
		    while (it.hasNext()) {
		      FishFood food = it.next();
		      if (food.isEaten) {
		        it.remove();
		      }
		    }
		    if (!fish.dead)
		    	fish.update( gl );
		    shark.update ( gl );
		    if (foodAdded) {
		    	for (FishFood food : food) {
		        	food.init( gl );
		        }
		    	foodAdded = false;
		    }
		    if (!food.isEmpty()){
		    	for (FishFood f : food){
		    		f.update(gl);
		    	}
		    }
		for (Component object : vivarium) {
			object.update(gl);
		}
	}

	public void draw(GL2 gl) {
		tank.draw(gl);
		
	    fish.draw( gl );
	    shark.draw( gl );
	    for (FishFood f : food){
	    	f.draw(gl);
	    }
		for (Component object : vivarium) {
			object.draw(gl);
		}
	}
	 public void addFood(){
		  FishFood f = new FishFood();
		  food.add(f);
		  foodAdded = true;
	  }

	@Override
	public void setModelStates(ArrayList<Configuration> config_list) {
		// assign configurations in config_list to all Components in here
	}

	@Override
	public void animationUpdate(GL2 gl) {
		for (Component example : vivarium) {
			if (example instanceof Animate) {
				((Animate) example).animationUpdate(gl);
			}
		}
	}
}
