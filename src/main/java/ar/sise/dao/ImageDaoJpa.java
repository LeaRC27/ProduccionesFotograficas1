/*
 * The MIT License
 *
 * Copyright 2013 jdmr.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ar.sise.dao;

import java.util.List;
import ar.sise.dao.ImageDao;
import ar.sise.model.Image;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jdmr
 */
@Repository
public class ImageDaoJpa implements ImageDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
//    List<Image> Imagenes = new ArrayList<Image>();
    
    @Transactional(readOnly = true)
    public List<Image> list() {
        return (List<Image>) entityManager.createNamedQuery("images").getResultList();
    }
    @Transactional
    public Image create(Image image) {
        entityManager.persist(image);
        return image;
    }
    
    @Transactional(readOnly = true)
    public Image get(Long id) {
       return (Image) entityManager.createNamedQuery("image").setParameter("id", id).getSingleResult();
    }

    @Transactional
    public void delete(Image image) {
        Image exImage= get(image.getId());
        entityManager.remove(exImage);
    }
       
    
    

        
}
