package com.sai.generator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenerator implements IdentifierGenerator{
	private static String id=null;
	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		id= "Created " + new SimpleDateFormat("mm-dd-yyyy").format(new Date()) + " -ID- " + new Random().nextInt(1000);
		return id;
	}

}
