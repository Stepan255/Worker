package Worker;

import java.util.Random;

public class IdGenerator {
	public int getId(){
		return new Random().nextInt(Integer.MAX_VALUE);
	}
}
