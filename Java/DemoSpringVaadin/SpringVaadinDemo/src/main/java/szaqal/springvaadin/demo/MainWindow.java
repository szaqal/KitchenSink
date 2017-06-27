package szaqal.springvaadin.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Component
@Scope("session")
public class MainWindow extends Window {
    private static final long serialVersionUID = 1L;

    @Autowired
    private HelloService helloService;

    public MainWindow() {
        super("Vaadin test");

    }

    @PostConstruct
    public void addInstanceLabels() {
        addComponent(new Label(helloService.getVaadinText()));
    }
}
