package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YuwenController {

	@RequestMapping({"/material","/"})
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();        
        mv.setViewName("material");
        return mv;
    }
	
}
