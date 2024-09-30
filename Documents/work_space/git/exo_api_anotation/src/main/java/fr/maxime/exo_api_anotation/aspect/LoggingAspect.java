package fr.maxime.exo_api_anotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("@annotation(fr.maxime.exo_api_anotation.annotation.Log)")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Entrée dans la méthode: " + methodName + " avec les arguments: " + java.util.Arrays.toString(arguments));
    }

    @AfterReturning(value = "@annotation(fr.maxime.exo_api_anotation.annotation.Log)", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Sortie de la méthode: " + methodName + " avec la valeur de retour: " + result);
    }
}
