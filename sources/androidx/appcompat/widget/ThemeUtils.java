package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.C0052R;
import androidx.core.graphics.ColorUtils;

public class ThemeUtils {
    static final int[] ACTIVATED_STATE_SET = {16843518};
    static final int[] CHECKED_STATE_SET = {16842912};
    static final int[] DISABLED_STATE_SET = {-16842910};
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = {16842908};
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = {-16842919, -16842908};
    static final int[] PRESSED_STATE_SET = {16842919};
    static final int[] SELECTED_STATE_SET = {16842913};
    private static final String TAG = "ThemeUtils";
    private static final int[] TEMP_ARRAY = new int[1];
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal<>();

    public static ColorStateList createDisabledStateList(int i, int i2) {
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    public static int getThemeAttrColor(Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int getDisabledThemeAttrColor(Context context, int i) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
        }
        TypedValue typedValue = getTypedValue();
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return getThemeAttrColor(context, i, typedValue.getFloat());
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = TL_TYPED_VALUE;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    static int getThemeAttrColor(Context context, int i, float f) {
        int themeAttrColor = getThemeAttrColor(context, i);
        return ColorUtils.setAlphaComponent(themeAttrColor, Math.round(((float) Color.alpha(themeAttrColor)) * f));
    }

    public static void checkAppCompatTheme(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C0052R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(C0052R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e(TAG, "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private ThemeUtils() {
    }
}
