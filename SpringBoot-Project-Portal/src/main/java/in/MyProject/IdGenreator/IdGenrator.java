package in.MyProject.IdGenreator;

import java.util.UUID;

public class IdGenrator {
	
	public static String genId() {
		return UUID.randomUUID().toString().replace("-", "").substring(0,7);
	}

}
