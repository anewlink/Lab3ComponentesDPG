/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.beans.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author g.martinez
 */
@Stateless
public class ServicioCatalogoMock implements IServicioCatalogoMockLocal, IServicioCatalogoMockRemote {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioCatalogoMock() {
        propertySupport = new PropertyChangeSupport(this);
        
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    @Override
    public void agregarMueble(Mueble mueble) {
        try {
            persistencia.create(mueble);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void eliminarMueble(long id) {
       Mueble mueble = (Mueble)persistencia.findById(Mueble.class, id);
        try {
            persistencia.delete(mueble);
        } catch (OperacionInvalidaException ex) {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Mueble> darMuebles() {
         return persistencia.findAll(Mueble.class);
    }

    @Override
    public void removerEjemplarMueble(long id) {
         Mueble mueble = (Mueble)persistencia.findById(Mueble.class, id);
        int cantidad = mueble.getCantidad();
        
        mueble.setCantidad(cantidad==0?0:cantidad-1);
        persistencia.update(mueble);
    }

    @Override
    public Mueble buscar(long id) {
        Object mueble = persistencia.findById(Mueble.class, id);
        return mueble!=null? (Mueble)mueble:null;
    }

   
    
}
