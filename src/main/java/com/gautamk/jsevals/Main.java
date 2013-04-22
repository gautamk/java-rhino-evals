package com.gautamk.jsevals;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created with IntelliJ IDEA.
 * User: gautam
 * Date: 22/4/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) {
        String script = "function sum(a,b) {return a+b;}";
        Context context = Context.enter();
        try {
            ScriptableObject scope = context.initStandardObjects();
            Scriptable that = context.newObject(scope);
            Function fct = context.compileFunction(scope, script, "script", 1, null);
            final Object result = fct.call(context, scope, that, new Object[]{200, 3});
            System.out.println(Context.jsToJava(result, int.class));
        } finally {
            Context.exit();
        }
    }
}
