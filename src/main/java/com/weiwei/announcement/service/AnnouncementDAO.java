package com.weiwei.announcement.service;

import com.weiwei.announcement.model.AnnouncementVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AnnouncementDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<AnnouncementVo> getAnnouncements() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from AnnouncementVo", AnnouncementVo.class).list();
    }

    public AnnouncementVo getAnnouncement(int id) {
        return sessionFactory.getCurrentSession().get(AnnouncementVo.class, id);
    }

    public void insert(AnnouncementVo announcementVo) {
        sessionFactory.getCurrentSession().save(announcementVo);
    }

    public void update(AnnouncementVo announcementVo) {
        sessionFactory.getCurrentSession().update(announcementVo);
    }

    public void delete(Integer id) {
        AnnouncementVo announcementVo = new AnnouncementVo();
        announcementVo.setId(id);
        AnnouncementVo announcementVo2 = (AnnouncementVo) sessionFactory.getCurrentSession().merge(announcementVo);
        sessionFactory.getCurrentSession().delete(announcementVo2);
    }
}
