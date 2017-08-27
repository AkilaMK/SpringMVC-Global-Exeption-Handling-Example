package com.akila.example.controller;

import com.akila.example.error.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by akila on 8/27/17.
 */
@Controller
@RequestMapping("/error")
public class ErrorProduceController {
    @RequestMapping(value="/orders/{number}", method= RequestMethod.GET)
    public String showOrder(@PathVariable("number") long number, Model model) {

        if (number < 5) throw new RuntimeException("number < 5");

        if (number > 100) throw new CustomException("number > 100");

        model.addAttribute("number", number);
        return "success";
    }

/*
    // Specify name of a specific view that will be used to display the error:
    @ExceptionHandler({SQLException.class,DataAccessException.class})
    public String databaseError() {
        // Nothing to do.  Returns the logical view name of an error page, passed
        // to the view-resolver(s) in usual way.
        // Note that the exception is NOT available to this view (it is not added
        // to the model) but see "Extending ExceptionHandlerExceptionResolver"
        // below.
        return "databaseError";
    }

    // Total control - setup a model and return the view name yourself. Or
    // consider subclassing ExceptionHandlerExceptionResolver (see below).
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
    */
}
