package com.upreyvan.chronos.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upreyvan.chronos.R;

import java.util.List;

public class Utils {


    public static int dpToPx(Context context, float dp) {
        return Math.round(
                TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        dp,
                        context.getResources().getDisplayMetrics()));
    }

    public static void setMargins(
            View view, Integer left, Integer top, Integer right, Integer bottom) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (params != null) {
            params.setMargins(
                    left != null ? left : params.leftMargin,
                    top != null ? top : params.topMargin,
                    right != null ? right : params.rightMargin,
                    bottom != null ? bottom : params.bottomMargin);
            view.setLayoutParams(params);
        }
    }

    public static void addSystemWindowInsetToPadding(
            View view, boolean left, boolean top, boolean right, boolean bottom) {
        final int initialLeft = view.getPaddingLeft();
        final int initialTop = view.getPaddingTop();
        final int initialRight = view.getPaddingRight();
        final int initialBottom = view.getPaddingBottom();

        ViewCompat.setOnApplyWindowInsetsListener(
                view,
                (v, windowInsets) -> {
                    Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
                    view.setPadding(
                            initialLeft + (left ? insets.left : 0),
                            initialTop + (top ? insets.top : 0),
                            initialRight + (right ? insets.right : 0),
                            initialBottom + (bottom ? insets.bottom : 0));
                    return windowInsets;
                });
    }

    public static void addSystemWindowInsetToMargin(
            View view, boolean left, boolean top, boolean right, boolean bottom) {
        final int initialLeft = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
        final int initialTop = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
        final int initialRight =
                ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
        final int initialBottom =
                ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;

        ViewCompat.setOnApplyWindowInsetsListener(
                view,
                (v, windowInsets) -> {
                    Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
                    ViewGroup.MarginLayoutParams layoutParams =
                            (ViewGroup.MarginLayoutParams) view.getLayoutParams();

                    int updatedLeft = initialLeft + (left ? insets.left : 0);
                    int updatedTop = initialTop + (top ? insets.top : 0);
                    int updatedRight = initialRight + (right ? insets.right : 0);
                    int updatedBottom = initialBottom + (bottom ? insets.bottom : 0);

                    layoutParams.setMargins(updatedLeft, updatedTop, updatedRight, updatedBottom);
                    view.setLayoutParams(layoutParams);

                    return windowInsets;
                });
    }

    @DrawableRes
    public static <T> int getShapedBackgroundForList(@NonNull List<T> list, int position) {
        if (list.size() == 1) {
            return R.drawable.item_shape_alone;
        } else if (position == 0) {
            return R.drawable.item_shape_top;
        } else if (position == list.size() - 1) {
            return R.drawable.item_shape_bottom;
        } else {
            return R.drawable.item_shape_middle;
        }
    }
}
