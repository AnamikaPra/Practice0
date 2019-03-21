package com.example.security;

import com.example.controller.WelcomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class CustomPermissionEvaluator implements PermissionEvaluator {

    Logger logger = LoggerFactory.getLogger(PermissionEvaluator.class);

    @Override
    public boolean hasPermission(
            Authentication auth, Object targetDomainObject, Object permission) {
        /*if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)){
            return false;
        }
        String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();
         
        return hasPrivilege(auth, targetType, permission.toString().toUpperCase());*/
        logger.debug("Anamika");
        return true;
    }
 
    @Override
    public boolean hasPermission(
            Authentication auth, Serializable targetId, String targetType, Object permission) {
        /*if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetType.toUpperCase(), 
          permission.toString().toUpperCase());*/
        return true;
    }

    private boolean hasPrivilege(Authentication auth, String targetType, String permission) {
        for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
            if (grantedAuth.getAuthority().startsWith(targetType)) {
                if (grantedAuth.getAuthority().contains(permission)) {
                    return true;
                }
            }
        }
        return false;

    }}