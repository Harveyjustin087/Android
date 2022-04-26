/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Auction Adapter Class
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//This class sets up the Recycler View for displaying Card Auctions
public class AuctionMagicAdapter extends RecyclerView.Adapter<AuctionMagicAdapter.ViewHolder>{

    private ArrayList<Auction> auctionArrayList;
    private Context context;
    private ClickListener<Auction> auctionClickListener;

    public AuctionMagicAdapter(ArrayList<Auction> auctionArrayList, Context context) {
        this.auctionArrayList = auctionArrayList;
        this.context = context;
    }

    /**
     * this method inflates the item layout and creates the view holder for recycler view
     * @param parent Parameter 1.
     * @param viewType Parameter 2.
     * @return void
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.magic_card_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    /**
     * this method sets the view attributes based on auction data
     * @param holder Parameter 1.
     * @param position Parameter 2.
     * @return void
     */
    @Override
    public void onBindViewHolder(@NonNull AuctionMagicAdapter.ViewHolder holder, int position) {
        Auction model = auctionArrayList.get(position);

        holder.textCardName.setText(model.getCard_name());
        holder.textCardDesc.setText(model.getDescription());
        holder.textCardValue.setText("$ " + Double.toString(model.getValue()) + "0");
        holder.cardImage.setImageResource(model.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this move the user to the Card Details Page when
             * selecting an auction from Recycler view
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                auctionClickListener.onItemClick(model);
            }
        });

    }
    /**
     * this sets up the items within the recycle view and Cardview
     * by determing items shown
     * @return int
     */
    @Override
    public int getItemCount() {
        return auctionArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView cardImage;
        private TextView textCardName, textCardDesc, textCardValue;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardImage = itemView.findViewById(R.id.magicImageView);
            textCardName = itemView.findViewById(R.id.txtCardName);
            textCardDesc = itemView.findViewById(R.id.txtCardDesc);
            textCardValue = itemView.findViewById(R.id.txtCardValue);
            cardView = itemView.findViewById(R.id.magicCardView);


        }
    }
    // Interface to set up on click listener for Auction items selected
    interface  ClickListener<Auction>{
        void onItemClick(Auction data);
    }

    /**
     * this method is for onClick actions navigating to the right auction selection
     * @param auctionClickListener Parameter 1.
     * @return void
     */
    public void setOnItemClickListener(ClickListener<Auction> auctionClickListener)
    {
        this.auctionClickListener = auctionClickListener;

    }
}
