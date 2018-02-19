package com.mitesh.spring5webapp.bootstrap;

import com.mitesh.spring5webapp.model.Author;
import com.mitesh.spring5webapp.model.Book;
import com.mitesh.spring5webapp.model.Publisher;
import com.mitesh.spring5webapp.repositories.AuthorRepository;
import com.mitesh.spring5webapp.repositories.BookRepository;
import com.mitesh.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component //knows is a spring component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> { //event is triggered and does this stuff...

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //publisher
        Publisher publisher = new Publisher();
        publisher.setName("Worx");
        publisherRepository.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Harry and Foo");
        publisherRepository.save(publisher2);

        //eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher2);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
