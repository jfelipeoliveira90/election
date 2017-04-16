package br.com.jfelipe.infrastructure.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static java.lang.System.nanoTime;
import static java.time.Duration.ofNanos;
import static java.util.UUID.randomUUID;

@Aspect
@Component
public class LoggerHandlerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("inAnyMethodWebLayer()")
    public void generateLogIdInWebLayer() {
        MDC.put("logID", format("LOGID:%s", randomUUID()));
    }

    @Around("inAnyMethodWebLayer()")
    public Object measureExecutionTimeInWebLayer(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = nanoTime();
        Object proceed = joinPoint.proceed();
        long end = nanoTime();
        long executionTime = ofNanos(end - start)
                .toMillis();

        logger.info("Tempo de execucao: {} ms", executionTime);
        return proceed;
    }

    @Pointcut("within(br.com.jfelipe.interfaces.web..*)")
    private void inAnyMethodWebLayer() {

    }
}
