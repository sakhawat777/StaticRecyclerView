package com.example.staticrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

// Recyclerview.Adapter
// Recyclerview.ViewHolder
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    //this context we will use to inflate the layout
  private Context mCtx;
    //we are storing all the products in a list
  private List<Product> productList;

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from (mCtx);
        View view = inflater.inflate (R.layout.list_layout, null);
        return new ProductViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        //getting the product of the specified position
    Product product = productList.get (i);
        //binding the data with the viewholder views

        productViewHolder.textViewTitle.setText (product.getTitle ());
        productViewHolder.textViewDesc.setText (product.getShortDesc ());
        productViewHolder.textViewRating.setText (String.valueOf (product.getRating ()));
        productViewHolder.textViewPrice.setText (String.valueOf (product.getPrice ()));
        productViewHolder.imageView.setImageDrawable (mCtx.getResources ().getDrawable (product.getImage ()));



    }

    @Override
    public int getItemCount() {
        return productList.size ();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewRating, textViewPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super (itemView);

            imageView = itemView.findViewById (R.id.imageView);
            textViewTitle = itemView.findViewById (R.id.textViewTitle);
            textViewDesc = itemView.findViewById (R.id.textViewShortDesc);
            textViewRating = itemView.findViewById (R.id.textViewRating);
            textViewPrice = itemView.findViewById (R.id.textViewPrice);

        }
    }
}
