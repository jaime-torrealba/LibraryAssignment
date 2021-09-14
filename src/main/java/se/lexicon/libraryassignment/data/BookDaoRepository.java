package se.lexicon.libraryassignment.data;

import org.springframework.stereotype.Repository;
import se.lexicon.libraryassignment.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class BookDaoRepository implements BookDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Book findById(int id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Override
    @Transactional
    public Collection<Book> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    @Transactional
    public Book update(Book book) {
       return entityManager.merge(book);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(id);
    }
}
