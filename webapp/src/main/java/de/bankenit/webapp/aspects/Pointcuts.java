package de.bankenit.webapp.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut(value = "execution(public * de.bankenit.webapp.presentation.controller.personen.PersonenQueryController.*(..))")
    public void personenQueryControllerMethods(){}

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void serviceMethods(){}

    @Pointcut("@within(de.bankenit.webapp.aspects.Dozent)")
    public void dozentMethods(){}

}
