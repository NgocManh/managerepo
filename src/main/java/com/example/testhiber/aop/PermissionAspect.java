package com.example.testhiber.aop;

import com.example.testhiber.exception.UserNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Random;

@Aspect
@Component
public class PermissionAspect {

    int x = 0;

    @Before("@annotation(requireRole)")
    void checkPerMission(JoinPoint joinPoint, RequireRole requireRole)
    {
        String role = requireRole.value();

        x++;

//        if(x%2 == 0)
//        {
//
//            throw new UserNotFoundException("permission denied");
//        }

    }

}
