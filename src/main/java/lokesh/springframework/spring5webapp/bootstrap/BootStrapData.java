package lokesh.springframework.spring5webapp.bootstrap;

import lokesh.springframework.spring5webapp.domain.Address;
import lokesh.springframework.spring5webapp.domain.Author;
import lokesh.springframework.spring5webapp.domain.Book;
import lokesh.springframework.spring5webapp.domain.Publisher;
import lokesh.springframework.spring5webapp.respositories.AuthorRepository;
import lokesh.springframework.spring5webapp.respositories.BookRepository;
import lokesh.springframework.spring5webapp.respositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository,PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Craig", "Walls");
        Book book = new Book("Spring in Action, fifth Edition", "23432423");
        Publisher publisher = new Publisher("Manning--",new Address("20 baldwin Road","NY","NY",11964));
        publisherRepository.save(publisher);

        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);
        publisher.getBookSet().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author rod =  new Author("Rod","Johnson");
        Book ejbBook = new Book("J2EE Development without EJB", "34534545");

        rod.getBooks().add(ejbBook);
        ejbBook.getAuthors().add(rod);
        ejbBook.setPublisher(publisher);
        publisher.getBookSet().add(ejbBook);

        authorRepository.save(rod);
        bookRepository.save(ejbBook);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("No of books "+ bookRepository.count());
        System.out.println("No of Publishers "+ publisherRepository.count());
        System.out.println("Publishers No of books"+ publisher.getBookSet().size());
    }
}
