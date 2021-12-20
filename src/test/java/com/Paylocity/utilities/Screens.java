package com.Paylocity.utilities;

import com.Paylocity.pages.PaylocityLogin;
import org.apache.commons.lang3.ObjectUtils;

public class Screens {
   private static ThreadLocal<PaylocityLogin> paylocityLogin = new ThreadLocal<>();

    public static PaylocityLogin getPaylocityLogin(){
        if (paylocityLogin.get()==null) {
            paylocityLogin.set(new PaylocityLogin());
        }
            return paylocityLogin.get();


    }
    public static void closeScreens(){
        if (paylocityLogin.get()!=null){
            paylocityLogin.set(null);
        }

    }
}
