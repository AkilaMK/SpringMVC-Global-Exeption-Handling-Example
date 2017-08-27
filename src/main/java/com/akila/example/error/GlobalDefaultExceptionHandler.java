package com.akila.example.error;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by akila on 8/27/17.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
    public static final String CUSTOM_ERROR_VIEW = "customError";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
/*        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the CustomException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
*/
        ModelAndView mav = new ModelAndView();

        if (e instanceof CustomException) {
            mav.addObject("customErrorMassage", e.getMessage());
            mav.setViewName(CUSTOM_ERROR_VIEW);
        } else {
            // Otherwise setup and send the user to a default error-view.
            mav.addObject("errorMassage", e.getMessage());
            mav.setViewName(DEFAULT_ERROR_VIEW);
        }

        return mav;
    }
}
