import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  @Input()
  product!: Product;

  @Output() productDetailEvent = new EventEmitter<Product>();

  constructor() { }

  ngOnInit(): void {
  }

  public openProductDetailsSection(value:Product){
    this.productDetailEvent.emit(value);
  }

}
