package beans.loggers;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  private static final Logger LOG = Logger.getLogger(LoggingAspect.class.getName());

  @Pointcut("execution(* *.logEvent(..))")
  private void allLogEventMethods() {
  }

  @Before("allLogEventMethods()")
  public void logBefore(JoinPoint joinPoint) {
    LOG.info("BEFORE : " +
        joinPoint.getTarget()
                 .getClass()
                 .getSimpleName()
        + " " +
        joinPoint.getSignature()
                 .getName());
  }

  @AfterReturning(
      pointcut = "allLogEventMethods()",
      returning = "retVal"
  )
  public void logAfter(Object retVal) {
    LOG.info("Returned value: " + retVal);
  }

  @AfterThrowing(
      pointcut = "allLogEventMethods()",
      throwing = "ex"
  )
  public void logAfterThrow(Throwable ex) {
    LOG.warning("Thrown: " + ex);
  }
}
