import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EbookService {

  constructor(private http: HttpClient) { }

  getAll(page: number, size: number) {
    return this.http.get<any[]>(`${environment.apiUrl}/ebooks`, {
      params: new HttpParams()
        .set('page', page.toString())
        .set('size', size.toString())

    });
  }

  getAllByCategory(page: number, size: number, category: string) {
    return this.http.get<any[]>(`${environment.apiUrl}/ebooks?page=${page}&size=${size}&category=${category}`);
  }

  //nposti ktab hna !!
  createBook(book) {
    return this.http.post(`${environment.apiUrl}/ebook`, book);
  }

}
