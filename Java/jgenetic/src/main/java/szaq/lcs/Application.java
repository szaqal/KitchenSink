package szaq.lcs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
	
	private static final int CLASSCOUNT = 50;
	
	public static void main(String[]args) {
		Env env = new Env(CLASSCOUNT);
		log.info(env.toString());
		new Performer(env).perform();
	}

}
