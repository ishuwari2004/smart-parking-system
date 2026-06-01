package parking_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "forward:/dashboard.html";
    }

    @GetMapping("/payments")
    public String payments() {
        return "forward:/payments.html";
    }

    @GetMapping("/vehicles")
    public String vehicles() {
        return "forward:/vehicles.html";
    }

    @GetMapping("/users")
    public String users() {
        return "forward:/users.html";
    }

    @GetMapping("/slots")
    public String slots() {
        return "forward:/slots.html";
    }
}
@GetMapping("/analytics")
public String analytics() {
    return "forward:/analytics.html";
}

@GetMapping("/plate-ai")
public String plateAi() {
    return "forward:/plate-ai.html";
}
@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "forward:/dashboard.html";
    }

    @GetMapping("/analytics")
    public String analytics() {
        return "forward:/analytics.html";
    }

    @GetMapping("/plate-ai")
    public String plateAi() {
        return "forward:/plate-ai.html";
    }
}