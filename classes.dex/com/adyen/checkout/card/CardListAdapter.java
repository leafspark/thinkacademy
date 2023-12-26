package com.adyen.checkout.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.card.data.CardType;
import com.adyen.checkout.components.api.ImageLoader;
import com.adyen.checkout.components.ui.view.RoundCornerImageView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import java.util.Collections;
import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private static final float ACTIVE = 1.0f;
    private static final float NOT_ACTIVE = 0.2f;
    private List<CardType> mFilteredCards = Collections.emptyList();
    private final ImageLoader mImageLoader;
    private final List<CardType> mSupportedCards;

    public CardListAdapter(ImageLoader imageLoader, List<CardType> list) {
        this.mImageLoader = imageLoader;
        this.mSupportedCards = list;
    }

    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i2 = R.layout.brand_logo;
        return new ImageViewHolder((RoundCornerImageView) (!(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false)));
    }

    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        CardType cardType = this.mSupportedCards.get(i);
        imageViewHolder.mCardLogo.setAlpha((this.mFilteredCards.isEmpty() || this.mFilteredCards.contains(cardType)) ? 1.0f : 0.2f);
        this.mImageLoader.load(cardType.getTxVariant(), imageViewHolder.mCardLogo);
    }

    public int getItemCount() {
        return this.mSupportedCards.size();
    }

    public void setFilteredCard(List<CardType> list) {
        this.mFilteredCards = list;
        notifyDataSetChanged();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        RoundCornerImageView mCardLogo;

        ImageViewHolder(View view) {
            super(view);
            this.mCardLogo = (RoundCornerImageView) view;
        }
    }
}
