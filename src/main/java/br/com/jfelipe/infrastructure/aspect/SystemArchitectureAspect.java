package br.com.jfelipe.infrastructure.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitectureAspect {
    static final String ANY_METHOD_IN_WEB_LAYER = "br.com.jfelipe.infrastructure.aspect.SystemArchitectureAspect.inAnyMethodWebLayer()";

    @Pointcut("within(br.com.jfelipe.interfaces.web..*)")
    public void inAnyMethodWebLayer() {

    }
}
