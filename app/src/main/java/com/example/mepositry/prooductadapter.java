package com.example.mepositry;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class prooductadapter extends RecyclerView.Adapter<prooductadapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    public Context mCtx;

    //we are storing all the products in a list
    private List<Prooduct> productList;

    //getting the context and product list with constructor

    public prooductadapter(Context context, List<Prooduct> productList) {
        this.mCtx = context;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_pro, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Prooduct product = productList.get(position);

        //binding the data with the viewholder views
        holder.n.setText(product.getName());
        holder.g.setText(product.getGender());
        holder.e.setText(product.getEmail());
        holder.a.setText(product.getAge());
        holder.s.setText(product.getSchool());
        holder.p.setText(product.getPhn());
        holder.h.setText(product.getHeight());
        holder.w.setText(product.getweight());
        holder.bmi.setText(product.getBmi());
        holder.ph.setText(product.getPh());
        holder.pu.setText(product.getPulse());
        holder.ur.setText(product.getUr());
        holder.br.setText(product.getBr());
        holder.er.setText(product.getEr());




        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView n,g,e,a,s,p,h,w,bmi,ph,pu,ur,br,er;
        ImageView imageView;
        Button b;
        public ProductViewHolder(View itemView) {
            super(itemView);

            n = itemView.findViewById(R.id.name);
            g = itemView.findViewById(R.id.gender);
            e = itemView.findViewById(R.id.email);
            a = itemView.findViewById(R.id.age);
            s= itemView.findViewById(R.id.school);
            p = itemView.findViewById(R.id.phn);
            h = itemView.findViewById(R.id.height);
            w= itemView.findViewById(R.id.weight);
            bmi = itemView.findViewById(R.id.bmi);
            ph = itemView.findViewById(R.id.ph);
            pu = itemView.findViewById(R.id.pulse);
            ur = itemView.findViewById(R.id.ur);
            br = itemView.findViewById(R.id.br);
            er = itemView.findViewById(R.id.er);



            //imageView = itemView.findViewById(R.id.imageView);
            //b=itemView.findViewById(R.id.imageView);
        }
    }
}
