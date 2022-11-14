import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ProductDetailsDTO } from 'src/app/dtos/productDetailsDTO';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  
  showQuantityFormField!: boolean;
  showAddToWishListButton! : boolean;
  showGoBackButton!: boolean;

  @Input()
  productDetails!: Product;

  @Input()
  feature! : ProductDetailsDTO;

  @Output() goBackEvent = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit(): void {
  }

  public openProductListSection(value: boolean){
     this.goBackEvent.emit(value);
  }
}
