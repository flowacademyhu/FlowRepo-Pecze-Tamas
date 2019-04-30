import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Book } from '../book.model';
import { Newspaper } from '../newspaper.model';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  private newbooks: any;
  private books = [
    new Book('Stars from Eger', 'The revenge of Jumurdzsák'),
    new Book('Boys from Pál street', 'RIP Nemecsek'),
    new Book('Sons of a man with stone heart', '')
  ];
  @Output()
  public e = new EventEmitter();
  private newspapers = [
    new Newspaper('Blikk'),
    new Newspaper('Népszabadság'),
    new Newspaper('Magyar Nemzet'),
  ];
  constructor(private bookservice: BookService) { }

  ngOnInit() {
    this.e.emit(this.books);
    this.bookservice.getBooks().subscribe(data => this.newbooks = data);
  }

}
