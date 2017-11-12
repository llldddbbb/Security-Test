package com.ldb.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Bobbi
 * @date 2017/11/1
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,String>{

    //可以使用spring的Autowire注入类


    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("初始化MyValidator");
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(s);
        return true;
    }
}
