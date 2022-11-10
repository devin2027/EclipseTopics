
/* add this to pom.xml build (must)
  <resources>
			<resource>
				<directory>src\main\java\Resources</directory>
				<filtering>true</filtering>
			</resource>
		</resources>
 */

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class logCreation {

	//Here Define LogManager
	private static Logger log = LogManager.getLogger(logCreation.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log.debug("Debugging is started");
		if(5>4)
			log.info("Object is present");
		log.error("Object is not present");
		log.fatal("This is fatal");
		
	}

}
