/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonotek.facade;

import com.sonotek.entity.Query;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oguzhan
 */
@Stateless
public class QueryFacade extends AbstractFacade<Query> {

    @PersistenceContext(unitName = "com.mycompany_sonotek_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QueryFacade() {
        super(Query.class);
    }
    
}
