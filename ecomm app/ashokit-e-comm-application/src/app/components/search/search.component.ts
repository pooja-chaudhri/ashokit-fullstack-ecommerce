import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-search',
  imports: [RouterModule],
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {

  constructor(private router: Router) { }

  doSearch(value: string) {  
    console.log("serch value : " + value)
    this.router.navigateByUrl(`/search/${value}`);
  }
}
