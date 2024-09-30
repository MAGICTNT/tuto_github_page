package fr.maxime.exo_api_anotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("@annotation(fr.maxime.exo_api_anotation.annotation.Performance)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        logger.info(joinPoint.getSignature() + " exécuté en " + executionTime + " ms");

        return result;
    }
}
