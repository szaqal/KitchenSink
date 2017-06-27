package szaqal.springvaadin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.Application;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Configurable
public class VaadinApplication extends Application {

	private static final long serialVersionUID = -5846031363209103131L;
	
	@Autowired
    private MainWindow mainWindow;

    @Override
    public void init() {
        setMainWindow(mainWindow);
    }
    
}
