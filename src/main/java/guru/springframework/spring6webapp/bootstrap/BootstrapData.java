package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		// super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author();
		eric.setFirstName("Eric");
		eric.setLastName("Gupta");

		Book book = new Book();
		book.setTitle("Domain Driven Design");
		book.setIsbn("1123123");

		Author eSaved = authorRepository.save(eric);
		Book bSaved = bookRepository.save(book);

		Author eeric = new Author();
		eeric.setFirstName("Eeric");
		eeric.setLastName("Gupta");

		Book book1 = new Book();
		book1.setTitle("Domain Driven Design part 2");
		book1.setIsbn("1123124");

		Author eeSaved = authorRepository.save(eeric);
		Book b1Saved = bookRepository.save(book1);

		eSaved.getBooks().add(bSaved);
		eeSaved.getBooks().add(b1Saved);
		bSaved.getAuthors().add(eSaved);
		b1Saved.getAuthors().add(eeSaved);
		
		Publisher publisher = new Publisher();
		publisher.setAddress("123 Address");
		publisher.setPublisherName("Gupta Publications");
		Publisher savedPublisher = publisherRepository.save(publisher);
		
		bSaved.setPublisher(savedPublisher);
		b1Saved.setPublisher(savedPublisher);
		savedPublisher.getBooks().add(bSaved);
		savedPublisher.getBooks().add(b1Saved);

		authorRepository.save(eSaved);
		authorRepository.save(eeSaved);
		bookRepository.save(bSaved);
		bookRepository.save(b1Saved);

		System.out.println("In Bootstrap");
		System.out.println("Author Count: " + authorRepository.count());
		System.out.println("Book Count: " + bookRepository.count());

		
		
		System.out.println("Publisher count: " + publisherRepository.count());

	}

}
