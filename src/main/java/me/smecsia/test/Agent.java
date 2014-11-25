package me.smecsia.test;

import javassist.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @author smecsia
 */
public class Agent implements ClassFileTransformer {

    public static void premain(final String agentArgument, final Instrumentation instrumentation) {
        instrumentation.addTransformer(new Agent());
    }

    @Override
    public byte[] transform(final ClassLoader loader, final String className, final Class clazz,
                            final java.security.ProtectionDomain domain, byte[] bytes) {
        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;
        try {
            cl = pool.makeClass(new java.io.ByteArrayInputStream(bytes));
            CtBehavior[] methods = cl.getDeclaredBehaviors();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].isEmpty() == false && methods[i].hasAnnotation(Step.class)) {
                    cl.defrost();
                    doMethod(methods[i]);
                }
                bytes = cl.toBytecode();
            }
        } catch (Exception e) {
            System.err.println("Could not instrument  " + className + ",  exception : " + e.getMessage());
        } finally {
            if (cl != null) {
                cl.detach();
            }
        }
        return bytes;
    }

    /**
     * modify code and add log statements before the original method is called
     * and after the original method was called
     */
    private void doMethod(final CtBehavior method) throws NotFoundException, CannotCompileException, ClassNotFoundException {
        final Step step = (Step) method.getAnnotation(Step.class);
        method.insertBefore("System.out.println(\"Start step '" + step.value() + "'\");");
        method.insertAfter("System.out.println(\"Stop step '" + step.value() + "'\");");
    }
}
