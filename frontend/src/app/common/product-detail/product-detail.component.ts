import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  showInWishListComponent: boolean = false;

  @Input()
  productDetails!: Product;

  @Output() goBackEvent = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit(): void {
  }

  public openProductListSection(value: boolean){
     this.goBackEvent.emit(value);
  }
}
