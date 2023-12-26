package androidx.window;

public final class R {

    public static final class attr {
        public static final int activityAction = 2130903076;
        public static final int activityName = 2130903078;
        public static final int alwaysExpand = 2130903089;
        public static final int clearTop = 2130903265;
        public static final int finishPrimaryWithSecondary = 2130903458;
        public static final int finishSecondaryWithPrimary = 2130903459;
        public static final int placeholderActivityName = 2130903863;
        public static final int primaryActivityName = 2130903877;
        public static final int secondaryActivityAction = 2130903931;
        public static final int secondaryActivityName = 2130903932;
        public static final int splitLayoutDirection = 2130903981;
        public static final int splitMinSmallestWidth = 2130903982;
        public static final int splitMinWidth = 2130903983;
        public static final int splitRatio = 2130903984;

        private attr() {
        }
    }

    public static final class id {
        public static final int androidx_window_activity_scope = 2131296356;
        public static final int locale = 2131297580;
        public static final int ltr = 2131297599;
        public static final int rtl = 2131298005;

        private id() {
        }
    }

    public static final class styleable {
        public static final int[] ActivityFilter = {R.attr.activityAction, R.attr.activityName};
        public static final int ActivityFilter_activityAction = 0;
        public static final int ActivityFilter_activityName = 1;
        public static final int[] ActivityRule = {2130903089};
        public static final int ActivityRule_alwaysExpand = 0;
        public static final int[] SplitPairFilter = {R.attr.primaryActivityName, R.attr.secondaryActivityAction, R.attr.secondaryActivityName};
        public static final int SplitPairFilter_primaryActivityName = 0;
        public static final int SplitPairFilter_secondaryActivityAction = 1;
        public static final int SplitPairFilter_secondaryActivityName = 2;
        public static final int[] SplitPairRule = {R.attr.clearTop, R.attr.finishPrimaryWithSecondary, R.attr.finishSecondaryWithPrimary, R.attr.splitLayoutDirection, R.attr.splitMinSmallestWidth, R.attr.splitMinWidth, R.attr.splitRatio};
        public static final int SplitPairRule_clearTop = 0;
        public static final int SplitPairRule_finishPrimaryWithSecondary = 1;
        public static final int SplitPairRule_finishSecondaryWithPrimary = 2;
        public static final int SplitPairRule_splitLayoutDirection = 3;
        public static final int SplitPairRule_splitMinSmallestWidth = 4;
        public static final int SplitPairRule_splitMinWidth = 5;
        public static final int SplitPairRule_splitRatio = 6;
        public static final int[] SplitPlaceholderRule = {R.attr.placeholderActivityName, R.attr.splitLayoutDirection, R.attr.splitMinSmallestWidth, R.attr.splitMinWidth, R.attr.splitRatio};
        public static final int SplitPlaceholderRule_placeholderActivityName = 0;
        public static final int SplitPlaceholderRule_splitLayoutDirection = 1;
        public static final int SplitPlaceholderRule_splitMinSmallestWidth = 2;
        public static final int SplitPlaceholderRule_splitMinWidth = 3;
        public static final int SplitPlaceholderRule_splitRatio = 4;

        private styleable() {
        }
    }

    private R() {
    }
}
