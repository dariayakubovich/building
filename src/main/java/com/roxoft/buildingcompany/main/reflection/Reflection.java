package main.java.com.roxoft.buildingcompany.main.reflection;

import java.lang.reflect.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.roxoft.buildingcompany.models.administration.Management;

public class Reflection {
	private static final Logger lOGGER = LogManager.getLogger(Management.class);

	public static void main(String[] args) {

		Class<Management> reflect = Management.class;
		try {
			Method method = reflect.getDeclaredMethod("work");
			method.invoke(new Management());

			Class[] arg = new Class[1];
			arg[0] = int.class;
			Method method1 = reflect.getDeclaredMethod("work", arg);
			method1.invoke(new Management(), 5);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		lOGGER.info("--------------------------------------------------------------------------------");
		
		lOGGER.info("package " + reflect.getPackage().getName() + ";");

		lOGGER.info(Modifier.toString(reflect.getModifiers()) + " " + "class " + reflect.getSimpleName() + " extends "
				+ reflect.getSuperclass().getSimpleName() + " ");

		Class[] interfaces = reflect.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			String interfaceName = interfaces[i].getSimpleName();
			lOGGER.info(i == 0 ? "implements " + interfaceName : ", " + interfaceName);
		}
		lOGGER.info(" {");

		Field[] fields = reflect.getDeclaredFields();
		for (Field field : fields)
			lOGGER.info("\t" + Modifier.toString(field.getModifiers()) + " " + getType(field.getType()) + " "
					+ field.getName() + ";");

		Constructor[] constructors = reflect.getDeclaredConstructors();
		for (Constructor c : constructors)
			lOGGER.info("\t" + Modifier.toString(c.getModifiers()) + " " + reflect.getSimpleName() + "("
					+ getParameters(c.getParameterTypes()) + ") { }");

		Method[] methods = reflect.getDeclaredMethods();
		for (Method m : methods)
			lOGGER.info("\t" + Modifier.toString(m.getModifiers()) + " " + getType(m.getReturnType()) + " "
					+ m.getName() + "(" + getParameters(m.getParameterTypes()) + ") { }");

		lOGGER.info("}");
	}

	private static String getType(Class cl) {
		String type = cl.isArray() ? cl.getComponentType().getSimpleName() + "[]" : cl.getSimpleName();
		return type;

	}

	private static String getParameters(Class[] params) {
		String p = "";
		for (int i = 0; i < params.length; i++) {
			if (i > 0)
				p = p + ", ";
			p = p + getType(params[i]) + " param" + i;
		}
		return p;
	}

}
