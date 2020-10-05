package com.grupopakar.grupopakarapp.layout;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grupopakar.grupopakarapp.util.Util;

public class DividerItemMenu extends RecyclerView.ItemDecoration {
    private final Drawable mDivider;

    public DividerItemMenu(Drawable divider) {
        mDivider = divider;
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int dividerLeft = parent.getPaddingLeft() + Util.convertDipToPixels(parent.getContext(), 10);
        int dividerRight = parent.getWidth() - parent.getPaddingRight()
                - Util.convertDipToPixels(parent.getContext(), 10);

        if (parent.getAdapter() != null) {
            View child = parent.getChildAt(0);
            if (child != null) {
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                int dividerTop = child.getBottom() + params.bottomMargin;
                int dividerBottom = dividerTop + mDivider.getIntrinsicHeight();

                mDivider.setBounds(dividerLeft, dividerTop + Util.convertDipToPixels(parent.getContext(), 5),
                        dividerRight, dividerBottom + Util.convertDipToPixels(parent.getContext(), 5));
                mDivider.draw(canvas);
            }
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.set(0, Util.convertDipToPixels(parent.getContext(), 5), 0, Util.convertDipToPixels(parent.getContext(), 5));
        }
    }
}