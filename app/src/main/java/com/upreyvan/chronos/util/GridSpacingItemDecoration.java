package com.upreyvan.chronos.util;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private final int spanCount;
    private final int hSpacing;
    private final int vSpacing;
    private final boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int hSpacing, int vSpacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.hSpacing = hSpacing;
        this.vSpacing = vSpacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;

        if (includeEdge) {
            outRect.left = hSpacing - column * hSpacing / spanCount;
            outRect.right = (column + 1) * hSpacing / spanCount;

            if (position < spanCount) {
                outRect.top = vSpacing;
            }
            outRect.bottom = vSpacing;
        } else {
            // Left/Right
            outRect.left = column * hSpacing / spanCount;
            outRect.right = hSpacing - (column + 1) * hSpacing / spanCount;

            // Top/Bottom
            if (position >= spanCount) {
                outRect.top = vSpacing;
            }
        }
    }
}