package study.datajpa.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeTraceAop {

    @Around("execution(* study.datajpa..*(..))")
    public Object execut(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        log.info("시작시간 : {}Ms 시작 경로 : {}",start,joinPoint.getSourceLocation());
        try{
            // 리턴값
            return joinPoint.proceed();
        }finally {
            long end = System.currentTimeMillis();
            long timeMs = end-start;
            log.info("끝나는 시간 : {}Ms 시작 경로 : {}",timeMs,joinPoint.getSourceLocation());
        }

    }

}
