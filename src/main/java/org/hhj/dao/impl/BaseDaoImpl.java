package org.hhj.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by hhj on 15-6-4.
 */
@Component(value = "baseDaoImple")
public class BaseDaoImpl{

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
