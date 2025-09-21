import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConstant } from '../app-constant';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  public getAllProduct():Observable<any>{
    return this.http.get<any>(`${AppConstant. prodcuct_endpoint}`);
  }
  
  getProductsByCategoryId(theCategoryId: number): Observable<any> {
    return this.http.get<any>(`${AppConstant.category_endpoint}/${theCategoryId}`);
  }

  public getAllCategory():Observable<any>{
    return this.http.get<any>(`${AppConstant.Allcategory_endpoint}`);
  }

  public searchProduct(thekeyword:string):Observable<any>{
    return this.http.get<any>(`${AppConstant.search_endpoint}/${thekeyword}`);
  }
}

