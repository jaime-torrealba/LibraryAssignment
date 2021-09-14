package se.lexicon.libraryassignment.data;

import se.lexicon.libraryassignment.model.BookLoan;

import java.util.Collection;

public interface BookLoanDao {

    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void  delete(int id);
}
