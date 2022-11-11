import { Product } from "../models/product";

export interface WishListDTO{
    productList: Product[];
    showInWishListComponent: boolean;
}